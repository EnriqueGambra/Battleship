
import java.util.HashMap;


public class BattleShip {
    
    static int rows = 10;
    static int columns = 10;
    int[][] gameBoardCPU = new int[rows][columns];
    int[][] gameBoardUser = new int[rows][columns];
    static Ship[] cpuShips = new Ship[3];
    static Ship[] userShips = new Ship[3];
    
    public static void main(String[] args) {
        
        cpuCreateShips(cpuShips);
    }
    
    public static void cpuCreateShips(Ship[] ships){
        for(int i = 0; i < ships.length; i++){
            ships[i] = new Ship(rows, columns, "Ship #"+i);
            ships[i].createShip();
        }
    }
    
}
