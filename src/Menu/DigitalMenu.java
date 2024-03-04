/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class DigitalMenu {
    
    public static void main(String[] args) {
        //Burgers
        //Classic Chicken Fillet Burger
        Burger classic = new Burger("#B1","Classic Chicken Fillet Burger",new String[]{"Breaded Pure Chicken Breast","Fresh Tomatoes","Shredded Lettuce","Cheddar Cheese Slice"},2.65);
        //Mexican Chicken Fillet Burger
        Burger mexican = new Burger("#B2","Mexican Chicken Fillet Burger",new String[]{"Breaded Pure Chicken Breast","Shredded Lettuce","Mexican Chicken Mix","2 Swiss Cheese Slices"},4.65);
        //Cheddary Chicken Fillet Burger
        Burger cheddary = new Burger("#B3","Cheddary Chicken Fillet Burger",new String[]{"Breaded Pure Chicken Breast","Fresh Tomatoes","Shredded Lettuce","Potato Chips","Cheddar Sauce","Mayo"},3.25);
        //Trio Tender N Cheddar Burger
        Burger triotender = new Burger("#B4","Trio Tender N Cheddar Burger",new String[]{"3 Breaded Pure Chicken Tenders", "BBQ Sauce","Cheddar Cheese Patty","Fresh Tomatoes","Shredded Lettuce", "Mayo"},4.65);
        //Honey Turkey Chicken Fillet Burger
        Burger honeyturkey = new Burger("#B5","Honey Turkey Chicken Fillet Burger",new String[]{"Breaded Pure Chicken Breast","Fresh Tomatoes","Shredded Lettuce","Grilled Turkey Slice","Cheddar Cheese Slice","Mayo","Honey Mustard Sauce"},3.60);
        //
        
        //Sides
        Sides wings = new Sides("#S1","Crispy Chicky Wings",new String[]{"4 Pieces of Breaded Chicken Wings"},2.00,"BBQ");
        Sides crispy = new Sides("#S2","Crispy Chicky Strips",new String[]{"3 Pieces of Breaded Pure Crispy Chicken Breast Strips"},2.00,"Honey Mustard");
        Sides tenders = new Sides("#S3","Crispy Chicky Tenders",new String[]{"3 Pieces of Breaded Pure Chicken Tenders"},2.00,"Buffalo");
        Sides cheesebites = new Sides("#S4","Cheezy Bites",new String[]{"4 Pieces of Breaded Cheese Mix Bites."},1.70,"No Sauce");
        //
        
        //Drinks
        //(String id,String name, String[] ingredients, double price)
        Drink sevenup = new Drink("#D1","7up",new String[]{"..."},0.60);
        Drink pepsi = new Drink("#D2","Pepsi",new String[]{"..."},0.60);
        Drink lemonade = new Drink("#D3","Lemonade",new String[]{"..."},0.60);
        Drink fruitjuice = new Drink("#D4","Fruit Juice",new String[]{"Orange,Apple,Pineapple"},0.60);
        //
        
        // Meals of Burgers
        ArrayList<Food> burgers = new ArrayList<>();
        burgers.add(classic);burgers.add(mexican);burgers.add(cheddary);burgers.add(triotender);burgers.add(honeyturkey);
        Category meals = new Category ("Meals",burgers);
        //
         
        //Sides N Sauces
        ArrayList<Food> sidesList = new ArrayList<>();
        sidesList.add(wings);sidesList.add(crispy);sidesList.add(tenders);sidesList.add(cheesebites);
        Category sidesnsauce = new Category ("SidesNSauces",sidesList);
        //sidesnsauce.DisplayCategory();
         
        //Drinks
        ArrayList<Food> drinkList = new ArrayList<>();
        drinkList.add(sevenup);drinkList.add(pepsi);drinkList.add(lemonade);drinkList.add(fruitjuice);
        Category drinks = new Category ("Drinks",drinkList);
        //
        
        //Digital Menu
        Menu menu = new Menu("QuickBite Diner",new ArrayList<Category>());
        menu.addCategory(meals);menu.addCategory(sidesnsauce);menu.addCategory(drinks);
        //
         
        //Display Menu
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        Receipt r = new Receipt();
        int firstlimit = 1,secondlimit = 5;
        int choice = 0;boolean again;
        System.out.println("\t-- "+menu.getName()+" Menu --\nPlease Enter a Nb : \n1-Show Menu\n2-Make/Add an Order\n3-Cancel an Order\n4-Print Receipt\n");
        while(!exit)
        {
            do
            {
                try
                {
                    choice = input.nextInt();
                    again = !validInput(choice,firstlimit,secondlimit);
                }
                catch(InputMismatchException | IllegalArgumentException e )
                {
                    System.out.println("Invalid Input. Please Try Again");
                    again = true;
                }
                input.nextLine();
            }while(again);

            switch(choice)
            {
                case 1 :
                    System.out.println(menu.displayMenu());
                    break;
                case 2 :
                    addOrder(menu,r);
                    break;
                case 3 :
                    cancelOrder(r);
                    break;
                case 4 :
                    printReceipt(r);
                    exit = true;
                    break;
                default :
                    System.out.println("Invalid Input.");
            }
        }    
    }
    
    public static void cancelOrder(Receipt receipt)
    {
        Scanner input = new Scanner(System.in);
        String orderId;
        System.out.println("Enter Order ID: ");
        orderId = input.next();
        //validate orderId
        String statement;
        if(!Order.validOrderId(orderId))
        {
            statement = "Invalid ID\n";
        }
        else
        {
            Order removedOrder =  receipt.getItem(orderId);
            if(removedOrder == null)
            {
                statement = "Order ID Not Found\n";
            }
            else
            {
                receipt.getItems().remove(removedOrder);
                statement = "Cancelation Succeeded\n";
            }
        }
        System.out.println(statement);
    }
    
    public static void printReceipt(Receipt receipt)
    {
        System.out.println(receipt.printReceipt());
    }
    
    public static void addOrder(Menu menu,Receipt receipt)
    {
        String orderIdMade = makeOrder(menu,receipt);
        String statement;
        if(orderIdMade == null)
            {
                statement = "Order Failed";
            }
        else
            {
                statement = "Order ID : "+orderIdMade+" Succeeded";
            }
        System.out.println(statement);
    }
    public static String makeOrder(Menu menu,Receipt receipt)
    {
        try
        {
            Order order = createOrder(menu);
            receipt.addOrders(order);
            return order.getId();
        }
        catch(IllegalArgumentException | NullPointerException e)
        {
            return null;
        }
    }
    
    public static Order createOrder(Menu menu)
    {
        Scanner input = new Scanner(System.in);
        //ask for category
        //ask for item name
        System.out.println("Enter the name of the choosen category : ");
        String categoryName = input.nextLine();
        System.out.println("Enter the name of the choosen item : ");
        String itemName = input.nextLine();
        System.out.println("Enter the quantity : ");
        try
        {
            int quantity = input.nextInt();
            Food item = menu.getFoodByCategoryName(categoryName, itemName);
            //Order(String nameofitem,int quantity,double itemprice)
            Order order = new Order(item.getName(),quantity,item.getPrice());
            return order;
        }
        catch(NullPointerException | InputMismatchException e)
        {
            return null;
        }
        // System.out.println("Invalid Input. Order Operation Failed.");

    }
    
    public static boolean validInput(int i,int firstlimit,int secondlimit)
    {
        if(i<firstlimit|| i>secondlimit)
        {
            throw new IllegalArgumentException();
        }
        return true;
    }
}