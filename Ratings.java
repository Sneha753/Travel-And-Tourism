import net.proteanit.sql.*;
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

public class Ratings extends JFrame implements ActionListener {
    String userId, hotelId;
    JLabel nameField;
    Choice hotelField;
    JSlider ratingField;
    JTextField reviewField;
    JTable table;
    JButton submitBtn, backBtn;
    int numberOfRatings, totalRating;
    Ratings(String userId){
        this.userId = userId;
        setBounds(200, 20, 1000, 700);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 1000, 120);
        p1.setBackground(new Color(0, 195, 255));
        p1.setLayout(null);
        add(p1);

        JLabel name = new JLabel("Name: ");
        name.setBounds(40, 20, 100, 30);
        name.setFont(new Font("Railway", Font.BOLD, 16));
        name.setForeground(Color.WHITE);
        p1.add(name);

        nameField = new JLabel();
        nameField.setBounds(160, 20, 150, 30);
        nameField.setForeground(Color.WHITE);
        p1.add(nameField);

        JLabel hotel = new JLabel("Hotel: ");
        hotel.setBounds(40, 60, 100, 30);
        hotel.setFont(new Font("Railway", Font.BOLD, 16));
        hotel.setForeground(Color.WHITE);
        p1.add(hotel);

        hotelField = new Choice();
        hotelField.setBounds(160, 60, 150, 30);
        p1.add(hotelField);

        JLabel rating = new JLabel("Rating: ");
        rating.setBounds(380, 20, 100, 30);
        rating.setFont(new Font("Railway", Font.BOLD, 16));
        rating.setForeground(Color.WHITE);
        p1.add(rating);

        ratingField = new JSlider(1, 5);
        ratingField.setBounds(500, 20, 130, 30);
        ratingField.setValue(5);
        ratingField.setBackground(null);
        p1.add(ratingField);
        JLabel val = new JLabel(ratingField.getValue()+"/5");
        val.setFont(new Font("Railway", Font.BOLD, 14));
        val.setForeground(Color.WHITE);
        val.setBounds(635, 20, 20, 30);
        p1.add(val);
        ratingField.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                val.setText(ratingField.getValue()+"/5");
            }
        });

        JLabel review = new JLabel("Review: ");
        review.setBounds(380, 60, 100, 30);
        review.setFont(new Font("Railway", Font.BOLD, 16));
        review.setForeground(Color.WHITE);
        p1.add(review);

        reviewField = new JTextField();
        reviewField.setBounds(500, 60, 150, 30);
        p1.add(reviewField);

        table = new JTable();
        table.setRowHeight(50);
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        getRatings();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bookHotel where user_id='"+userId+"'");
            while (rs.next()){
                nameField.setText(rs.getString("name"));
                hotelField.add(rs.getString("hotel"));
            }
            rs = c.s.executeQuery("select * from bookHotel where user_id='"+userId+"' and hotel='"+hotelField.getSelectedItem()+"'");
            while (rs.next()){
                hotelId = rs.getString("hotel_id");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        hotelField.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from bookHotel where user_id='"+userId+"' and hotel='"+hotelField.getSelectedItem()+"'");
                    while (rs.next()){
                        hotelId = rs.getString("hotel_id");
                    }
                }
                catch (Exception ea){
                    ea.printStackTrace();
                }
            }
        });

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 120, 985, 500);
        add(sp);

        submitBtn = new JButton("Submit");
        submitBtn.setBounds(660, 60, 80, 30);
        submitBtn.setBackground(Color.BLACK);
        submitBtn.setForeground(Color.WHITE);
        submitBtn.addActionListener(this);
        p1.add(submitBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(350, 620, 100, 30);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        add(backBtn, "South");

        setVisible(true);
    }
    public void getRatings(){
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from ratings");
            while (rs.next()){
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submitBtn){
            String name = nameField.getText();
            String hotel = hotelField.getSelectedItem();
            String rating = ratingField.getValue()+"/5";
            String review = reviewField.getText();
            if(review.equals("")){
                review = "good";
            }
            Date date = new Date();
            if(name.equals("")||hotel.equals("")||rating.equals("")){
                JOptionPane.showConfirmDialog(null, "All fields are required!");
            }
            else {
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from calculateRatings where hotel_id='"+hotelId+"'");
                    while (rs.next()){
                        numberOfRatings = rs.getInt("numberOfRatings");
                        totalRating =  rs.getInt("rating");
                    }
                    c.s.executeUpdate("insert into ratings values('"+userId+"', '"+name+"', '"+hotelId+"', '"+hotel+"', '"+rating+"', '"+review+"', '"+date+"')");
                    c.s.executeUpdate("update calculateRatings set rating='"+(totalRating+ratingField.getValue())+"', numberOfRatings='"+(numberOfRatings+1)+"' where hotel_id='"+hotelId+"'");
                    c.s.executeUpdate("update hotel set ratings='"+(((totalRating+ratingField.getValue())/(numberOfRatings+1))+"/5")+"' where hotel_id='"+hotelId+"'");

                    JOptionPane.showMessageDialog(null, "Review Added Thank You!");
                    getRatings();
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
        new Ratings("");
    }
}
