import java.sql.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

class Student {
    String name;
    int age;
    String address;

    Student (String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}

public class App implements ActionListener {

    Student student[] = new Student[10];

    JFrame app;
    JLabel lName;
    JTextField tName;
    JLabel lAge;
    JTextField tAge;
    JLabel lAddress;
    JTextField tAddress;
    JButton previous;
    JButton next;

    Color appBg = new Color(0x69, 0x98, 0xAB);
    Color buttonBg = new Color(0x1A, 0x37, 0x4D);
    Color buttonFg = new Color(0xB1, 0xD0, 0xE0);

    int index = 0;

    public void intialize(String name, int age, String address) {
        app = new JFrame();
        lName = new JLabel("Name: ");
        lName.setBounds(50, 50, 100, 20);

        tName = new JTextField(name);
        tName.setBounds(100, 50, 200, 20);
        tName.setEditable(false);

        lAge = new JLabel("Age: ");
        lAge.setBounds(50, 100, 100, 20);

        tAge = new JTextField(String.valueOf(age));
        tAge.setBounds(100, 100, 200, 20);
        tAge.setEditable(false);

        lAddress = new JLabel("Adress: ");
        lAddress.setBounds(50, 150, 100, 20);

        tAddress = new JTextField(address);
        tAddress.setBounds(100, 150, 200, 120);
        tAddress.setEditable(false);

        previous = new JButton("Previous");
        previous.setBounds(50, 300, 100, 25);
        previous.addActionListener(this);
        previous.setEnabled(false);
        previous.setBackground(buttonBg);
        previous.setForeground(buttonFg);

        next = new JButton("Next");
        next.setBounds(200, 300, 100, 25);
        next.addActionListener(this);
        next.setEnabled(true);
        next.setBackground(buttonBg);
        next.setForeground(buttonFg);

        app.add(lName);
        app.add(tName);
        app.add(lAge);
        app.add(tAge);
        app.add(lAddress);
        app.add(tAddress);
        app.add(previous);
        app.add(next);

        app.getContentPane().setBackground(appBg);
        app.setSize(375, 400);
        app.setLayout(null);
        app.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == previous) {
            index--;
            tName.setText(student[index].name);
            tAge.setText(String.valueOf(student[index].age));
            tAddress.setText(student[index].address);
        }

        if (event.getSource() == next) {
            index++;
            tName.setText(student[index].name);
            tAge.setText(String.valueOf(student[index].age));
            tAddress.setText(student[index].address);
        }

        if (index > 0) {
            previous.setEnabled(true);
        } else {
            previous.setEnabled(false);
        }

        if (index < 5) {
            next.setEnabled(true);
        } else {
            next.setEnabled(false);
        }
    }

    public void fetchData (ResultSet resultSet, App app, Connection con) throws Exception {
        for (int i = 0; resultSet.next(); i++) {
            student[i] = new Student(resultSet.getString("name"), resultSet.getInt("age"), resultSet.getString("address"));
        }

        app.intialize(student[0].name, student[0].age, student[0].address);
    }

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "oracle");

        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM students;");

        App app = new App();

        app.fetchData(resultSet, app, con);
        
        con.close();
    }
}