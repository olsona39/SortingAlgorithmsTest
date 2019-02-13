import java.io.*;
import java.util.*;
import java.lang.*;

public class javastuff{

  public static void main(String[] args){
    System.out.println(calculator());
  }

  public static int calculator(){
    String opr;
    Scanner reader = new Scanner(System.in);
    System.out.println("Enter your first two numbers");
    int x = reader.nextInt();
    int y = reader.nextInt();
    Scanner op = new Scanner(System.in);
    System.out.println("Enter operator");
    opr = op.next();
    if(opr.equal("*")){
      return x*y;
    }
    if(opr.equals("+")){
      return x+y;
    }
    if(opr.equals("/")){
      return x/y;
    }
    if(opr.equals("-")){
      return x-y;
    }
    return -1;
  }
}
