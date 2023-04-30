package dao;
import connection.ConnectionFactory;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DB operations implementation
 * @param <T> generic
 */

public class AbstractDAO <T>{

    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
    //We can use this object to get information about the corresponding class at runtime
    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * generates the String for select from where
     * @param field string that represents the search criteria in the DB
     */
    private String createSelectQuery(String field){

        StringBuilder builder  = new StringBuilder();

        builder .append("SELECT ");
        builder .append(" * ");
        builder .append(" FROM ");
        builder .append(type.getSimpleName());
        builder .append(" WHERE " + field + " =?");

        return builder .toString();

    }

    /**
     * executes a select * from table
     * @return a list of T-type objects
     */

    public List<T> viewAll()  {

        String query = "SELECT * FROM " + type.getSimpleName();

        List<T> list = new ArrayList<T>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            System.out.println(query);
            resultSet = statement.executeQuery();
            list = createObjects(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return list;

    }

    /**
     *  finds a certain line in the DB
     * @param id serach criteria
     */
    public T findById(int id){

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String query = createSelectQuery("id");

        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);

        }catch (SQLException e) {

            LOGGER.log(Level.WARNING, type.getName()+"DAO:findById" + e.getMessage());

        }finally{
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return null;
    }

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * generates the string for insert
     * @param field columns we want to insert
     * @param query  we put ? where we will enter values
     * @return string we will use later
     */
    private String createInsertQuerry(String field, String query){
        StringBuilder queryAux = new StringBuilder();

        queryAux.append("INSERT ");
        queryAux.append(" INTO ");
        queryAux.append(type.getSimpleName());
        queryAux.append(" (" + field + ") ");
        queryAux.append("VALUES (" + query+ ")");

        return  queryAux.toString();
    }

    /**
     * inserts the object into the DB
     * @param object to be inserted
     */
    public void insert(T object){
        Connection connection = null;
        PreparedStatement statement = null;

        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;

        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try{
            connection = ConnectionFactory.getConnection();
            String fields = "";
            String queryAux = "";
            for(Field field : type.getDeclaredFields()){
                if(!field.getName().equals("id")) {
                    fields += field.getName() + ",";
                    queryAux += "?,";
                }
            }
            fields = fields.substring(0,fields.length() - 1);
            queryAux = queryAux.substring(0,queryAux.length() - 1);

            String query = createInsertQuerry(fields,queryAux);

            statement = connection.prepareStatement(query);
            int i = 1;
            for(Field field : type.getDeclaredFields()){
                String fieldName = field.getName();
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                Method method = propertyDescriptor.getReadMethod();
                if(!fieldName.equals("id")) {
                    if (method.invoke(object) != null) {
                        statement.setObject(i++, method.invoke(object));
                    }
                    else {
                        statement.setString(i++, "null");
                    }
                }
            }
            statement.executeUpdate();

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally{
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }



    /**
     * generates the string for update
     * @param field to define column
     */
    public String createUpdateQuerry(String field){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("UPDATE ");
        stringBuilder.append(type.getSimpleName());
        stringBuilder.append(" SET ");
        stringBuilder.append(field);
        stringBuilder.append(" WHERE id"  + " =?");

        return stringBuilder.toString();
    }

    /**
     * updates the object in the DB
     * @param ob  object to be updated must have an existing identifier in the table
     */
    public void update(T ob) {
        Connection connection;
        PreparedStatement statement;
        connection = ConnectionFactory.getConnection();
        String fields = "";
        int id  = 0;

        try {
            for (Field field : type.getDeclaredFields()) {
                String fieldName = field.getName();
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                Method method = propertyDescriptor.getReadMethod();

                if (!fieldName.equals("id")) {

                    if (!method.invoke(ob).equals("null")) {

                        fields += field.getName() + "=?,";
                    }
                }
                else
                    id = (int) method.invoke(ob);
            }

            fields = fields.substring(0,fields.length() - 1);
            String query = createUpdateQuerry(fields);

            statement = connection.prepareStatement(query);

            int i = 1;
            for(Field field : type.getDeclaredFields()){
                String fieldName = field.getName();
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                Method method = propertyDescriptor.getReadMethod();

                if(!fieldName.equals("id")) {

                    if (!method.invoke(ob).equals("null")) {

                        statement.setObject(i++, method.invoke(ob));
                    }
                }
            }
            statement.setInt(i,id);
            statement.executeUpdate()   ;

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    /**
     * deletes the row that has the corresponding id
     * @param id identifier of type integer
     */
    public void delete(int id){

        String query = "DELETE  FROM " + type.getSimpleName() + " WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            System.out.println(query);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }


}
