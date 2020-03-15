package smaug.customer.service.controller.designMode.siglen;

public class HungryFactory {
    private static final Hungry hungry = new Hungry();

    public static final Hungry getInstance() {
        return hungry;
    }
}
