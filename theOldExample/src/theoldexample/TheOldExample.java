// this code for the deadlock
package theoldexample;

import java.util.Random;


public class TheOldExample {

    public static void main(String[] args) throws Exception {
      
    
        int num;
        Random random=new Random();
        Read read = new Read();
        Write write = new Write();
        
        for (int i = 0; i < 10; i++) {
            num =  1+random.nextInt(10);
          if ((num%2==0)){
              Thread r=  new Thread(read);
              r.setName("READ"+(i+1));
          //    System.out.println("random number :"+num);
              r.start();
            
          }
          else{
            Thread w = new Thread(write);
            w.setName("WRITE"+(i+1));
            //System.out.println("random number :"+num);
            w.start();
            

          }
      }
        

    }
}

