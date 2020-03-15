package smaug.customer.service.controller.designMode.siglen;

public class HungryTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread() {
                @Override
                public void run() {
                    System.out.println(System.currentTimeMillis() + " " +HungryFactory.getInstance());
                }
            }.start();
        }
    }
}
