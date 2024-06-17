import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class ViewTravelAgency extends JFrame implements ActionListener {
    JTable table;
    JButton backBtn;
    ViewTravelAgency(){
        setBounds(200, 80, 1050, 600);
        getContentPane().setBackground(Color.WHITE);

        table = new JTable();
        table.setRowHeight(50);
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        table.setEnabled(false);
        add(table);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from travelagency");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(table);
        table.setBounds(50, 40, 1000, 400);
        add(sp);

        backBtn = new JButton("Back");
        backBtn.setBounds(450, 520, 100, 30);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        add(backBtn, "South");


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args) {
        new ViewTravelAgency();
    }
}
