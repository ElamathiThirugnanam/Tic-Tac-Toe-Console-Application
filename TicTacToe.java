import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("                TIC TAC TOE                ");
        //3*3 board for the game
        char[][] board=new char[3][3];
        for(char[] b:board)
        {
            Arrays.fill(b, ' ');
        }
        play(board);
    }
    public static void play(char[][] board)
    {
        //Asking the user to choose the symbol to play
        System.out.println("Choose your symbol: X/O");
        Scanner sc=new Scanner(System.in);
        char user=sc.next().charAt(0);
        //flag is to know who has the current turn, first user has the first chance
        boolean flag=true;
        //flag to see if game is over
        boolean game=false;
        //Iteration
        for(int i=0;i<9;i++)
        {
            if(flag)
            {
                System.out.println(user+"'s turn, "+"Choose the index from 1 to 9:");
                int index=sc.nextInt()-1;
                //Check if the index is already filled, if so repeat else fill it with user's symbol
                if(board[index/3][index%3]!=' ')
                {
                    System.out.println("This has been filled already, kindly choose another index");
                    printBoard(board);
                    i--;
                    continue;
                }
                else
                {
                    board[index/3][index%3]=user;
                    flag=!flag;
                }
            }
            else
            {
                System.out.println(user+"'s turn, "+"Choose the index from 1 to 9:");
                int index=sc.nextInt()-1;
                //Check if the index is already filled, if so repeat else fill it with user's symbol
                if(board[index/3][index%3]!=' ')
                {
                    System.out.println("This has been filled already, kindly choose another index");
                    printBoard(board);
                    i--;
                    continue;
                }
                else
                {
                    board[index/3][index%3]=user;
                    flag=!flag;
                }
            }
            //Printing the board
            printBoard(board);
            //Checking if a winning possibility is attained
            char res=checkForWin(board);
            if(res!='n')
            {
                if(res=='X')
                {
                    System.out.println("X WON!");
                    game=true;
                    break;
                }
                System.out.println("Y WON!");
                game=true;
                break;
            }
            //Changing the turn of user
            user=user=='X'?'O':'X';
        }
        if(game) System.out.println("Match Draw!");
        //To play again
        System.out.println("Do you want to play again? Yes/No");
        String next=sc.next();
        if(next.equalsIgnoreCase("yes"))
        {
            //Resetting the board for next game
            reset(board);
            //Calling the method to play again
            play(board);
        }
    }
    public static void reset(char[][] board)
    {
        for(char[] b:board)
        {
            Arrays.fill(b, ' ');
        }
    }
    public static char checkForWin(char[][] board)
    {
        //Method to check is any of the winning conditions is met.
        //Winning conditions: any one row or column or diagonal is of same character
        for(int i=0;i<3;i++)
        {
            if(board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2]) return board[0][0];
            if(board[0][i]!=' ' && board[0][i]==board[1][i] && board[1][i]==board[2][i]) return board[0][0];
        }
        if(board[0][0]!=' ' && board[0][0]==board[1][1] && board[0][0]==board[2][2]) return board[0][0];
        return board[2][0] != ' ' && board[2][0] == board[1][1] && board[1][1] == board[0][2]?board[0][2]:'n';
    }
    public static void printBoard(char[][] board)
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(j<2)
                {
                    System.out.print(board[i][j]+" | ");
                }
                else
                {
                    System.out.print(board[i][j]);
                }
            }
            System.out.println(" ");
            if(i<2)
            {
                System.out.println("------------");
            }
        }
    }
}