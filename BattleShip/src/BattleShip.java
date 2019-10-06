
import java.util.HashMap;


public class BattleShip {
    static int rows = 10;
    static int columns = 10;
    int[][] gameBoard = new int[rows][columns];
    HashMap<Character, Integer> columnMap = new HashMap<>();
    static Ship[] ships = new Ship[3];
    
    public static void main(String[] args) {
        cpuCreateShips(ships);
        
    }
    
    public static void cpuCreateShips(Ship[] ships){
        for(int i = 0; i < ships.length; i++){
            ships[i] = new Ship(rows, columns);
            ships[i].createShip();
        }
    }
    
}
