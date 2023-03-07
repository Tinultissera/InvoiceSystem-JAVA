package menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomersController {

    public static int saveCustomer(Customer customer)throws ClassNotFoundException, SQLException {

        Connection con;
        Statement stmt;

        con = DBConnector.getConnection();
        stmt = con.createStatement();
        String queryString = "insert into customerdetails(customerId, customerName, email, address, number, DOB, gender) values ('"+customer.getCustomerId()+"', '"+customer.getCustomerName()+"', '"+customer.getEmail()+"', '"+customer.getAddress()+"', '"+customer.getNumber()+"', '"+customer.getDOB()+"', '"+customer.getGender()+"')";  //yyyy-mm-dd
        int i = stmt.executeUpdate(queryString);
        customer.printAdminTaskOfCustomer(customer.getCustomerName(), customer.getCustomerId(), "Save customer");
        return i;
    }

    public static int upgradeCustomer(Customer customer)throws ClassNotFoundException, SQLException{
        Connection con;
        Statement stmt;

        con = DBConnector.getConnection();
        stmt = con.createStatement();
        String queryString = "update customerdetails set customerName = '"+customer.getCustomerName()+"', email = '"+customer.getEmail()+"', address = '"+customer.getEmail()+"', number = '"+customer.getNumber()+"', DOB = '"+customer.getDOB()+"', gender = '"+customer.getGender()+"' where customerId = "+customer.getCustomerId()+"";
        int i = stmt.executeUpdate(queryString);
        customer.printAdminTaskOfCustomer(customer.getCustomerName(), customer.getCustomerId(), "Update customer");
        return i;
    }

    public static int deleteCustomer(Customer customer)throws ClassNotFoundException, SQLException{
        Connection con;
        Statement stmt;

        con = DBConnector.getConnection();
        stmt = con.createStatement();
        String queryString = "delete from customerdetails where customerId = '"+customer.getCustomerId()+"'";
        int i = stmt.executeUpdate(queryString);
        customer.printAdminTaskOfCustomer(customer.getCustomerName(), customer.getCustomerId(), "Delete customer");
        return i;
    }

    public static boolean selectCustomer(Customer customer)throws ClassNotFoundException, SQLException{
        Connection con;
        Statement stmt;
        ResultSet rs;

        con = DBConnector.getConnection();
        stmt = con.createStatement();
        String queryString = "select * from customerdetails where customerId = '"+customer.getCustomerId()+"' or customerName = '"+customer.getCustomerName()+"' or number = '"+customer.getNumber()+"'";
        rs = stmt.executeQuery(queryString);

        if(rs.next()){
             customer.setCustomerId(rs.getString("customerId"));
             customer.setCustomerName(rs.getString("customerName"));
             customer.setEmail(rs.getString("email"));
             customer.setAddress(rs.getString("address"));
             customer.setNumber(rs.getString("number"));
             customer.setDOB(rs.getString("DOB"));
             customer.setGender(rs.getString("gender"));

             return true;
        }

        return false;
    }

    public static void selectAllCustomer(Customer customer)throws ClassNotFoundException, SQLException{
        Connection con;
        Statement stmt;
        ResultSet rs;

        con = DBConnector.getConnection();
        stmt = con.createStatement();
        String queryString = "select * from customerdetails";
        rs = stmt.executeQuery(queryString);

        customer.displayCustomerHeader();

        while (rs.next()){
            customer.setCustomerId(rs.getNString("customerId"));
            customer.setCustomerName(rs.getNString("customerName"));
            customer.setEmail(rs.getNString("email"));
            customer.setAddress(rs.getNString("address"));
            customer.setNumber(rs.getString("number"));
            customer.setDOB(rs.getString("DOB"));
            customer.setGender(rs.getString("gender"));

            customer.displayCustomer();

        }
    }

    public static String createCustomerID() throws SQLException, ClassNotFoundException {
        Connection con;
        Statement stmt;
        ResultSet rs;

        con = DBConnector.getConnection();
        stmt = con.createStatement();
        String queryString = "SELECT MAX(customerId) FROM customerdetails";
        rs = stmt.executeQuery(queryString);

        rs.next();
        rs.getString("MAX(customerId)");
        if (rs.getString("MAX(customerId)") == null) {
            return "C-0000001";
        } else {
            long id = Long.parseLong(rs.getString("MAX(customerId)").substring(2, rs.getString("MAX(customerId)").length()));
            id++;
            return ("C-" + String.format("%07d", id));
        }
    }
}
