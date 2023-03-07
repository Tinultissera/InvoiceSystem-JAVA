package menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductController {
    public static int saveProducts(Product product)throws ClassNotFoundException, SQLException{
        Connection con;
        Statement stmt;

        con = DBConnector.getConnection();
        stmt = con.createStatement();
        String queryString = "insert into productdetails(productId, productName, description, purchasePrice, sellingPrice, quantity) values ('"+product.getProductId()+"', '"+product.getProductName()+"', '"+product.getDescription()+"', "+product.getPurchasePrice()+", "+product.getSellingPrice()+", "+product.getQuantity()+")";
        int i = stmt.executeUpdate(queryString);
        product.printAdminTaskOfProducts(product.getProductName(), product.getProductId(), "Save product");
        return i;
    }

    public static int updateProduct(Product product)throws ClassNotFoundException, SQLException{
        Connection con;
        Statement stmt;

        con = DBConnector.getConnection();
        stmt = con.createStatement();
        String queryString = "update productdetails set productName = '"+product.getProductName()+"', description = '"+product.getDescription()+"', purchasePrice = "+product.getPurchasePrice()+", sellingPrice = "+product.getSellingPrice()+", quantity = "+product.getQuantity()+" where productId = "+product.getProductId()+"";
        int i = stmt.executeUpdate(queryString);
        product.printAdminTaskOfProducts(product.getProductName(), product.getProductId(), "Update product");
        return i;
    }

    public static int deleteProduct(Product product)throws ClassNotFoundException, SQLException{
        Connection con;
        Statement stmt;

        con = DBConnector.getConnection();
        stmt = con.createStatement();
        String queryString = "delete from productdetails where productId = '"+product.getProductId()+"'";
        int i = stmt.executeUpdate(queryString);
        product.printAdminTaskOfProducts(product.getProductName(), product.getProductId(), "Delete product");
        return i;
    }

    public static boolean selectProduct(Product product)throws ClassNotFoundException, SQLException{
        Connection con;
        Statement stmt;
        ResultSet rs;

        con = DBConnector.getConnection();
        stmt = con.createStatement();
        String queryString = "select * from productdetails where productId = '"+product.getProductId()+"' or productName = '"+product.getProductName()+"'";
        rs = stmt.executeQuery(queryString);

        if(rs.next()) {
            product.setProductId(rs.getString("productId"));
            product.setProductName(rs.getString("productName"));
            product.setDescription(rs.getString("description"));
            product.setPurchasePrice(rs.getFloat("purchasePrice"));
            product.setSellingPrice(rs.getFloat("sellingPrice"));
            product.setQuantity(rs.getInt("quantity"));

            return true;
        }
        return false;
    }

    public static void selectAllProducts(Product product)throws ClassNotFoundException, SQLException{
        Connection con;
        Statement stmt;
        ResultSet rs;

        con = DBConnector.getConnection();
        stmt = con.createStatement();
        String queryString = "select * from productdetails";
        rs = stmt.executeQuery(queryString);

        product.displayProductHeader();
        while (rs.next()) {
            product.setProductId(rs.getString("productId"));
            product.setProductName(rs.getString("productName"));
            product.setDescription(rs.getString("description"));
            product.setPurchasePrice(rs.getFloat("purchasePrice"));
            product.setSellingPrice(rs.getFloat("sellingPrice"));
            product.setQuantity(rs.getInt("quantity"));

            product.displayProduct();

        }
    }

    public static String createProductID() throws SQLException, ClassNotFoundException {
        Connection con;
        Statement stmt;
        ResultSet rs;

        con = DBConnector.getConnection();
        stmt = con.createStatement();
        String queryString = "SELECT MAX(productId) FROM productdetails";
        rs = stmt.executeQuery(queryString);

        rs.next();
        rs.getString("MAX(productId)");
        if (rs.getString("MAX(productId)") == null) {
            return "P-0000001";
        } else {
            long id = Long.parseLong(rs.getString("MAX(productId)").substring(2, rs.getString("MAX(productId)").length()));
            id++;
            return ("P-" + String.format("%07d", id));
        }
    }
}
