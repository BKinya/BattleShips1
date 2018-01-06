import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class wwwwww
{
    static final String[] sc = {"WVERTICALL"
            , "ROOAFFLSAB"
            , "ACRILIATOA"
            , "NDODKONWDC"
            , "DRKESOODDK"
            , "OEEPZEGLIW"
            , "MSIIHOAERA"
            , "ALRKRRIRER"
            , "KODIDEDRCD"
            , "HELWSLEUTH"};
    public static void main (String[] args) throws java.lang.Exception
    {
        try{
            int row = 10;
            int col = 10;
            char[][] puzzle = new char[row+2][col+2];
            String getChar = "";
            for (int i=0; i<row+2; i++){

                if (i>0 && i<row+1) getChar = sc[i-1];
                for(int j = 0;j<col+2; j++){
                    if (i % (row + 1) == 0 || j % (col + 1) == 0) {
                        puzzle[i][j] = '#';
                    } else {
                        puzzle[i][j] = getChar.charAt(j-1);
                    }
                }
            }
            for (int i=0; i<row+2; i++){
                for (int j=0; j<col+2; j++){
                    System.out.printf("%c ", puzzle[i][j]);
                }
                System.out.println();
            }
			/* PRE INCREMENTING ROW/COL */
            row += 2;
            col += 2;
            char[][] puzzle2 = new char[row][col];
            for (int i=0; i<row; i++){

                if (i>0 && i<row-1) getChar = sc[i-1];
                for(int j = 0;j<col; j++){
                    if (i % (row - 1) == 0 || j % (col - 1) == 0) {
                        puzzle2[i][j] = '#';
                    } else {
                        puzzle2[i][j] = getChar.charAt(j-1);
                    }
                }
            }
            for (int i=0; i<row; i++){
                for (int j=0; j<col; j++){
                    System.out.printf("%c ", puzzle2[i][j]);
                }
                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
