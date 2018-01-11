import java.io.*;
import java.util.*;

class Bully{
  static int crash=0,processCount=10;
  static int p[]=new int[processCount];


  int election(int i,int j){
    if(j>i && p[j]==1){
      return 1;
    }
    else
      return 0;
  }

  void bully(){
    Scanner scr=new Scanner(System.in);
    int i=0,coord=processCount-1,ch;
    while(i<processCount){
      p[i++]=1;
    }

    System.out.println("---Bully Algorithm Demonstration---");
    System.out.println("--There are total 10 Nodes from 0 to 9--");
    System.out.println("All are alive at moment");
    do{
      System.out.println("Please Enter Your Choice");
      System.out.println("1.Crash a Node\n2.Recover a Node\n3.Display the co-ordinator\n4.Exit");
      ch=scr.nextInt();
      switch(ch){
        case 1:
          System.out.println("Enter the Node Number to be Crashed");
          int c=scr.nextInt();
          while(c<0 || c>processCount-1){
            System.out.println("Invalid Node Number");
            System.out.println("Please Re-enter the Node Number to be Crashed");
            c=scr.nextInt();
          }
          p[c]=0;
          crash++;
          System.out.println("Node "+c+" is dead!");

          if(c==coord)
          {
            if(crash==processCount)
            {
              System.out.println("All Nodes are dead!");
              break;
            }
            System.out.println("The Co-ordinator is Crashed!");
            System.out.println("Please Enter the Initiator Node");
            int init=scr.nextInt();
            while(p[init]==0){
              System.out.println("The Node You Have Entered is Already Dead!");
              System.out.println("Please Enter Another Node");
              init=scr.nextInt();
            }
            int flag=0;
            while(flag==0){
              if(p[init]==1){
                int j=init+1;
                while(j<processCount){
                  int msg=election(init,j);
                  if(msg==1)
                  {
                    System.out.println("Node "+j+" is in election process");
                    flag=1;
                    break;
                  }
                  j++;
                }
                if(flag==0){
                  coord=init;
                  System.out.println("Election Finished");
                  System.out.println("Elected Co-ordinator: Node "+coord);
                  flag=1;
                }
                else{
                  flag=0;
                  init=j;
                }
            }

            }
          }
          break;
        case 2:
          break;
        case 3:
          System.out.println("The Co-ordinator is "+coord);
          break;
        case 4:
          System.exit(0);
        default:
          System.out.println("Invalid Choice");
      }
    }while(true);


  }
  public static void main(String[] args){
    Bully b=new Bully();
    b.bully();
  }
}
