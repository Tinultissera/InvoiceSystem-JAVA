package menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InvoiceController {

    public static int saveInvoice(Invoice invoice)throws ClassNotFoundException, SQLException{
        Connection con;
        Statement stmt;

        con = DBConnector.getConnection();
        stmt = con.createStatement();
        String queryString = "insert into invoice (invoiceNumber, invoiceDate, customerName, customerID, productNames, productID, unitsPerProduct, pricePerProducts, totalPricePerProduct, discount, paymentMethod, totalPrice, subTotal) values ('"+invoice.getInvoiceNumber()+"', '"+invoice.getInvoiceData()+"', '"+invoice.getCustomerName()+"', '"+invoice.getCustomerId()+"', '"+invoice.getProductNames()+"', '"+invoice.getProductIDs()+"', '"+invoice.getUnitsPerProduct()+"', '"+invoice.getPricePerProducts()+"', '"+invoice.getTotalPricePerProduct()+"', '"+invoice.getDiscount()+"', '"+invoice.getPaymentMethod()+"', "+invoice.getTotalPrice()+", "+invoice.getSubTotal()+")";
        int i = stmt.executeUpdate(queryString);
        return i;
    }

    public static int deleteInvoice(Invoice invoice)throws ClassNotFoundException, SQLException {
        Connection con;
        Statement stmt;

        con = DBConnector.getConnection();
        stmt = con.createStatement();
        String queryString = "delete from invoice where invoiceNumber = '"+invoice.getInvoiceNumber()+"'";
        int i = stmt.executeUpdate(queryString);
        return i;
    }

    public static String ProductIDArrayToString(Invoice invoice){
        String productID = "";
        for (int i = 0; i < invoice.getProductIDArray().size(); i++) {
            productID = productID + invoice.getProductIDArray().get(i) + "\n";
        }
        return productID;
    }

    public static String ProductNameArrayToString(Invoice invoice) {
        String productName = "";
        for (int i = 0; i < invoice.getProductNameArray().size(); i++) {
            productName = productName + invoice.getProductNameArray().get(i) + "\n";
        }
        return productName;
    }

    public static String NumberOfUnitsArrayToString(Invoice invoice) {
        String numberOfUnits = "";
        for (int i = 0; i < invoice.getNumberOfUnitsArray().size(); i++) {
            numberOfUnits = numberOfUnits + invoice.getNumberOfUnitsArray().get(i).toString() + "\n";
        }
        return numberOfUnits;
    }

    public static String PriceOfProductArrayToString(Invoice invoice) {
        String priceOfProduct = "";
        for (int i = 0; i < invoice.getPriceOfProductArray().size(); i++) {
            priceOfProduct = priceOfProduct + invoice.getPriceOfProductArray().get(i).toString() + "\n";
        }
        return priceOfProduct;
    }

    public static String totalPricePerProductArrayToString(Invoice invoice) {
        String totalPricePerProduct = "";
        for (int i = 0; i < invoice.getTotalPricePerProductArray().size(); i++) {
            totalPricePerProduct = totalPricePerProduct + invoice.getTotalPricePerProductArray().get(i).toString() + "\n";
        }
        return totalPricePerProduct;
    }

    public static String discountPerQuantityToString(Invoice invoice) {
        String discountPerProduct = "";
        for (int i = 0; i < invoice.getDiscountPerQuantityArray().size(); i++) {
            discountPerProduct = discountPerProduct + invoice.getDiscountPerQuantityArray().get(i).toString() + "\n";
        }
        return discountPerProduct;
    }

    public static String createInvoice() throws ClassNotFoundException, SQLException {
        Connection con;
        Statement stmt;
        ResultSet rs;

        con = DBConnector.getConnection();
        stmt = con.createStatement();
        String queryString = "SELECT MAX(invoiceNumber) FROM invoice";
        rs = stmt.executeQuery(queryString);

        rs.next();
        rs.getString("MAX(invoiceNumber)");
        if (rs.getString("MAX(invoiceNumber)") == null) {
            return "I-0000001";
        } else {
            long id = Long.parseLong(rs.getString("MAX(invoiceNumber)").substring(2, rs.getString("MAX(invoiceNumber)").length()));
            id++;
            return ("I-" + String.format("%07d", id));
        }
    }

    public static boolean searchInvoiceByCustomerName(Invoice invoice) throws SQLException, ClassNotFoundException {
        Connection con;
        Statement stmt;
        ResultSet rs;

        con = DBConnector.getConnection();
        stmt = con.createStatement();
        String queryString = "select * from invoice where customerName = '"+invoice.getCustomerName()+"'";
        rs = stmt.executeQuery(queryString);

        while (rs.next()) {
            invoice.setInvoiceNumber(rs.getString("invoiceNumber"));
            invoice.setInvoiceData(rs.getString("invoiceDate"));
            invoice.setCustomerName(rs.getString("customerName"));
            invoice.setCustomerId(rs.getString("customerID"));
            invoice.setProductNames(rs.getString("productNames"));
            invoice.setProductIDs(rs.getString("productID"));
            invoice.setUnitsPerProduct(rs.getString("unitsPerProduct"));
            invoice.setPricePerProducts(rs.getString("pricePerProducts"));
            invoice.setTotalPricePerProduct(rs.getString("totalPricePerProduct"));
            invoice.setDiscount(rs.getString("discount"));
            invoice.setPaymentMethod(rs.getString("paymentMethod"));
            invoice.setTotalPrice(rs.getFloat("totalPrice"));
            invoice.setSubTotal(rs.getFloat("subTotal"));

            invoice.displayInvoice();

            return true;
        }
        return false;
    }

    public static boolean searchInvoiceByDate(Invoice invoice, String startDate, String endDate) throws SQLException, ClassNotFoundException {
        Connection con;
        Statement stmt;
        ResultSet rs;

        con = DBConnector.getConnection();
        stmt = con.createStatement();
        String queryString = "SELECT * FROM invoice WHERE invoiceDate BETWEEN '"+startDate+"' AND '"+endDate+"'";
        rs = stmt.executeQuery(queryString);

        while (rs.next()) {
            invoice.setInvoiceNumber(rs.getString("invoiceNumber"));
            invoice.setInvoiceData(rs.getString("invoiceDate"));
            invoice.setCustomerName(rs.getString("customerName"));
            invoice.setCustomerId(rs.getString("customerID"));
            invoice.setProductNames(rs.getString("productNames"));
            invoice.setProductIDs(rs.getString("productID"));
            invoice.setUnitsPerProduct(rs.getString("unitsPerProduct"));
            invoice.setPricePerProducts(rs.getString("pricePerProducts"));
            invoice.setTotalPricePerProduct(rs.getString("totalPricePerProduct"));
            invoice.setDiscount(rs.getString("discount"));
            invoice.setPaymentMethod(rs.getString("paymentMethod"));
            invoice.setTotalPrice(rs.getFloat("totalPrice"));
            invoice.setSubTotal(rs.getFloat("subTotal"));

            invoice.displayInvoice();

            return true;
        }
        return false;
    }

}
