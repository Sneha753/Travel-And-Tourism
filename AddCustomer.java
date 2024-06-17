import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {
    JLabel labelusername, labelname;
    JComboBox comboid;
    JTextField numField,countryfield,addressfield, emailfield, phonefield;
    JRadioButton rmale, rfemale;
    JButton addbtn, backbtn;
    String userName;

    AddCustomer(String userName){
        this.userName = userName;
        setBounds(180,50,900,600);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel username = new JLabel("Username :");
        username.setBounds(30,50,150,30);
        username.setFont(new Font("Railway",Font.BOLD,18));
        add(username);

        labelusername = new JLabel();
        labelusername.setBounds(220,50,150,30);
        labelusername.setFont(new Font("Railway",Font.BOLD,18));
        add(labelusername);

        JLabel id = new JLabel("ID :");
        id.setBounds(30,100,150,30);
        id.setFont(new Font("Railway",Font.BOLD,18));
        add(id);

        String [] ids = { "Aadhar Card", "Passport", "Ration Card","Pan Card"};
        comboid= new JComboBox(ids);
        comboid.setBounds(220,100,150,30);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel number = new JLabel("Number :");
        number.setBounds(30,140,150,30);
        number.setFont(new Font("Railway",Font.BOLD,18));
        add(number);

        numField = new JTextField();
        numField.setBounds(220,140,150,30);
        add(numField);

        JLabel name = new JLabel("Name :");
        name.setBounds(30,180,150,30);
        name.setFont(new Font("Railway",Font.BOLD,18));
        add(name);

        labelname = new JLabel();
        labelname.setBounds(220,180,150,30);
        labelname.setFont(new Font("Railway",Font.BOLD,18));
        add(labelname);

        JLabel gender = new JLabel("Gender :");
        gender.setBounds(30,220,150,30);
        gender.setFont(new Font("Railway",Font.BOLD,18));
        add(gender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(220,220,70,30);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300,220,70,30);
        add(rfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        JLabel country = new JLabel("Country :");
        country.setBounds(30,260,150,30);
        country.setFont(new Font("Railway",Font.BOLD,18));
        add(country);

        countryfield = new JTextField();
        countryfield.setBounds(220,260,150,30);
        add(countryfield);

        JLabel address = new JLabel("Address :");
        address.setBounds(30,300,150,30);
        address.setFont(new Font("Railway",Font.BOLD,18));
        add(address);

        addressfield = new JTextField();
        addressfield.setBounds(220,300,150,30);
        add(addressfield);

        JLabel email = new JLabel("E-mail :");
        email.setBounds(30,340,150,30);
        email.setFont(new Font("Railway",Font.BOLD,18));
        add(email);

        emailfield = new JTextField();
        emailfield.setBounds(220,340,150,30);
        add(emailfield);

        JLabel phone = new JLabel("Phone :");
        phone.setBounds(30,380,150,30);
        phone.setFont(new Font("Railway",Font.BOLD,18));
        add(phone);

        phonefield = new JTextField();
        phonefield.setBounds(220,380,150,30);
        add(phonefield);

        addbtn = new JButton("Add");
        addbtn.setBackground(new Color(131, 193, 223));
        addbtn.setForeground(Color.WHITE);
        addbtn.setBounds(70,440,100,40);
        addbtn.addActionListener(this);
        add(addbtn);

        backbtn = new JButton("Back");
        backbtn.setBackground(new Color(131, 193, 223));
        backbtn.setForeground(Color.WHITE);
        backbtn.setBounds(220,440,100,40);
        backbtn.addActionListener(this);
        add(backbtn);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 500, 500);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from signup where username = '"+userName+"'" );
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
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
        if(ae.getSource() == addbtn){
            String username = labelusername.getText();
            String id = (String)comboid.getSelectedItem();
            String idNumber = numField.getText();
            String name  = labelname.getText();
            String gender = "";
            if(rmale.isSelected()){
                gender = "Male";
            }
            else if (rfemale.isSelected()){
                gender = "Female";
            }
            String country = countryfield.getText();
            String address = addressfield.getText();
            String email = emailfield.getText();
            String phone = phonefield.getText();

            try{
                Conn c = new Conn();
                String query = "insert into AddCustomer values ('"+name+"','"+username+"','"+id+"','"+idNumber+"','"+gender+"','"+country+"','"+address+"','"+email+"','"+phone+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);

            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == backbtn){
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new AddCustomer("");
    }

}

