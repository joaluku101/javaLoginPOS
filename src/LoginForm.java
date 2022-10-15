import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class LoginForm extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfEmail;
    JPasswordField pfPassword;



    public void initialize(){
        /********Form Panel***************/

        JLabel lbLoginForm = new JLabel("Login Form", SwingConstants.CENTER);
        lbLoginForm.setFont(mainFont);

        JLabel lbEmail = new JLabel("Email");
        lbEmail.setFont(mainFont);

        tfEmail = new JTextField();
        tfEmail.setFont(mainFont);

        JLabel lbPassword = new JLabel("Password");
        lbPassword.setFont(mainFont);

        pfPassword = new JPasswordField();
        pfPassword.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1,10, 10));
        formPanel.add(lbLoginForm);
        formPanel.add(lbEmail);
        formPanel.add(tfEmail);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);

        /**********Button Panel**********/
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(mainFont);
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());

                User user = getAuthenticatedUser(email, password);

                if (user !=null) {
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.initialize(user);
                    dispose();
                    
                } else {
                    JOptionPane.showMessageDialog(LoginForm.this,
                    "Email or Password Invalid",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE 
                    );
                    
                }

                
            }


            
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(mainFont);
        btnCancel.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                dispose();

                
            }

        } );

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.add(btnLogin);
        buttonsPanel.add(btnCancel);







        /*************Initialize the Frame*********/
        add(formPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.SOUTH);









        setTitle("Login Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMaximumSize(new Dimension(350, 450));
        setLocationRelativeTo(null);
        setVisible(true);


    }

    private User getAuthenticatedUser(String email, String password){
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost/MyStore?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection conn = DriverManger.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfull...

            String sql = "SELECT * FROM users WHERE email=? AND password =?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultset = preparedStatement.executeQuery();

            if(resultSet.next()){
                user = new User();
                user.name = resultset.getString("name");
                user.email = resultset.getString("email");
                user.phone = resultset.getString("phone");
                user.address = resultset.getString("address");
                user.password = resultset.getString("password");




            }

            preparedStatement.close();
            conn.close();

            


        } catch (Exception e) {
            // TODO: handle exception
        }

        


    }
    
}
