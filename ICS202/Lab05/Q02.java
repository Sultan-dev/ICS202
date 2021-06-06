import java.net.PortUnreachableException;

public class Q02 {

    public static void main(String[] args) {

        int num1 = 50, num2 = 5;

        System.out.printf("GCD of %d and %d is %d.", num1, num2, GCD(num1, num2));
    }

    public static int GCD(int num1, int num2){

        if(num2 == 0){
            return num1;
        }else{
            return GCD(num2, num1 % num2);
        }
    }
}
