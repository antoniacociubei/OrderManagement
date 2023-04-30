package presentation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * GUI FRAME which will be displayed when Order btn is pressed
 */

public class OrderFrame {

    private JFrame frmOrder;
    private JTextField orderIdField;
    private JTextField clientIdField;
    //private JTextField clientNameField;
    private JTextField prodIdField;
    //private JTextField prodNameField;
    private JTextField quantityField;
    JButton btnNewButtonOrder;
    JButton btnDeleteOrder;
    JButton btnEditOrder;
    JButton btnFindByIdOrder;
    JButton btnViewAllOrder;

    /**
     * Launch the application.
     */
    public OrderFrame() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmOrder = new JFrame();
        frmOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmOrder.setBounds(100, 100, 609, 363);
        /*contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);*/
        frmOrder.getContentPane().setLayout(null);

        JLabel lblOrderId = new JLabel("Order Id");
        lblOrderId.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblOrderId.setBounds(45, 29, 98, 26);
        frmOrder.getContentPane().add(lblOrderId);

        JLabel lblCientId = new JLabel("Client Id");
        lblCientId.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCientId.setBounds(45, 87, 98, 26);
        frmOrder.getContentPane().add(lblCientId);

        JLabel lblProductId = new JLabel("Product Id");
        lblProductId.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblProductId.setBounds(45, 176, 98, 26);
        frmOrder.getContentPane().add(lblProductId);

        /*JLabel lblClientName = new JLabel("Client name");
        lblClientName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblClientName.setBounds(45, 123, 98, 26);
        frmOrder.getContentPane().add(lblClientName);*/

        /*JLabel lblProductName = new JLabel("Product name");
        lblProductName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblProductName.setBounds(45, 212, 113, 26);
        frmOrder.getContentPane().add(lblProductName);*/

        JLabel lblQuantity = new JLabel("Quantity");
        lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblQuantity.setBounds(45, 248, 113, 26);
        frmOrder.getContentPane().add(lblQuantity);

        orderIdField = new JTextField();
        orderIdField.setBounds(149, 35, 158, 19);
        frmOrder.getContentPane().add(orderIdField);
        orderIdField.setColumns(10);

        clientIdField = new JTextField();
        clientIdField.setColumns(10);
        clientIdField.setBounds(149, 93, 158, 19);
        frmOrder.getContentPane().add(clientIdField);

       /* clientNameField = new JTextField();
        clientNameField.setColumns(10);
        clientNameField.setBounds(149, 123, 158, 19);
        frmOrder.getContentPane().add(clientNameField);*/

        prodIdField = new JTextField();
        prodIdField.setColumns(10);
        prodIdField.setBounds(149, 182, 158, 19);
        frmOrder.getContentPane().add(prodIdField);

     /*   prodNameField = new JTextField();
        prodNameField.setColumns(10);
        prodNameField.setBounds(149, 218, 158, 19);
        frmOrder.getContentPane().add(prodNameField);*/

        quantityField = new JTextField();
        quantityField.setColumns(10);
        quantityField.setBounds(149, 248, 158, 19);
        frmOrder.getContentPane().add(quantityField);

        btnNewButtonOrder = new JButton("Add new");
        btnNewButtonOrder.setForeground(new Color(255, 255, 255));
        btnNewButtonOrder.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnNewButtonOrder.setBackground(new Color(149, 196, 183));
        btnNewButtonOrder.setBounds(384, 47, 96, 30);
        frmOrder.getContentPane().add(btnNewButtonOrder);

        btnDeleteOrder = new JButton("Delete");
        btnDeleteOrder.setForeground(new Color(255, 255, 255));
        btnDeleteOrder.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnDeleteOrder.setBackground(new Color(149, 196, 183));
        btnDeleteOrder.setBounds(384, 87, 96, 30);
        frmOrder.getContentPane().add(btnDeleteOrder);

        btnEditOrder = new JButton("Edit");
        btnEditOrder.setForeground(new Color(255, 255, 255));
        btnEditOrder.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnEditOrder.setBackground(new Color(149, 196, 183));
        btnEditOrder.setBounds(384, 127, 96, 30);
        frmOrder.getContentPane().add(btnEditOrder);

        btnFindByIdOrder = new JButton("Find by id");
        btnFindByIdOrder.setForeground(new Color(255, 255, 255));
        btnFindByIdOrder.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnFindByIdOrder.setBackground(new Color(149, 196, 183));
        btnFindByIdOrder.setBounds(384, 167, 96, 30);
        frmOrder.getContentPane().add(btnFindByIdOrder);

        btnViewAllOrder = new JButton("View all");
        btnViewAllOrder.setForeground(new Color(255, 255, 255));
        btnViewAllOrder.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnViewAllOrder.setBackground(new Color(149, 196, 183));
        btnViewAllOrder.setBounds(384, 207, 96, 30);
        frmOrder.getContentPane().add(btnViewAllOrder);
        frmOrder.setVisible(true);
    }

    /*private JTextField orderIdField;
    private JTextField ;
    private JTextField clientNameField;
    private JTextField ;
    private JTextField prodNameField;
    private JTextField ;*/

    public int getId(){

        return Integer.parseInt(orderIdField.getText());
    }

    public int getIdClient() {

        return Integer.parseInt(clientIdField.getText());
    }

    public int getIdProduct() {

        return Integer.parseInt(prodIdField.getText());
    }

    public int getQuantity() {

        return Integer.parseInt(quantityField.getText());
    }

    public void viewAllActionListener(ActionListener a){
        btnViewAllOrder.addActionListener(a);
    }

    public void deleteActionListener(ActionListener a){
        btnDeleteOrder.addActionListener(a);
    }

    public void editOrderActionListener(ActionListener a){
        btnEditOrder.addActionListener(a);
    }

    public void addOrderActionListener(ActionListener a){
        btnNewButtonOrder.addActionListener(a);
    }

    public void findByIdActionListener(ActionListener a){
       btnFindByIdOrder.addActionListener(a);
    }

}
