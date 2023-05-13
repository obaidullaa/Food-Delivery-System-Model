# Food Delivery System Clone

The food delivery system is designed to cater to two main stakeholders, the restaurant owner and the customer.
Restaurant owners can sign up and log in to the system to add their cuisine and food items. On the other hand,
customers can sign up and log in to the system and select a cuisine, choose a restaurant, select food items and
enter the quantity they want. The system also includes extra checks such as username, password, email, and phone number validation.
The system utilizes Java modules such as File, FileWriter, IOException, FileReader, Random, and Scanner to perform
various tasks such as file input/output and user input/output. The main objective of the system is to provide a 
convenient and efficient platform for food ordering and delivery

Modules: Following are the modules and classes used
java.io.File;
java.io.FileWriter;
java.io.IOException;
java.io.FileReader;
java.util.Random;
java.util.Scanner; 



Introduction:
Food delivery System consist of two main parts: 
1) Restaurant / Shop Owner
2) Customer

#	                      Restaurant Owner

1. SignUp and Login:
In starting we are showed login and if you donot have account then Signup let you create account.
After this you can easily login.

2. Cuisines:
After login, all cuisines will be showed, which are categories. Owner will have to select the cuisines

3. Enter food items:
After this you will have to enter the food items, you can enter as many products as you want.

4. Close the program:
To exit the program you will have to enter the zero.  
 

 #                         Customer

1. Signup and Login:
In starting we are showed login and if you donot have account then Signup let you create account.

For signup User will be asked:
    • User Name
    • Email
    • Password
    • Phone number
    • Address
After this you can easily login 

2. Cuisine:
Five cuisines are presented which are Pizza, Burger, Chinese, Burger, Pakistani, Sweet. You will have to select from on of these categories.

3. Restaurant Selection:
Restaurant of your category will be shown and you will have to select your desired restaurant.

4. Restaurant Menu:
Restaurant menu will be shown be shown to customer and he will have to select the item he want.

5. Quantity:
Customer will also have to enter the quantity he wants.

6. Bill:
Final bill with final amount will be shown and you will have to confirm the delivery or cancel it.



# Extra Checks


// ============================ Username

Must be between six and 50 characters long.
Can contain any letters from a to z and any numbers from 0 through 9.
Can contain spaces and some special characters, including @ (at sign) . (period) - (hyphen or dash) _ (underscore).
Can contain non-English characters (such as é).
Is not case-sensitive.

// ============================= password

Must be between eight and 32 characters long.
Must include at least one number or special character and one letter.
Can contain any letters a to z and any numbers from 0 through 9.
Can contain some special characters, including @ (at sign) . (period) - (hyphen or dash) _ (underscore).
Is case-sensitive.
Must be different from your first name, last name, and username.

// ============================== Email 

(1) email prefix and (2) email domain

(1) Acceptable email prefix formats
   (a) least 2 characters
   (b) Allowed characters: letters (a-z), numbers, underscores, periods, and dashes.
   (c) An underscore, period, or dash must be followed by one or more letter or number.

(2) Acceptable email domain formats
    (a) Allowed characters: letters, numbers, dashes.
    (b) The last portion of the domain must be at least two characters, for example: .com, .org, .cc
    
// ============================== Phone Number 

Phone number length is 10, then first character must be between 6 & 9
Phone number length is 10, then first character must be 0
Phone number length is 10, then first character must be 9 and second must be 1
