package menu;

import java.io.FileWriter;
import java.io.IOException;

public class Product {
    // product data
    private String productId;
    private String productName;
    private String description;
    private float purchasePrice;
    private float sellingPrice;
    private int quantity;

    // constructors
    public Product(){

    }

    public Product(String productId, String productName, String description, float purchasePrice, float sellingPrice, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
    }

    // setters

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //getters

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public int getQuantity() {
        return quantity;
    }


    public void displayProductHeader(){
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%5s %10s %16s %20s %19s %14s", "PRODUCT ID", "NAME", "DESCRIPTION", "PURCHASE PRICE", "SELLING PRICE", "QUANTITY");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
    }
    public void displayProduct(){

        System.out.format("%5s %11s %16s %14s %20s %15s", productId, productName, description, purchasePrice, sellingPrice, quantity);
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public void printAdminTaskOfProducts(String pName, String pID, String task){
        try {
            FileWriter myWriter = new FileWriter("ProductAdminTask.txt", true);
            myWriter.write("'"+pName+"'\t'"+pID+"'\t'"+task+"'\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
