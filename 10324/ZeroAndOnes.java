import java.util.Scanner;

/**
 * Created by Ge on 15/10/21.
 *
 * Question url:https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1265
 */
public class ZeroAndOne {
    public static void main (String[]args){
        int count;
        int num = 0;

        Scanner s = new Scanner(System.in);
        while(s.hasNextLine()){
            char[]input = s.nextLine().toCharArray();
            String use = new String(input);
            if(!use.contains("1") && !(use.contains("0"))){
                continue;
            }
            num = num + 1;
            System.out.printf("Case %d:\n", num);
            count = s.nextInt();
            int i = 0;
            while(i < count){
                int lower = s.nextInt();
                int upper = s.nextInt();
                if(lower > upper){
                    int temp = lower;
                    lower = upper;
                    upper = temp;
                }
                int flag = 0; //same
                for(int j = lower; j < upper; j++){
                    if(input[j] != input[j+1]){
                        flag = 1; //different
                        break;
                    }
                }
                if(flag == 0){
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
                i++;
            }
            s.nextLine();
        }
    }
}
