import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewDetails extends JFrame implements ActionListener {
    JButton backbtn;

    ViewDetails(String username){
        setBounds(180,40,900,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel un = new JLabel("Username :");
        un.setBounds(30,50,150,25);
        un.setFont(new Font("Railways",Font.BOLD,20));
        add(un);

        JLabel labelun = new JLabel();
        labelun.setBounds(220,50,150,25);
        labelun.setFont(new Font("Railways",Font.BOLD,20));
        add(labelun);

        JLabel id = new JLabel("Id :");
        id.setBounds(30,110,150,25);
        id.setFont(new Font("Railways",Font.BOLD,20));
        add(id);

        JLabel labelid = new JLabel();
        labelid.setBounds(220,110,150,25);
        labelid.setFont(new Font("Railways",Font.BOLD,20));
        add(labelid);

        JLabel number = new JLabel("Number :");
        number.setBounds(30,170,150,25);
        number.setFont(new Font("Railways",Font.BOLD,20));
        add(number);

        JLabel labelnum = new JLabel();
        labelnum.setBounds(220,170,150,25);
        labelnum.setFont(new Font("Railways",Font.BOLD,20));
        add(labelnum);

        JLabel name = new JLabel("Name :");
        name.setBounds(30,230,150,25);
        name.setFont(new Font("Railways",Font.BOLD,20));
        add(name);

        JLabel labelname = new JLabel();
        labelname.setBounds(220,230,150,25);
        labelname.setFont(new Font("Railways",Font.BOLD,20));
        add(labelname);

        JLabel gender = new JLabel("Gender :");
        gender.setBounds(30,290,150,25);
        gender.setFont(new Font("Railways",Font.BOLD,20));
        add(gender);

        JLabel labelgender = new JLabel();
        labelgender.setBounds(220,290,150,25);
        labelgender.setFont(new Font("Railways",Font.BOLD,20));
        add(labelgender);

        JLabel country = new JLabel("Country :");
        country.setBounds(500,50,150,25);
        country.setFont(new Font("Railways",Font.BOLD,20));
        add(country);

        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(680,50,150,25);
        labelcountry.setFont(new Font("Railways",Font.BOLD,20));
        add(labelcountry);

        JLabel address = new JLabel("Address :");
        address.setBounds(500,110,150,25);
        address.setFont(new Font("Railways",Font.BOLD,20));
        add(address);

        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(680,110,150,25);
        labeladdress.setFont(new Font("Railways",Font.BOLD,20));
        add(labeladdress);

        JLabel email = new JLabel("Email :");
        email.setBounds(500,170,150,25);
        email.setFont(new Font("Railways",Font.BOLD,20));
        add(email);

        JLabel labelemail = new JLabel();
        labelemail.setBounds(680,170,150,25);
        labelemail.setFont(new Font("Railways",Font.BOLD,20));
        add(labelemail);

        JLabel phone = new JLabel("Phone :");
        phone.setBounds(500,230,150,25);
        phone.setFont(new Font("Railways",Font.BOLD,20));
        add(phone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(680,230,150,25);
        labelphone.setFont(new Font("Railways",Font.BOLD,20));
        add(labelphone);

        backbtn = new JButton("Back");
        backbtn.setBackground(Color.BLACK);
        backbtn.setForeground((Color.WHITE));
        backbtn.setBounds(580,290,100,30);
        backbtn.addActionListener(this);
        add(backbtn);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/travelGroup.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,300,800,300);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from addcustomer where username = '"+username+"'" );
            while(rs.next()){
                labelun.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnum.setText(rs.getString("idNumber"));
                labelname.setText(rs.getString("name"));
                labelgender.setText( rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelemail.setText(rs.getString("email"));
                labelphone.setText(rs.getString("phone"));

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == backbtn){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ViewDetails("sneha753");
    }
}
