import java.util.Scanner;
public class UI {
    private Board board;
    private Scanner scanner;
    UI(Scanner scanner, Board board){
        this.scanner = scanner;
        this.board=board;
    }
    public void Ask(){
        System.out.println("Welcome! to tic tac toe:");
        System.out.print("wnat to play some tic tac toe with friends?:");
        String input = scanner.nextLine();
        if(input.toLowerCase().equalsIgnoreCase("Yes")){
            start();
        }else{
            System.out.print("thanks kind sir, come back again");
        }
    }
    public void start(){
        System.out.println("players can only choose between: O or X");
        System.out.print("player one choose:");
        String pone = scanner.nextLine();
        String ptwo = whichPlayerChooseWhat(pone);
        System.out.println("Player two gets:"+ptwo);
        System.out.println(" ");
        System.out.println("LET'S START THE GAME!!!!!");
        while(true){
            System.out.print("Player one enter co-ordinates:");
            int CO_one1 = Integer.valueOf(scanner.nextLine());
            int CO_one2 = Integer.valueOf(scanner.nextLine());
            this.board.putCoinBoards(CO_one1,CO_one2,pone);
            this.board.printingBoard();
            if(hasWon(pone)){
                System.out.println("player one has won!!!");
                break;
            };
            System.out.print("Player two enter co-ordinates:");
            int CO_two1 = Integer.valueOf(scanner.nextLine());
            int CO_two2 = Integer.valueOf(scanner.nextLine());
            this.board.putCoinBoards(CO_two1,CO_two2,ptwo);
            this.board.printingBoard();
            if(hasWon(ptwo)){
                System.out.println("Player 2 has won");
                break;
            }
        }
    }
    public String whichPlayerChooseWhat(String pone){
        if(pone.equalsIgnoreCase("O")){
            return "x";
        }
        return "O";
    }
    public boolean hasWon(String player){
        if(this.board.checkWinCondition(player)){
            return true;
        }
        return false;
    }
}
