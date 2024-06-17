import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Random;

public class BookHotel extends JFrame implements ActionListener {
    JLabel nameField, priceField, phoneField, emailField, descriptionField, addressField;
    Choice hotelField;
    JButton bookBtn, backBtn;
    String userId;
    String hotelId = "";
    JRadioButton netBanking, upi, debitCard, creditCard;
    JTextField paymentField;
    BookHotel(String userId){
        this.userId = userId;
        setBounds(350, 60, 700, 600);
        setLayout(null);

        JLabel heading = new JLabel("Book Hotel");
        heading.setBounds(280, 10, 100, 30);
        heading.setFont(new Font("Railway", Font.BOLD, 16));
        add(heading);

        JLabel heading2 = new JLabel("Payment");
        heading2.setBounds(500, 60, 100, 30);
        heading2.setFont(new Font("Railway", Font.BOLD, 12));
        add(heading2);

        JLabel name = new JLabel("Name: ");
        name.setBounds(40, 60, 100, 30);
        add(name);

        nameField = new JLabel();
        nameField.setBounds(160, 60, 180, 30);
        add(nameField);

        JLabel hotel = new JLabel("Hotel: ");
        hotel.setBounds(40, 120, 100, 30);
        add(hotel);

        hotelField = new Choice();
        hotelField.setBounds(160, 120, 180, 30);
        add(hotelField);

        JLabel price = new JLabel("Price: ");
        price.setBounds(40, 180, 100, 30);
        add(price);

        priceField = new JLabel();
        priceField.setBounds(160, 180, 180, 30);
        add(priceField);

        JLabel phone = new JLabel("Phone: ");
        phone.setBounds(40, 240, 100, 30);
        add(phone);

        phoneField = new JLabel();
        phoneField.setBounds(160, 240, 180, 30);
        add(phoneField);

        JLabel email = new JLabel("E-mail: ");
        email.setBounds(40, 300, 100, 30);
        add(email);

        emailField = new JLabel();
        emailField.setBounds(160, 300, 180, 30);
        add(emailField);

        JLabel description = new JLabel("Description: ");
        description.setBounds(40, 360, 100, 30);
        add(description);

        descriptionField = new JLabel();
        descriptionField.setBounds(160, 360, 300, 30);
        add(descriptionField);

        JLabel address = new JLabel("Address: ");
        address.setBounds(40, 420, 100, 30);
        add(address);

        addressField = new JLabel();
        addressField.setBounds(160, 420, 300, 30);
        add(addressField);

        netBanking = new JRadioButton("Net Banking");
        netBanking.setBounds(450, 110, 100, 20);
        netBanking.setSelected(true);
        add(netBanking);
        upi = new JRadioButton("UPI");
        upi.setBounds(550, 110, 100, 20);
        add(upi);
        debitCard = new JRadioButton("Debit Card");
        debitCard.setBounds(450, 140, 100, 20);
        add(debitCard);
        creditCard = new JRadioButton("Credit Card");
        creditCard.setBounds(550, 140, 100, 20);
        add(creditCard);
        ButtonGroup pg = new ButtonGroup();
        pg.add(netBanking);
        pg.add(upi);
        pg.add(debitCard);
        pg.add(creditCard);

        JLabel paymentLbl = new JLabel("ID/Number:");
        paymentLbl.setBounds(450, 180, 100, 20);
        add(paymentLbl);

        paymentField = new JTextField();
        paymentField.setBounds(550, 180, 100, 20);
        add(paymentField);

        bookBtn = new JButton("Book");
        bookBtn.setBounds(40, 480, 100, 30);
        bookBtn.setBackground(Color.BLACK);
        bookBtn.setForeground(Color.WHITE);
        bookBtn.addActionListener(this);
        add(bookBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(160, 480, 100, 30);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        add(backBtn);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from addcustomer where username='"+userId+"'");
            while (rs.next()){
                nameField.setText(rs.getString("name"));
            }
            rs = c.s.executeQuery("select * from hotel");
            while (rs.next()){
                hotelField.add(rs.getString("name"));
            }
            rs = c.s.executeQuery("select * from hotel where name='"+hotelField.getSelectedItem()+"'");
            while (rs.next()){
                priceField.setText(rs.getString("price"));
                phoneField.setText(rs.getString("phone"));
                emailField.setText(rs.getString("email"));
                descriptionField.setText(rs.getString("description"));
                addressField.setText(rs.getString("address"));
                hotelId = rs.getString("hotel_id");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        hotelField.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String hotel = hotelField.getSelectedItem();
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from hotel where name='"+hotel+"'");
                    while (rs.next()){
                        priceField.setText(rs.getString("price"));
                        phoneField.setText(rs.getString("phone"));
                        emailField.setText(rs.getString("email"));
                        descriptionField.setText(rs.getString("description"));
                        addressField.setText(rs.getString("address"));
                        hotelId = rs.getString("hotel_id");
                    }
                }
                catch (Exception ea){
                    ea.printStackTrace();
                }
            }
        });

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == bookBtn){
            Random rand = new Random();
            long bookingId = Math.abs(rand.nextLong() % 1000000);
            long paymentId = Math.abs(rand.nextLong() % 1000000);
            String name = nameField.getText();
            String hotel = hotelField.getSelectedItem();
            String price = priceField.getText();
            String paymentMethod = "";
            if(netBanking.isSelected()){
                paymentMethod = "Net Banking";
            }
            else if(upi.isSelected()){
                paymentMethod = "UPI";
            }
            else if(debitCard.isSelected()){
                paymentMethod = "Debit Card";
            }
            else {
                paymentMethod = "Credit Card";
            }
            String paymentDetails = paymentField.getText();
            Date date = new Date();
            int confirm = JOptionPane.showConfirmDialog(null, "Please Confirm");
            if(paymentDetails.length()<3){
                JOptionPane.showMessageDialog(null, "Payment Details Are Required And ID/Number must be 6 or more Characters!");
            }
            else if(paymentDetails.equals("")){
                JOptionPane.showMessageDialog(null, "Payment Details Are Required!");
            }
            else if (confirm == 0){
                try{
                    Conn c = new Conn();
                    String query = "insert into bookHotel values('"+bookingId+"', '"+userId+"', '"+hotelId+"', '"+name+"', '"+hotel+"', '"+price+"', '"+paymentId+"', '"+date+"')";
                    String query2 = "insert into payments values('"+paymentId+"', '"+bookingId+"', '"+userId+"', '"+paymentMethod+"', '"+paymentDetails+"', '"+price+"', '"+date+"')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Hotel Booked Successfully!");
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
        new BookHotel("sneha753");
    }
}
