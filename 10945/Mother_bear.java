import java.util.Scanner;

/**
 * Created by Ge on 16/1/21.
 */
public class Mother_bear {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String str = s.nextLine();
            if(str.equals("DONE")){
                System.exit(0);
            }
            str = str.replace(" ", "");
            str = str.replace("!", "");
            str = str.replace(",", "");
            str = str.replace(".", "");
            str = str.replace("?", "");
            str = str.toLowerCase();
            int length = str.length();
            int i = 0;
            int flag = 0;
            while(i < length){
                if(str.charAt(i) != str.charAt(length - 1)){
                    System.out.println("Uh oh..");
                    flag = 1;
                    break;
                } else {
                    i++;
                    length--;
                }
            }
            if(flag == 0){
                System.out.println("You won't be eaten!");
            }
        }
    }
}
