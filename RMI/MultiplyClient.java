import java.rmi.Naming;
import java.util.*;

public class MultiplyClient{

  public static void main(String[] args){
    try{
      MultiplyInterface mi=(MultiplyInterface)Naming.lookup("//localhost/Multiply");
      System.out.println("Please Enter Any two integers: ");
      Scanner scr=new Scanner(System.in);
      int n1=scr.nextInt();
      int n2=scr.nextInt();
      System.out.println("Multiplication of the given numebrs is "+mi.multiply(n1,n2));
    }
    catch(Exception e){
      System.out.println("Client could not connect");
      e.printStackTrace();
    }
  }

}
