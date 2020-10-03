package cn.zsy.mashibing;

import sun.misc.Contended;

public class T05_Contended {

    @Contended
    volatile long x;

    @Contended
    volatile long y;

    public static void main(String[] args) throws Exception {
        T05_Contended t = new T05_Contended();
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 10000_0000L; i++) {
                t.x = i;
            }
        });

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 10000_0000L; i++) {
                t.y = i;
            }
        });

        final long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println((System.nanoTime() - start) / 100_0000);
    }

}
