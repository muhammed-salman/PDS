import java.rmi.*;
import java.rmi.server.*;

class Multiply extends UnicastRemoteObject implements MultiplyInterface{

  public Multiply()throws RemoteException{}

  public int multiply(int n1,int n2)throws RemoteException{
    return n1*n2;
  }
}
