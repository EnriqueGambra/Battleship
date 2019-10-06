import java.util.Scanner;

public class BattleShip {
    
    static int rows = 10;
    static int columns = 10;
    int[][] gameBoardCPU = new int[rows][columns];
    int[][] gameBoardUser = new int[rows][columns];
    static Ship[] cpuShips = new Ship[3];
    static Ship[] userShips = new Ship[3];
    
    public static void main(String[] args) {
        
        cpuCreateShips(cpuShips);
        mainGame();
    }
    
    public static void mainGame(){
        
        Scanner myObj = new Scanner(System.in);
        int shipsActiveCounter = cpuShips.length;
        
        while(shipsActiveCounter > 0){
            System.out.println("Enter in a guess in the format #,#");
            String guess = myObj.nextLine();
            
            for(int i = 0; i < cpuShips.length; i++){
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
    
    public static void cpuCreateShips(Ship[] ships){
        for(int i = 0; i < ships.length; i++){
            int name = i +1;
            ships[i] = new Ship(rows, columns, "Ship #" + name);
            ships[i].createShip();
            ships[i].showCoordinates();
        }
    }
    
}
