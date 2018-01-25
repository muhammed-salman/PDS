import java.rmi.Naming;

class MultiplyServer{
  public static void main(String[] args){
    try{
      Naming.rebind("Multiply",new Multiply());
      System.out.println("I am waiting for Client to Connect!");    
    }
    catch(Exception e){
      System.out.println("Server Could not Connect: "+e);
    }
  }
}
