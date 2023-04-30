package bll;
import dao.OrderDAO;
import java.io.FileWriter;
import java.util.List;
import java.util.NoSuchElementException;
import model.Order;
import model.Product;

/**
 * connects Order and Order DAO
 */

public class OrderBll {

    private OrderDAO orderDAO;
    private FileWriter myObj;

  //method to write in text file the bill
    public OrderBll() {
        orderDAO = new OrderDAO();

        try {
            myObj = new FileWriter("Bill.txt");
        }
        catch (java.io.IOException e){

            e.printStackTrace();
        }

    }

    private static int bill = 0;

    //metoda pt inserare-->DAO
    //Aici cream si factura, fiind nivelul de logica al aplicatiei
    public void insertOrder(Order orderObj) {

        ClientBll client = new ClientBll();
        ProductBll productBll = new ProductBll();

        int quantity = productBll.findProductById(orderObj.getId_product()).getQuantity();

        if(quantity  <  orderObj.getQuantity()) {

            throw new NoSuchElementException("We runed out of stock!!!");
        }
        else {
            Product product = productBll.findProductById(orderObj.getId_product());
            //--> legatura spre DAO
            orderDAO.insert(orderObj);

            product.setQuantity(quantity - orderObj.getQuantity());

            if (quantity - orderObj.getQuantity() != 0){

                productBll.updateProduct(product);
            }
            else
            {
                productBll.deleteProduct(product.getId());
            }

            int total = orderObj.getQuantity() * productBll.findProductById(orderObj.getId_product()).getPrice();

            String str = "";
            str = str + ("Nr bill: " + bill + "\nClient name: " + client.findClientById(orderObj.getId_client()).getName());
            str = str + ("\nProduct name: " + productBll.findProductById(orderObj.getId_product()).getProduct_name());
            str = str + ("\nQuantity: " + orderObj.getQuantity());
            str = str + ("\nTotal: " + total);

            //increment bill nr
            bill++;

            try {
                myObj = new FileWriter("Bill.txt");
                myObj.write(str);
                myObj.close();
            }catch (java.io.IOException e){
                e.printStackTrace();
            }

        }

    }

    public List<Order> viewAllOrders(){

        List<Order> list = orderDAO.viewAll();

        if (list == null) {
            throw new NoSuchElementException("Table is empty!!!");
        }
        return list;

    }

    public void deleteOrder(int id){

        orderDAO.delete(id);

    }


    public void updateOrder(Order t){

        orderDAO.update(t);
    }

    public Order findOrderById(int id) {
        Order orderDAOById = orderDAO.findById(id);
        if (orderDAOById == null) {
            throw new NoSuchElementException("The order with id =" + id + " was not found!");
        }
        return orderDAOById;
    }


}
