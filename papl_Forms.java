
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;


public class papl_Forms {
    public static void main(String[] args) {


        // Create the Swing components
        JFrame frame = new JFrame("Vehicle and Driver Form");



        // Create a panel for the Vehicle form
        JPanel vehiclePanel = new JPanel();
        vehiclePanel.setBorder(BorderFactory.createTitledBorder("Vehicle Entry"));
        vehiclePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 10);

        JLabel ownerLabel = new JLabel("Owner:");
        JTextField ownerField = new JTextField(20);
        JLabel modelLabel = new JLabel("Model:");
        JTextField modelField = new JTextField(20);
        JLabel manufactureYearLabel = new JLabel("Manufacture Year:");
        JSpinner manufactureYearSpinner = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        JLabel vehicleNumberLabel = new JLabel("Vehicle Number:");
        JTextField vehicleNumberField = new JTextField(10);
        JLabel registrationDateLabel = new JLabel("Registration Date:");
        JDateChooser registrationDateChooser = new JDateChooser();
        JLabel vehicleManufactureLabel = new JLabel("Vehicle Manufacture:");
        JTextField vehicleManufactureField = new JTextField(20);
        registrationDateChooser.setBounds(0 , 5 , 100 , 30);



        gbc.gridx = 0;
        gbc.gridy = 0;
        vehiclePanel.add(ownerLabel, gbc);
        gbc.gridx = 1;
        vehiclePanel.add(ownerField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        vehiclePanel.add(modelLabel, gbc);
        gbc.gridx = 1;
        vehiclePanel.add(modelField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        vehiclePanel.add(manufactureYearLabel, gbc);
        gbc.gridx = 1;
        vehiclePanel.add(manufactureYearSpinner, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        vehiclePanel.add(vehicleNumberLabel, gbc);
        gbc.gridx = 1;
        vehiclePanel.add(vehicleNumberField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        vehiclePanel.add(registrationDateLabel, gbc);
        gbc.gridx = 1;
        vehiclePanel.add(registrationDateChooser, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        vehiclePanel.add(vehicleManufactureLabel, gbc);
        gbc.gridx = 1;
        vehiclePanel.add(vehicleManufactureField, gbc);

        // Create a panel for the Driver form
        JPanel driverPanel = new JPanel();
        driverPanel.setBorder(BorderFactory.createTitledBorder("Driver Entry"));
        driverPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 10);

        JLabel driverCodeLabel = new JLabel("Driver Code:");
        JTextField driverCodeField = new JTextField(10);
        JLabel driverNameLabel = new JLabel("Driver Name:");
        JTextField driverNameField = new JTextField(20);
        JLabel licenseNumberLabel = new JLabel("License Number:");
        JTextField licenseNumberField = new JTextField(15);
        JLabel licenseExpiryDateLabel = new JLabel("License Expiry Date:");
        JDateChooser licenseExpiryDateChooser = new JDateChooser();
        JLabel driverVehicleNumberLabel = new JLabel("Vehicle Number:");
        JTextField driverVehicleNumberField = new JTextField(10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        driverPanel.add(driverCodeLabel, gbc);
        gbc.gridx = 1;
        driverPanel.add(driverCodeField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        driverPanel.add(driverNameLabel, gbc);
        gbc.gridx = 1;
        driverPanel.add(driverNameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        driverPanel.add(licenseNumberLabel, gbc);
        gbc.gridx = 1;
        driverPanel.add(licenseNumberField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        driverPanel.add(licenseExpiryDateLabel, gbc);
        gbc.gridx = 1;
        driverPanel.add(licenseExpiryDateChooser, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        driverPanel.add(driverVehicleNumberLabel, gbc);
        gbc.gridx = 1;
        driverPanel.add(driverVehicleNumberField, gbc);

        // Create a main panel to hold both the Vehicle and Driver panels
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(vehiclePanel);
        mainPanel.add(Box.createVerticalStrut(20)); // Add spacing between panels
        mainPanel.add(driverPanel);

        // Create buttons for Vehicle and Driver forms
        JButton vehicleButton = new JButton("Add Vehicle");
        JButton driverButton = new JButton("Add Driver");
        JButton mapping = new JButton("Mapping");
        JButton mappingButton = new JButton("Tabular");
        JButton graphButton = new JButton("Graph");
        JButton older5 = new JButton("old5");
        JButton old5exp3 = new JButton("old5exp3");

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(vehicleButton);
        buttonPanel.add(driverButton);
        buttonPanel.add(mapping);
        buttonPanel.add(mappingButton);
        buttonPanel.add(graphButton);
        buttonPanel.add(older5);
        buttonPanel.add(old5exp3);

        // Add the main panel and button panel to the frame
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setVisible(true);
        // Add action listeners for the buttons

        vehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validate required fields for Vehicle form
                if (ownerField.getText().isEmpty() ||
                        modelField.getText().isEmpty() ||
                        vehicleNumberField.getText().isEmpty() ||
                        registrationDateChooser.getDate() == null ||
                        vehicleManufactureField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all required fields for Vehicle!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Handle vehicle form submission
                    String owner = ownerField.getText();
                    String model = modelField.getText();
                    int manufactureYear = (int) manufactureYearSpinner.getValue();
                    String vehicleNumber = vehicleNumberField.getText();
                    Date registrationDate = registrationDateChooser.getDate();
                    String vehicleManufacture = vehicleManufactureField.getText();
                    java.sql.Date sqlDateVehicle = new java.sql.Date(registrationDate.getTime());


                    try {

//            load the driver
                        Class.forName("com.mysql.cj.jdbc.Driver");

//             create the connection

                        String url = "jdbc:mysql://localhost:3306/papl";
                        Connection con = DriverManager.getConnection(url , "root" , "Ayush@123");


                        DatabaseMetaData dbm = con.getMetaData();
                        boolean exists;
                        ResultSet tables = dbm.getTables(null, null, "vehicle", null);
                        if (tables.next()) {
                            exists = true;
                        }
                        else {
                            // Table does not exist
                            exists = false;
                        }

                        if(exists == false)
                        {
                            String q = "create table vehicle(Owner varchar(30) , Model varchar(20) , ManufacturingYear int , vehicel_No varchar(20), RegistrationDate Date ,  VehicleManufacturer varchar(20)) ";
                            Statement stmt = con.createStatement();
                            stmt.executeUpdate(q);
                            System.out.println("vehicle created.....");
                        }

                        String insertQuery = "insert into vehicle(Owner , Model , ManufacturingYear , Vehicel_No , RegistrationDate,  VehicleManufacturer) Values(? , ? , ? ,? ,? ,?)";
                        PreparedStatement psmt = con.prepareStatement(insertQuery);
                        psmt.setString(1 , owner);
                        psmt.setString(2 , model);
                        psmt.setInt(3 , manufactureYear);
                        psmt.setString(4 , vehicleNumber);
                        psmt.setDate(5 ,sqlDateVehicle);
                        psmt.setString(6 , vehicleManufacture);
                        psmt.executeUpdate();
                        System.out.println(" data inserted in to vehicle......");
                        JOptionPane.showMessageDialog(frame, "The vehicle data is inserted Succesfully!!!", "Success", JOptionPane.INFORMATION_MESSAGE);

                        ownerField.setText("");
                        modelField.setText("");
                        manufactureYearSpinner.setValue(0);
                        vehicleNumberField.setText("");
                        registrationDateChooser.setCalendar(null);
                        vehicleManufactureField.setText("");
                        con.close();



                    } catch (Exception event) {
                        event.printStackTrace();
                    }






                }
            }
        });

        driverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validate required fields for Driver form
                if (driverCodeField.getText().isEmpty() ||
                        driverVehicleNumberField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all required fields for Driver!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Handle driver form submission
                    String driverCode = driverCodeField.getText();
                    String driverName = driverNameField.getText();
                    String licenseNumber = licenseNumberField.getText();
                    Date licenseExpiryDate = licenseExpiryDateChooser.getDate();
                    java.sql.Date licenceDriverdate = new java.sql.Date(licenseExpiryDate.getTime());
                    String driverVehicleNumber = driverVehicleNumberField.getText();


                    try {

//            load the driver
                        Class.forName("com.mysql.cj.jdbc.Driver");

//             create the connection
                        String url = "jdbc:mysql://localhost:3306/papl";
                        Connection con = DriverManager.getConnection(url , "root" , "Ayush@123");


                        DatabaseMetaData dbm = con.getMetaData();
                        boolean exists;
                        ResultSet tables = dbm.getTables(null, null, "driver", null);
                        if (tables.next()) {
                            exists = true;
                        }
                        else {
                            // Table does not exist
                            exists = false;
                        }

                        if(exists == false)
                        {
                            String q = "create table driver(Driver_Code varchar(30) , Driver_Name varchar(20) , Licence_No varchar(20) ,Licence_Exp_Date Date, Vehicle_No varchar(20)) ";
                            Statement stmt = con.createStatement();
                            stmt.executeUpdate(q);
                            System.out.println("driver created created.....");
                        }

                        String insertQuery = "insert into driver(Driver_Code , Driver_Name , Licence_No , Licence_Exp_Date, Vehicle_No) Values(? , ? , ? ,?, ?)";
                        PreparedStatement psmt = con.prepareStatement(insertQuery);
                        psmt.setString(1 , driverCode);
                        psmt.setString(2 , driverName);
                        psmt.setString(3 , licenseNumber);
                        psmt.setDate(4 ,licenceDriverdate );
                        psmt.setString(5 , driverVehicleNumber);
                        psmt.executeUpdate();
                        System.out.println(" data inserted in to driver......");
                        JOptionPane.showMessageDialog(frame, "The driver data is inserted Succesfully!!!", "Success", JOptionPane.INFORMATION_MESSAGE);

                        driverCodeField.setText("");
                        driverNameField.setText("");
                        licenseNumberField.setText("");
                        licenseExpiryDateChooser.setCalendar(null);
                        driverVehicleNumberField.setText("");

                        con.close();



                    } catch (Exception event) {
                        event.printStackTrace();
                    }
                }
            }
        });


        mapping.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {


                try {


//            load the driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

//             create the connection
                    String url = "jdbc:mysql://localhost:3306/papl";
                    Connection con = DriverManager.getConnection(url , "root" , "Ayush@123");
                    String mapping = "select papl.driver.Vehicle_No , papl.driver.Driver_Code , papl.driver.Driver_Name , papl.driver.Licence_No , papl.driver.Licence_Exp_Date , papl.vehicle.Model , papl.vehicle.ManufacturingYear , papl.vehicle.RegistrationDate , papl.vehicle.VehicleManufacturer\n" +
                            "\tfrom papl.driver\n" +
                            "\tright join papl.vehicle on papl.driver.Vehicle_No = papl.vehicle.Vehicel_No;\n";

                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(mapping);


                    while(rs.next())
                    {
                        System.out.print("vehicle No : " + rs.getString("Vehicle_No") + " | ");
                        System.out.print("Driver Code  : " + rs.getString("Driver_Code") + " | ");
                        System.out.print("Driver Name : " + rs.getString("Driver_Name") + " | ");
                        System.out.print("licence No : " + rs.getString("Licence_No") + " | ");
                        System.out.print("licence Exp Date : " + rs.getString("Licence_Exp_Date") + " | ");
                        System.out.print("ManufacturingYear : " + rs.getString("ManufacturingYear") + " | ");
                        System.out.print("Model : " + rs.getString("Model") + " | ");
                        System.out.print("registration date : " +  rs.getString("RegistrationDate") + " | ");
                        System.out.println("vehicle manufacturer : " + rs.getString("VehicleManufacturer"));

                    }
                    stmt.close();
                    con.close();
                }

                catch (Exception event) {
                    event.printStackTrace();
                }
            }
        });


        mappingButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {

                 JPanel mainPanel;
                 JTable table;
                 JFrame frame;
                try {
                    frame = new JFrame("Table Frame");
                    frame.setTitle("JTable Example");
                    frame.setSize(1000, 400);
                    frame.setLocationRelativeTo(null);
                    mainPanel = new JPanel(new BorderLayout());
                    table = new JTable(new DefaultTableModel());
                    JScrollPane scrollPane = new JScrollPane(table);
                    mainPanel.add(scrollPane, BorderLayout.CENTER);


//            load the driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

//             create the connection
                    String url = "jdbc:mysql://localhost:3306/papl";
                    Connection con = DriverManager.getConnection(url , "root" , "Ayush@123");

                    String mappingQuery = "select papl.driver.Vehicle_No , papl.driver.Driver_Code , papl.driver.Driver_Name , papl.driver.Licence_No , papl.driver.Licence_Exp_Date , papl.vehicle.Model , papl.vehicle.ManufacturingYear , papl.vehicle.RegistrationDate , papl.vehicle.VehicleManufacturer\n" +
                            "from papl.driver\n" +
                            "right join papl.vehicle on papl.driver.Vehicle_No = papl.vehicle.Vehicel_No where year(Licence_Exp_Date) - year(papl.vehicle.RegistrationDate) > 5;\n";

                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(mappingQuery);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int cols = rsmd.getColumnCount();
                    String col[] = new String[cols];
                    for(int i = 0;i<cols ;i++)
                    {
                        col[i] = rsmd.getColumnName(i+1);
                    }
                    model.setColumnIdentifiers(col);
                    frame.add(mainPanel);
                    frame.setVisible(true);
                    String vehicleno , drivercode  ,drivername , licenceno , licExpDate , manuYear , Model , regdate , vehManu ;
                    while(rs.next())
                    {
                        System.out.print("vehicle No : " + rs.getString("Vehicle_No") + " | ");
                        System.out.print("Driver Code  : " + rs.getString("Driver_Code") + " | ");
                        System.out.print("Driver Name : " + rs.getString("Driver_Name") + " | ");
                        System.out.print("licence No : " + rs.getString("Licence_No") + " | ");
                        System.out.print("licence Exp Date : " + rs.getString("Licence_Exp_Date") + " | ");
                        System.out.print("ManufacturingYear : " + rs.getString("ManufacturingYear") + " | ");
                        System.out.print("Model : " + rs.getString("Model") + " | ");
                        System.out.print("registration date : " +  rs.getString("RegistrationDate") + " | ");
                        System.out.println("vehicle manufacturer : " + rs.getString("VehicleManufacturer"));


                        vehicleno = rs.getString(1);
                        drivercode = rs.getString(2);
                        drivername = rs.getString(3);
                        licenceno = rs.getString(4);
                        licExpDate = rs.getString(5);
                        manuYear = rs.getString(6);
                        Model = rs.getString(7);
                        regdate = rs.getString(8);
                        vehManu = rs.getString(9);
                        String row[] = {vehicleno , drivercode , drivername , licenceno , licExpDate , manuYear , Model , regdate , vehManu};
                        model.addRow(row);


                    }
                    stmt.close();
                    con.close();


                }

                catch (Exception event) {
                    event.printStackTrace();
                }


            }
        });

        graphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
//            load the driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//             create the connection
                    String url = "jdbc:mysql://localhost:3306/papl";
                    Connection con = DriverManager.getConnection(url , "root" , "Ayush@123");

                    String mappingQuery = "select count(*) as count , papl.driver.Driver_Name as name \n" +
                            "\tfrom papl.driver\n" +
                            "\tright join papl.vehicle on papl.driver.Vehicle_No = papl.vehicle.Vehicel_No where year(curdate()) - year(papl.vehicle.RegistrationDate) > 5 group by papl.driver.Driver_Name ;\n";

                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(mappingQuery);

                    while(rs.next())
                    {
                            String name  = rs.getString("name");
                            int count = rs.getInt("count");
                        dataset.addValue(count, "Drivers", name);

                    }
                    JFreeChart chart = ChartFactory.createBarChart(
                            "Experienced Drivers (> 5 Years)", // Chart Title
                            "Driver Name", // Category Axis Label
                            "Count", // Value Axis Label
                            dataset,
                            org.jfree.chart.plot.PlotOrientation.VERTICAL,
                            true,
                            true,
                            false
                    );

                    JFrame frame = new JFrame("Experienced Drivers Bar Chart");
                    frame.getContentPane().add(new ChartPanel(chart));
                    frame.pack();
                    frame.setVisible(true);
                    stmt.close();
                    con.close();



                }

                catch (Exception event) {
                    event.printStackTrace();
                }

            }
        });



        older5.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {


                try {


//            load the driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

//             create the connection
                    String url = "jdbc:mysql://localhost:3306/papl";
                    Connection con = DriverManager.getConnection(url , "root" , "Ayush@123");

                    String older5 = "select papl.driver.Vehicle_No , papl.driver.Driver_Code , papl.driver.Driver_Name , papl.driver.Licence_No , papl.driver.Licence_Exp_Date , papl.vehicle.Model , papl.vehicle.ManufacturingYear , papl.vehicle.RegistrationDate , papl.vehicle.VehicleManufacturer\n" +
                            "\tfrom papl.driver\n" +
                            "\tright join papl.vehicle on papl.driver.Vehicle_No = papl.vehicle.Vehicel_No where year(curdate()) - year(papl.vehicle.RegistrationDate) > 5;\n";

                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(older5);


                    while(rs.next())
                    {
                        System.out.print("vehicle No : " + rs.getString("Vehicle_No") + " | ");
                        System.out.print("Driver Code  : " + rs.getString("Driver_Code") + " | ");
                        System.out.print("Driver Name : " + rs.getString("Driver_Name") + " | ");
                        System.out.print("licence No : " + rs.getString("Licence_No") + " | ");
                        System.out.print("licence Exp Date : " + rs.getString("Licence_Exp_Date") + " | ");
                        System.out.print("ManufacturingYear : " + rs.getString("ManufacturingYear") + " | ");
                        System.out.print("Model : " + rs.getString("Model") + " | ");
                        System.out.print("registration date : " +  rs.getString("RegistrationDate") + " | ");
                        System.out.println("vehicle manufacturer : " + rs.getString("VehicleManufacturer"));


                    }
                    stmt.close();
                    con.close();


                }

                catch (Exception event) {
                    event.printStackTrace();
                }


            }
        });

        old5exp3.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {


                try {


//            load the driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

//             create the connection
                    String url = "jdbc:mysql://localhost:3306/papl";
                    Connection con = DriverManager.getConnection(url , "root" , "Ayush@123");

                    String old5exp3 = "select papl.driver.Vehicle_No , papl.driver.Driver_Code , papl.driver.Driver_Name , papl.driver.Licence_No , papl.driver.Licence_Exp_Date , papl.vehicle.Model , papl.vehicle.ManufacturingYear , papl.vehicle.RegistrationDate , papl.vehicle.VehicleManufacturer\n" +
                            "\tfrom papl.driver\n" +
                            "\tright join papl.vehicle on papl.driver.Vehicle_No = papl.vehicle.Vehicel_No where year(curdate()) - year(papl.vehicle.RegistrationDate) > 5 and year(Licence_Exp_Date) - year(curdate()) < 3;\n";

                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(old5exp3);


                    while(rs.next())
                    {
                        System.out.print("vehicle No : " + rs.getString("Vehicle_No") + " | ");
                        System.out.print("Driver Code  : " + rs.getString("Driver_Code") + " | ");
                        System.out.print("Driver Name : " + rs.getString("Driver_Name") + " | ");
                        System.out.print("licence No : " + rs.getString("Licence_No") + " | ");
                        System.out.print("licence Exp Date : " + rs.getString("Licence_Exp_Date") + " | ");
                        System.out.print("ManufacturingYear : " + rs.getString("ManufacturingYear") + " | ");
                        System.out.print("Model : " + rs.getString("Model") + " | ");
                        System.out.print("registration date : " +  rs.getString("RegistrationDate") + " | ");
                        System.out.println("vehicle manufacturer : " + rs.getString("VehicleManufacturer"));


                    }
                    stmt.close();
                    con.close();


                }

                catch (Exception event) {
                    event.printStackTrace();
                }


            }
        });

    }
}



