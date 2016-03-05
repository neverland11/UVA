import java.util.Scanner;

/**
 * Created by Ge on 16/2/4.
 */
//UVA10305
public class Ordering {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            int task = s.nextInt();
            int edge = s.nextInt();
            if(task == 0 && edge == 0){
                System.exit(0);
            }
            s.nextLine();
            int[][] g = new int[task][task];
            for (int i = 0; i < edge; i++) {
                int head = s.nextInt() - 1;
                int tail = s.nextInt() - 1;
                g[head][tail] = 1;
            }
            int[] result = new int[task];
            int count = 0;
            int flag = 0;

            while(count < task) {
                int i = 0;
                for (i = 0; i < task; i++) { //i for the tail
                    flag = 0;
                    for (int j = 0; j < task; j++) { // j for the head
                        if (g[j][i] == 1) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        int fla = 0;
                        for (int h = 0; h < result.length; h++){
                            if(result[h] == i + 1){
                                fla = 1;
                                break;
                            }
                        }
                        if(fla == 0) {
                            result[count] = i + 1;
                            count++;
                        }
                        //set the tails to 0, met the pre-
                        for (int h = 0; h < task; h++) {
                            g[i][h] = 0;
                        }
                    }
                    if(count == task) {
                        break;
                    }
                }
                if(count == task){
                    break;
                }
            }

            //Print the output
            for(int i = 0; i < result.length; i++){
                if(i == result.length - 1){
                    System.out.printf("%d\n",result[i]);
                    break;
                }
                System.out.print(result[i] + " ");
            }
        }
    }
}
