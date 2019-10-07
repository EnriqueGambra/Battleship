import java.util.Scanner;


public class Ship {
    
    private String name;
    private String[] coordinates = new String[3];
    private int rows, columns;
    
    //Constructor that initializes the Ship class
    public Ship(int rows, int columns, String name){
        this.rows = rows;
        this.columns = columns;
        this.name = name;
    }
    
    //Creates a ship
    public void createCPUShip(){
        int x = 0;
        int y = 0;
        boolean constantX = false;
        boolean constantY = false;
        // Chooses if the x coordinate or the y coordinate is consistent
        int xOrY = (int)(Math.random() * ((2 - 1)+1) + 1);
        //Generates a constant coordinate for either the x or y value
        int constantCoordinate = (int)(Math.random() * (((rows-1) - 0)+ 1)+ 0);
        
        //Sets the value of constant coordinate to the x or y value
        if(xOrY == 1){
            x = constantCoordinate;
            constantX = true;
        }
        else{
            y = constantCoordinate;
            constantY = true;
        }
        
        //For loop that continues to create coordinates until there are 3 seperate coordinates
        for(int i = 0; i < coordinates.length; i++){
            if(constantX){
                if(i == 0){
                    y = createCoordinate(-1);
                    coordinates[i] = x + "," + y;
                }
                else{
                    y = createCoordinate(Character.getNumericValue(coordinates[i-1].charAt(2)));
                    coordinates[i] = x + "," + y;
                }
            }
            else{
                if(i == 0){
                    x = createCoordinate(-1);
                    coordinates[i] = x + "," + y;
                }
                else{
                    x = createCoordinate(Character.getNumericValue(coordinates[i-1].charAt(0)));
                    coordinates[i] = x + "," + y;
                }
            }
        }
    }
    
    //Method that creates user's ship. Asks for coordinates they want.
    public void createUserShip(){
        Scanner myObj = new Scanner(System.in);
        for(int i = 0; i < coordinates.length; i++){
            System.out.println("Enter in the " + (i+1) + " coordinate in the form #,#");
            String coordinate = myObj.nextLine();
            boolean isValid = checkValidityCoordinates(coordinate);
            
            if(isValid == true)
            {
                coordinates[i] = coordinate;
            }
        }
    }
    
    //Method that checks the validity of coordinates. If valid, will return true. Otherwise program will shut down
    public boolean checkValidityCoordinates(String coordinate){
            try{
                boolean xIsLetter = Character.isLetter(coordinate.charAt(0));
                boolean yIsLetter = Character.isLetter(coordinate.charAt(2));
                
                if(xIsLetter == true || yIsLetter == true){
                    System.out.println("One of the characters you entered is a letter! Program shutting down!");
                    System.exit(0);
                }
                
                if(coordinate.length() > 3){
                    System.out.println("You didn't enter in a number from 0-9. Program shutting down!");
                    System.exit(0);
                }
            }
            catch(Exception e){
                System.out.println("You didn't enter in a number! Program shutting down!");
                System.exit(0);
            }
            
            return true;
    }
    
    //Randomly generates a coordinate value. If coordinate value already
    //in place, will add one more to the x or y value.
    public int createCoordinate(int coordinate)
    {
        int value;
        if(coordinate == -1)
        {
            value = (int)(Math.random() * (((rows-3) - 0) + 1) + 0);
        }
        else{
            value = coordinate + 1;
        }
        return value;
    }
    
    // Method that checks to see if a ship was hit. 
    public String checkHit(String guess)
    {
        for(int i = 0; i < coordinates.length; i++)
        {
            if(guess.equals(coordinates[i]))
            {
                coordinates[i] = null;
                boolean shipSunk = checkShipSunk();
                
                if(shipSunk){
                    return this.name + " has been sunk!";
                }
                
                return "Hit";
            }
        }
        return "Miss";
    }
    
    //Checks to see if a ship has been sunk
    public boolean checkShipSunk(){
        int partsSunk = 0;
        for(int i = 0; i < coordinates.length; i++)
        {
            if(coordinates[i] == null){
                partsSunk += 1;
            }
        }
        
        if(partsSunk == 3)
        {
            return true;
        }
        
        return false;
    }
    
    //Method for testing. Shows coordinates of a ship.
    public void showCoordinates(){
        for(int i = 0; i < coordinates.length; i++){
            System.out.println(coordinates[i]);
        }
    }
}
