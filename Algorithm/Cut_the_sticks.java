/** ***************
  * This is the solve of the problem Cut the sticks in sub-domain Implementation in domain Algorithm 
  * @author Mir Ayman Ali
  *     =>  Coder
  * @version 1.0
  * @since 2016
  * ***************/

import java.io.*;
import java.util.*;
import java.lang.*;

public class Cut_the_sticks {

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        int sticks = Integer.parseInt(sc.nextLine());
        int[] lengths = new int[sticks];

        for(int i = 0; i < sticks; i++) lengths[i] = Integer.parseInt(sc.next());

        System.out.println(lengths.length);

        int[] left = cut_stick(lengths,0, lengths.length);

        while(true){
            if(left[0] < 1) break;
            System.out.println(left[0]);
            left = cut_stick(lengths,  left[1], left[0]);
        }
    }
    /** ***************
      * @param  sticks  takes an array of integers. Here the lenghts of differnt sticks
      * @param  lim     takes an integer. Here the minimum of the previous length of sticks
      * @param  valid   takes an integer. Here takes how many stiks were left in the previous process
      * @return         returns the sticks left in index 0 and the minimum length of the stick
      * ***************/
    public static int[] cut_stick(int[] sticks,  int lim, int valid){
        int[] left = new int[2];
        int max = sticks[0];
        for(int t: sticks){
            if(t > max) max = t;
        }
        int min = max;
        for(int t: sticks){
            if(t > lim && t < min) min = t;
        }
        for(int t: sticks){
            if(t==min) left[0]++;
        }
        left[0] = valid - left[0]; 
        left[1] = min;
        return left;
    }
}
