
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class SignUp extends JFrame implements ActionListener {
    JLabel signUpIdField;
    JTextField usfield, namefield, pnfield, ansfield;
    JPasswordField pwfield;
    Choice sqField;
    JButton createBtn, cancelBtn;

    SignUp(){
            setBounds(80,50,1100,600);
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            JPanel p1 = new JPanel();
            p1.setBackground(new Color(131,193,223));
            p1.setBounds(0,0,600,600);
            p1.setLayout(null);
            add(p1);


            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
            Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel signupImg = new JLabel(i3);
            signupImg.setBounds(100,80 , 400 , 400);
            p1.add(signupImg);

            JLabel Signup = new JLabel("SignUp");
            Signup.setFont(new Font("Railway",Font.BOLD,34));
            Signup.setBounds(800,20,150,50);
            Signup.setForeground(new Color(37, 180, 196));
            add(Signup);

            JLabel us = new JLabel("Username :");
            us.setFont(new Font("Railway",Font.BOLD,16));
            us.setBounds(650,95,125,30);
            add(us);

            usfield = new JTextField();
            usfield.setBounds(830,95,200,30);
            add(usfield);

            JLabel name = new JLabel("Name :");
            name.setFont(new Font("Railway",Font.BOLD,16));
            name.setBounds(650,140,125,30);
            add(name);

            namefield = new JTextField();
            namefield.setBounds(830,140,200,30);
            add(namefield);

            JLabel pw = new JLabel("Password :");
            pw.setFont(new Font("Railway",Font.BOLD,16));
            pw.setBounds(650,185,125,30);
            add(pw);

            pwfield = new JPasswordField();
            pwfield.setBounds(830,185,200,30);
            add(pwfield);

            JLabel pn = new JLabel("Phone no :");
            pn.setFont(new Font("Railway",Font.BOLD,16));
            pn.setBounds(650,230,125,30);
            add(pn);

            pnfield = new JTextField();
            pnfield.setBounds(830,230,200,30);
            add(pnfield);

            JLabel sq = new JLabel("Security question :");
            sq.setFont(new Font("Railway",Font.BOLD,16));
            sq.setBounds(650,275,150,30);
            add(sq);

            sqField = new Choice();
            sqField.setFont(new Font("Railway",Font.BOLD,16));
            sqField.setBounds(830, 275, 200, 30);
            sqField.add("What is your fav color");
            sqField.add("What is your fav sports");
            sqField.add("What is your fav food");
            sqField.add("Which is your birth place");
            add(sqField);

            JLabel ans = new JLabel("Answer :");
            ans.setFont(new Font("Railway",Font.BOLD,16));
            ans.setBounds(650,320,125,30);
            add(ans);

            ansfield = new JTextField();
            ansfield.setBounds(830,320,200,30);
            add(ansfield);

            createBtn = new JButton("Create");
            createBtn.setFont(new Font("Railway",Font.BOLD,18));
            createBtn.setBounds(700, 400, 120, 40);
            createBtn.setBackground(new Color(131,193,223));
            createBtn.setForeground(Color.WHITE);
            createBtn.addActionListener(this);
            add(createBtn);

            cancelBtn = new JButton("Cancel");
            cancelBtn.setFont(new Font("Railway",Font.BOLD,18));
            cancelBtn.setBounds(900, 400, 120, 40);
            cancelBtn.setBackground(new Color(131,193,223));
            cancelBtn.setForeground(Color.WHITE);
            cancelBtn.addActionListener(this);
            add(cancelBtn);





        setVisible(true);
    }
    public static void main(String[] args) {
        new SignUp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==createBtn){
                Random rand = new Random();
                long signupid = Math.abs(rand.nextLong() % 1000000);
                long loginid = Math.abs(rand.nextLong() % 1000000);
                String signupId = signupid + "";
                String loginId = loginid + "";
                String username = usfield.getText();
                String name = namefield.getText();
                String password = pwfield.getText();
                String phone = pnfield.getText();
                String securityQuestion = sqField.getSelectedItem();
                String answer = ansfield.getText();


                try{
                   Conn c = new Conn();
                   String query1 = "insert into signup values('"+signupId+"','"+loginId+"','"+username+"','"+name+"','"+password+"','"+phone+"','"+securityQuestion+"','"+answer+"','CUSTOMER')";
                   String query2 = "insert into login values('"+loginId+"','"+username+"','"+password+"','CUSTOMER')";
                   c.s.executeUpdate(query1);
                   c.s.executeUpdate(query2);

                   JOptionPane.showMessageDialog(null,"Account created successfully");
                   setVisible(false);
                   new Login();
                }
                catch(Exception ex){
                        ex.printStackTrace();
                }

        }
        else if(e.getSource()==cancelBtn){
            setVisible(false);
            new Login();
        }
    }
}
