package menu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Invoice {
    private String invoiceNumber;
    private String invoiceData;
    private String customerName;
    private String customerId;
    private String productNames;
    private String productIDs;
    private String unitsPerProduct;
    private String PricePerProducts;
    private String totalPricePerProduct;
    private String discount;
    private String paymentMethod;
    private float TotalPrice;
    private float subTotal;

    private ArrayList<String> productIDArray;
    private ArrayList<String> productNameArray;
    private ArrayList<Integer> numberOfUnitsArray;
    private ArrayList<Float> priceOfProductsArray;
    private ArrayList<Float> totalPricePerProductArray;
    private ArrayList<Float> totalPriceWithOrWithoutDiscount;
    private ArrayList<Float> discountPerQuantityArray;

    String InvoiceTitle = new String("ABC COMPANY");
    String SubTitle = new String("Invoice");

    //constructors

    public Invoice(){
        productIDArray = new ArrayList<>();
        productNameArray = new ArrayList<>();
        numberOfUnitsArray = new ArrayList<>();
        priceOfProductsArray = new ArrayList<>();
        totalPricePerProductArray = new ArrayList<>();
        totalPriceWithOrWithoutDiscount = new ArrayList<>();
        discountPerQuantityArray = new ArrayList<>();

    }

    // setters

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setInvoiceData(String invoiceData) {
        this.invoiceData = invoiceData;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setProductNames(String productNames) {
        this.productNames = productNames;
    }

    public void setProductIDs(String productIDs) {
        this.productIDs = productIDs;
    }

    public void setUnitsPerProduct(String unitsPerProduct) {
        this.unitsPerProduct = unitsPerProduct;
    }

    public void setPricePerProducts(String pricePerProducts) {
        this.PricePerProducts = pricePerProducts;
    }

    public void setTotalPricePerProduct(String totalPricePerProduct) {
        this.totalPricePerProduct = totalPricePerProduct;
    }

    public void setProductIDArray(ArrayList<String> productIDArray) {
        this.productIDArray = productIDArray;
    }

    public void setProductNameArray(ArrayList<String> productNameArray) {
        this.productNameArray = productNameArray;
    }

    public void setNumberOfUnitsArray(ArrayList<Integer> numberOfUnitsArray) {
        this.numberOfUnitsArray = numberOfUnitsArray;
    }

    public void setPriceOfProductArray(ArrayList<Float> priceOfProductArray) {
        this.priceOfProductsArray = priceOfProductArray;
    }

    public void setTotalPricePerProductArray(ArrayList<Float> totalPricePerProductArray) {
        this.totalPricePerProductArray = totalPricePerProductArray;
    }

    public void setDiscountPerQuantityArray(ArrayList<Float> discountPerQuantityArray) {
        this.discountPerQuantityArray = discountPerQuantityArray;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void setTotalPriceWithOrWithoutDiscount(ArrayList<Float> totalPriceWithOrWithoutDiscount) {
        this.totalPriceWithOrWithoutDiscount = totalPriceWithOrWithoutDiscount;
    }

    public void setTotalPrice(float totalPrice) {
        TotalPrice = totalPrice;
    }

    // getters

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getInvoiceData() {
        return invoiceData;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getProductNames() {
        return productNames;
    }

    public String getProductIDs() {
        return productIDs;
    }

    public String getUnitsPerProduct() {
        return unitsPerProduct;
    }

    public String getPricePerProducts() {
        return PricePerProducts;
    }

    public String getTotalPricePerProduct() {
        return totalPricePerProduct;
    }

    public ArrayList<String> getProductIDArray() {
        return productIDArray;
    }

    public ArrayList<String> getProductNameArray() {
        return productNameArray;
    }

    public ArrayList<Integer> getNumberOfUnitsArray() {
        return numberOfUnitsArray;
    }

    public ArrayList<Float> getPriceOfProductArray() {
        return priceOfProductsArray;
    }

    public ArrayList<Float> getTotalPricePerProductArray() {
        return totalPricePerProductArray;
    }

    public ArrayList<Float> getDiscountPerQuantityArray() {
        return discountPerQuantityArray;
    }

    public ArrayList<Float> getTotalPriceWithOrWithoutDiscount() {
        return totalPriceWithOrWithoutDiscount;
    }

    public float getTotalPrice() {
        return TotalPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public String getDiscount() {
        return discount;
    }

    // print invoice
    public void printInvoice(){
        try {
            FileWriter invoice = new FileWriter(invoiceNumber+".txt");
            invoice.write("\t\t\t\t\t\t\t\t"+InvoiceTitle+"\n");
            invoice.write(SubTitle+ " - " +invoiceNumber+ "\n");
            invoice.write(invoiceData+"\n\n");

            invoice.write("CUSTOMER NAME - "+customerName+ "\nCUSTOMER ID   - "+customerId+ "\n\n");

            invoice.write("**************************************************************************************************************\n");
            invoice.write("PRODUCT NAME\tPRODUCT ID\t\tUNITS\t\tPRICE PER PRODUCT\t\tTOTAL PRICE PER PRODUCT\t\tDISCOUNT\n");
            for (int i = 0; i < productIDArray.size(); i++) {
                invoice.write(""+productNameArray.get(i)+"\t\t\t"+productIDArray.get(i)+"\t\t"+numberOfUnitsArray.get(i)+"\t\t"+priceOfProductsArray.get(i)+"\t\t\t\t"+totalPricePerProductArray.get(i)+"\t\t\t\t\t"+discountPerQuantityArray.get(i)+"");
                invoice.write("\n");
            }
            invoice.write("\n");
            invoice.write("SUBTOTAL    - " +subTotal+"\n");
            invoice.write("TOTAL PRICE - " +TotalPrice+"\n");
            invoice.write("PAID BY     - " +paymentMethod+"\n");
            invoice.write("**************************************************************************************************************\n\n");
            invoice.write("THANK YOU FOR SHOPPING WITH US");
            invoice.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void displayInvoice(){

        String[] pNs = productNames.split("\n");
        String[] pIDs = productIDs.split("\n");
        String[] units = unitsPerProduct.split("\n");
        String[] pPP = PricePerProducts.split("\n");
        String[] tPPP = totalPricePerProduct.split("\n");
        String[] d = discount.split("\n");

        for (int i = 0; i < pIDs.length; i++) {
            productNameArray.add(i, pNs[i]);
            productIDArray.add(i, pIDs[i]);
            getNumberOfUnitsArray().add(Integer.parseInt(units[i]));
            getPriceOfProductArray().add(Float.parseFloat(pPP[i]));
            getTotalPricePerProductArray().add(Float.parseFloat(tPPP[i]));
            getDiscountPerQuantityArray().add(Float.parseFloat(d[i]));

        }
        System.out.print("\t\t\t\t\t\t\t\t"+InvoiceTitle+"\n");
        System.out.print(SubTitle+ " - " +invoiceNumber+ "\n");
        System.out.print(invoiceData+"\n\n");

        System.out.print("CUSTOMER NAME - "+customerName+ "\nCUSTOMER ID   - "+customerId+ "\n\n");

        System.out.print("**************************************************************************************************************\n");
        System.out.print("PRODUCT NAME\tPRODUCT ID\t\tUNITS\t\tPRICE PER PRODUCT\t\tTOTAL PRICE PER PRODUCT\t\tDISCOUNT\n");
        for (int i = 0; i < productIDArray.size(); i++) {
            System.out.print(""+productNameArray.get(i)+"\t\t\t"+productIDArray.get(i)+"\t\t"+numberOfUnitsArray.get(i)+"\t\t\t"+priceOfProductsArray.get(i)+"\t\t\t\t\t"+totalPricePerProductArray.get(i)+"\t\t\t\t\t\t"+discountPerQuantityArray.get(i));
            System.out.print("\n");
        }
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("SUBTOTAL    - " +subTotal+"\n");
        System.out.print("TOTAL PRICE - " +TotalPrice+"\n");
        System.out.print("PAID BY     - " +paymentMethod+"\n");
        System.out.print("**************************************************************************************************************\n\n");
        System.out.print("THANK YOU FOR SHOPPING WITH US\n\n\n");
    }



}
