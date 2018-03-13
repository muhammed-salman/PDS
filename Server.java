import java.net.*;
import java.io.*;

class Server{
  public static void main(String[] args) {
    try{
      //step 1 create server socket
      ServerSocket server = new ServerSocket(1500);
      System.out.println("\nListening on port 1500....");

      //step 2 accept client request\
      Socket client = server.accept();
      System.out.println("\nConnected to Client");

      //step 3 display client info
      System.out.println("\nClient Info:\nIP Address:"+client.getInetAddress()+"\tPort:"+client.getPort());

      //step 4 setup input output streams
      DataInputStream serverInput = new DataInputStream(client.getInputStream());

      DataOutputStream serverOutput =new DataOutputStream(client.getOutputStream());

      //step 5 fetch the data from client
      int num1=serverInput.readInt();
      int num2=serverInput.readInt();
      System.out.println("\nRecieved Data from Client:\nNumber 1="+num1+"\tNumber 2="+num2);

      //step 6 calculate result
      int result=num1*num1+2*num1*num2+num2*num2;

      //step 7 send the result back to client
      serverOutput.writeInt(result);
      System.out.println("\nResult sent back successfully!");

      //step 8 close the sockets
      client.close();
      server.close();
      System.out.println("\nDisconnected!");
    }
    catch(Exception e){
      e.printStackTrace();
    }

  }
}
