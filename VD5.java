/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan3;

/**
 *
 * @author cr4zyb0t
 */
public class VD5 {
    private final Object monitor = new Object();
    public void waitForSignal() throws InterruptedException{
        synchronized(monitor){
            //Tiến trình sẽ treo cho đến khi notify
            monitor.wait();
        }
    }
    public void notifySignal(){
        synchronized (monitor) {
            //Đánh thức tiến trình
            monitor.notify();
        }
    }
}
