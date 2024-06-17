import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgotPassword extends JFrame implements ActionListener {
    JTextField usField,sqField,nameField,ansField;
    JPasswordField pwField;
    JButton searchbtn, retrievebtn,backbtn;

    ForgotPassword(){
        setBounds(300,100,800,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fp.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(520,70,200,200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(40,20,400,300);
        add(p1);

        JLabel username = new JLabel("Username :");
        username.setBounds(40,20,100,30);
        username.setFont(new Font("Railway",Font.BOLD,16));
        p1.add(username);

        usField = new JTextField();
        usField.setBounds(180,40,150,30);
        add(usField);

        searchbtn = new JButton("Search");
        searchbtn.setBackground(new Color(131, 193, 223));
        searchbtn.setForeground(Color.WHITE);
        searchbtn.setBounds(300,20,80,30);
        searchbtn.addActionListener(this);
        p1.add(searchbtn);

        JLabel name = new JLabel("Name:");
        name.setBounds(40,60,100,30);
        name.setFont(new Font("Railway",Font.BOLD,16));
        p1.add(name);

        nameField = new JTextField();
        nameField.setBounds(140,60,150,30);
        p1.add(nameField);

        JLabel sq = new JLabel("Question:");
        sq.setBounds(40,100,100,30);
        sq.setFont(new Font("Railway",Font.BOLD,16));
        p1.add(sq);

        sqField = new JTextField();
        sqField.setBounds(140,100,150,30);
        p1.add(sqField);


        JLabel ans = new JLabel("Answer:");
        ans.setBounds(40,140,100,30);
        ans.setFont(new Font("Railway",Font.BOLD,16));
        p1.add(ans);

        ansField = new JTextField();
        ansField.setBounds(140,140,150,30);
        p1.add(ansField);

        retrievebtn = new JButton("Retrieve");
        retrievebtn.setBackground(new Color(131, 193, 223));
        retrievebtn.setForeground(Color.WHITE);
        retrievebtn.setBounds(300,140,90,30);
        retrievebtn.addActionListener(this);
        p1.add(retrievebtn);

        JLabel pw = new JLabel("Password:");
        pw.setBounds(40,180,100,30);
        pw.setFont(new Font("Railway",Font.BOLD,16));
        p1.add(pw);

        pwField = new JPasswordField();
        pwField.setBounds(140,180,150,30);
        p1.add(pwField);

        backbtn = new JButton("Back");
        backbtn.setBackground(new Color(131, 193, 223));
        backbtn.setForeground(Color.WHITE);
        backbtn.setBounds(160,240,90,30);
        backbtn.addActionListener(this);
        p1.add(backbtn);

        setVisible(true);

    }

    public static void main(String[] args) {
        new ForgotPassword();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == searchbtn){
            try{
                String query = "select *from signup where username = '"+usField.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    rs.getString("name");
                    rs.getString("Question");


                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == retrievebtn){

        }
        else{
            setVisible(false);
            new Login();
        }
    }
}
