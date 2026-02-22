import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.print("enter the level type(3x3,4x4):");
//        int user_input = scanner.nextInt();
        Board board = new Board(3,3);
        board.initializingTheArray(3,3);
        UI ui = new UI(scanner,board);
        ui.Ask();

    }
}
