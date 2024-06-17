import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class AddTravelAgency extends JFrame implements ActionListener {
    JLabel travelAgencyIdField;
    JTextField nameField, phoneField, emailField, addressField;
    JButton addBtn, backBtn;
    JCheckBox transportation1Field, transportation2Field, transportation3Field, transportation4Field;
    AddTravelAgency(){
        setBounds(350, 140, 700, 320);
        setLayout(null);

        JLabel heading = new JLabel("Add Travel Agency");
        heading.setFont(new Font("Railway", Font.BOLD, 18));
        heading.setBounds(250, 10, 200, 30);
        add(heading);

        JLabel travelAgencyId = new JLabel("ID: ");
        travelAgencyId.setBounds(30, 60, 100, 20);
        add(travelAgencyId);

        Random rand = new Random();
        long taId = Math.abs(rand.nextLong() % 1000000);
        travelAgencyIdField = new JLabel(""+taId);
        travelAgencyIdField.setBounds(150, 60, 160, 20);
        add(travelAgencyIdField);

        JLabel name = new JLabel("Name: ");
        name.setBounds(30, 120, 100, 20);
        add(name);

        nameField = new JTextField();
        nameField.setBounds(150, 120, 160, 20);
        add(nameField);

        JLabel phone = new JLabel("Phone: ");
        phone.setBounds(30, 180, 100, 20);
        add(phone);

        phoneField = new JTextField();
        phoneField.setBounds(150, 180, 160, 20);
        add(phoneField);

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

        JLabel transportations = new JLabel("Transportations: ");
        transportations.setBounds(390, 180, 100, 20);
        add(transportations);

        transportation1Field = new JCheckBox("Flight");
        transportation1Field.setBounds(490, 180, 70, 20);
        add(transportation1Field);
        transportation2Field = new JCheckBox("Train");
        transportation2Field.setBounds(570, 180, 70, 20);
        add(transportation2Field);
        transportation3Field = new JCheckBox("Bus");
        transportation3Field.setBounds(490, 200, 70, 20);
        add(transportation3Field);
        transportation4Field = new JCheckBox("Car");
        transportation4Field.setBounds(570, 200, 70, 20);
        add(transportation4Field);

        addBtn = new JButton("Add");
        addBtn.setBounds(30, 240, 100, 30);
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        addBtn.addActionListener(this);
        add(addBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(140, 240, 100, 30);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        add(backBtn);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addBtn){
            String id = travelAgencyIdField.getText();
            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String address = addressField.getText();
            String transportations = "";
            if(transportation1Field.isSelected()){
                transportations = transportations + transportation1Field.getText()+" ";
            }
            if(transportation2Field.isSelected()){
                transportations = transportations + transportation2Field.getText()+" ";
            }
            if(transportation3Field.isSelected()){
                transportations = transportations + transportation3Field.getText()+" ";
            }
            if(transportation4Field.isSelected()){
                transportations = transportations + transportation4Field.getText()+" ";
            }

            if(name.equals("")||phone.equals("")||email.equals("")||address.equals("")||transportations.equals("")){
                JOptionPane.showMessageDialog(null, "All fields are required!");
            }
            else {
                try{
                    Conn c = new Conn();
                    String query = "insert into travelagency values('"+id+"', '"+name+"', '"+phone+"', '"+email+"', '"+address+"', '"+transportations+"')";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Travel agency added successfully!");
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
        new AddTravelAgency();
    }
}

