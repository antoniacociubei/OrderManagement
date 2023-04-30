package presentation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * GUI FRAME which will be displayed when Product btn is pressed
 */
public class ProductFrame{

    private JFrame frmProduct;
    private JTextField prodIdField;
    private JTextField prodNameField;
    private JTextField priceField;
    private JTextField qntyField;
    //private JTextField textField; //producer
    private JButton  btnFindByIdProd;
    private JButton btnNewButtonProd;
    private JButton   btnEditProd;
    private JButton  btnDeleteProd;
    private JButton   btnViewAllProd;


    public ProductFrame() {

        initialize();
    }

    private void initialize() {
        frmProduct = new JFrame();
        frmProduct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmProduct.setBounds(100, 100, 612, 307);
        //contentPane = new JPanel();
        //contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        //setContentPane(contentPane);
        frmProduct.getContentPane().setLayout(null);


        JLabel lblProductId = new JLabel("Product id");
        lblProductId.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblProductId.setBounds(45, 54, 82, 19);
        frmProduct.getContentPane().add(lblProductId);

        prodIdField = new JTextField();
        prodIdField.setColumns(10);
        prodIdField.setBounds(151, 56, 167, 20);
        frmProduct.getContentPane().add(prodIdField);

        JLabel lblProductName = new JLabel("Product name");
        lblProductName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblProductName.setBounds(45, 94, 108, 19);
        frmProduct.getContentPane().add(lblProductName);

        prodNameField = new JTextField();
        prodNameField.setColumns(10);
        prodNameField.setBounds(151, 96, 167, 20);
        frmProduct.getContentPane().add(prodNameField);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPrice.setBounds(45, 134, 96, 19);
        frmProduct.getContentPane().add(lblPrice);

        priceField = new JTextField();
        priceField.setColumns(10);
        priceField.setBounds(151, 136, 167, 20);
        frmProduct.getContentPane().add(priceField);

        JLabel lblQuantity = new JLabel("Quantity");
        lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblQuantity.setBounds(45, 174, 96, 19);
        frmProduct.getContentPane().add(lblQuantity);

        qntyField = new JTextField();
        qntyField.setColumns(10);
        qntyField.setBounds(151, 176, 167, 20);
        frmProduct.getContentPane().add(qntyField);

        /*JLabel lblProducer = new JLabel("Producer");
        lblProducer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblProducer.setBounds(45, 205, 96, 19);
        frmProduct.getContentPane().add(lblProducer);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(151, 206, 167, 20);
        frmProduct.getContentPane().add(textField);
*/
        btnNewButtonProd = new JButton("Add new");
        btnNewButtonProd.setForeground(new Color(255, 255, 255));
        btnNewButtonProd.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnNewButtonProd.setBackground(new Color(156, 153, 201));
        btnNewButtonProd.setBounds(407, 36, 96, 30);
        frmProduct.getContentPane().add(btnNewButtonProd);

        btnDeleteProd = new JButton("Delete");
        btnDeleteProd.setForeground(new Color(255, 255, 255));
        btnDeleteProd.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnDeleteProd.setBackground(new Color(156, 153, 201));
        btnDeleteProd.setBounds(407, 76, 96, 30);
        frmProduct.getContentPane().add(btnDeleteProd);

        btnEditProd = new JButton("Edit");
        btnEditProd.setForeground(new Color(255, 255, 255));
        btnEditProd.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnEditProd.setBackground(new Color(156, 153, 201));
        btnEditProd.setBounds(407, 116, 96, 30);
        frmProduct.getContentPane().add(btnEditProd);

        btnFindByIdProd = new JButton("Find by id");
        btnFindByIdProd.setForeground(new Color(255, 255, 255));
        btnFindByIdProd.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnFindByIdProd.setBackground(new Color(156, 153, 201));
        btnFindByIdProd.setBounds(407, 156, 96, 30);
        frmProduct.getContentPane().add(btnFindByIdProd);

        btnViewAllProd = new JButton("View all");
        btnViewAllProd.setForeground(new Color(255, 255, 255));
        btnViewAllProd.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnViewAllProd.setBackground(new Color(156, 153, 201));
        btnViewAllProd.setBounds(407, 196, 96, 30);
        frmProduct.getContentPane().add(btnViewAllProd);
        frmProduct.setVisible(true);
    }

   /* private JFrame frmOrder;;
    private JTextField prodIdField;
    private JTextField prodNameField;
    private JTextField priceField;
    private JTextField qntyField;*/

    //!producer
   /* public String getProducer(){
        return textField.getText();
    }*/

    public String getPrice(){

        return priceField.getText();
    }

    public String getQuantity(){

        return qntyField.getText();
    }

    public String getProductName(){

        return prodNameField.getText();
    }

    public int getId(){

        return Integer.parseInt(prodIdField.getText());
    }

    public void addNewActionListener(ActionListener act){

        btnNewButtonProd.addActionListener(act);
    }

    public void deleteActionListener(ActionListener act){

        btnDeleteProd.addActionListener(act);
    }


    public void viewAllActionListener(ActionListener act){

        btnViewAllProd.addActionListener(act);
    }


    public void editProductActionListener(ActionListener act){

        btnEditProd.addActionListener(act);
    }

    public void findByIdActionListener(ActionListener act){

        btnFindByIdProd.addActionListener(act);
    }

}
