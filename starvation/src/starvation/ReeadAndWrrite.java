
package starvation;

import java.util.concurrent.Semaphore;


public class ReeadAndWrrite {
    
 static Semaphore mutex = new Semaphore(1);
 static Semaphore rw_mutex = new Semaphore(1);

 static int readCount = 0;

}
