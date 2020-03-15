package smaug.customer.service.controller.designMode.lazyone;

import java.util.concurrent.CountDownLatch;

public class LazyOneTest {
    public static void main(String[] args) {

        int count = 100;
        CountDownLatch countDownLatch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Object o = LazyTwo.getInstance();
                    System.out.println(System.currentTimeMillis() + "  " + o);
                }
            }.start();
          //  countDownLatch.countDown();
        }
    }
}
