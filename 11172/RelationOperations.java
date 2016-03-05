/**
 * Created by Ge on 15/10/21.
 */
import java.util.Scanner;
public class main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t ; i++) {
            int a = s.nextInt();
            int b = s.nextInt();

            if (a < b) {
                System.out.println("<");
            } else if (a > b) {
                System.out.println(">");
            } else {
                System.out.println("=");
            }
        }
    }
}
