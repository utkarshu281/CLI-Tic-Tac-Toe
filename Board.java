
import java.util.Arrays;
public class Board {
    private String[][] array;
    private int rememberRow;
    private int rememberColumn;
    Board(int row, int column){
        array = new String[row][column];
        rememberRow=row;
        rememberColumn=column;
        //these two variables make the Board remember the values of rows and columns
    }
    public void initializingTheArray(int row, int column){
        for(int i=0; i<row; i++){
            for(int j=0;j<column;j++){
                array[i][j] = "-";
            }
        }
    }
    public void putCoinBoards(int c1, int c2, String Player){
        if(array[c1][c2].equalsIgnoreCase("-")){
            array[c1][c2]=Player;
        }else{
            System.out.println("the symbol is already thier");
        }
    }
    public int getRows(){
        return rememberRow;
    }
    public int getColumn(){
        return rememberColumn;
    }
    public void printingBoard(){
        for(int i=0;i<getRows();i++){
            for(int j=0;j<getColumn();j++){
                System.out.print(array[i][j]+" | ");
            }
            System.out.println();
        }
    }
    public boolean checkWinCondition(String player){
        if(winforRows(player))return true;
        if(winForAntiDiagonal(player))return true;
        if(winforDiagonal(player))return true;
        if(winforColumn(player))return true;
        return false;
    }
    public boolean winforRows(String player){
        for(int i=0;i<getRows();i++){
            boolean win=true;
            for(int j=0;j<getColumn();j++){
                if(!(array[i][j].equals(player))){
                    win = false;
                    break;
                }
            }
            if(win) return true;
        }
        return false;
    }
    public boolean winforColumn(String player) {
        for (int i = 0; i < getColumn(); i++) {
            boolean win = true; // reset for each column

            for (int j = 0; j < getRows(); j++) {
                if (!array[j][i].equals(player)) {
                    win = false;
                    break;
                }
            }

            if (win) {
                return true;
            }
        }
        return false;
    }
    public boolean winforDiagonal(String player){
        boolean win=true;
        for(int i=0;i<getRows();i++){
            if(!array[i][i].equals(player)){
                win=false;
                break;
            }
        }
        return win;
    }
    public boolean winForAntiDiagonal(String player) {
        boolean win = true;

        for (int i = 0; i < getRows(); i++) {
            if (!array[i][getColumn() - i - 1].equals(player)) {
                win = false;
                break;
            }
        }
        return win;
    }

}
