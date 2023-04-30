package presentation;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * GUI FRAME which will be displayed when Client btn is pressed
 */

public class ClientFrame {

    private JFrame frmClient;

    private JTextField idField;
    private JTextField nameField;
    private JTextField adrField;
    private JTextField emailField;

    JButton btnNewButtonClient;
    JButton btnDeleteClient;
    JButton btnEditClient;
    JButton btnFindByIdClient;
    JButton btnViewAllClient;


    public ClientFrame() {

        initialize();

    }


    private void initialize() {
        frmClient = new JFrame();
        frmClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmClient.setBounds(100, 100, 552, 279);
        /*contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);*/
        frmClient.getContentPane().setLayout(null);

        JLabel LblClientId = new JLabel("Client id");
        LblClientId.setFont(new Font("Tahoma", Font.BOLD, 14));
        LblClientId.setBounds(63, 39, 82, 19);
        frmClient.getContentPane().add(LblClientId);

        idField = new JTextField();
        idField.setBounds(132, 39, 167, 20);
        frmClient.getContentPane().add(idField);
        idField.setColumns(10);

        JLabel lbltName = new JLabel("Name");
        lbltName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbltName.setBounds(63, 77, 96, 19);
        frmClient.getContentPane().add(lbltName);

        nameField = new JTextField();
        nameField.setColumns(10);
        nameField.setBounds(132, 79, 167, 20);
        frmClient.getContentPane().add(nameField);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAddress.setBounds(63, 117, 96, 19);
        frmClient.getContentPane().add(lblAddress);

        adrField = new JTextField();
        adrField.setColumns(10);
        adrField.setBounds(132, 119, 167, 20);
        frmClient.getContentPane().add(adrField);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblEmail.setBounds(63, 157, 96, 19);
        frmClient.getContentPane().add(lblEmail);

        emailField = new JTextField();
        emailField.setColumns(10);
        emailField.setBounds(132, 159, 167, 20);
        frmClient.getContentPane().add(emailField);

        btnNewButtonClient= new JButton("Add new");
        btnNewButtonClient.setForeground(new Color(255, 255, 255));
        btnNewButtonClient.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnNewButtonClient.setBackground(SystemColor.activeCaption);
       /* btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });*/
        btnNewButtonClient.setBounds(375, 21, 96, 30);
        frmClient.getContentPane().add(btnNewButtonClient);

        btnDeleteClient = new JButton("Delete");
        btnDeleteClient.setForeground(new Color(255, 255, 255));
        btnDeleteClient.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnDeleteClient.setBackground(SystemColor.activeCaption);
        /*btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });*/
        btnDeleteClient.setBounds(375, 61, 96, 30);
        frmClient.getContentPane().add( btnDeleteClient);

        btnEditClient = new JButton("Edit");
        btnEditClient.setForeground(new Color(255, 255, 255));
        btnEditClient.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnEditClient.setBackground(SystemColor.activeCaption);
        btnEditClient.setBounds(375, 101, 96, 30);
        frmClient.getContentPane().add(btnEditClient);

        btnFindByIdClient = new JButton("Find by id");
        btnFindByIdClient.setForeground(new Color(255, 255, 255));
        btnFindByIdClient.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnFindByIdClient.setBackground(SystemColor.activeCaption);
        btnFindByIdClient.setBounds(375, 141, 96, 30);
        frmClient.getContentPane().add(btnFindByIdClient);

        btnViewAllClient = new JButton("View all");
        btnViewAllClient.setForeground(new Color(255, 255, 255));
        btnViewAllClient.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnViewAllClient.setBackground(SystemColor.activeCaption);
        btnViewAllClient.setBounds(375, 181, 96, 30);
        frmClient.getContentPane().add(btnViewAllClient);

        frmClient.setVisible(true);
    }


    public String getNume(){

        return nameField.getText();
    }

    public String getAdresa(){

        return adrField.getText();
    }

    public String getEmail(){

        return emailField.getText();
    }

    public int getId(){

        return Integer.parseInt(idField.getText());
    }

    public void addClientActionListener(ActionListener a){

        btnNewButtonClient.addActionListener(a);
    }
    public void deleteClientActionListener(ActionListener a){

        btnDeleteClient.addActionListener(a);
    }

    public void viewAllActionListener(ActionListener a){

        btnViewAllClient.addActionListener(a);
    }

    public void editClientActionListener(ActionListener a){

        btnEditClient.addActionListener(a);

    }



    public void findByIdActionListener(ActionListener a){

        btnFindByIdClient.addActionListener(a);
    }


}
