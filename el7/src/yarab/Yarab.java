// this code is the final imple using random threads 
// and the writers broblem solved


package yarab;

import java.util.Random;
public class Yarab {

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
        
        
//        
//        Thread t1 = new Thread(read);
//        t1.setName("thread"+" "+"1");
//        
//        Thread t2 = new Thread(write);
//        t2.setName("thread"+" "+"2");
//        Thread t3 = new Thread(write);
//        t3.setName("thread"+" "+"3");
//        
//        Thread t4 = new Thread(read);      
//        t4.setName("thread"+" "+"4");
//        Thread t5 = new Thread(read);
//        t5.setName("thread"+" "+"5");
//        
//        Thread t6 = new Thread(read);
//        t6.setName("thread"+" "+"6");
//        Thread t7 = new Thread(write);
//        t7.setName("thread"+" "+"7");
//        Thread t8 = new Thread(read);      
//        t8.setName("thread"+" "+"8");
//        
//        Thread t9 = new Thread(read);      
//        t9.setName("thread"+" "+"9");
//        Thread t10 = new Thread(read);
//        t10.setName("thread"+" "+"10");
//        
//        Thread t11 = new Thread(write);
//        t11.setName("thread"+" "+"11");
//        Thread t12 = new Thread(write);
//        t12.setName("thread"+" "+"12");
//       
//        Thread t13 = new Thread(read);   
//        t13.setName("thread"+" "+"13");
//        
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        t7.start();
//        t6.start();
//       
//        t8.start();
//        t9.start();
//        t10.start();
//        t11.start();
//        t12.start();
//        t13.start();


    }
}