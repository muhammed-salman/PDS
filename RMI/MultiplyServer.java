import java.rmi.Naming;

class MultiplyServer{
  public static void main(String[] args) {
    try{
      Naming.rebind("Multiply",new Multiply());
      System.out.println("\nI am ready for client to connect");
    }
    catch(Exception e){
      System.out.println("\nServer: An Error Occured. Disconnecting");
      e.printStackTrace();
    }
  }
}
