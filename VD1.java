/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan3;

/**
 *
 * @author cr4zyb0t
 */
public class VD1 {
    //Sử dụng từ khóa synchronize để đồng bộ hóa
    private int count = 0;
    //Có thể đồng bộ hóa
    private synchronized void demTang(){
        count++;
    }
}
