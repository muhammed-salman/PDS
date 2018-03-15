import java.util.*;

class Berkeley{

  static void syncTime(int tmH,int tmM,int tmS,int tsH[],int tsM[],int tsS[],int n){

    int adjustH=tmH,adjustM=tmM,adjustS=tmS;

    for(int i=0;i<n-1;i++){
      adjustH+=tsH[i];
      adjustM+=tsM[i];
      adjustS+=tsS[i];
    }
    adjustH/=n;
    adjustM/=n;
    adjustS/=n;

    System.out.println("\nAverage Value of Time : "+adjustH+":"+adjustM+":"+adjustS);

    //calculate offset
    int[] offsetH=new int[n-1];
    int[] offsetM=new int[n-1];
    int[] offsetS=new int[n-1];

    for(int i=0;i<n-1;i++){
      offsetH[i]=adjustH-tsH[i];
      offsetM[i]=adjustM-tsM[i];
      offsetS[i]=adjustS-tsS[i];
    }

    System.out.println("\nOffsets for clients:");

    for(int i=0;i<n-1;i++){
      System.out.println("Client"+ (i+1)+": "+offsetH[i]+":"+offsetM[i]+":"+offsetS[i]);
    }

    //Synchronizing Time by adding offset
    for(int i=0;i<n-1;i++){
      tsS[i]+=offsetS[i];
      if(tsS[i]>59){
        tsS[i]-=60;
        tsM[i]++;
      }
      tsM[i]+=offsetM[i];
      if(tsM[i]>59){
        tsM[i]-=60;
        tsH[i]++;
      }
      tsH[i]+=offsetH[i];
      if(tsH[i]>23){
        tsH[i]-=24;
      }
    }
    //adjusted time becomes new server Time
    tmH=adjustH;
    tmM=adjustM;
    tmS=adjustS;

    //Printing New Synchronized time for server and clients

    System.out.println("Synchronized Server Time: "+tmH+":"+tmM+":"+tmS);

    System.out.println("New Synchronized time for clients: ");
    for(int i=0;i<n-1;i++){
      System.out.println("Client "+(i+1)+" Time: "+tsH[i]+":"+tsM[i]+":"+tsS[i]);
    }


  }
  public static void main(String[] args){
    //Server Time variables
    Calendar serverDate = Calendar.getInstance();
    int tmH=serverDate.get(Calendar.HOUR_OF_DAY);
    int tmM =serverDate.get(Calendar.MINUTE);
    int tmS= serverDate.get(Calendar.SECOND);

     Scanner scr = new Scanner(System.in);

     System.out.println("Current Server Time: "+tmH+":"+tmM+":"+tmS);

     System.out.println("Enter the Number of Client Nodes in System: ");
     int n=scr.nextInt();

    //Client Time variables
     int[] tsH= new int[n];
     int[] tsM= new int[n];
     int[] tsS= new int[n];

    //Random time assignment to client nodes

    Random random = new Random();
    for(int i=0;i<n;i++){
      tsH[i]= tmH;
      tsM[i]= random.nextInt(59);
      tsS[i]= random.nextInt(59);
    }

    for(int i=0;i<n;i++){
      System.out.println("Client "+(i+1)+" Time: "+tsH[i]+":"+tsM[i]+":"+tsS[i]);
    }

    System.out.println("Synchronizing Time among nodes");

    syncTime(tmH,tmM,tmS,tsH,tsM,tsS,n+1);

  }
}
