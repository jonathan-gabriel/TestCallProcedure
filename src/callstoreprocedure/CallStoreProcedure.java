/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package callstoreprocedure;

/**
 *
 * @author User
 */
public class CallStoreProcedure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i <= 30; i++) {
//            Thread.sleep(100);
            CallProcThread sp = new CallProcThread();
            sp.start();
//            Thread.sleep(50);
        }
        
    } // fin main
    
}
