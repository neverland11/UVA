import java.util.Scanner;

/**
 * Created by Ge on 16/2/25.
 */
public class NonStop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int kkkk = 1;
        while(flag) {
            int count = scanner.nextInt();
            if(count == 0){
                System.exit(0);
            }
            int[][] dist = new int[count + 1][count + 1]; //the weight map
            int[][] path = new int[count + 1][count + 1]; // the path

            for (int i = 1; i <= count; i++) {
                for(int j = 0; j <= count; j++){
                    dist[i][j] = Integer.MAX_VALUE;
                }
                int number = scanner.nextInt();
                if (number == 0) {
                    continue;
                }
                for (int j = 0; j < number; j++) {
                    int end = scanner.nextInt();
                    int weight = scanner.nextInt();
                    dist[i][end] = weight;
                }
                for (int j = 1; j <= count; j++){
                    path[i][j] = j;
                }
            }

            for(int k = 1; k <= count; k++){
                for(int i = 1; i <= count; i++){
                    for(int j = 1; j <= count; j++){
                        if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                            if (dist[i][k] + dist[k][j] < dist[i][j]) {
                                dist[i][j] = dist[i][k] + dist[k][j];
                                path[i][j] = path[i][k];
                            }
                        }
                    }
                }
            }

            int start = scanner.nextInt();
            int finpoint = scanner.nextInt();
            int seconds = dist[start][finpoint];
            System.out.printf("Case %d: Path =",kkkk);
            System.out.printf(" %d", start);

            while (path[start][finpoint] != finpoint){
                System.out.printf(" %d", path[start][finpoint]);
                start = path[start][finpoint];
            }
            System.out.printf(" %d; %d second delay\n", finpoint, seconds);

            kkkk++;
        }
    }
}
