package presentation;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import bll.ClientBll;
import bll.OrderBll;
import bll.ProductBll;
import model.Client;
import model.Order;
import model.Product;
import start.Reflection;

/**
 * Links GUI and app logic
 */

public class Controller {

    private JFrame frame;
    private JTextArea label;

    public Controller(View view){
        frame = new JFrame();
        label = new JTextArea("");
        frame.add(label);
        view.productActionListener(new ProductGUI());
        view.orderActionListener(new OrderGUI());
        view.persoanaActionListener(new ClientGUI());

    }

    /**
     * GUI class for Product table
     */
    class ProductGUI implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ProductFrame productFrame = new ProductFrame();
            productFrame.addNewActionListener(new AddProductInterface(productFrame));
            productFrame.deleteActionListener(new DeleteProductInterface(productFrame));
            productFrame.viewAllActionListener(new SelectAllProductInterface(productFrame));
            productFrame.editProductActionListener(new EditProductInterface(productFrame));
            productFrame.findByIdActionListener(new FindByIProductInterface(productFrame));
        }

        /**
         * adds product to the table
         */
        class AddProductInterface implements  ActionListener{
            ProductFrame productFrame;

            public AddProductInterface( ProductFrame productFrame){
                this.productFrame = productFrame;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                String quantity = productFrame.getQuantity();
                String prodName = productFrame.getProductName();
                String price = productFrame.getPrice();

                if(quantity == null)
                    quantity = "null";

                if(prodName == null)
                    prodName = "null";

                if(price == null)
                    price = "null";

                ProductBll productBll = new ProductBll();
                productBll.addProduct(new Product( prodName,Integer.parseInt(price),Integer.parseInt(quantity)));
            }
        }

        /**
         * deletes product
         */
        class DeleteProductInterface implements ActionListener{

            ProductFrame productFrame;

            public DeleteProductInterface(ProductFrame productFrame){

                this.productFrame = productFrame;
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                ProductBll productBll = new ProductBll();
                productBll.deleteProduct(productFrame.getId());

            }
        }

        /**
         * shows all products
         */
        class SelectAllProductInterface implements ActionListener{
            ProductFrame productFrame;

            public  SelectAllProductInterface(ProductFrame productFrame){

                this.productFrame = productFrame;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                ProductBll productBll = new ProductBll();
                String []column = {"Id", "Product name","Price","Quantity"};
                List<Product> list = productBll.viewAllProducts();
                String [][] data = new String[list.size()][5];
                frame.getContentPane().removeAll();
                int i = 0;
                for(Product c : list){
                   /* data[i][0] = String.valueOf(c.getId());
                    data[i][3] = String.valueOf(c.getQuantity());
                    data[i][2] = String.valueOf(c.getPrice());
                    data[i++][1] = String.valueOf(c.getProduct_name());*/
                    data[i][0] = String.valueOf(c.getId());
                    data[i][1] = String.valueOf(c.getProduct_name());
                    data[i][2] = String.valueOf(c.getPrice());
                    data[i++][3] = String.valueOf(c.getQuantity());
                                }
                JTable jt=new JTable(data,column);
                JScrollPane sp=new JScrollPane(jt);
                jt.setBounds(40,40,1000,400);
                frame.add(sp);
                frame.setSize(1000,400);
                frame.setVisible(true);
            }
        }

        /**
         * edits product
         */
        class EditProductInterface implements ActionListener{
            ProductFrame productFrame;

            public EditProductInterface( ProductFrame productFrame){

                this.productFrame = productFrame;
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                String quantity = productFrame.getQuantity();
                String prodName = productFrame.getProductName();
                String price = productFrame.getPrice();

                if(prodName == null)
                    prodName = "null";

                if(quantity == null)
                    quantity = "null";

                if(price == null)
                    price = "null";

                ProductBll productBll = new ProductBll();
                productBll.updateProduct(new Product(productFrame.getId(),prodName,Integer.parseInt(price),Integer.parseInt(quantity)));
            }
        }

        /**
         * finds product by id
         */
        class FindByIProductInterface implements ActionListener{
            ProductFrame productFrame;

            public FindByIProductInterface( ProductFrame productFrame){

                this.productFrame = productFrame;            }


            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("");
                ProductBll productBll = new ProductBll();
                label.append(Reflection.retrieveProperties(productBll.findProductById(productFrame.getId())));
                frame.dispose();
                frame.setVisible(true);
                frame.setSize(300,400);
            }
        }
    }


    /**
     * GUI class for Client table
     */
    class  ClientGUI implements ActionListener{

        /**
         * calls calls by action performed by user
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            ClientFrame clientFrame = new ClientFrame();

            clientFrame.addClientActionListener(new ClientAddInterfata(clientFrame));
            clientFrame.deleteClientActionListener(new DeleteClientInterfata(clientFrame));
            clientFrame.findByIdActionListener(new FindByIdInterface(clientFrame));
            clientFrame.editClientActionListener(new EditClientInterfata(clientFrame));
            clientFrame.viewAllActionListener(new FindAllInterfata(clientFrame));


        }

        /**
         * searches for client in the DB by id
         */
        class FindByIdInterface implements ActionListener{

            private ClientFrame clientFrame;

            public FindByIdInterface(ClientFrame clientFrame){
                this.clientFrame = clientFrame;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.getContentPane().removeAll();
                ClientBll clientBll = new ClientBll();
                label.setText("");
                label.append(Reflection.retrieveProperties(clientBll.findClientById(clientFrame.getId())));
                frame.dispose();
                frame.setVisible(true);
                frame.setSize(300,400);
            }
        }

        /*class FindByIdInterface implements ActionListener{
            ClientFrame clientFrame;

            public FindByIdInterface( ClientFrame clientFrame){

                this.clientFrame = clientFrame;            }


            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("");
                ProductBll productBll = new ProductBll();
                label.append(Reflection.retrieveProperties(productBll.findProductById(clientFrame.getId())));
                frame.dispose();
                frame.setVisible(true);
                frame.setSize(300,400);
            }
        }*/

        /**
         * adds client to DB
         */
        class ClientAddInterfata implements  ActionListener{

            private final ClientFrame clientFrame;

            public ClientAddInterfata(ClientFrame clientFrame){
                this.clientFrame = clientFrame;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                Client c = new Client(clientFrame.getNume(), clientFrame.getAdresa(), clientFrame.getEmail());
                ClientBll clientBll = new ClientBll();
                clientBll.insertClient(c);
            }
        }

        /**
         * edit a clinets attributes
         */
        class EditClientInterfata implements ActionListener{

            private ClientFrame clientFrame;

            public EditClientInterfata(ClientFrame clientFrame){
                this.clientFrame = clientFrame;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                ClientBll clientBll = new ClientBll();
                Client client = clientBll.findClientById(clientFrame.getId());

                String nume = clientFrame.getNume();
                if(nume  == null)
                    nume = client.getName();

                String adresa = clientFrame.getAdresa();
                if(adresa == null){
                    adresa = client.getAddress();
                }
                String email = clientFrame.getEmail();
                if(email == null){
                    email = client.getEmail();
                }

                Client cl= new Client(clientFrame.getId(),nume,adresa,email);
                clientBll.updateClient(cl);

            }
        }

        /**
         * show all clients in the DB
         */
        class FindAllInterfata implements ActionListener{
            private ClientFrame clientFrame;

            public FindAllInterfata(ClientFrame clientFrame){
                this.clientFrame = clientFrame;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                ClientBll clientBll = new ClientBll();
                String []column = {"Id","Nume","Adresa", "Email"};
                List<Client> list = clientBll.findAll();
                String [][] data = new String[list.size()][4];
                int i = 0;
                for(Client c : list){
                    data[i][0] = String.valueOf(c.getId());
                    data[i][1] = c.getName();
                    data[i][2] = c.getAddress();
                    data[i++][3] = c.getEmail();
                }
                JTable jt=new JTable(data,column);
                JScrollPane sp=new JScrollPane(jt);
                jt.setBounds(30,40,1000,300);
                frame.add(sp);
                frame.setSize(1000,300);
                frame.setVisible(true);
            }
        }

        /**
         * delete a client from the DB
         */
        class DeleteClientInterfata implements  ActionListener{
            private ClientFrame clientFrame;

            public DeleteClientInterfata(ClientFrame clientFrame){
                this.clientFrame = clientFrame;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                ClientBll clientBll = new ClientBll();
                clientBll.delete(clientFrame.getId());
            }
        }

    }

    /**
     * GUI class for Client table
     */
    class  OrderGUI implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            OrderFrame orderFrame = new OrderFrame();

            orderFrame.addOrderActionListener(new AddOrderInterface(orderFrame));
            orderFrame.deleteActionListener(new DeleteOrderInterface(orderFrame));
            orderFrame.viewAllActionListener(new ViewAllOrderInterface(orderFrame));
            orderFrame.editOrderActionListener(new EditOrderInterface(orderFrame));
            orderFrame.findByIdActionListener(new FindByIdOrderInterface(orderFrame));

        }

        /**
         * adds order to DB
         */
        class AddOrderInterface implements ActionListener{
            private  OrderFrame orderFrame;

            public AddOrderInterface(OrderFrame orderFrame){

                this.orderFrame = orderFrame;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                OrderBll orderBll = new OrderBll();
                orderBll.insertOrder(new Order(orderFrame.getIdClient(), orderFrame.getIdProduct(), orderFrame.getQuantity()));
            }
        }

        /**
         * deletes order from DB
         */

        class DeleteOrderInterface implements ActionListener{

            private  OrderFrame orderFrame;

            public DeleteOrderInterface(OrderFrame orderFrame){
                this.orderFrame = orderFrame;
            }


            @Override
            public void actionPerformed(ActionEvent e) {
                OrderBll orderBll = new OrderBll();
                orderBll.deleteOrder(orderFrame.getId());
            }
        }

        /**
         * show all orders
         */
        class ViewAllOrderInterface implements ActionListener{
            private  OrderFrame orderFrame;

            public ViewAllOrderInterface(OrderFrame orderFrame){

                this.orderFrame = orderFrame;
            }


            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                OrderBll orderBll = new OrderBll();
                String []column = {"Id","Id Client","Id product", "Quantity"};
                List<Order> list = orderBll.viewAllOrders();
                String [][] data = new String[list.size()][4];
                int i = 0;
                for(Order c : list){
                    data[i][0] = String.valueOf(c.getId());
                    data[i][1] = String.valueOf(c.getId_client());
                    data[i][2] = String.valueOf(c.getId_product());
                    data[i++][3] = String.valueOf(c.getQuantity());
                }
                JTable jt=new JTable(data,column);
                JScrollPane sp=new JScrollPane(jt);
                jt.setBounds(30,40,1000,300);
                frame.add(sp);
                frame.setSize(1000,300);
                frame.setVisible(true);
            }
        }

        /**
         * edit order
         */
        class EditOrderInterface implements ActionListener{
            private  OrderFrame orderFrame;

            public EditOrderInterface(OrderFrame orderFrame){
                this.orderFrame = orderFrame;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                Order order = new Order(orderFrame.getId(), orderFrame.getIdClient(), orderFrame.getIdProduct(), orderFrame.getQuantity());
                OrderBll orderBll = new OrderBll();
                orderBll.updateOrder(order);
                //System.out.println("sal");
            }
        }

        /**
         * find order by id
         */
        class FindByIdOrderInterface implements ActionListener{
            private  OrderFrame orderFrame;

            public FindByIdOrderInterface(OrderFrame orderFrame){

                this.orderFrame = orderFrame;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.getContentPane().removeAll();
                frame.add(label);
                label.setText("");
                OrderBll orderBll = new OrderBll();
                label.append(Reflection.retrieveProperties(orderBll.findOrderById(orderFrame.getId())));
                frame.dispose();
                frame.setVisible(true);
                frame.setSize(300,400);
            }
        }
    }


}
