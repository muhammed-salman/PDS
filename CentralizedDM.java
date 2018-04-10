import java.io.*;
import java.util.*;

class CentralizedDM{

  static int n,front=-1,rear=-1;
  static boolean grant=false;
  static int RQ[];

  public static boolean isEmpty(){
    return front==-1&&rear==-1;
  }

  public static void insertQueue(int e){
    if(front==-1)
      front=rear=0;
    else
      rear=(rear+1)%n;

    RQ[rear]=e;
  }
  public static int dequeue(){
    int e=RQ[front];
    if(front==rear)
      front=rear=-1;
    else
      front=(front+1)%n;
    return e;
  }
  public static void release(int pid){
    System.out.println("\n\nProcess "+pid+" is Leaving Critical Region");
    grant=false;
    if(!isEmpty())
    {
      int nextPid=dequeue();
      grant=true;
      reply(nextPid);
    }
    else{
      System.out.println("\n\nCo-ordinator: No More Request in queue. Waiting.....");
    }

  }

  public static void reply(int reciever){
    System.out.println("\n\nProcess "+reciever+" has entered Critical Region");
    release(reciever);
  }


  public static void request(int sender){
    System.out.println("\nRecieved request for Critical Region Entry from Process "+sender);
    if(!grant && isEmpty()){
      grant = true;
      reply(sender);
    }
    else{
      insertQueue(sender);
    }

  }

  public static void main(String[] args){
    Scanner scr =new Scanner(System.in);
    System.out.println("\nEnter the Numbes of Nodes: ");
    n=scr.nextInt();

    //Creating request queues
    RQ= new int[n];

//    Random random = new Random();
    for(int i=0;i<n;i++)
      request(i+1);

  }
}
