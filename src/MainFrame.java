import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
    public void init(){

    

        JLabel name = new JLabel("Your Name Here");
    name.setBounds(40,50,40,40);
    add(name);

        JTextField name_field = new JTextField();
        name_field.setBounds(50,60,50,50);
        add(name_field);

    
        setTitle("Login");
        setSize(700, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


    }
    

}
