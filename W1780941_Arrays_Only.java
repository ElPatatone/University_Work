
package w1780941_arrays_only;

        
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
        
        
/**
 *
 * @author mohah
 */
public class W1780941_Arrays_Only {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
            //initialises the main variables I will be using in the program
            int cabinNumber = 0;
            String name = null;

            String[] cruiseShip = new String[12];

   
            
            
           
            
            String choice = "null";

            initialise(cruiseShip);
            

            //prints out the menu and asks for a choice
            while (!choice.equalsIgnoreCase("q")){

                System.out.println("Please select one of the following options");
                System.out.println("V: View all cabins \nA: Add customer to cabin  \nE: Display Empty cabins \nD: Delete customer from cabin \nF: Find cabin from customer name \nS: Store program data into file \nL: Load program data from file \nO: View passengers Ordered alphabetically by name \nQ: Exit the program");
                System.out.println();
                System.out.print("Enter your choice: ");
                
                Scanner in = new Scanner(System.in);
                choice = in.next();
               
                System.out.println();
            

                if (choice.equalsIgnoreCase("a"))
                {
                    addCustomer(cruiseShip, name, cabinNumber);
                    
                }

                else if (choice.equalsIgnoreCase("v"))
                {
                    viewAllCabins(cruiseShip);
                }

                else if (choice.equalsIgnoreCase("e"))
                {
                    displayEmptyCabins(cruiseShip);
                   
                }

                else if (choice.equalsIgnoreCase("d"))
                {
                    deleteCustomer(cruiseShip, cabinNumber);
                    
                }

                else if (choice.equalsIgnoreCase("f")){
                    findCabinFromName(cruiseShip);
                    
                }

                else if (choice.equalsIgnoreCase("s"))
                {
                    storeData(cruiseShip);
                    
                }

                else if (choice.equalsIgnoreCase("l"))
                {
                    loadData(cruiseShip);
                   
                }

                else if (choice.equalsIgnoreCase("o"))
                {
                    sortAlphabetically(cruiseShip);
                    
                }

                else if (choice.equalsIgnoreCase("o"))
         
                
                break;    
            }
            System.out.println("You have quit the program");
            System.out.println();
            
           
            
        }

    /**
     *
     * @param cruiseShip
     */
    public static void initialise(String cruiseShip[]) {
            //just fillls in the array with the string empty 
            Arrays.fill(cruiseShip, "empty");
        }
        
    /**
     *
     * @param cruiseShip
     */
    public static void viewAllCabins(String cruiseShip[]) {

            //this will go through each of the elements of the array and print out the values of each.
            for(int i=0; i< cruiseShip.length; i++)
            {
                System.out.println("Cabin " + (i + 1) + " is occupied by - " + cruiseShip[i]);       
            }
            System.out.println();
    
        }

    /**
     *
     * @param cruiseShip
     * @param name
     * @param cabinNumber
     */
    public static void addCustomer(String cruiseShip[], String name, int cabinNumber) {
        
            //this will ask the user for the cabin number and the name they want to assign to the cabin
            //As indexing starts from 0. The cabin number would also start from 0, but you don't have a cabin 0 usually. So all I am doing is taking 1 away from the user input in order to get the right index for the cabin. 

            Scanner in = new Scanner(System.in);
           
            System.out.print("Enter the cabin number (1 to 12): ");
            cabinNumber = in.nextInt();

            System.out.print("Enter name for cabin " + cabinNumber +" : " ) ;
            name = in.next();
    
            System.out.println();
            

            cruiseShip[cabinNumber - 1] =  name ;
            

        }   

    /**
     *
     * @param cruiseShip
     */
    public static void displayEmptyCabins(String cruiseShip[]){

            //By going throgh the array it will check for the elements that have the "empty" value and print them out
            for(int i=0; i< cruiseShip.length; i++)
            {
                if(cruiseShip[i].equals("empty"))
                {
                    System.out.println("Cabin " + (i + 1) + " is " + cruiseShip[i]);
                }          
            }
            System.out.println();


        }

    /**
     *
     * @param cruiseShip
     * @param cabinNumber
     */
    public static void deleteCustomer(String cruiseShip[], int cabinNumber){

            Scanner in = new Scanner(System.in);
            //By taking in the user input for the cabin number it will then delete the customer by matching the input with the right index in the array
            System.out.println("Delete customer from a cabin.");
            System.out.print("Enter the cabin number (1 to 12): ");
            cabinNumber = in.nextInt();

            System.out.println("Customer has been succesfully deleted.");
            //same thing is done with the input - 1 to get the right index/
            System.out.println();
            cruiseShip[cabinNumber - 1] =  "empty";
            
        }

    /**
     *
     * @param cruiseShip
     */
    public static void findCabinFromName(String cruiseShip[]) {

            Scanner in = new Scanner(System.in);
            System.out.print("Enter customer name: ");
            String find = in.next();
            System.out.println();

            // boolean found = false;
    
            for (int i = 0; i < cruiseShip.length; i++) {
                if (find.equals(cruiseShip[i])) {
                    // found = true;
                    System.out.println(find + " is found in Cabin Number " + (i + 1));
                }
            }
            System.out.println();

    
        }

    /**
     *
     * @param cruiseShip
     */
    public static void storeData(String cruiseShip[]){

            //this will create the file data.txt in the same directory the prgroam file is stored.
            //it will then iterate through the array and write the data into the file on a new line.
            try 
            {
                FileWriter writer = new FileWriter("data.txt");
            
                for(int i=0; i< cruiseShip.length; i++)
                {
                    writer.write("Cabin " + (i + 1) + " is occupied by - " + cruiseShip[i] + "\n");       
                }
                writer.close();
            } 
            
            catch (IOException e) 
            {
                e.printStackTrace();
            }
            
            System.out.println();        
    
        }
        
    /**
     *
     * @param cruiseShip
     */
    public static void loadData(String cruiseShip[]){

            
            try 
            {
                FileReader reader = new FileReader("data.txt");
                
                System.out.println("Data read from the text file.");
                System.out.println();  
                      
                int data = 0;
                while(data != -1)
                {
                    
                    System.out.print((char)data);
                    data = reader.read();
                }
               
                reader.close();
            } 
            
            catch (IOException e) 
            {
                e.printStackTrace();
            }
            
            System.out.println();        
    
        }

    /**
     *
     * @param cruiseShip
     */
    public static void sortAlphabetically(String cruiseShip[]){

            //using the bubble sort algorithm each element is compared to the element after it and it is swapped if it is in the wrong order.
            String temp = null;

            for(int i = 0; i < cruiseShip.length; i++)
            { 
                for(int j = 1; j < cruiseShip.length - i; j++)
                {
                    if(cruiseShip[j - 1].compareToIgnoreCase(cruiseShip[j]) > 0)
                    {
                        temp = cruiseShip[j - 1];
                        cruiseShip[j - 1] = cruiseShip[j];
                        cruiseShip[j] = temp;
                    }

                }
            }

            System.out.println("After sorting");
            System.out.println();

            for (String cruiseShip1 : cruiseShip) 
            {
                if (!cruiseShip1.equals("empty")) 
                {
                    System.out.println(cruiseShip1);
                }
            }
                System.out.println();

    }
        
        
}
    

