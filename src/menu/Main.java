package menu;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean done = true;
        int userFirstOption;

        Scanner userInput = new Scanner(System.in);

        while (done){

            try {

                int i = 0;

                System.out.println("Select option \n1)Customers\n2)Products \n3)Invoice \n4)Admin tasks \n5)exit");
                userFirstOption = Integer.parseInt(userInput.nextLine());

                if(userFirstOption == 1){
                    optionCustomer(userInput,i);
                }else if(userFirstOption == 2){
                    optionProduct(userInput,i);
                }else if(userFirstOption == 3){
                    optionInvoice(userInput, i);
                }else if(userFirstOption == 4){

                }else if(userFirstOption == 5){
                    done = false;
                    break;
                }else{
                    System.out.println("wrong input");
                }

            }
            catch(ClassNotFoundException ex){
                System.out.println("Driver not found");
            }
            catch (SQLException EX){
                System.out.println("Database not found");
                EX.printStackTrace();
            }
        }
    }


    public static void optionCustomer(Scanner userInput, int i) throws SQLException, ClassNotFoundException {

        int userSecondOptionCustomer = 0;

        String customerID;
        String customerName;
        String email;
        String address;
        String number;
        String DOB;
        String gender;

        // create customer object
        Customer c1;

        System.out.println("Select option \n1)Add Customer \n2)Update Customer \n3)Delete Customer \n4)Display a Customer \n5)Display all Customers");
        userSecondOptionCustomer = Integer.parseInt(userInput.nextLine());

        switch (userSecondOptionCustomer){ // switch for customers
            case 1:
                while (i == 0){
                    customerID = CustomersController.createCustomerID();
                    System.out.print("Enter Customer Name - ");
                    customerName = userInput.nextLine();
                    System.out.print("Enter Customer Email - ");
                    email = userInput.nextLine();
                    System.out.print("Enter Customer Address - ");
                    address = userInput.nextLine();
                    System.out.print("Enter Customer Contact Number - ");
                    number = userInput.nextLine();
                    System.out.print("Enter Customer DOB - ");
                    DOB = userInput.nextLine();
                    System.out.print("Enter Customer Gender - ");
                    gender = userInput.nextLine();

                    c1 = new Customer(customerID, customerName, email, address, number, DOB, gender);

                    i = CustomersController.saveCustomer(c1);
                    if(i != 0){
                        System.out.println("Customer Added");
                    }else{
                        System.out.println("Problem in adding Customer");
                    }
                }
                break;

            case 2:
                while (i == 0){
                    System.out.print("Enter Customer ID - ");
                    customerID = userInput.nextLine();
                    System.out.print("Enter Customer Name - ");
                    customerName = userInput.nextLine();
                    System.out.print("Enter Customer Email - ");
                    email = userInput.nextLine();
                    System.out.print("Enter Customer Address - ");
                    address = userInput.nextLine();
                    System.out.print("Enter Customer Contact Number - ");
                    number = userInput.nextLine();
                    System.out.print("Enter Customer DOB - ");
                    DOB = userInput.nextLine();
                    System.out.print("Enter Customer Gender - ");
                    gender = userInput.nextLine();

                    c1 = new Customer(customerID, customerName, email, address, number, DOB, gender);

                    i = CustomersController.upgradeCustomer(c1);
                    if(i != 0){
                        System.out.println("Customer Updated");
                    }else{
                        System.out.println("Problem in updating Customer");
                    }
                }

                break;

            case 3:
                while (i == 0){
                    System.out.print("Enter Customer ID - ");
                    customerID = userInput.nextLine();

                    c1 = new Customer();
                    c1.setCustomerId(customerID);

                    i = CustomersController.deleteCustomer(c1);
                    if(i != 0){
                        System.out.println("Customer deleted");
                    }else{
                        System.out.println("Problem in deleting Customer");
                    }
                }
                break;

            case 4:
                while (true){
                    System.out.print("Enter Customer ID - ");
                    customerID = userInput.nextLine();

                    c1 = new Customer();
                    c1.setCustomerId(customerID);

                    if(CustomersController.selectCustomer(c1)){
                        c1.displayCustomerHeader();
                        c1.displayCustomer();
                        break;
                    }else{
                        System.out.println("Invalid customer ID");
                    }
                }
                break;

            case 5:
                c1 = new Customer();

                CustomersController.selectAllCustomer(c1);
                break;
        }
    }

    public static void optionProduct(Scanner userInput, int i) throws SQLException, ClassNotFoundException {

        int userSecondOptionProduct = 0;

        String productID;
        String productName;
        String description;
        int purchasePrice;
        int sellingPrice;
        int quantity;

        // create Product object
        Product p1;

        System.out.println("Select option \n1)Add Product \n2)Update Product \n3)Delete Product \n4)Display a Product \n5)Display all Products");
        userSecondOptionProduct = Integer.parseInt(userInput.nextLine());

        switch (userSecondOptionProduct){ // switch for products
            case 1:
                while (i == 0){
                    productID = ProductController.createProductID();
                    System.out.print("Enter Product Name - ");
                    productName = userInput.nextLine();
                    System.out.print("Enter Product Description - ");
                    description = userInput.nextLine();
                    System.out.print("Enter Product Purchase Price - ");
                    purchasePrice = Integer.parseInt(userInput.nextLine());
                    System.out.print("Enter Product Selling Price - ");
                    sellingPrice = Integer.parseInt(userInput.nextLine());
                    System.out.print("Enter Product quantity - ");
                    quantity = Integer.parseInt(userInput.nextLine());

                    p1 = new Product(productID, productName, description, purchasePrice, sellingPrice, quantity);

                    i = ProductController.saveProducts(p1);
                    if(i != 0){
                        System.out.println("Product Added");
                    }else{
                        System.out.println("Problem in adding product");
                    }
                }

                break;

            case 2:
                while (i == 0){
                    System.out.print("Enter Product ID - ");
                    productID = userInput.nextLine();
                    System.out.print("Enter Product Name - ");
                    productName = userInput.nextLine();
                    System.out.print("Enter Product Description - ");
                    description = userInput.nextLine();
                    System.out.print("Enter Product Purchase Price - ");
                    purchasePrice = Integer.parseInt(userInput.nextLine());
                    System.out.print("Enter Product Selling Price - ");
                    sellingPrice = Integer.parseInt(userInput.nextLine());
                    System.out.print("Enter Product quantity - ");
                    quantity = Integer.parseInt(userInput.nextLine());

                    p1 = new Product(productID, productName, description, purchasePrice, sellingPrice, quantity);

                    i = ProductController.updateProduct(p1);
                    if(i != 0){
                        System.out.println("Product Updated");
                    }else{
                        System.out.println("Problem in Updating product");
                    }
                }

                break;

            case 3:
                while (i == 0){
                    System.out.print("Enter Product ID - ");
                    productID = userInput.nextLine();

                    p1 = new Product();
                    p1.setProductId(productID);

                    i = ProductController.deleteProduct(p1);
                    if(i != 0){
                        System.out.println("Product deleted");
                    }else{
                        System.out.println("Problem in deleting product");
                    }
                }

                break;

            case 4:
                while (true){
                    System.out.print("Enter Product ID - ");
                    productID = userInput.nextLine();

                    p1 = new Product();
                    p1.setProductId(productID);

                    if(ProductController.selectProduct(p1)){
                        p1.displayProductHeader();
                        p1.displayProduct();
                        break;
                    }else{
                        System.out.println("Invalid product ID");
                    }
                }

                break;

            case 5:
                p1 = new Product();
                ProductController.selectAllProducts(p1);
                break;

        }
    }

    public static void optionInvoice(Scanner userInput, int i) throws SQLException, ClassNotFoundException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        Customer customer;
        Product product;
        Invoice invoice;

        int userOption;

        String contactNumber;
        String productID;
        String invoiceID;
        int numOfUnits;
        int paymentType;
        float totalPricePerProduct;
        float subTotal = 0;
        float totalPrice = 0;
        int unitsForDiscount = 5;
        float discount = 4;

        System.out.println("Enter option \n1)Generate Invoice \n2)Delete invoice \n3)Search invoice \n4)Edit Discount");
        userOption = Integer.parseInt(userInput.nextLine());

        switch (userOption){
            case 1:

                while (true){
                    // set contact number of customer
                    System.out.print("Enter contact number - ");
                    contactNumber = userInput.nextLine();

                    customer = new Customer();
                    customer.setNumber(contactNumber);

                    if(CustomersController.selectCustomer(customer)){
                        break;
                    }else{
                        System.out.println("Invalid contact number");
                    }
                }

                invoice = new Invoice();

                // create invoice number
                String invoiceNumber;
                invoiceNumber = InvoiceController.createInvoice();
                invoice.setInvoiceNumber(invoiceNumber);



                // set customer name and id to invoice
                invoice.setCustomerName(customer.getCustomerName());
                invoice.setCustomerId(customer.getCustomerId());



                // set data to invoice
                invoice.setInvoiceData(formatter.format(date));

                String enter;
                do {
                    System.out.print("Enter product ID - ");
                    productID = userInput.nextLine();

                    product = new Product();

                    product.setProductId(productID);

                    ProductController.selectProduct(product);

                    // add selected product details to the list
                    invoice.getProductIDArray().add(product.getProductId());
                    invoice.getProductNameArray().add(product.getProductName());
                    invoice.getPriceOfProductArray().add(product.getSellingPrice());

                    // ask user to enter number of units
                    System.out.print("Enter number of units (If number of units greater than '"+unitsForDiscount+"' get '"+discount+"'% discount) - ");
                    numOfUnits = Integer.parseInt(userInput.nextLine());

                    // add number of units of the selected products to the list
                    invoice.getNumberOfUnitsArray().add(numOfUnits);

                    // calculate total price per product
                    totalPricePerProduct = numOfUnits * product.getSellingPrice();

                    // add total price per product to array list
                    invoice.getTotalPricePerProductArray().add(totalPricePerProduct);

                    // check is number of units greater-then the is discount number of units
                    if(numOfUnits > unitsForDiscount){
                        invoice.getDiscountPerQuantityArray().add(discount);

                        // calculate discount
                        totalPricePerProduct = (totalPricePerProduct / (100 + discount)) * 100;

                        // add total price per product to array list with discount
                        invoice.getTotalPriceWithOrWithoutDiscount().add(totalPricePerProduct);
                    }else if(numOfUnits < unitsForDiscount){
                        invoice.getDiscountPerQuantityArray().add(0f);

                        // add total price per product to array list with no discount
                        invoice.getTotalPriceWithOrWithoutDiscount().add(totalPricePerProduct);
                    }
                    // press while to continue adding products or press n to end process
                    System.out.print("To continue adding press y or to end process press n - ");
                    enter = userInput.nextLine();
                }while (Objects.equals(enter.toUpperCase(), "Y"));

                // get total price without discount
                for (int j = 0; j < invoice.getTotalPricePerProductArray().size(); j++) {
                    subTotal += invoice.getTotalPricePerProductArray().get(j);
                }
                // set total price
                invoice.setSubTotal(subTotal);

                // get subtotal
                for(int j = 0; j < invoice.getTotalPriceWithOrWithoutDiscount().size(); j++){
                    totalPrice += invoice.getTotalPriceWithOrWithoutDiscount().get(j);
                }
                // set subtotal to invoice
                invoice.setTotalPrice(totalPrice);

                // ask is pay buy card or cash
                System.out.println("Payment method \n1)Cash \n2)Card");
                paymentType = Integer.parseInt(userInput.nextLine());

                // set selection to invoice
                float cash = 0;
                if(paymentType == 1){
                    System.out.print("\nSubtotal Price - "+invoice.getSubTotal() + "\n");
                    System.out.print("Total price    - "+invoice.getTotalPrice() + "\n");
                    invoice.setPaymentMethod("Cash");
                    System.out.print("Enter cash amount - ");
                    cash = Integer.parseInt(userInput.nextLine());

                    // calculate change money
                    float balance;
                    balance = cash - totalPrice;
                    // display invoice details
                    System.out.print("\nSubtotal Price - "+invoice.getSubTotal() + "\n");
                    System.out.print("Total price    - "+invoice.getTotalPrice() + "\n");
                    System.out.print("Balance        - "+balance + "\n\n");
                }else if(paymentType == 2){
                    invoice.setPaymentMethod("Card");
                    System.out.print("\nSubtotal Price - "+invoice.getSubTotal() + "\n");
                    System.out.print("Total price    - "+invoice.getTotalPrice() + "\n\n");
                }

                // set selected product ids
                invoice.setProductIDs(InvoiceController.ProductIDArrayToString(invoice));

                // set selected product Names
                invoice.setProductNames(InvoiceController.ProductNameArrayToString(invoice));

                // set number of units of selected product
                invoice.setUnitsPerProduct(InvoiceController.NumberOfUnitsArrayToString(invoice));

                // set selected product price
                invoice.setPricePerProducts(InvoiceController.PriceOfProductArrayToString(invoice));

                // set total price of selected product with the number of units
                invoice.setTotalPricePerProduct(InvoiceController.totalPricePerProductArrayToString(invoice));

                // set discounts to selected products
                invoice.setDiscount(InvoiceController.discountPerQuantityToString(invoice));

                // save invoice to database
                i = InvoiceController.saveInvoice(invoice);
                if(i != 0){
                    System.out.println("Invoice Added");
                }else{
                    System.out.println("Problem in adding invoice");
                }

                invoice.printInvoice();

                break;



            case 2:
                while (i == 0){
                    System.out.print("Enter invoice ID - ");
                    invoiceID = userInput.nextLine();

                    invoice = new Invoice();

                    invoice.setInvoiceNumber(invoiceID);

                    i = InvoiceController.deleteInvoice(invoice);

                    if(i != 0){
                        System.out.println("Invoice deleted");
                    }else{
                        System.out.println("Problem in deleting invoice");
                    }
                }

                break;

            case 3:
                int selectedOption;
                System.out.println("Select option\n1)Search invoice by customer name \n2)Search invoice by date");
                selectedOption = Integer.parseInt(userInput.nextLine());

                switch (selectedOption){
                    case 1:
                        String searchData;
                        while (true){
                            System.out.print("Enter customer name - ");
                            searchData = userInput.nextLine();

                            invoice = new Invoice();
                            invoice.setCustomerName(searchData);

                            if(InvoiceController.searchInvoiceByCustomerName(invoice)) {
                                System.out.println("Invoices under customer name '"+searchData+"'");
                                break;
                            }else{
                                System.out.println("Invalid Customer name");
                            }
                        }
                        break;

                    case 2:
                        String startDate;
                        String endDate;
                        invoice = new Invoice();
                        while (true){
                            System.out.print("Enter starting date - ");
                            startDate = userInput.nextLine();

                            System.out.print("Enter end date - ");
                            endDate = userInput.nextLine();

                            if (InvoiceController.searchInvoiceByDate(invoice, startDate, endDate)){
                                System.out.println("Invoices from '"+startDate+"' to '"+endDate+"'");
                                break;
                            }else{
                                System.out.println("Invalid dates");
                            }
                        }


                }


        }
    }
}
