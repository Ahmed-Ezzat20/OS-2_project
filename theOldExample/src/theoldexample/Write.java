
package theoldexample;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Write  extends ReadAndWrite implements Runnable {

     
   static String id,employee;
   Scanner input=new Scanner(System.in);
     
        @Override
        public void run() {
            
                
                 try {
               
              r_mutex.acquire();
              
               w_mutex.acquire();
              
              System.out.println("Thread "+Thread.currentThread().getName() + " Write is Acquired");
              //////////////////////////////////////
        try {
//            
//            System.out.println("Enter id for Thread "+Thread.currentThread().getName()+": ");
//            id=input.nextLine();
//            System.out.println("\nEnter name for Thread "+Thread.currentThread().getName()+": ");
//            employee=input.nextLine();
            
            FileWriter fw = new FileWriter("C:\\Users\\pc\\Desktop.txt",true);
            try (PrintWriter pw = new PrintWriter(fw)) {
//                pw.print(id+" ");
//                pw.print(employee+"\n");

                 pw.print(Thread.currentThread().getName()+"\n");

                pw.close();
            }
        } catch (IOException ex) {
            
        }

              //////////////////////////////////////
              System.out.println("Thread "+Thread.currentThread().getName() + " Write is Released");
              
               w_mutex.release();
              
              
             // r_mutex.release();
               } catch (InterruptedException ex) {
                     java.util.logging.Logger.getLogger(Write.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                 }
               
          
      
        }
        }
   

