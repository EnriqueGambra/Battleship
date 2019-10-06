
import java.util.HashMap;


public class BattleShip {

    int[][] gameBoard = new int[7][7];
    HashMap<Character, Integer> columnMap = new HashMap<>();
    static Ship[] ships = new Ship[3];
    
    public static void main(String[] args) {
        createShips(ships);
        
    }
    
    public static void createShips(Ship[] ships){
        for(int i = 0; i < ships.length; i++){
            ships[i] = new Ship();
            ships[i].createShip();
        }
    }
    
}
