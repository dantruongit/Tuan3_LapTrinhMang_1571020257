/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan3;

/**
 *
 * @author cr4zyb0t
 */
public class VD3 {
    private int count = 0;
    //Phương thức 1 đồng bộ hóa
    public synchronized void increment(){
        count++;
    }
    //Phương thức 2 đồng bộ hóa
    public synchronized void decrement(){
        count-=2;
    }
    //Phương thức không đồng bộ hóa
    public int getCount(){
        return count;
    }
    public static void main(String[] args) {
        VD3 counter = new VD3();
        //Tạo các luồng để tăng và giảm
        Thread incrementThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < 1000 ; i++){
                    counter.increment();
                    System.out.println("Da tang");
                }
            }
        });
        Thread decrementThread = new Thread(() -> {
            for(int i = 0 ; i < 1000; i++){
                counter.decrement();
                System.out.println("Da giam");
            }
        });
        //Khởi chạy các luồng
        incrementThread.start();
        decrementThread.start();
        try {
            //Chờ đợi cho các luồng hoàn thành
            incrementThread.join();
            decrementThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //In ra kết quả cuối cùng
        System.out.println("COUNT : "+ counter.getCount());
    }
}
