import java.util.Scanner;

public class BattleShip {
    
    static int rows = 10;
    static int columns = 10;
    int[][] gameBoardCPU = new int[rows][columns];
    int[][] gameBoardUser = new int[rows][columns];
    static Ship[] cpuShips = new Ship[3];
    static Ship[] userShips = new Ship[3];
    
    public static void main(String[] args) {
        
        Scanner myObj = new Scanner(System.in);
        cpuCreateShips(cpuShips);
        
        while(cpuShips.length > 0){
            System.out.println("Enter in a guess in the format #,#");
            String guess = myObj.nextLine();
            
            for(int i = 0; i < cpuShips.length; i++){
                String result = cpuShips[i].checkHit(guess);
                
                if(result.equals("Miss"))
                {
                    continue;
                }
                else{
                    System.out.println(result);
                    break;
                }
                
            }
        }
    }
    
    public static void cpuCreateShips(Ship[] ships){
        for(int i = 0; i < ships.length; i++){
            ships[i] = new Ship(rows, columns, "Ship #"+i);
            ships[i].createShip();
            ships[i].showCoordinates();
        }
    }
    
}
