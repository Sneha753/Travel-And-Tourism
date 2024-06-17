import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddHotel extends JFrame implements ActionListener {
    JLabel hotelIdField;
    JTextField nameField, phoneField, emailField, addressField, priceField;
    JButton addBtn, backBtn;
    JTextArea hotelDescriptionField;
    AddHotel(){
        setBounds(50, 70, 1200, 500);
        setLayout(null);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/bookhotel.jpg"));
        Image i5 = i4.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(690,0,500,500);
        add(image);

        JLabel heading = new JLabel("Add Hotel");
        heading.setFont(new Font("Railway", Font.BOLD, 18));
        heading.setBounds(250, 10, 200, 30);
        add(heading);

        JLabel hotelId = new JLabel("ID: ");
        hotelId.setBounds(30, 10, 30, 20);
        add(hotelId);

        Random rand = new Random();
        long hId = Math.abs(rand.nextLong() % 1000000);
        hotelIdField = new JLabel(""+hId);
        hotelIdField.setBounds(60, 10, 160, 20);
        add(hotelIdField);

        JLabel name = new JLabel("Name: ");
        name.setBounds(30, 60, 100, 20);
        add(name);

        nameField = new JTextField();
        nameField.setBounds(150, 60, 160, 20);
        add(nameField);

        JLabel phone = new JLabel("Phone: ");
        phone.setBounds(30, 120, 100, 20);
        add(phone);

        phoneField = new JTextField();
        phoneField.setBounds(150, 120, 160, 20);
        add(phoneField);

        JLabel price = new JLabel("Price: ");
        price.setBounds(30, 180, 100, 20);
        add(price);

        priceField = new JTextField();
        priceField.setBounds(150, 180, 160, 20);
        add(priceField);

        JLabel email = new JLabel("E-mail: ");
        email.setBounds(390, 60, 100, 20);
        add(email);

        emailField = new JTextField();
        emailField.setBounds(490, 60, 160, 20);
        add(emailField);

        JLabel address = new JLabel("Address: ");
        address.setBounds(390, 120, 100, 20);
        add(address);

        addressField = new JTextField();
        addressField.setBounds(490, 120, 160, 20);
        add(addressField);

        JLabel description = new JLabel("Description: ");
        description.setBounds(390, 180, 100, 20);
        add(description);

        hotelDescriptionField = new JTextArea();
        hotelDescriptionField.setBounds(490, 180, 160, 60);
        hotelDescriptionField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        hotelDescriptionField.setLineWrap(true);
        add(hotelDescriptionField);

        addBtn = new JButton("Add");
        addBtn.setBounds(30, 280, 100, 30);
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        addBtn.addActionListener(this);
        add(addBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(180, 280, 100, 30);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        add(backBtn);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addBtn){
            String id = hotelIdField.getText();
            String name = nameField.getText();
            String phone = phoneField.getText();
            String price = priceField.getText();
            String email = emailField.getText();
            String address = addressField.getText();
            String description = hotelDescriptionField.getText();
            if(description.length()>499){
                JOptionPane.showMessageDialog(null, "Description length:"+description.length()+" You can add only 500 characters description");
            }
            else if(name.equals("")||phone.equals("")||email.equals("")||address.equals("")||price.equals("")||description.equals("")){
                JOptionPane.showMessageDialog(null, "All fields are required!");
            }
            else {
                try{
                    Conn c = new Conn();
                    String query = "insert into hotel values('"+id+"', '"+name+"', '"+phone+"', '"+price+"', '"+email+"', '"+address+"', '"+description+"', '')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate("insert into calculateRatings values('"+id+"', '"+0+"', '"+0+"')");

                    JOptionPane.showMessageDialog(null, "Hotel added successfully!");
                    setVisible(false);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
        else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddHotel();
    }
}
