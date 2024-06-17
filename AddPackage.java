import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class AddPackage extends JFrame implements ActionListener {
    JLabel packageIdField;
    JTextField nameField, destinationField, priceField;
    JButton addBtn, backBtn;
    JTextArea packageDescriptionField;
    AddPackage(){
        setBounds(350, 140, 700, 320);
        setLayout(null);

        JLabel heading = new JLabel("Add Package");
        heading.setFont(new Font("Railway", Font.BOLD, 18));
        heading.setBounds(250, 10, 200, 30);
        add(heading);

        JLabel packageId = new JLabel("ID: ");
        packageId.setBounds(30, 10, 30, 20);
        add(packageId);

        Random rand = new Random();
        long hId = Math.abs(rand.nextLong() % 1000000);
        packageIdField = new JLabel(""+hId);
        packageIdField.setBounds(60, 10, 160, 20);
        add(packageIdField);

        JLabel name = new JLabel("Name: ");
        name.setBounds(30, 60, 100, 20);
        add(name);

        nameField = new JTextField();
        nameField.setBounds(150, 60, 160, 20);
        add(nameField);

        JLabel destination = new JLabel("Destination: ");
        destination.setBounds(30, 120, 100, 20);
        add(destination);

        destinationField = new JTextField();
        destinationField.setBounds(150, 120, 160, 20);
        add(destinationField);

        JLabel price = new JLabel("Price: ");
        price.setBounds(30, 180, 100, 20);
        add(price);

        priceField = new JTextField();
        priceField.setBounds(150, 180, 160, 20);
        add(priceField);

        JLabel packageDescription = new JLabel("Package Description: ");
        packageDescription.setBounds(350, 60, 140, 20);
        add(packageDescription);

        packageDescriptionField = new JTextArea();
        packageDescriptionField.setBounds(490, 60, 160, 100);
        packageDescriptionField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        packageDescriptionField.setLineWrap(true);
        add(packageDescriptionField);

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
            String id = packageIdField.getText();
            String name = nameField.getText();
            String destination = destinationField.getText();
            String price = priceField.getText();
            String packageDescription = packageDescriptionField.getText();
            if(packageDescription.length()>499){
                JOptionPane.showMessageDialog(null, "Description length:"+packageDescription.length()+" You can add only 500 characters description");
            }
            else if(name.equals("")||destination.equals("")||price.equals("")||packageDescription.equals("")){
                JOptionPane.showMessageDialog(null, "All fields are required!");
            }
            else {
                try{
                    Conn c = new Conn();
                    c.s.executeUpdate("insert into package values('"+id+"', '"+name+"', '"+destination+"', '"+price+"', '"+packageDescription+"')");

                    JOptionPane.showMessageDialog(null, "Package Added Successfully!");
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
        new AddPackage();
    }
}
