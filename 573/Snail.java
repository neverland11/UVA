import java.awt.*;
import java.util.Scanner;

/**
 * Created by Ge on 16/1/14.
 */
public class Snail {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String str = s.nextLine();
            String[]num = str.split(" ");
            int h = Integer.parseInt(num[0]);
            if(h == 0){
                System.exit(0);
            }
            int up = Integer.parseInt(num[1]);
            int down = Integer.parseInt(num[2]);
            double fra = Integer.parseInt(num[3]);

            int day = 1;
            double temp = up - down; // the length of first day
            double pre = up;
            fra = up * fra * 0.01;

            while(h > 0){
                if(up > h){
                    System.out.printf("success on day %d\n", day);
                    break;
                } else if (up < down){
                    System.out.printf("failure on day %d\n", day);
                    break;
                }

                day++;
                pre = pre - fra;
                if(pre < 0){
                    pre = 0;
                }
                temp = temp + pre;
                if(temp > h){
                    System.out.printf("success on day %d\n", day);
                    break;
                }

                temp = temp - down;

                if(temp < 0){
                    System.out.printf("failure on day %d\n", day);
                    break;
                }
            }
        }
    }
}
