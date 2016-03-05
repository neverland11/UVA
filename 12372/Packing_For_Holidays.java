import java.util.Scanner;

/**
 * Created by Ge on 16/1/14.
 */
public class Packing_For_Holidays {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        s.nextLine();
        for(int j = 0; j < i; j++){
            int flag = 0;
            String str = s.nextLine();
            String[]num = str.split(" ");
            int length = num.length;
            for(int h = 0; h < length; h++){
                int now = Integer.parseInt(num[h]);
                if(now > 20){
                    System.out.printf("Case %d: bad\n", j+1);
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) {
                System.out.printf("Case %d: good\n", j + 1);
            }
        }
    }
}
