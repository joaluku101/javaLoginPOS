import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public void initialize(User user){
        /***********Info Panel********/
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(0, 2, 5, 5));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30,50));
        infoPanel.add(new JLabel("First Name"));
        infoPanel.add(new JLabel(user.FirstName));
        infoPanel.add(new JLabel("Second Name"));
        infoPanel.add(new JLabel(user.SecondName));
        infoPanel.add(new JLabel("Role"));
        infoPanel.add(new JLabel(user.role));
        infoPanel.add(new JLabel("E-mail"));
        infoPanel.add(new JLabel(user.email));
        infoPanel.add(new JLabel("Phone"));
        infoPanel.add(new JLabel(user.phone));
        infoPanel.add(new JLabel("ID No"));
        infoPanel.add(new JLabel(user.idno));
        infoPanel.add(new JLabel("Address"));
        infoPanel.add(new JLabel(user.address));
        infoPanel.add(new JLabel("Date of Birth"));
        infoPanel.add(new JLabel(user.dob));

        add(infoPanel, BorderLayout.NORTH);

        setTitle("Dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);



    }


    
}
