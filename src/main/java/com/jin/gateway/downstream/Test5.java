package com.jin.gateway.downstream;

/**
 * @author wu.jinqing
 * @date 2020年10月15日
 */
public class Test5 {
    public static void main(String[] args) {
        for(int i = 1; i <= 100; i++)
        {
            int k = tableSizeFor(i);

            System.out.println("i=" + i + ", k=" + k);
        }
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 :  n + 1;
    }
}
