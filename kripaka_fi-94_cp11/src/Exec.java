import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Exec {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        String str;
        while(true){
            System.out.print(">> ");
            str = scanner.nextLine();
            if(Objects.equals(str, "EXIT")){
                break;
            }
            System.out.println(parser.parse(str));
            System.out.println(Arrays.deepToString(parser.getArgs()));
        }

        scanner.close();
    }
}
