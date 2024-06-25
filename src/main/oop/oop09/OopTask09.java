package oop09;

public class OopTask09 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRun("thread1", 600));
        Thread thread2 = new Thread(new MyRun("thread2", 700));

        thread1.start();
        thread2.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main_" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyRun implements Runnable {
    public String name;
    public long time;

    public MyRun(String name, long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public void run(){
        for (int i = 0; i < 9; i++){
            System.out.println(name + "_" + i);
            try {
                Thread.sleep(time);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}