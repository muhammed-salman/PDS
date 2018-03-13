import java.net.*;
import java.io.*;
import java.util.*;

class Client{
  public static void main(String[] args) {
    try{
      //step 1 create client socket
      Socket client=new Socket("localhost",1500);
      System.out.println("Client connected to server at localhost:1500....");

      //step 2 accept input from user
      Scanner scr = new Scanner(System.in);
      System.out.println("\nPlease Enter Two Integers: ");
      int num1=scr.nextInt();
      int num2=scr.nextInt();

      //step 3 setup input output streams
      DataInputStream clientInput=new DataInputStream(client.getInputStream());

      DataOutputStream clientOutput=new DataOutputStream(client.getOutputStream());

      //step 4 send data to server
      clientOutput.writeInt(num1);
      clientOutput.writeInt(num2);

      //step 5 fetch the data from server
      int result=clientInput.readInt();

      //step 6 display result
      System.out.println("Server Response: Result="+result);

      //step 7 close the sockets
      System.out.println("\nTerminating the process...");
      client.close();
    }
    catch(Exception e){
      e.printStackTrace();
    }

  }
}
