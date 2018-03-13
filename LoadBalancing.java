import java.io.*;
import java.util.*;

class LoadBalancing{
  public static void loadBalancer(int servers,int processes){
    if(servers<=0){
      System.out.println("\nNumber of servers are either zero or negative");
    }
    else{
      int server[]=new int[servers];
      int eachProcess=processes/servers;
      int remainProcess=processes%servers;
      for(int i=0;i<server.length;i++){
        server[i]=eachProcess;
      }
      for(int i=0;i<server.length && remainProcess>0;i++){
        server[i]+=1;
        remainProcess--;
      }
      for(int i=0;i<server.length;i++){
        System.out.println("\nServer "+(i+1)+" is assigned "+server[i]+" process(es)");
      }
    }
  }
  public static void main(String args[]){
    int servers=0,processes=0,input;
    int choice;
    Scanner scr = new Scanner(System.in);
    do{
      System.out.println("\nPlease Enter Your Choice: ");
      System.out.println("\n1.Add Servers\n2.Remove Servers\n3.Add Processes\n4.Remove Processes\n5.Exit");
      choice = scr.nextInt();
      switch(choice){
        case 1:
          System.out.println("\nHow many servers to add? ");
          input = scr.nextInt();
          while(input<0){
            System.out.println("\nInvalid Input");
            System.out.println("\nPlease Re-Enter the Number of Servers to add: ");
            input = scr.nextInt();
          }
          servers +=input;
          loadBalancer(servers,processes);
          break;
        case 2:
          System.out.println("\nHow many servers to remove? ");
          input = scr.nextInt();
          while(input<0 || input>servers){
            System.out.println("\nInvalid Input");
            System.out.println("\nPlease Re-Enter the Number of Servers to remove: ");
            input = scr.nextInt();
          }
          servers -=input;
          loadBalancer(servers,processes);
          break;
        case 3:
          System.out.println("\nHow many processes to add? ");
          input = scr.nextInt();
          while(input<0){
            System.out.println("\nInvalid Input");
            System.out.println("\nPlease Re-Enter the Number of processes to add: ");
            input = scr.nextInt();
          }
          processes +=input;
          loadBalancer(servers,processes);
          break;
        case 4:
          System.out.println("\nHow many processes to remove? ");
          input = scr.nextInt();
          while(input<0 || input>processes){
            System.out.println("\nInvalid Input");
            System.out.println("\nPlease Re-Enter the Number of processes to remove: ");
            input = scr.nextInt();
          }
          processes -=input;
          loadBalancer(servers,processes);
          break;
        case 5:
          System.exit(0);
          break;
      }
    }while(true);
  }
}
