package com.jin.gateway.downstream;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wu.jinqing
 * @date 2020年10月15日
 */
public class Test4 {
    /*

    if (++size > threshold)
            resize();




size=0 threshold=1
0 1=2*0.75
1 1=resize -> (2*2)*0.75=3
2 3=4*0.75
3 3=resize -> (4*2)*0.75=6
4 6=6
5 6=6
6 6=resize -> (8*2)*0.75=12
7 12=12
8 12=12
9 12=12
10 12=12
11 12=12
12 12=resize -> (12)*2=24  oldCap >= DEFAULT_INITIAL_CAPACITY 16  newThr = oldThr << 1;

HashMap扩容规则：

0.如果实例化的时候给了初始容量，首次初始化数组容量等于阈值 newCap = oldThr;

1.新数组容量是老数组容量的两倍 newCap = oldCap << 1

2.当老的数组的容量小于16时，新的阈值是新的数组容量的loadFactor倍  newThr = (float)newCap * loadFactor;

3.当老的数组的容量大于等于16时，新的阈值是老的阈值的两倍  newThr = oldThr << 1;

oldCap >= DEFAULT_INITIAL_CAPACITY 16  newThr = oldThr << 1;





final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
            Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;

        return newTab;
    }


     */
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(9);

        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");
        map.put("D", "4");
        map.put("E", "5");
        map.put("F", "6");
        map.put("G", "7");
        map.put("H", "8");
        map.put("I", "9");
        map.put("J", "10");
        map.put("K", "11");
        map.put("L", "12");
        map.put("M", "13");
        map.put("N", "14");



    }
}
