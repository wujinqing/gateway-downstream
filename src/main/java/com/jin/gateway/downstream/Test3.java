package com.jin.gateway.downstream;

import java.io.File;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wu.jinqing
 * @date 2020年09月07日
 */
public class Test3 {
    public static AtomicLong count = new AtomicLong(0);
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\wujinqing\\IdeaProjects\\mutms");

        readFile(file);

        System.out.println(count.get());
    }

    public static void readFile(File file)
    {
        if(file.isDirectory())
        {
            for (File file1 : file.listFiles()) {
                readFile(file1);
            }
        }else {
            String name = file.getName();

            if(name.endsWith(".java"))
            {
                count.getAndIncrement();
                System.out.println(name);
            }
        }
    }
}
