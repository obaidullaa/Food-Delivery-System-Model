import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.Random;

import java.util.Scanner;
import java.util.Random;

public class Code{
  public static void main(String[] args) {
  
    Scanner input = new Scanner(System.in);
    
    design();
    design();
    System.out.println("          Choose your desired option:\n " + "          1. Seller(Restaurant owner)\n" + "           2. Customer \n ");
    design();
    design();
    
    System.out.print("Enter your choice: ");
    char user = (input.next()).charAt(0);
    
    // For Restaurant owner
    if (user == '1') {
      
      design();
      int count = 1;
      
      //  ==========> Login && SignUp of Restaurant
      boolean loop = true;
      
      String name = "";
      while (loop){
        
        if (count == 2){
          design();
          System.out.println("============================ Login ===================================");
        }
        
        System.out.print("Enter the username: ");
        name = input.next();
        
        if (!isSignedIn(name, "Restaurants.txt")){
          design();
          System.out.print("You donot have account\nIf you want to create account press 0 to signup, To login again press anything except 0: ");
          char ch = (input.next()).charAt(0); // ch = choice
          
          // Sign Up
          if (ch == '0'){
           
            design();
            System.out.println("=========================== Welcome to signup ==============================");
            
            design();
            System.out.print("Enter the name:     ");
            String rName = input.next(); // Restaurant name
            while (rName.length()<4){
              System.out.println("Length must be greater than 4");
              System.out.print("Enter the Username again: ");
              rName = input.next();
            }
            
            design();
            passwordCriterion();
            String rPassword = input.next(); // Restaurant password
            while (!isValidPassword(rPassword)){
                System.out.print("The password is not Secure, please set password by following the above criteria: ");
             	rPassword = input.next();
            }
            
            design();
            System.out.println("Following the cuisines, you will have to chose from one of these: ");
            System.out.println("1: Pizza\n2: Burger\n3: Chinese \n4: Pakistani\n5: Sweet");
   	    System.out.print("Select the main cuisine for you restaurant: ");
   	    String rCategory = input.next(); // Restaurant cuisine
        
            registerRestaurant(rName, rPassword, rCategory);
            
            count++;
          }
        }
         else{
           loop = false;
         }
       } 
      
       System.out.print("Enter the password: ");
       String password = input.next();
      
       String cat = categoryOfRestaurant(name, password, "Restaurants.txt");
       
       // ========> Restaurants to add thier food items 
       
       String path =  cat + "/" + name + ".txt";
       System.out.println("Path is " + path);
       
       File file = new File(path);
       
       System.out.println("=========================== FoodProduct adding Section ==============================");

       addFoodItem(file);
       
      }
      
      // Customer
      else if (user == '2'){
        
        design();
        int count = 1;
      
        // ==========> Login && SignUp of Customer
        boolean loop = true;
      
        String cEmail = "";
        while (loop){
        
          if (count == 2){
            design();
            System.out.println("============================ Login ===================================");
          }
        
          System.out.print("Enter your Email to login: ");
          cEmail = input.next(); 
        
          if (!isCustomerRegistered(cEmail, "Customers.txt")){
            design();
            System.out.print("You donot have account\nIf you want to create account press 0 to signup, To login again press anything except 0: ");
            char ch = (input.next()).charAt(0); // ch = choice
          
            // Sign Up
            if (ch == '0'){
           
              design();
              System.out.println("=========================== Welcome to signup ==============================");
              
              design();
              // Input user name from customer
              System.out.print("Enter the User name:     ");
              String cName = input.next(); // Customer name
              while (cName.length()<4){
                System.out.println("Length must be greater than 4");
                System.out.print("Enter the Username again: ");
                cName = input.next();
              }
              
              design();
              // Input email from customer isValidEmail(String email)
              emailCriterion();
              cEmail = input.next(); // Customer email
              while (!isValidEmail(cEmail)){
                  System.out.print("The email is not correct, please set password by following the above criteria: ");
               	  cEmail = input.next();
              }
              
              design();
              // Input password from customer
              passwordCriterion();
              String cPassword = input.next(); // Customer password
              while (!isValidPassword(cPassword)){
                  System.out.print("The password is not Secure, please set password by following the above criteria: ");
               	  cPassword = input.next();
              }
              
              design();
              // Input phone number from customer
              System.out.print("Enter your phone number: ");
              String cNumber = input.next(); // Customer Number
              while (!isValidPhoneNumber(cNumber)){
                System.out.print("Enter the correct phone number: ");
                cNumber = input.next();
              }
              
              design();
              // Input location from customer
              System.out.println("Location : a, b, c, d");
              System.out.print("Enter your location: ");
              String cLocation = input.next(); // Customer Location
              while (!(cLocation.equals("a") || cLocation.equals("b") || cLocation.equals("c") || cLocation.equals("d"))){
                System.out.print("You have to choose only from these locations, please enter again : ");
                cLocation = input.next();
              }
        
              registerCustomer(cName, cPassword, cEmail, cNumber, cLocation);
              count++;
            }
          }
           else{
             loop = false;
           }
         }
       
         System.out.print("Enter the password: ");
         String cpassword = input.next();
       
         while (!customerPasswordChecking(cEmail, cpassword, "Customers.txt")){
           System.out.print("Please Enter the correct password: ");
           cpassword = input.next();
         }
         
         // Interface after login||Signup
          
         // Cuisines list
         design();
         System.out.println("Select the Cuisine:\n1: Pizza\n2: Burger\n3: Chinese \n4: Pakistani\n5: Sweet: ");
         String c = input.next();
         design();
         
         // Restaurant list
         design();
         System.out.println("Following are the Restaurants providing deals on your desired cuisine: ");
         for (int i=0; i<totalRow("Restaurants.txt"); i++){
           if ((getCategory(i, "Restaurants.txt")).equals(c)){
               System.out.print(getName(i, "Restaurants.txt") + "   "); 
           }
         }
         System.out.println();
         
         
         // Restaurant selection
         System.out.print("Enter the name of restaurant you want to select: ");
         String selectedRestaurantname = input.next();
         
         String path = c + "/" + selectedRestaurantname + ".txt";
         design();
         
         // Show items of the Restaurant
         System.out.println("==========================================================");
         showData(path);
         System.out.println("==========================================================");
         
         File f = new File(path);
        
         
         design();
         // Item selection         
         System.out.print("Enter the item name  : ");
         String inputProduct = input.next();
         
         int price = 1;
          
         // Get the price of selected item
         for (int i=0; i<totalRow(path); i++){
           if ((getItem(i, path)).equals(inputProduct)){
             price = getPrice(i, path);
           }
         }
         
         // Quantity 
         System.out.print("Enter the quantity  : ");
         int quantity = input.nextInt();
         design();
         
         
         // Total bill (bill + tax)
         double x = price * quantity * 0.005;
         double total = (price * quantity) - x;
         
         // Distance
         int max = 6; // kilometer
         int min = 1; 
         
         Random r = new Random();
         int distance = r.nextInt((max - min) + 1) + min;
         
         // Rider fee
         int riderFee = distance*15;
         
         // final Amount (total + Rider fee)
         double finalAmount = total + riderFee; 
        
         System.out.println("==========================================================");
         
         System.out.println("Item            =       " + inputProduct);
         System.out.println("Price           =       " + price);
         System.out.println("Quantity        =       " + quantity);
         System.out.println("Tax             =       " + 0.005);
         System.out.println("Total           =       " + total);
         
         System.out.println("Distance        =       " + distance);
         System.out.println("Rider fee       =       " + riderFee);
         System.out.println("Final Amount    =       " + finalAmount);
         
         System.out.println("==========================================================");
         
         
         System.out.println("Enter 1 to confirm delivery else decline: ");
         int confirmation = input.nextInt();
         
         if (confirmation == 1){
           System.out.println("Your orderd is on your way");
         }
         else{
           System.out.println("Order canceled");
         }
        
      }
      
      else{
        System.out.println("You have entered the wrong option");
      }
    }
    
    // ==============================================================================================================================================
    // ===============================================================   Customer     ===============================================================
    // ==============================================================================================================================================
    
    // =============================================== Check if Customer is registered =================================================
    
    public static boolean isCustomerRegistered(String customer, String fileName){
      boolean registered = false;
      for (int i=0; i<totalRow(fileName); i++){
        if (getEmail(i, fileName).equals(customer)){
          registered = true;
        }
      }
      
      return registered;
    }
    
    
    // =========================================== Checking the password of Customer during login =================================================
    
    public static boolean customerPasswordChecking(String customer, String password, String fileName){
      boolean passwordValue = false;
      for (int i=0; i<totalRow(fileName); i++){
        if (getEmail(i, fileName).equals(customer)){
          if (password.equals(getCustomerPassword(i, fileName))){
            passwordValue = true;
          }       
        }
      }
      
      return passwordValue;
    }
    
    // ============================================  getName, getPassword, getEmail, getNumber, getLocation(Customer) ==================================================
  
    public static String getCustomerName(int r, String fileName){
       return getCol0(0, getRow(r, fileName));
    }
  
    public static String getCustomerPassword(int r, String fileName){
       return getCol0(1, getRow(r, fileName));
    }
  
    public static String getEmail(int r, String fileName){
       return getCol0(2, getRow(r, fileName));
    }
    
    public static String getNumber(int r, String fileName){
       return getCol0(3, getRow(r, fileName));
    }
    
    public static String getLocation(int r, String fileName){
       return getCol0(4, getRow(r, fileName));
    }
  
    public static String getCol0(int c, String row){
    
      String name = "";
      String password = "";
      String email = "";
      String number = "";
      String location = "";
    
      int colon = 0;
    
      for (int i=0; i<row.length(); i++){
        if ((row.substring(i, i+1)).equals(",")){
          colon++;
        }
      
        if (colon == 0){name += row.substring(i, i+1);}
        else if (colon == 1){password += row.substring(i, i+1);}
        else if (colon == 2){email += row.substring(i, i+1);}
        else if (colon == 3){number += row.substring(i, i+1);}
        else if (colon == 4){location += row.substring(i, i+1);}
      }
    
      if (c == 0){return name;}
      else if (c == 1){return removeExtraComma(password);}
      else if (c == 2){return removeExtraComma(email);}
      else if (c == 3){return removeExtraComma(number);}
      else if (c == 4){return removeExtraComma(location);}   
  
      return "";
    }
  
    // Scanner class to get specific row
    public static String getRow(int row, String fileName){
      try{
     
       File f = new File(fileName);
       Scanner sc = new Scanner(f);
     
       int r = 0;
       while(sc.hasNextLine()){
         if (r == row){
           return sc.nextLine();
         }
       
         r++;
         sc.nextLine();
       }
      }
    
      catch(IOException e){
        e.printStackTrace();
      }
    
      return "";
    }
    
    
    // ================================================ Register  =================================================================
    
    public static void registerCustomer(String name, String password, String email, String number, String location){
       
       File file1 = new File("Customers.txt");
       
       String data = name + "," + password + "," + email + "," + number + "," + location;
   
       try{
         FileWriter w = new FileWriter(file1, true);
         
         if (file1.length() == 0){
           w.write(data);  
         }
         else{
           w.append("\n" + data);
         }
     
         w.close();
       }
   
       catch(Exception e){
         e.getStackTrace();
       }
    
    }
    
    // ====================================================================== Show products to customer ==========================================================================
    
    
  // show the Data
  public static void showData(String fileName){
    
    System.out.println();
    System.out.println(" Item                 |||||              Price");
    System.out.println("--------------------------------------------");
    for (int i=0; i<totalRow(fileName); i++){
      System.out.printf(" %s         %s\n", getCol1(0, getRow1(i, fileName)), getCol1(1, getRow1(i, fileName)));
    }
    System.out.println("---------------------------------------------");
    
  }
  
  // get elements (Item, getPrice)
    
    public static String getElement(int r, int c, String fileName){
      return getCol1(c, getRow1(r, fileName));
    }
  
    public static String getItem(int r, String fileName){
      return getCol1(0, getRow1(r, fileName));
    }
  
    public static int getPrice(int r, String fileName){
      return Integer.parseInt(getCol1(1, getRow1(r, fileName)));
    } 
    
    
  
  public static String getCol1(int c, String row){
    
    String product = "";
    String price = "";
    
    int colon = 0;
    
    for (int i=0; i<row.length(); i++){
      if ((row.substring(i, i+1)).equals(",")){
        colon++;
      }
      
      if (colon == 0){product += row.substring(i, i+1);}
      else if (colon == 1){price += row.substring(i, i+1);}
    }
    
    if (c == 0){return product;}
    else if (c == 1){return removeExtraComma(price);}    
    
    return "";
  }
  
  // Scanner class to get specific row
  public static String getRow1(int row, String fileName){
    try{
     
     File f = new File(fileName);
     Scanner sc = new Scanner(f);
     
     int r = 0;
     while(sc.hasNextLine()){
       //if (r != row-1){
       //  sc.nextLine();
       //}
       
       if (r == row){
         return sc.nextLine();
       }
       
       r++;
       sc.nextLine();
     }
    }
    catch(IOException e){
      e.printStackTrace();
    }
    
    return "";
  }
    
    // ==============================================================================================================================================
    // ===============================================================    Checks    =================================================================
    // ==============================================================================================================================================
    
    
    // ================================================================= Password Check =============================================================
    
    public static boolean isValidPassword(String password) {
        
        int PASSWORD_LENGTH = 6;
        
        if (password.length() < PASSWORD_LENGTH) return false;

        int charCount = 0;
        int numCount = 0;
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (isNumber(ch)) numCount++;
            else if (isLetter(ch)) charCount++;
            else return false;
        }


        return (charCount >= 2 && numCount >= 2);
    }

    
    public static void passwordCriterion(){
        System.out.print(
                "1. A password must have at least eight characters.\n" +
                "2. A password consists of only letters and digits.\n" +
                "3. A password must contain at least two digits \n" +
                "Input a password (You are agreeing to the above Terms and Conditions.): ");
    }
    
    // ========================================================================== Email Check ================================================================
    
    public static boolean isValidEmail(String email){
      
      // prefix and Suffix
      String emailPrefix = "";
      String emailSuffix = "";
     
      for (int i=0; i<email.length(); i++){
            if ((email.substring(i, i+1)).equals("@")){
                emailPrefix = email.substring(0, i);
                emailSuffix = email.substring(i+1, email.length());
            }
        }
    
     
      if (!isValidPrefix(emailPrefix) && !isValidSuffix(emailSuffix)){
          return false;
      }
      
      return true;
    }

    // Prefix Check =============================================================
    /* 
       (1) Acceptable email prefix formats
         (a) least 2 characters
         (b) Allowed characters: letters (a-z), numbers, underscores, periods, and dashes.
    */

    public static boolean isValidPrefix(String prefix) {
        
        int prefixLength = 4;
        if (prefix.length() < prefixLength) return false;

        int alpCount = 0; // Alphabetic characters
        int numCount = 0; // Numeric characters
        int characterCount = 0; // All characters except alphanumeric characters

        for (int i = 0; i < prefix.length(); i++) {

            char ch = prefix.charAt(i);

            if (isNumber(ch)) numCount++;
            else if (isLetter(ch)) alpCount++;
            else if (isCharacter(ch)) characterCount++;
            else return false;
        }

        return (characterCount >= 1 && numCount >= 1 && alpCount >= 2);
    }
    

    // Suffix Check =============================================================
    
    public static boolean isValidSuffix(String suffix){
        
        // if Suffix is among popular EmailSuffixes then return (No extra need to check validity of domain)
        String[] popularEmailSuffix = {"gmail.com", "outlook.com", "hotmail.com", "aol.com", "aim.com", "yahoo.com", "icloud.com", "titan.email", "protonmail.com", "pm.com", "zoho.com ", "yandex.com", "gmx.com", "hubspot.com", "mail.com", "tutanota.com"};
        for (int i=0; i<popularEmailSuffix.length; i++){
            
            if ((popularEmailSuffix[i]).compareTo(suffix) == 0){
                return true;
            }
        }

        // if not popular then we will check domain
        
        String domainName = "";
        String domain = "";
        for (int i=0; i<suffix.length(); i++){
            if ((suffix.substring(i, i+1)).equals(".")){
                domainName = suffix.substring(0, i);
                domain = suffix.substring(i+1, suffix.length());
            }
        }

        System.out.println(domainName);
        System.out.println(domain);


        return false;
    }

    // Domain Check
    /*  
        (1) Domain name must have all alphabetic characters

        (2) Acceptable email domain formats
          (a) Allowed characters: letters, numbers, dashes.
          (b) The last portion of the domain must be at least two characters, for example: .com, .org, .cc
    */

    public static boolean isValidDomainName(String domain) {
        int domainLength = 2;
        if (domain.length() < domainLength) return false;
        for (int i=0; i<domain.length(); i++){
            if (isNumber(domain.charAt(i))){
                return false;
            }
            else if (isCharacter(domain.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean isValidDomain(String domain) {
        int domainLength = 2;
        if (domain.length() < domainLength) return false;
        return true;
    }
    
    /*
    
  (1) Acceptable email prefix formats
    (a) least 2 characters
    (b) Allowed characters: letters (a-z), numbers, underscores, periods, and dashes.
    (c) An underscore, period, or dash must be followed by one or more letter or number.

  (2) Acceptable email domain formats
    (a) Allowed characters: letters, numbers, dashes.
    (b) The last portion of the domain must be at least two characters, for example: .com, .org, .cc
    
    */
    
    public static void emailCriterion(){
        System.out.print(
                "1. A email name must have at least three characters.\n" +
                "2. A email may consists of only letters(a-z), numbers, underscores, periods, and dashes.\n" +
                "3. A email domain must be valid \n" +
                "Input a email (You are agreeing to the above Terms and Conditions.): ");
    }
    
    // ================================================================= Phone Number Check =========================================================
    
    /*
      Phone number length is 10, then first character must be between 6 & 9
      Phone number length is 10, then first character must be 0
      Phone number length is 10, then first character must be 9 and second must be 1
    */
    
    public static boolean isValidPhoneNumber(String number){
      if (number.length() == 10){
        if (number.charAt(0) < '6' &&  number.charAt(0) > '9'){
          return false;
        }
        return true;
      }
      
      else if (number.length() == 11){
        if (number.charAt(0) != '0'){
          return false;
        }
        return true;
      }
      
      else if (number.length() == 12){
        if (number.charAt(0) != '9' && number.charAt(1) != '1'){
          return false;
        }
        return true;
      }
      
      return false;
    }
    
    // ===============================================================================================
    

    // Letter
    public static boolean isLetter(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }

    // Number
    public static boolean isNumber(char ch) {
        return (ch >= '0' && ch <= '9');
    }

    // Underscores, periods, and dashes
    public static boolean isCharacter(char ch){
        if (ch == '_' || ch == '-' || ch == '.'){
            return true;
        }
        return false;
    }
    
    
    // ==============================================================================================================================================
    // ===============================================================   Restaurant Owner    ========================================================
    // ==============================================================================================================================================
    
    // ======================================================================= Add Food Item ==============================================================================
   
   public static void addFoodItem(File file){
     // Writing a file
     Scanner input = new Scanner(System.in);
     
     System.out.println("Enter 0 in food item name if you want to stop adding items.");
     
     String name = "-1";
     
     while(true){
     
       System.out.println();
       
       System.out.print("Enter the food name: ");
       name = input.next();
       
       if (name.equals("0")){break;}
       
       System.out.print("Enter the price : ");
       String price = input.next();
     
       String data = name + "," + price;
   
       try{
         FileWriter w = new FileWriter(file, true);
         
         if (file.length() == 0){
           w.write(data);  
         }
         else{
           w.append("\n" + data);
         }
     
         w.close();
       }
   
       catch(Exception e){
         e.getStackTrace();
       }
     }
   }
   
    
    
    // =============================================== Get category of the Restaurant =================================================
    
    public static String categoryOfRestaurant(String company, String companyPassword, String fileName){
      
      String cat = "";
      
      for (int i=0; i<totalRow(fileName); i++){
        if ((getName(i, fileName)).equals(company)){
          if ((getPassword(i, fileName)).equals(companyPassword)){
            cat = getCategory(i, fileName);
          }
        }
      }
      return cat;
    }
    
    // =============================================== Check if Restaurant is registered =================================================
    
    public static boolean isSignedIn(String company, String fileName){
      boolean registered = false;
      for (int i=0; i<totalRow(fileName); i++){
        if ((getName(i, fileName).equals(company))){
          registered = true;
        }
      }
      
      return registered;
    }
    
    // ==================================================  getName, getPassword, getCategory (Company) =====================================================================
  
    public static String getName(int r, String fileName){
       return getCol(0, getRow(r, fileName));
    }
  
    public static String getPassword(int r, String fileName){
       return getCol(1, getRow(r, fileName));
    }
  
    public static String getCategory(int r, String fileName){
       return getCol(2, getRow(r, fileName));
    }
  
    public static String getCol(int c, String row){
    
      String name = "";
      String password = "";
      String category = "";
    
      int colon = 0;
    
      for (int i=0; i<row.length(); i++){
        if ((row.substring(i, i+1)).equals(",")){
          colon++;
        }
      
        if (colon == 0){name += row.substring(i, i+1);}
        else if (colon == 1){password += row.substring(i, i+1);}
        else if (colon == 2){category += row.substring(i, i+1);}
      }
    
      if (c == 0){return name;}
      else if (c == 1){return removeExtraComma(password);}
      else if (c == 2){return removeExtraComma(category);}   
  
      return "";
    }
    
    // ================================================ Register Restaurant =================================================================
    
    public static void registerRestaurant(String companyName, String password, String category){
       
       // =========================== Store name of restaurant in Restaurant.txt file =====================
       
       File file1 = new File("Restaurants.txt");
       
       String data = companyName + "," + password + "," + category;
   
       try{
         FileWriter w = new FileWriter(file1, true);
         
         if (file1.length() == 0){
           w.write(data);  
         }
         else{
           w.append("\n" + data);
         }
     
         w.close();
       }
   
       catch(Exception e){
         e.getStackTrace();
       }
     
       // ===================== Create file of restaurant name in given category(Cuisine) ======================
       
       companyName += ".txt";
     
       String path = category + "/" + companyName;
       File file2 = new File(path);
   
       // if file doesnot exists then create the file
       if (!file2.exists()){
         try{
           boolean value = file2.createNewFile();
         }
   
         catch(Exception e){
           e.getStackTrace();
         }
       }
    
    }
    
  // ==================================================================================
  
  // Get total number of rows in file
  public static int totalRow(String fileName){
    
    int r = 0;
    try{
     
     File f = new File(fileName);
     Scanner sc = new Scanner(f);
     
     while(sc.hasNextLine()){
       sc.nextLine();
       r++;
     }
    }
    catch(IOException e){
      e.printStackTrace();
    }
    
    return r;
  }
  
  
  // Remove extra comma and dot at end of string
  public static String removeExtraComma(String s){
    return s.substring(1, s.length());
  }
  

  public static void design() {
      for (int i = 0; i <= 15; i++) {
          System.out.print(" * ");
      }
      System.out.println();
  }

}