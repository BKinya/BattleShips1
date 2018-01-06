import java.util.Random;
import java.util.Scanner;
public class RecursionIcrement {
    public static void main(String args []){
        //int num1=numRecursion(0);
        //System.out.println(num1);
       //int name = 0;
       //int x= name1(name);
       //System.out.println(x+ "wwwww");

        randomNumbers();
    }
    public static void randomNumbers(){
        Random rand = new Random();
        for (int i=0;i<5;i++){

            int y= rand.nextInt(9);
            int x= rand.nextInt(9);
            System.out.println(y);
            System.out.println(x);
        }




    }
    public static int numRecursion(int num){
        System.out.println("My name is Beatrice");
        if(num >=5){
            System.out.println("frtr");
            return num;
        }else{
            System.out.println("drdtsd");
            return numRecursion(++num);
        }

    }

    public static int name1(int i){
        int value=0;
        String name = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        name = sc.next();

        if(i==5){
            return 0;
        }else {
            return name1(++i);
        }

    }
}
