import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class LoginForm extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfEmail;
    JPasswordField pfPassword;



    public void initialize(){
        /********Form Panel***************/

        JLabel lbLoginForm = new JLabel("Login Form", SwingConstants.CENTER);
        lbLoginForm.setFont(mainFont);

        JLabel lbEmail = new JLabel("E-mail");
        lbEmail.setFont(mainFont);

        tfEmail = new JTextField();
        tfEmail.setFont(mainFont);

        JLabel lbPassword = new JLabel("Password");
        lbPassword.setFont(mainFont);

        pfPassword = new JPasswordField();
        pfPassword.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1,10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30,50));
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
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30,50));
        buttonsPanel.add(btnLogin);
        buttonsPanel.add(btnCancel);


        /*************Initialize the Frame*********/
        add(formPanel, BorderLayout.NORTH);
     //   add(formPanel, BorderLayout.SOUTH);
        add(buttonsPanel, BorderLayout.SOUTH);


        setTitle("Login Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMaximumSize(new Dimension(350, 450));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private User getAuthenticatedUser(String email, String password){
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/raiweb_solutions";
        final String USERNAME = "root";
        final String PASSWORD = "maragwe";
        try {

            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfull...
            System.out.println("Connected to database successfull...");



        //    System.exit(ABORT);

            String sql = "SELECT * FROM user WHERE email=? AND password =?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            

            ResultSet resultSet = preparedStatement.executeQuery();

            

            if(resultSet.next()){
                user = new User();
                user.FirstName = resultSet.getString("FirstName");
                user.SecondName = resultSet.getString("SecondName");
                user.role = resultSet.getString("role");
                user.email = resultSet.getString("email");
                user.phone = resultSet.getString("phone");
                user.address = resultSet.getString("address");
                user.password = resultSet.getString("password");
                user.dob = resultSet.getString("dob");
                user.idno = resultSet.getString("idno");

              //  System.exit(ABORT);

            }

            preparedStatement.close();
            conn.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Database connection fail!");
         //   JOptionPane.showMessageDialog(rootPane, e, PASSWORD, ABORT);

        
           // System.exit(ABORT);
        }

        return user;


    }
    
}
