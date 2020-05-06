package Persistor;

import Response.VehicleInformation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class PreparedStatement {

//    public void preparedStatement (VehicleInformation vehicleInformation){
//        Class.forName("org.apache.derby.jdbc.ClientDriver");
//        Connection con = DriverManager.getConnection (
//                "jdbc:derby://localhost:1527/testDb","name","pass");
//        PreparedStatement updateVehicleInfo = con.prepareStatement(
//                "insert into emp values(?,?,?)");
//
//        updateVehicleInfo.setInt(1,23);
//        updateVehicleInfo.setString(1, vehicleInformation.getYear());
//        updateVehicleInfo.setString(2, vehicleInformation);
//        updateVehicleInfo.setString(2, "CEO");
//        updateVehicleInfo.executeUpdate();
//
//        Statement stmt = con.createStatement();
//        String query = "select * from emp";
//        ResultSet rs =  stmt.executeQuery(query);
//        System.out.println("Id Name    Job");
//
//        while (rs.next()) {
//            int id = rs.getInt("id");
//            String name = rs.getString("name");
//            String job = rs.getString("job");
//            System.out.println(id + "  " + name+"   "+job);
//        }
//    }
}
