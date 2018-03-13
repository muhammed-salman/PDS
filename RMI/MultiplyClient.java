import java.util.*;
import java.rmi.Naming;

class MultiplyClient{
  public static void main(String[] args) {
    try{

      Scanner scr= new Scanner(System.in);
      MultiplyInterface mi;
      mi=(MultiplyInterface)Naming.lookup("//localhost/Multiply");
      System.out.println("\nWelcome to RMI Program");
      System.out.println("Please Enter any Two Numbers: ");
      int num1=scr.nextInt();
      int num2=scr.nextInt();
      System.out.println("\nSending Request to server to invoke multiply()");
      System.out.println("Server Response: Result="+mi.multiply(num1,num2));
      System.out.println("\nClient Disconnecting..");
    }
    catch(Exception e){
      System.out.println("\nAn Error Occured. Disconnecting from server");
      e.printStackTrace();
    }

  }
}
