package menu;

import java.io.FileWriter;
import java.io.IOException;

public class Customer {
    // customer data
    private String customerId;
    private String customerName;
    private String email;
    private String address;
    private String number;
    private String DOB;
    private String gender;

    // constructors

    public Customer(){

    }

    public Customer(String customerId, String customerName, String email, String address, String number, String DOB, String gender) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.address = address;
        this.number = number;
        this.DOB = DOB;
        this.gender = gender;
    }

    // setters

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // getters

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public String getDOB() {
        return DOB;
    }

    public String getGender() {
        return gender;
    }

    public void displayCustomerHeader(){
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("CUSTOMER ID\t\tCUSTOMER NAME\t\tEMAIL\t\t\t\tADDRESS\t\t\t\t\t\t\tNUMBER\t\t\tDOB\t\t\t\tGENDER");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
    }

    public void displayCustomer(){

        System.out.format(customerId+"\t\t"+customerName+"\t\t\t\t"+email+"\t\t"+address+"\t\t"+number+"\t\t"+DOB+"\t\t"+gender);
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public void printAdminTaskOfCustomer(String cName, String cID, String task){
        try {
            FileWriter myWriter = new FileWriter("CustomerAdminTask.txt", true);
            myWriter.write("'"+cName+"'\t'"+cID+"'\t'"+task+"'\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
