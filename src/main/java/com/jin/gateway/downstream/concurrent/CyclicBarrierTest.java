package com.jin.gateway.downstream.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wu.jinqing
 * @date 2020年07月28日
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        int num = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(num, () -> {
            System.out.println("Action");
        });

        for(int i = 0; i < num; i++)
        {
            final int k = i;
            new Thread(()-> {
                System.out.println("i:" + k);

                try {
                    Thread.sleep(1000);
                    cyclicBarrier.await();
                    System.out.println("end i:" + k);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
