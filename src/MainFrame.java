import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class MainFrame extends JFrame {

    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfEmail;
    JPasswordField pfPassword;

    public void init(){

    

        JLabel name = new JLabel("Your Name Here",SwingConstants.CENTER);
    name.setFont(mainFont);

    JLabel ibEmail = new JLabel("Your Name Here",SwingConstants.CENTER);
    name.setFont(mainFont);

    tfEmail = new JTextField();
    tfEmail.setFont(mainFont);

    JLabel pfPassword = new JLabel("Password");
    pfPassword.setFont(mainFont);

    JPanel formPanel = new JPanel();
    formPanel.setLayout(getLayout());
    formPanel.add(name);
    formPanel.add(ibEmail);
    formPanel.add(tfEmail);
    formPanel.add(formPanel);
    formPanel.add(pfPassword);

    JButton btnLogin = new JButton("Login");
    btnLogin.setFont(mainFont);
    btnLogin.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub

            String email = tfEmail.getText();
            String password = String.valueOf(pfPassword.getPassword());

            User user = getAuthenticatedUser(email, password);

            if(user!=null){
                MainFrame mainFrame = new MainFrame();
                mainFrame.init(user);
                dispose();



            }
            else{
                JOptionPane.showMessageDialog(MainFrame.this,
                "Email or Password Invalid",
                "Try again", 
                JOptionPane.ERROR_MESSAGE);


            }


            
            
            
        }

        
    });

    //    JTextField name_field = new JTextField();
    //    name_field.setBounds(50,60,50,50);
    //    add(name_field);


        add(formPanel, BorderLayout.NORTH);



    
        setTitle("Login Form");
        setSize(700, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


    }
    

}
