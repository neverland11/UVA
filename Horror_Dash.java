import java.util.Scanner;

/**
 * Created by Ge on 16/1/14.
 */
public class Horror_Dash{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        s.nextLine();
        for(int j = 0; j < i; j++){
            int max = 0;
            String str = s.nextLine();
            String[]num = str.split(" ");
            int length = num.length;
            for(int h = 0; h < length; h++){
                int now = Integer.parseInt(num[h]);
                if(now > max){
                    max = now;
                }
            }
            System.out.printf("Case %d: %d\n", j+1, max);
        }
    }
}
