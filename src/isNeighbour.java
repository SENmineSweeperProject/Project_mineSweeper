import java.util.ArrayList;
import java.util.HashMap;

public class isNeighbour {

    public static ArrayList<cell> isNeighbourOf(int row, int col,HashMap map){

        ArrayList<cell> neighbors = new ArrayList<>();

        for (int i = Math.max(0, row-1); //Math.max used to ensure index doesn't go below 0
             i <= Math.min(row+1, GUI.gridRows-1); //min used to make sure index is doesn't go further than the latest grid row,
             i++) {                              //grid.length gives us the maximum row index

            for (int j = Math.max(0, col-1);    //Math.max used to ensure index doesn't go below 0
                 j <= Math.min(col+1, GUI.gridCols-1);    //Same as before min used to keep in bounds,
                 j++) {                                     //Here grid[0].length-1 gives us the number of columns in each row

                if (map.get(GUI.posOfCell(i,j)) != map.get(GUI.posOfCell(row,col))) { //Check and don't add the clicked button
                    neighbors.add((cell) map.get(GUI.posOfCell(i,j)));

                }
            }
        }
        GUI.currentMap.get(GUI.posOfCell(row, col)).setNeighbors(neighbors);
        return neighbors;
    }

}
