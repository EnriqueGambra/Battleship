import java.util.Scanner;

public class BattleShip {
    
    static int rows = 10;
    static int columns = 10;
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
        int shipsActiveCounter = cpuShips.length; //Gets how many ships are in the list
        
        while(shipsActiveCounter > 0){           //While there are ships still active, run the game logic
            System.out.println("Enter in a guess in the format #,#");
            String guess = myObj.nextLine();
            
            for(int i = 0; i < cpuShips.length; i++){   ///Checks to see if there are any hits or misses. Outputs to terminal
                String result = cpuShips[i].checkHit(guess);
                
                if(result.equals("Miss") && i != cpuShips.length - 1)
                {
                    continue;
                }
                else if(result.equals("Miss") && i == cpuShips.length -1){
                    System.out.println("Miss");
                }
                else{
                    System.out.println(result);
                    
                    if(result.endsWith("sunk!")){
                        shipsActiveCounter -= 1;
                    }
                    break;
                }
            }
        }
        
        System.out.println("All ships have been sunk! Ending the game.");
        
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
    
    public static void createUserShips(Ship[] ships){
        Scanner myObj = new Scanner(System.in);
        
        for(int i = 0; i < ships.length; i++){
            System.out.println("Enter in the " + (i+1) + " ship's name.");
            String name = myObj.nextLine();
            ships[i] = new Ship(rows, columns, name);
            ships[i].createUserShip();
        }
    }
    
}
