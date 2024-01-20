/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author cr4zyb0t
 */
public class VD2 {
    private int count = 0;
    //Tạo khóa : lock các tiến trình khi cần thiết
    private Lock lc = new ReentrantLock();
    public void demTang(){
        lc.lock();//Khóa các tiến trình khác
        try {
            count++;//Thực hiện đếm
        } catch (Exception e) {
            
        }
        finally{
            lc.unlock();//Mở các tiến trình khác
        }
    }
}
