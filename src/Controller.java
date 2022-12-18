

import java.util.Random;

 
             
public class Controller {
    public static int T=5;
    boolean booking ;
    int WaitBooking,Seeking;
    private boolean seekingTurn =false;

    public  synchronized void statrtBook() {

        while(booking || Seeking>0){
            WaitBooking++;
            try{
               wait(); }
            catch(InterruptedException ex){
                WaitBooking--;
            } 
        }
        
        WaitBooking--;
        booking=true;
    }
    
    public static synchronized int book(String s){
          T=T-1;
          if(T<0){
              T=0;
              return 0;
              
          }
          return 1;
    }
    public synchronized void stopWriting(){
        booking = false;
        seekingTurn =true;
        notifyAll();
    }
    
    
    public synchronized void startSeeking() {
        
        while(booking || WaitBooking > 0 && !seekingTurn ){
            try{
                wait();
            }catch(InterruptedException ex){
            }
           
        } Seeking++;
    }

    
    public synchronized void stopSeeking(){
        --Seeking;
        seekingTurn = false;
        if(Seeking==0){
            notifyAll();
        }
    }
    public int getTickets(){
        return T;
    }
}
