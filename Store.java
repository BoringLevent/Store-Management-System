import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

public class Store {
    int bill;
    Scanner scan = new Scanner(System.in);
    String[] Inventory = {"Lays", "Cheetos", "Orbis", "Dorritos", "Pepsi", "Coca-Cola", "Dew"};
    int[] inventoryAmount = {0,0,0,0,0,0,0};

    public void showInventory(){
        clearScreen();
        for(int i = 0; i<7; i++){
            if(inventoryAmount[i] != 0){
                System.out.println(Inventory[i] + ": " + inventoryAmount[i]);
            }
        }
        System.out.println("Your total bill is $" + bill);
        System.out.println("-----------------------------");
        System.out.println("Enter any key to exit. ");
        scan.nextLine();
        displayMainMenu();

    }
    public void purchaseItem(){

        String[] items = {"Lays", "Cheetos", "Orbis", "Dorritos", "Pepsi", "Coca-Cola", "Dew"};
        int[] prices = {30,20,10,50,60,40,30};

        for(int i = 0; i < 7; i++){
            System.out.println(i+1 + ") " + items[i] +": " + prices[i]);
        }
        System.out.println("Enter a number (1-7) or 0 to exit.");
        int choice = scan.nextInt();

        if (choice == 0){
            clearScreen();
            displayMainMenu();
        }
        else{
            System.out.println("Enter the quantity: ");
            int quantity = scan.nextInt();
            clearScreen(); 
            bill = bill + prices[choice] * quantity;
            inventoryAmount[choice] = inventoryAmount[choice] + quantity;
            System.out.println("Purchased " + quantity + " " + items[choice] + " for price " + prices[choice] * quantity);
            purchaseItem();
        }

        /*
        while(true){
            System.out.println("Choose the number of item to purchase (0 to exit)");
            System.out.println(Arrays.toString(items));
            int i = scan.nextInt();

            if(i==0){
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Checkout Successful! Your total bill is: " + bill);
                return false;
            }

            else{
                System.out.println("Purchased item " + items[i-1] + " for price " + prices[i-1]);
                bill = bill + prices[i-1];
                System.out.println("Bill: " + bill);
                purchaseItem(items, prices);
            }
            return true;
        }
        
    }

        String[] items = {"1.Lays: 50", "2.Cocomo: 10", "3.Juice: 20", "4.Cheetos: 30", "5.Pepsi: 70"};
        int[] prices = {50,10,20,30,70};
        System.out.println("Please choose an item below to purchase: ");
        
        purchaseItem(items,prices);

         */
    }

    public void displayMainMenu(){
        System.out.println("Please choose an option from below!");
        System.out.println("1) Purchase Items\n2) See Inventory\n3) Exit.");
        int choice = scan.nextInt();
        switch(choice){
            case 1:
                purchaseItem();
                break;

            case 2:
                showInventory();
                break;
            
            case 3:
                System.out.println("Exiting the store! Your bill is $" + bill);
                break;
            
            default:
                System.out.println("Invalid number entered! Try again");
                displayMainMenu();

        }
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
    
}
