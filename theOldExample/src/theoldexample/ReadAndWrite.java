
package theoldexample;

import java.util.concurrent.Semaphore;


public class ReadAndWrite {
    
 static Semaphore mutex = new Semaphore(1);
 static Semaphore r_mutex = new Semaphore(1);
 static Semaphore w_mutex = new Semaphore(1);
 static int readCount = 0;

}

    

