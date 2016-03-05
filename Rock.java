import java.util.Scanner;

/**
 * Created by Ge on 16/1/21.
 */
public class Rock {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int sum = s.nextInt();
        s.nextLine();
        for(int i = 0; i < sum; i++){
            String str = s.nextLine();
            String[] num = str.split(" ");
            int row = Integer.parseInt(num[0]);
            int col = Integer.parseInt(num[1]);
            int day = Integer.parseInt(num[2]);
            int[][]grid = new int[row][col];
            for(int j = 0; j < row; j++) { //build the grid
                str = s.nextLine();
                for (int c = 0; c < col; c++) {
                    if (str.charAt(c) == 'R') {
                        grid[j][c] = 0; // 0 for rock
                    } else if (str.charAt(c) == 'S') {
                        grid[j][c] = 1; //1 for S
                    } else {
                        grid[j][c] = 2; //2 for Paper
                    }
                }
            }
        }
    }
}
