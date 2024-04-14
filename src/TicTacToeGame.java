import java.util.Scanner;
public class TicTacToeGame {


        public static void main(String[] args) {

            //Create a 3*3 board
            char[][] board=new char[3][3];

            //Initialise the board as empty
            for(int row=0; row< board.length; row++){
                for (int column=0 ;column<board[row].length ;column++){
                    board[row][column] =' ';
                }
            }

            char player= 'x';  //Initialise the player with x
            boolean gameOver=false;  //Initialise gameOver as false

            Scanner sc=new Scanner(System.in);

            while (!gameOver){
                printBoard(board);  //Display the board before player give input
                System.out.print("Player " +player+" enter:");
                int row= sc.nextInt();  //Taking the coordinate where the player want to put the input value
                int column=sc.nextInt();

                if(board[row][column]==' '){
                    //place the element
                    board[row][column]=player;
                    gameOver=haveWon(board,player);

                    if(gameOver){
                        System.out.println("Player "+player+" won");
                    }
                    else{
                        player= (player=='x') ? '0' : 'x'; //If the game is not over and the player has entered 'x' then it will be switched to 'o' for the next time
                    }
                }else{
                    System.out.println("Invalid move!!!Please try again");
                }
            }
            printBoard(board);
        }

        public static boolean haveWon(char[][] board,char player){
            //Check the rows
            for (int row= 0; row< board.length; row++) {
                if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                    return true;
                }
            }
            //Check for columns
            for (int column= 0; column < board[0].length; column++) {
                if (board[0][column] == player && board[1][column] == player && board[2][column] == player) {
                    return true;
                }
            }

            //For diagonal
            if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
                return true;
            }

            if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
                return true;
            }
            return false;
        }

        public static void printBoard(char[][] board){
            for(int row=0; row< board.length; row++){
                for (int column=0 ;column<board[row].length ;column++){
                    System.out.print( board[row][column] + " | ");
                }
                System.out.println();
            }
        }
    }



