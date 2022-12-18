
package theoldexample;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Read  extends ReadAndWrite implements Runnable {
        File EmFile=new File("C:\\Users\\pc\\Desktop.txt");

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
                    w_mutex.acquire();
                    }
                    
                mutex.release();
                r_mutex.acquire();
                
               
                System.out.println("Thread "+Thread.currentThread().getName() + " Read is Acquired");
//                if(EmFile.length()==0 ){
//                System.out.println("File is empty");
//                }
//                else
                System.out.println(getEmployeeName());
                System.out.println("Thread "+Thread.currentThread().getName() + " Read is Released");


                r_mutex.release();
                  mutex.acquire();
                   readCount--;
                   
                    if (readCount == 0) {
                    //w_mutex.release();
                    }
                    mutex.release();
               } catch (InterruptedException ex) {
                    Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
                }
       
        }
  }


