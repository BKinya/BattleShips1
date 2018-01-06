import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import  java.util.Scanner;
public class BattleShips {

    static int playerShips=5;
    static int compShips=5;
    static int a;
    static int b;
    static  Scanner sc;
    static Random rand;
    static String msg, msg1, msg2,msg3= null;
    static String[][] ocean = new String[10][10];

    public static void main(String args[]) {
        int i=0;
        System.out.println("**** Welcome to battleShips ****\n\n Right now the see is empty\n");
        printOcean(ocean);

        playerShip(i);
        computerShips(i);
        letPlayGame();
        System.out.println("players ships "  +playerShips);
        System.out.println("computer ships " +compShips);


    }

    public static void printOcean(String matrix[][]) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.print(row + "|");
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(matrix[row][column]);
                }

            }
            System.out.println("|" + row);
        }

    }

    public static int playerShip(int deployedShips) {
         sc = new Scanner(System.in);
        System.out.println("Enter x cordinate");

        a = Integer.parseInt(sc.next());
        System.out.println("Enter y cordinate");
        b = Integer.parseInt(sc.next());

        if (a>=10 || b>=10 ){
            System.out.println("out of bounds! Bad luck ! try again");

            playerShip(deployedShips);
            }else {
                if (ocean[a][b] !=null){
                    System.out.println("Bad luck! Already occupied Try again");

                    playerShip(deployedShips);
                }else{
                   ocean[a][b] =" 1";
                   if (ocean[a][b]!=null){
                       ocean[a][b]= " @";
                   }

                }

            }
           if(deployedShips == 4){
                //System.out.println("All ships deployed");
                printOcean(ocean);
                return 5;
           }else {
               System.out.println("deploying");
               return playerShip(++deployedShips);
           }

    }

    public static int computerShips(int deployed){
         rand = new Random();
        int x= rand.nextInt(10);
        int y= rand.nextInt(10);

        if (ocean[x][y]!=null){
            computerShips(deployed);

        }else {
            ocean[x][y]= " 2";
            if (ocean[x][y]!=null){

                ocean[x][y]="  ";
                System.out.println("Ship deployed");
            }
        }

        if (deployed==4){
            System.out.println("All ships are deployed");
            printOcean(ocean);
            return 4;
        }else {

            return computerShips(++deployed);
        }


    }

    public static void playersTurn() {
        msg="Sorry you missed :(";
        msg1="Oh no!!! you sunk your own ship";
        msg2="Boom!!!You sunk computers ship";

        System.out.println("Your(player's)Turn ");
        sc = new Scanner(System.in);
        System.out.println("Enter x cordinate");
        a = sc.nextInt();
        System.out.println("Enter y cordinate");
        b = sc.nextInt();
        evaluate(a,b);
    }

    public static void computersTurn(){
        msg="computer missed";
        msg1="whoops!!! Computer sunk one of your ships";
        msg2="Compputer sunk one of its own ships";
        System.out.println("Computers Turn");
        rand=new Random();
        int d=rand.nextInt(10);
        int e=rand.nextInt(10);

        evaluate(d,e);

            }
    public static int evaluate(int p,int q){
        int j=0;

        if (p >= 10 || q >= 10) {
            System.out.println("Cordinates out of bound! Try again");
            playersTurn();
        } else {
            if (ocean[p][q] == " _" || ocean[p][q]==" !" || ocean[p][q]==" x") {
                System.out.println("You have already guessed that ..Try another cordinate");

                playersTurn();
            } else {
                if (ocean[p][q]==null){
                    System.out.println(msg);
                    ocean[p][q]=" _";
                }else if (ocean[p][q]==" @"){
                    System.out.println(msg1);
                    ocean[p][q]=" x";
                    --playerShips;
                    //System.out.println("players ships "  +playerShips);
                    return playerShips;

                }else if (ocean[p][q]=="  "){
                    System.out.println(msg2);
                    ocean[p][q]=" !";
                    --compShips;
                    //System.out.println("computer ships " +compShips);
                    return compShips;
                }

            }

        }

        return 0;
    }

    public static void letPlayGame(){

        playersTurn();
        try{
            Thread.sleep(2000);
        }catch (InterruptedException es){
            es.getMessage();
        }
        computersTurn();
        printOcean(ocean);
        if (playerShips ==0 || compShips==0){
            if (playerShips==0){
                System.out.println("YOU LOST!!!GAME OVER!!!!");
            }else if (compShips==0){
                System.out.println("HORRAY!!! YOU WIN THE BATTLE :)");
            }

        }else {
            letPlayGame();


        }



    }


}





