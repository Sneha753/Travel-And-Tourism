import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    JButton addDetailsbtn,viewDetailsbtn,updateDetailsbtn,viewHotelbtn,bookHotelbtn,viewPackagebtn,bookPackagebtn,viewTravelAgencybtn,bookTravelAgencybtn,paymentbtn,ratingbtn,logoutbtn,addHotelbtn,addPackagebtn,addTravelAgencybtn,viewBookedPackagebtn;
    String userName,userType;

    Dashboard(String username,String user_type){
        this.userName = username;
        this.userType = user_type;
        setSize(1290,650);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(21, 21, 200));
        p1.setBounds(0,0,1290,65);
        add(p1);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(40,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Railway",Font.BOLD,36));
        p1.add(heading);

        JLabel title = new JLabel("Travel and Tourism Management System");
        title.setBounds(400,70,1000,50);
        title.setFont(new Font("Railway",Font.BOLD,42));
        title.setForeground(new Color(21, 21, 200));
        add(title);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(21, 21, 200));
        p2.setBounds(0,65,350,600);
        add(p2);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1000,500,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350,140,1000,500);
        add(image);

        addDetailsbtn = new JButton("Add Personal Details");
        addDetailsbtn.setBounds(0,0,350,40);
        addDetailsbtn.setFont(new Font("Railway",Font.BOLD,20));
        addDetailsbtn.setForeground(Color.WHITE);
        addDetailsbtn.setBackground(new Color(21, 21, 200));
        addDetailsbtn.setMargin(new Insets(0,0,0,30));
        addDetailsbtn.addActionListener(this);
        p2.add(addDetailsbtn);

        viewDetailsbtn = new JButton("View Personal Details");
        viewDetailsbtn.setBounds(0,40,350,40);
        viewDetailsbtn.setFont(new Font("Railway",Font.BOLD,20));
        viewDetailsbtn.setForeground(Color.WHITE);
        viewDetailsbtn.setBackground(new Color(21, 21, 200));
        viewDetailsbtn.setMargin(new Insets(0,0,0,30));
        viewDetailsbtn.addActionListener(this);
        p2.add(viewDetailsbtn);

        updateDetailsbtn = new JButton("Update Personal Details");
        updateDetailsbtn.setBounds(0,80,350,40);
        updateDetailsbtn.setFont(new Font("Railway",Font.BOLD,20));
        updateDetailsbtn.setForeground(Color.WHITE);
        updateDetailsbtn.setBackground(new Color(21, 21, 200));
        updateDetailsbtn.setMargin(new Insets(0,0,0,30));
        updateDetailsbtn.addActionListener(this);
        p2.add(updateDetailsbtn);

        viewHotelbtn = new JButton("View Hotels");
        viewHotelbtn.setBounds(0,120,350,40);
        viewHotelbtn.setFont(new Font("Railway",Font.BOLD,20));
        viewHotelbtn.setForeground(Color.WHITE);
        viewHotelbtn.setBackground(new Color(21, 21, 200));
        viewHotelbtn.setMargin(new Insets(0,0,0,30));
        viewHotelbtn.addActionListener(this);
        p2.add(viewHotelbtn);

        //customer
        bookHotelbtn = new JButton("Book Hotel");
        bookHotelbtn.setBounds(0,160,350,40);
        bookHotelbtn.setFont(new Font("Railway",Font.BOLD,20));
        bookHotelbtn.setForeground(Color.WHITE);
        bookHotelbtn.setBackground(new Color(21, 21, 200));
        bookHotelbtn.setMargin(new Insets(0,0,0,30));
        bookHotelbtn.addActionListener(this);

        //admin
        addHotelbtn = new JButton("Add Hotel");
        addHotelbtn.setBounds(0,160,350,40);
        addHotelbtn.setFont(new Font("Railway",Font.BOLD,20));
        addHotelbtn.setForeground(Color.WHITE);
        addHotelbtn.setBackground(new Color(21, 21, 200));
        addHotelbtn.setMargin(new Insets(0,0,0,30));
        addHotelbtn.addActionListener(this);

        viewPackagebtn = new JButton("View Packages");
        viewPackagebtn.setBounds(0,200,350,40);
        viewPackagebtn.setFont(new Font("Railway",Font.BOLD,20));
        viewPackagebtn.setForeground(Color.WHITE);
        viewPackagebtn.setBackground(new Color(21, 21, 200));
        viewPackagebtn.setMargin(new Insets(0,0,0,30));
        viewPackagebtn.addActionListener(this);
        p2.add(viewPackagebtn);

        //Customer
        bookPackagebtn = new JButton("Book Packages");
        bookPackagebtn.setBounds(0,240,350,40);
        bookPackagebtn.setFont(new Font("Railway",Font.BOLD,20));
        bookPackagebtn.setForeground(Color.WHITE);
        bookPackagebtn.setBackground(new Color(21, 21, 200));
        bookPackagebtn.setMargin(new Insets(0,0,0,30));
        bookPackagebtn.addActionListener(this);

        //Admin
        addPackagebtn = new JButton("Add Packages");
        addPackagebtn.setBounds(0,240,350,40);
        addPackagebtn.setFont(new Font("Railway",Font.BOLD,20));
        addPackagebtn.setForeground(Color.WHITE);
        addPackagebtn.setBackground(new Color(21, 21, 200));
        addPackagebtn.setMargin(new Insets(0,0,0,30));
        addPackagebtn.addActionListener(this);

        viewTravelAgencybtn = new JButton("Check Travel Agency");
        viewTravelAgencybtn.setBounds(0,280,350,40);
        viewTravelAgencybtn.setFont(new Font("Railway",Font.BOLD,20));
        viewTravelAgencybtn.setForeground(Color.WHITE);
        viewTravelAgencybtn.setBackground(new Color(21, 21, 200));
        viewTravelAgencybtn.setMargin(new Insets(0,0,0,30));
        viewTravelAgencybtn.addActionListener(this);
        p2.add(viewTravelAgencybtn);

        //Customer
        bookTravelAgencybtn = new JButton("View Booked Hotel");
        bookTravelAgencybtn.setBounds(0,320,350,40);
        bookTravelAgencybtn.setFont(new Font("Railway",Font.BOLD,20));
        bookTravelAgencybtn.setForeground(Color.WHITE);
        bookTravelAgencybtn.setBackground(new Color(21, 21, 200));
        bookTravelAgencybtn.setMargin(new Insets(0,0,0,30));
        bookTravelAgencybtn.addActionListener(this);


        //Admin
        addTravelAgencybtn = new JButton("Add Travel Agency");
        addTravelAgencybtn.setBounds(0,320,350,40);
        addTravelAgencybtn.setFont(new Font("Railway",Font.BOLD,20));
        addTravelAgencybtn.setForeground(Color.WHITE);
        addTravelAgencybtn.setBackground(new Color(21, 21, 200));
        addTravelAgencybtn.setMargin(new Insets(0,0,0,30));
        addTravelAgencybtn.addActionListener(this);

        viewBookedPackagebtn = new JButton("View Booked Package");
        viewBookedPackagebtn.setBounds(0,360,350,40);
        viewBookedPackagebtn.setFont(new Font("Railway",Font.BOLD,20));
        viewBookedPackagebtn.setForeground(Color.WHITE);
        viewBookedPackagebtn.setBackground(new Color(21, 21, 200));
        viewBookedPackagebtn.setMargin(new Insets(0,0,0,30));
        viewBookedPackagebtn.addActionListener(this);
        p2.add(viewBookedPackagebtn);

        paymentbtn = new JButton("Payment");
        paymentbtn.setBounds(0,400,350,40);
        paymentbtn.setFont(new Font("Railway",Font.BOLD,20));
        paymentbtn.setForeground(Color.WHITE);
        paymentbtn.setBackground(new Color(21, 21, 200));
        paymentbtn.setMargin(new Insets(0,0,0,30));
        paymentbtn.addActionListener(this);
        p2.add(paymentbtn);

        ratingbtn = new JButton("Ratings");
        ratingbtn.setBounds(0,440,350,40);
        ratingbtn.setFont(new Font("Railway",Font.BOLD,20));
        ratingbtn.setForeground(Color.WHITE);
        ratingbtn.setBackground(new Color(21, 21, 200));
        ratingbtn.setMargin(new Insets(0,0,0,30));
        ratingbtn.addActionListener(this);
        p2.add(ratingbtn);

        logoutbtn = new JButton("Logout");
        logoutbtn.setBounds(0,480,350,40);
        logoutbtn.setFont(new Font("Railway",Font.BOLD,20));
        logoutbtn.setForeground(Color.WHITE);
        logoutbtn.setBackground(new Color(21, 21, 200));
        logoutbtn.setMargin(new Insets(0,0,0,30));
        logoutbtn.addActionListener(this);
        p2.add(logoutbtn);

        if(user_type.equals("ADMIN")){
            p2.add(addHotelbtn);
            p2.add(addPackagebtn);
            p2.add(addTravelAgencybtn);
        }
        else{
            p2.add(bookHotelbtn);
            p2.add(bookPackagebtn);
            p2.add(bookTravelAgencybtn);
        }

        setVisible(true);
    }
    public static void main(String[] args) {
        new Dashboard("","");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addDetailsbtn){
            new AddCustomer(userName);
        }
        else if(e.getSource() == viewDetailsbtn){
            new ViewDetails(userName);
        }
        else if(e.getSource()== updateDetailsbtn){
            new UpdateDetails(userName);
        }
        else if (e.getSource() == viewHotelbtn) {
            new ViewHotel();
        }
        else if (e.getSource() == viewPackagebtn) {
            new ViewPackage();
        }
        else if (e.getSource() == viewTravelAgencybtn) {
            new ViewTravelAgency();
        }
        else if (e.getSource() == addHotelbtn) {
            new AddHotel();
        }
        else if (e.getSource() == addPackagebtn) {
            new AddPackage();
        }
        else if (e.getSource() == addTravelAgencybtn) {
            new AddTravelAgency();
        }
        else if (e.getSource() == paymentbtn) {
            new Payments(userName,userType);
        }
        else if (e.getSource() == ratingbtn) {
            new Ratings(userName);
        }
        else if(e.getSource() == bookHotelbtn){
            new BookHotel(userName);
        }
        else if(e.getSource()==bookPackagebtn){
            new BookPackage(userName);
        }
        else if(e.getSource()==bookTravelAgencybtn){
            new ViewBookedHotel(userName);
        }
        else if(e.getSource()==viewBookedPackagebtn){
            new ViewBookedPackage(userName);
        }
        else if(e.getSource() == logoutbtn){
            setVisible(false);
            new Login();
        }
    }
}
