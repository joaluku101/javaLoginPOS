import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;

import javax.swing.*;
import javax.swing.WindowConstants;



public class SignUpForm extends JFrame {
    

    SignUpForm(){
        JPanel signUpPanel = new JPanel();
       signUpPanel.setBackground(Color.yellow);
        signUpPanel.setBounds(0, 0, 420, 700);

        JLabel yOurNameLabel = new JLabel("Name:");
        JLabel eMail = new JLabel("Email:");
        JLabel bUsinessNameLabel = new JLabel("Business Name:");
      //  JTextField bUsinessNameField = new JTextField();
      //  JTextField yOurNamTextField = new JTextField();
      //  JTextField eMaField = new JTextField();


        yOurNameLabel.setBounds(50, 100, 120, 25);
        eMail.setBounds(50, 150, 120, 25);
        bUsinessNameLabel.setBounds(50, 200, 120, 25);
      //  yOurNamTextField.setBounds(125, 100, 200, 25);
      //  eMaField.setBounds(125, 150, 200, 25);
      //  yOurNamTextField.setBounds(125, 200, 200, 25);




        setTitle("Sign up");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(420, 700);
        
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        add(yOurNameLabel);
        add(eMail);
        add(bUsinessNameLabel);
      //  add(yOurNamTextField);
      //  add(eMaField);
      
      //  add(signUpPanel);
      //  add(bUsinessNameField);
        
        

    


    }
    

 


    
}
