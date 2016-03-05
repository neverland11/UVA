import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ge on 16/1/28.
 */
public class Closest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = 1;
        while(s.hasNextInt()){
            int n = s.nextInt();
            if(n == 0){
                //System.out.println();
                System.exit(0);
            }
            int[]array = new int[n];
            s.nextLine();
            for(int i = 0; i < n; i++){
                array[i] = s.nextInt();
            }
            Arrays.sort(array); //sort the array

            int m = s.nextInt();
            System.out.printf("Case %d:\n", count);
            for(int i = 0; i < m; i++){
                int sum = array[0] + array[1];
                int total = s.nextInt();
                int min = Math.abs(sum - total);
                s.nextLine();
                int flag = 0;
                int result = sum;
                //double loop, find the min
                for(int j = 0; j < array.length - 1; j++) {
                    for(int h = j + 1; h < array.length; h++){
                        if(flag == 1){
                            break;
                        }
                        sum = array[j] + array[h];
                        if(Math.abs(sum - total) < min){
                            if(sum - total == 0){
                                System.out.printf("Closest sum to %d is %d.\n", total, sum);
                                flag = 1;
                                break;
                            } else {
                                min = Math.abs(sum - total);
                                result = sum;
                            }
                        }
                    }
                    if(flag == 1){
                        break;
                    }
                }
                if(flag != 1) {
                    System.out.printf("Closest sum to %d is %d.\n", total, result);
                }
            }
            count++;
        }
        System.exit(0);
    }
}
