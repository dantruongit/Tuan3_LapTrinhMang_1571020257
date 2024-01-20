/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan3;

/**
 *
 * @author cr4zyb0t
 */
public class VD4 {
    private final Object lc = new Object();
    //Phương thức được đồng bộ 1
    public synchronized void phuongThuc1(){
        
    }
    //
    public synchronized void phuongThuc2(){
        synchronized(lc){
            
        }
    }
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
           //--- 
        });
        thread.start();
        try {
            //Chờ cho tiến trình khác hoàn thành thì mới thực hiện
            thread.join();
        } catch (Exception e) {
        }
    }
}
