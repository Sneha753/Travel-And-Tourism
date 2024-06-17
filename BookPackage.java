import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;

public class BookPackage extends JFrame implements ActionListener {

    JButton checkPriceBtn, bookPackageBtn, backBtn;
    JLabel getUserName, getId, getIdNumber, getPhone, getPrice;
    //    JTextField personsField;
    Choice packages, destinations, travelAgencies, transportations;
    JSlider personsField;
    int min = 1;
    int max = 15;
    HashSet<String> packs = new HashSet<>();
    String packageId, travelAgencyId;
    JRadioButton netBanking, upi, debitCard, creditCard;
    JTextField paymentField;

    String userId;
    BookPackage(String userId){
        this.userId = userId;

        setBounds(350, 80, 700, 500);
        setLayout(null);

        JLabel heading = new JLabel("BOOK PACKAGE");
        heading.setBounds(100, 30, 200, 30);
        heading.setFont(new Font("Railway", Font.PLAIN, 20));
        add(heading);

        JLabel heading2 = new JLabel("Payment");
        heading2.setBounds(500, 160, 100, 30);
        heading2.setFont(new Font("Railway", Font.BOLD, 12));
        add(heading2);

        JLabel travelAgencyLbl = new JLabel("Travel Agency");
        travelAgencyLbl.setBounds(400, 80, 100, 30);
        travelAgencyLbl.setFont(new Font("Railway", Font.BOLD, 12));
        add(travelAgencyLbl);

        travelAgencies = new Choice();
        travelAgencies.setBounds(510, 80, 150, 25);
        travelAgencies.setBackground(Color.WHITE);
        add(travelAgencies);

        JLabel transport = new JLabel("Transportation: ");
        transport.setBounds(400, 115, 100, 25);
        add(transport);

        transportations = new Choice();
        transportations.setBounds(510, 115, 150, 25);
        transportations.setBackground(Color.WHITE);
        add(transportations);

        JLabel userName = new JLabel("Name: ");
        userName.setBounds(30, 80, 150, 25);
        userName.setFont(new Font("Railway", Font.PLAIN, 16));
        add(userName);

        getUserName = new JLabel();
        getUserName.setBounds(200, 80, 150, 25);
        add(getUserName);

        JLabel lblpackage = new JLabel("Select Package: ");
        lblpackage.setBounds(30, 115, 150, 25);
        lblpackage.setFont(new Font("Railway", Font.PLAIN, 16));
        add(lblpackage);

        packages = new Choice();
        packages.setBounds(200, 115, 150, 25);
        packages.setBackground(Color.WHITE);
        add(packages);

        JLabel destination = new JLabel("Select Destination: ");
        destination.setBounds(30, 150, 150, 25);
        destination.setFont(new Font("Railway", Font.PLAIN, 16));
        add(destination);

        destinations = new Choice();
        destinations.setBounds(200, 150, 150, 25);
        destinations.setBackground(Color.WHITE);
        add(destinations);

        JLabel persons = new JLabel("Total Persons: ");
        persons.setBounds(30, 185, 150, 25);
        persons.setFont(new Font("Railway", Font.PLAIN, 16));
        add(persons);

        personsField = new JSlider(min, max);
        personsField.setBounds(200, 185, 150, 25);
        personsField.setFont(new Font("Railway", Font.PLAIN, 16));
        add(personsField);

        JLabel val = new JLabel(""+personsField.getValue());
        val.setBounds(355, 185, 150, 25);
        add(val);
        personsField.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                val.setText(""+personsField.getValue());
            }
        });

        JLabel id = new JLabel("ID: ");
        id.setBounds(30, 220, 150, 25);
        id.setFont(new Font("Railway", Font.PLAIN, 16));
        add(id);

        getId = new JLabel();
        getId.setBounds(200, 220, 150, 25);
        add(getId);

        JLabel idNumber = new JLabel("ID Number: ");
        idNumber.setBounds(30, 255, 150, 25);
        idNumber.setFont(new Font("Railway", Font.PLAIN, 16));
        add(idNumber);

        getIdNumber = new JLabel();
        getIdNumber.setBounds(200, 255, 150, 25);
        add(getIdNumber);

        JLabel phone = new JLabel("Phone: ");
        phone.setBounds(30, 290, 150, 25);
        phone.setFont(new Font("Railway", Font.PLAIN, 16));
        add(phone);

        getPhone = new JLabel();
        getPhone.setBounds(200, 290, 150, 25);
        add(getPhone);

        JLabel price = new JLabel("Total Price: ");
        price.setBounds(30, 325, 150, 25);
        price.setFont(new Font("Railway", Font.PLAIN, 16));
        add(price);

        getPrice = new JLabel();
        getPrice.setBounds(200, 325, 150, 25);
        add(getPrice);

        netBanking = new JRadioButton("Net Banking");
        netBanking.setBounds(450, 200, 100, 20);
        netBanking.setSelected(true);
        add(netBanking);
        upi = new JRadioButton("UPI");
        upi.setBounds(550, 200, 100, 20);
        add(upi);
        debitCard = new JRadioButton("Debit Card");
        debitCard.setBounds(450, 230, 100, 20);
        add(debitCard);
        creditCard = new JRadioButton("Credit Card");
        creditCard.setBounds(550, 230, 100, 20);
        add(creditCard);
        ButtonGroup pg = new ButtonGroup();
        pg.add(netBanking);
        pg.add(upi);
        pg.add(debitCard);
        pg.add(creditCard);

        JLabel paymentLbl = new JLabel("ID/Number:");
        paymentLbl.setBounds(450, 270, 100, 20);
        add(paymentLbl);

        paymentField = new JTextField();
        paymentField.setBounds(550, 270, 100, 20);
        add(paymentField);

        checkPriceBtn = new JButton("Check Price");
        checkPriceBtn.setBounds(50, 360, 140, 30);
        checkPriceBtn.setBackground(Color.BLACK);
        checkPriceBtn.setForeground(Color.WHITE);
        checkPriceBtn.addActionListener(this);
        add(checkPriceBtn);

        bookPackageBtn = new JButton("Book Package");
        bookPackageBtn.setBounds(220, 360, 140, 30);
        bookPackageBtn.setBackground(Color.BLACK);
        bookPackageBtn.setForeground(Color.WHITE);
        bookPackageBtn.addActionListener(this);
        add(bookPackageBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(140, 400, 140, 30);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        add(backBtn);



        try{
            Conn c = new Conn();
            String query = "select * from addcustomer where username='"+userId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                getUserName.setText(rs.getString("name"));
                getId.setText(rs.getString("id"));
                getIdNumber.setText(rs.getString("idNumber"));
                getPhone.setText(rs.getString("phone"));
            }
            rs = c.s.executeQuery("select * from package");
            while (rs.next()){
                packs.add(rs.getString("name"));
            }
            for(String pack : packs){
                packages.add(pack);
            }
            rs = c.s.executeQuery("select * from package where name='"+packages.getSelectedItem()+"'");
            while (rs.next()){
                destinations.add(rs.getString("destination"));
            }
            rs = c.s.executeQuery("select * from travelagency");
            while (rs.next()){
                travelAgencies.add(rs.getString("name"));
            }
            rs = c.s.executeQuery("select * from travelagency where name='"+travelAgencies.getSelectedItem()+"'");
            while (rs.next()){
                travelAgencyId = rs.getString("travelAgency_id");
                String[] trans = rs.getString("transportations").split(",");
                for(String t : trans){
                    transportations.add(t.trim());
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        travelAgencies.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                transportations.removeAll();
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from travelagency where name='"+travelAgencies.getSelectedItem()+"'");
                    while (rs.next()){
                        travelAgencyId = rs.getString("travelAgency_id");
                        String[] trans;
                        if(rs.getString("transportations").contains(",")){
                            trans = rs.getString("transportations").split(",");
                        }else {
                            trans = rs.getString("transportations").split(" ");
                        }
                        for(String t : trans){
                            transportations.add(t.trim());
                        }
                    }
                }
                catch (Exception ea){
                    ea.printStackTrace();
                }
            }
        });
        packages.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                destinations.removeAll();
                getPrice.setText("");
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from package where name='"+packages.getSelectedItem()+"'");
                    while (rs.next()){
                        destinations.add(rs.getString("destination"));
                    }
                }
                catch (Exception ea){
                    ea.printStackTrace();
                }
            }
        });
        destinations.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                getPrice.setText("");
            }
        });

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkPriceBtn){
            String pack = packages.getSelectedItem();
            String destination = destinations.getSelectedItem();
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from package where name='"+pack+"' and destination='"+destination+"'");
                while (rs.next()){
                    getPrice.setText(rs.getString("price"));
                    packageId = rs.getString("package_id");
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == bookPackageBtn){
            Random rand = new Random();
            long bookingId = Math.abs(rand.nextLong() % 1000000);
            long paymentId = Math.abs(rand.nextLong() % 1000000);
            String persons = "" + personsField.getValue();
            String price = getPrice.getText();
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
            String transportation = transportations.getSelectedItem();
            Date date = new Date();

            if(getUserName.getText().equals("") || paymentDetails.equals("")){
                JOptionPane.showMessageDialog(null, "All fields are required!");
                return;
            }
            else if(price.equals("")){
                JOptionPane.showMessageDialog(null,"Please Check Price First");
                return;
            }
            int confirm = JOptionPane.showConfirmDialog(null, "Please Confirm");
            if(getPrice.getText().length() > 2 && paymentDetails.length()>3 && confirm == 0){
                try{
                    Conn c = new Conn();
                    c.s.executeUpdate("insert into BookPackage values('"+bookingId+"', '"+userId+"', '"+packageId+"', '"+travelAgencyId+"', '"+transportation+"', '"+persons+"', '"+price+"', '"+paymentId+"', '"+date+"')");
                    c.s.executeUpdate("insert into payments values('"+paymentId+"', '"+bookingId+"', '"+userId+"', '"+paymentMethod+"', '"+paymentDetails+"', '"+price+"', '"+date+"')");

                    JOptionPane.showMessageDialog(null,"Package booked successfully");
                    setVisible(false);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            else if(paymentDetails.length()<3){
                JOptionPane.showMessageDialog(null, "Invalid Payment ID/Number!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Payment Canceled!");
            }
        }
        else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new BookPackage("");
    }
}
