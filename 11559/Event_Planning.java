import java.util.Scanner;

/**
 * Created by Ge on 16/1/15.
 */
public class Event_Planning {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String str = s.nextLine();
            String[] num = str.split(" ");
            int peo = Integer.parseInt(num[0]); //number of people
            int bud = Integer.parseInt(num[1]); //budget
            int hot = Integer.parseInt(num[2]); //number of hotels
            int week = Integer.parseInt(num[3]); //number of weeks
            int min = bud; //result
            int flag = 0; //no possible answers

            for (int j = 0; j < hot; j++) {
                int each = s.nextInt();
                s.nextLine();
                str = s.nextLine();
                num = str.split(" ");
                int length = num.length;
                for (int h = 0; h < length; h++) {
                    int now = Integer.parseInt(num[h]);
                    if (now >= peo) {
                        if (peo * each <= bud && peo * each < min) {
                            min = peo * each;
                            flag = 1;
                        }
                    }
                }
            }

            if (flag == 0) {
                System.out.println("stay home");
            } else {
                System.out.println(min);
            }

        }
    }
}
