import java.util.Scanner;

/**
 * Created by Ge on 16/1/21.
 */
public class Minesweeper {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = 0;
        while (s.hasNext()) {
            count++;
            int row = s.nextInt();
            int col = s.nextInt();
            s.nextLine();
            if (row != 0 || col != 0) {
                int[][] grid = new int[row][col];
                int[][] num = new int[row][col];
                if(col != 0) {
                    for (int i = 0; i < row; i++) {
                        String str = s.nextLine();
                        for (int j = 0; j < col; j++) {
                            if (str.charAt(j) == '*') {
                                grid[i][j] = 1;
                                num[i][j] = 9;
                            } else {
                                grid[i][j] = 0;
                            }
                        }
                    }
                }
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[i].length; j++) {
                        if (grid[i][j] == 1) {
                            int istart = i - 1;
                            int jstart = j - 1;
                            int ifin = i + 1;
                            int jfin = j + 1;
                            if (i == 0) {
                                istart = 0;
                            }
                            if (j == 0) {
                                jstart = 0;
                            }
                            if (i == grid.length - 1) {
                                ifin = i;
                            }
                            if (j == (grid[i].length - 1)) {
                                jfin = j;
                            }
                            for (int r = istart; r <= ifin; r++) {
                                for (int colnum = jstart; colnum <= jfin; colnum++) {
                                    if (num[r][colnum] != 9) {
                                        num[r][colnum]++;
                                    }
                                }
                            }
                        }
                    }
                }

                System.out.printf("Field #%d:\n", count);
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < num[i].length; j++) {
                        if (num[i][j] == 9) {
                            System.out.printf("%s", "*");
                        } else {
                            System.out.printf("%d", num[i][j]);
                        }
                    }
                    System.out.println();
                }
                System.out.println();
            } else {
                System.exit(0);
            }
        }
    }
}
