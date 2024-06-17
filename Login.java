import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField unfield, pwfield;
    JButton loginbtn, SignUpbtn, Forgotpwbtn;

    Login() {
        setSize(900, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 223));
        p1.setBounds(0, 0, 450, 500);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login3.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel loginImg = new JLabel(i3);
        loginImg.setBounds(20, 20, 400, 400);
        p1.add(loginImg);

        JLabel login = new JLabel("Login");
        login.setBounds(600, 20, 150, 50);
        login.setFont(new Font("Railway", Font.BOLD, 40));
        login.setForeground(new Color(36, 194, 211));
        add(login);

        JLabel un = new JLabel("Username :");
        un.setBounds(500, 120, 150, 30);
        un.setFont(new Font("Railway", Font.BOLD, 20));
        un.setForeground(Color.BLACK);
        add(un);

        unfield = new JTextField();
        unfield.setBounds(650, 120, 180, 30);
        add(unfield);

        JLabel pw = new JLabel("Password :");
        pw.setBounds(500, 190, 150, 30);
        pw.setFont(new Font("Railway", Font.BOLD, 20));
        pw.setForeground(Color.BLACK);
        add(pw);

        pwfield = new JTextField();
        pwfield.setBounds(650, 190, 180, 30);
        add(pwfield);

        loginbtn = new JButton("Login");
        loginbtn.setBounds(500, 280, 150, 50);
        loginbtn.setBackground(new Color(131, 193, 223));
        loginbtn.setForeground(Color.WHITE);
        loginbtn.setFont(new Font("Railway", Font.BOLD, 20));
        loginbtn.addActionListener(this);
        add(loginbtn);


        SignUpbtn = new JButton("SignUp");
        SignUpbtn.setBounds(700, 280, 150, 50);
        SignUpbtn.setBackground(new Color(131, 193, 223));
        SignUpbtn.setForeground(Color.WHITE);
        SignUpbtn.setFont(new Font("Railway", Font.BOLD, 20));
        SignUpbtn.addActionListener(this);
        add(SignUpbtn);

        Forgotpwbtn = new JButton("Forgot Password");
        Forgotpwbtn.setBounds(580, 350, 200, 50);
        Forgotpwbtn.setBackground(new Color(131, 193, 223));
        Forgotpwbtn.setForeground(Color.WHITE);
        Forgotpwbtn.setFont(new Font("Railway", Font.BOLD, 20));
        Forgotpwbtn.addActionListener(this);
        add(Forgotpwbtn);


        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginbtn) {
            String username = unfield.getText();
            String password = pwfield.getText();

            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select *from login where username = '"+username+"' and password ='"+password+"'");
                if(rs.next()){
                    setVisible(false);
                    new Dashboard(rs.getString("username"),rs.getString("user_type"));
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }

            }
            catch(Exception ex){
                ex.printStackTrace();
            }

        } else if (e.getSource() == SignUpbtn) {
            setVisible(false);
            new SignUp();
        } else if (e.getSource() == Forgotpwbtn) {
        }
    }
}