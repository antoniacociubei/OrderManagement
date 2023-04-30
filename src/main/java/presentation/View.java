package presentation;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;

/**
 * main window frame
 * activates the rest of the frames at btn pressing
 */
public class View {

    private JFrame frame;
    private JButton clientButton;
    private JButton productButton;
    private JButton orderButton ;

    //lunch app
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    View window = new View();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

   //create
    public View() {

        initialize();
    }


    private void initialize() {
        frame = new JFrame();

        frame.setBounds(100, 100, 401, 389);
        //contentPane = new JPanel();
        //contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        clientButton = new JButton("CLIENT");
        clientButton.setForeground(new Color(255, 255, 255));
        clientButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        clientButton.setBackground(SystemColor.activeCaption);
       /* clientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });*/
        clientButton.setBounds(124, 67, 136, 40);
        frame.getContentPane().add(clientButton);

        productButton = new JButton("PRODUCT");
        productButton.setForeground(new Color(255, 255, 255));
        productButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        productButton.setBackground(new Color(156, 153, 201));
        productButton.setBounds(124, 224, 136, 40);
        frame.getContentPane().add(productButton);

        orderButton = new JButton("ORDER");
        orderButton.setForeground(new Color(255, 255, 255));
        orderButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        orderButton.setBackground(new Color(149, 196, 183));
        orderButton.setBounds(124, 142, 136, 40);
        frame.getContentPane().add(orderButton);

        frame.setVisible(true);

    }

    public void persoanaActionListener(ActionListener cl){

        clientButton.addActionListener(cl);
    }

    public void productActionListener(ActionListener pr){

        productButton.addActionListener(pr);
    }

    public void orderActionListener(ActionListener or){

        orderButton.addActionListener(or);
    }

}
