package bll;
import java.util.ArrayList;
import java.util.List;
import dao.ClientDAO;
import model.Client;
import java.util.NoSuchElementException;
import bll.validators.EmailValidator;
import bll.validators.Validator;


/**
 * connects Client and ClientDAO
 */
public class ClientBll {

    private List<Validator<Client>> validators;
    private ClientDAO clientDAO;

    public ClientBll() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        //conectre nivel inferior DAO
        clientDAO = new ClientDAO();
    }

    //metoda adugare client
    //aici aplicam si validarea
    public void insertClient(Client client) {

        for (Validator<Client> v : validators) {

            v.validate(client);
        }

        clientDAO.insert(client); //apelare insert DAO
    }

    //meoda stergere client
    public void delete(int id){

        clientDAO.delete(id);
    }

    //gasire client dupa id
    //no need for validation
    public Client findClientById(int id) {
        Client client = clientDAO.findById(id);
        //execption message
        if (client == null) {

            throw new NoSuchElementException("The client with id =" + id + " was not found!!!");
        }

        return client;
    }

    public List<Client> findAll(){
        List<Client> listofClients = clientDAO.viewAll();
        //exception messsage
        if (listofClients == null) {
            throw new NoSuchElementException("Table is empty!!");
        }
        return listofClients;
    }

    public void updateClient(Client t){

        clientDAO.update(t);
    }




}
