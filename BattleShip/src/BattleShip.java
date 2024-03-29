import java.util.Scanner;
import java.util.ArrayList;

public class BattleShip {
    
    static int rows = 10;
    static int columns = 10;
    static ArrayList<String> cpuGuesses = new ArrayList<>();
    static Ship[] cpuShips = new Ship[3];
    static Ship[] userShips = new Ship[3];
    
    public static void main(String[] args) {
        createUserShips(userShips);
        cpuCreateShips(cpuShips);
        mainGame();
    }
    
    //Main area of where the game is created
    public static void mainGame(){
        Scanner myObj = new Scanner(System.in);
        int shipsCPUActive = cpuShips.length; //Gets how many ships are in the list
        int shipsUserActive = userShips.length;
        int turn = 1; //Determines whose turn it is. 1 for user and -1 for CPU
        
        while(shipsCPUActive > 0 & shipsUserActive > 0){   //While there are ships still active, run the game logic
            if(turn == 1){ //Users turn
                shipsCPUActive = userTurn(shipsCPUActive); //Users turn method
                turn *= -1; //Changes turn to CPU
            }
            else if(turn == -1){ //CPU's turn
                shipsUserActive = CPUTurn(shipsUserActive);
                turn *= -1;
            }
        }
        
        if(shipsCPUActive > 0){
            System.out.println("All user ships have been sunk! You lose!"); 
        }
        else if(shipsUserActive > 0){
            System.out.println("All CPU ships have been sunk! You Win!");
        }
    }
    
    //Method that creates guess. If guess hasn't been used before, CPU will return
    //the guess, otherwise it will continue to make new guesses
    public static String CPUGuess(){
        boolean guessedAlready = true;
        String guess = "";
        while(true){
            int x = (int)(Math.random() * (((rows-1) - 0) + 1) + 0);  //Randomly generates the x coordinate value
            int y = (int)(Math.random() * (((rows-1) - 0) + 1) + 0);  //Randomly generates the y coordinate value
            guess = x + "," + y;
            
            if(cpuGuesses.isEmpty()){
                cpuGuesses.add(guess);
            }
            
            for(int i = 0; i < cpuGuesses.size(); i++){
                if(cpuGuesses.get(i).equals(guess)){
                    break;
                }
                else if(i == cpuGuesses.size() - 1){
                    guessedAlready = false;
                }
            }
            if(guessedAlready == false){
                cpuGuesses.add(guess);
                break;
            }
        }
        
        return guess;
    }
    
    public static int CPUTurn(int shipsUserActive){
        System.out.println("CPU's turn!!");
        
        String guess = CPUGuess(); 
        
        System.out.println("The CPU guesses " + guess);

        for(int i = 0; i < userShips.length; i++){   ///Checks to see if there are any hits or misses. Outputs to terminal
            String result = userShips[i].checkHit(guess);

            if(result.equals("Miss") && i != userShips.length - 1) //If we aren't at the last ship in the 
            {
                continue;
            }
            else if(result.equals("Miss") && i == userShips.length -1){
                System.out.println("CPU misses");
            }
            else{
                System.out.println(result);

                if(result.endsWith("sunk!")){
                    shipsUserActive -= 1;
                }
                break;
            }
        }
        System.out.println("********************************");
        
        return shipsUserActive;
    }
    
    public static int userTurn(int shipsCPUActive){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Users turn! Enter in a guess in the format #,#");
        String guess = myObj.nextLine();
        
        for(int i = 0; i < cpuShips.length; i++){   ///Checks to see if there are any hits or misses. Outputs to terminal
            String result = cpuShips[i].checkHit(guess);

            if(result.equals("Miss") && i != cpuShips.length - 1) //If result is miss and we still haven't gone through the entire loop, just continue
            {
                continue;
            }
            else if(result.equals("Miss") && i == cpuShips.length -1){ //If we have gone through the entire loop, output a miss
                System.out.println("User misses!");
            }
            else{
                System.out.println(result);

                if(result.endsWith("sunk!")){  //If a ship is sunk, output to the terminal, ship is sunk
                    shipsCPUActive -= 1;        //Decrement ship counter
                }
                break;
            }
        }
        System.out.println("********************************");
        return shipsCPUActive;
    }
    
    //Creates CPU ships
    public static void cpuCreateShips(Ship[] ships){
        for(int i = 0; i < ships.length; i++){
            int name = i +1;
            ships[i] = new Ship(rows, columns, "Ship #" + name);
            ships[i].createCPUShip();
            //ships[i].showCoordinates(); -- Testing line. Shows the ship's coordinates for tests
        }
    }
    
    //Creates the user ships
    public static void createUserShips(Ship[] ships){
        Scanner myObj = new Scanner(System.in);
        
        for(int i = 0; i < ships.length; i++){
            System.out.println("Enter in the " + (i+1) + "'s ship name.");
            String name = myObj.nextLine();
            ships[i] = new Ship(rows, columns, name);
            ships[i].createUserShip();
        }
    }
    
}
