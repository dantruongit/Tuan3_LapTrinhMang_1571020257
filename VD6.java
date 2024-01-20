/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan3;

/**
 *
 * @author cr4zyb0t
 */
public class VD6 {
    private final Object monitor = new Object();
    private boolean isDataReady = false;
    //Ham san xuat du lieu
    public void productData() throws InterruptedException{
        synchronized (monitor) {
            //Dam bao chi co 1 tien trinh duoc thuc hien
            //Neu du lieu da san sang -> nha khoa
            while(isDataReady){
                monitor.wait();
            }
            //Lap lai viec san xuat du lieu
            System.out.println("San xuat du lieu... ");
            Thread.sleep(2000);
            //Sau khi san xuat du lieu xong -> du lieu da san sang
            isDataReady = true;
            //Thong bao cho tien trinh dang chờ
            monitor.notify();
        }    
    }
    //Ham su dung du lieu
    public void useData() throws InterruptedException{
        synchronized (monitor) {
            //Dam bao chi co 1 tien trinh duoc thuc hien
            //Neu du lieu da san sang thi tien trinh useData se thuc hien
            while(!isDataReady){
                monitor.wait();
            }
            //Neu da san sang thi su dung du lieu
            System.out.println("Su dung du lieu ... ");
            //Sau khi su dung du lieu
            isDataReady = false;
            //Thong bao cho tien trinh dang cho
            monitor.notify();
        }
    }
    public static void main(String[] args) {
        VD6 ex = new VD6();
        Thread thProduct = new Thread(()->{
            try {
                while(true){
                    ex.productData();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread thUse = new Thread(()->{
            try {
                while(true){
                    ex.useData();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thProduct.start();
        thUse.start();
        
    }
}
