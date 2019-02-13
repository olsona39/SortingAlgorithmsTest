import java.util.*;

public class practice{
    public static void main(String[] args){
        fib(100);
    }
    public static void fib(int count){
        ArrayList list = new ArrayList();
        float num1 = 0, num2 = 0, num3 = 1;
        for(int i = 0; i < count; i++){
            num1 = num2;
            num2 = num3;
            num3 = num1 + num2;
            list.add(num3);
        }
    System.out.println(list);
    }
}