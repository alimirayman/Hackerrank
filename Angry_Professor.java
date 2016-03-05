/** ***************
  * @author MIR AYMAN ALI
  *      => Coder
  * @version  1.0
  * @since  2016
  * ***************/
import java.io.*;
import java.util.*;

public class Angry_Professor {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        for(int t = 0; t < test; t++){
            int students = Integer.parseInt(sc.next());
            int lim = Integer.parseInt(sc.next());
            int onTime = 0;
            for(int s = 0; s < students; s++){
                if( Integer.parseInt(sc.next()) >= 0) onTime++;
            }
            if(onTime>=lim) System.out.println("NO");
            else System.out.println("YES");
                
        }
    }
}
