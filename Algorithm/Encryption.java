/** ***************
  * @author MIR AYMAN ALI
  *      => Coder
  * @see <a href="https://www.hackerrank.com/challenges/encryption/">hackerrank - encryption</a>
  * @version  1.0
  * @since  2016
  * ***************/

import java.io.*;
import java.util.*;
import java.lang.*;

public class Encryption {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String user = sc.nextLine();

        char[] r_user = user.toCharArray();
        double len = (double) r_user.length;

        int down = (int) Math.floor(Math.sqrt(len));
        int up   = (int) Math.ceil(Math.sqrt(len));
        if(down*up< len) down = up;

        char[][] grid = new char[down][up];
        // pre defineing all the index in char array to '' <empty char>
        for(int i = 0; i < down;i++){
            for(int k = 0; k < up; k++){
                grid[i][k] = ' ';
            }
        }
        // filling in with all the char from the grid. In other way Encrypting
        for(int i = 0, j = 0; i < down;i++){
            for(int k = 0; k < up && j < len; k++, j++){
                grid[i][k] = r_user[j];
            }
        }
        // Printing the output
        for(int i = 0; i < up;i++){
            for(int k = 0; k < down; k++){
                if(grid[k][i]!=' ')
                    System.out.print(grid[k][i]);
            }
            System.out.print(" ");
        }

    }
}
