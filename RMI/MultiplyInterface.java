import java.rmi.*;

public interface MultiplyInterface extends Remote{
  public int multiply(int n1, int n2)throws RemoteException;
}
