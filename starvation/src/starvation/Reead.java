
package starvation;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reead extends ReeadAndWrrite implements Runnable {
       File EmFile =new File("C:\\Users\\pc\\Desktop\\project os.txt");

        public String getEmployeeName(){
        String x="";
        try{
        Scanner input =new Scanner(EmFile);
            x+="############OUTPUT############";
            while(input.hasNext()){
                x+="\n"+input.next();
            }
            input.close();
            
        }catch(IOException e){
            
        }
        return x;
   }
     
   
    
        @Override
        public void run() {
                try {
                    
                  mutex.acquire();
                
                  
                    readCount++;
                    if (readCount == 1) {
                    rw_mutex.acquire();
                    }
                    
                mutex.release();
                
                 
                ///////////////////////////////
               
                System.out.println("Thread "+Thread.currentThread().getName() + " Read is Acquired");
                if(EmFile.length()==0 ){
                 System.out.println("File is empty");
                }
                else
                System.out.println(getEmployeeName());
                System.out.println("Thread "+Thread.currentThread().getName() + " Read is Released");
                
                
                //////////////////////////////
                
                mutex.acquire();
                   readCount--;
                   
                    if (readCount == 0) {
                    rw_mutex.release();
                    }
                    mutex.release();
               } catch (InterruptedException ex) {
                    Logger.getLogger(Reead.class.getName()).log(Level.SEVERE, null, ex);
                }
       
        }
  }



