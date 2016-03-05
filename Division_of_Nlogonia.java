import java.util.Scanner;

/**
 * Created by Ge on 16/1/14.
 */
public class Division_of_Nlogonia {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int i = s.nextInt();
            if(i == 0){
                System.exit(0);
            }
            int xaxis = s.nextInt();
            int yaxis = s.nextInt();
            s.nextLine();
            for(int j = 0; j < i; j++){ //i = how many cases
                String str = s.nextLine();
                String[]num = str.split(" ");
                int xnow = Integer.parseInt(num[0]);
                int ynow = Integer.parseInt(num[1]);
                if(xnow> xaxis && ynow > yaxis){
                    System.out.println("NE");
                } else if(xnow < xaxis && ynow > yaxis){
                    System.out.println("NO");
                } else if(xnow > xaxis && ynow < yaxis){
                    System.out.println("SE");
                } else if(xnow < xaxis && ynow < yaxis){
                    System.out.println("SO");
                } else if(xnow == xaxis || ynow == yaxis){
                    System.out.println("divisa");
                }
            }
        }
    }
}
