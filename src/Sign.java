import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Sign extends JFrame {
    Sign(){
        setTitle("Sign Up Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);

        LoginForm login = new LoginForm();
        login.setVisible(false);


    }


    
}
