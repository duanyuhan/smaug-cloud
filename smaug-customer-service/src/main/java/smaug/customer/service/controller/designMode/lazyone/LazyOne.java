package smaug.customer.service.controller.designMode.lazyone;

public class LazyOne {

    private static LazyOne lazyOne = null;

    public static LazyOne getInstance() {
        if (lazyOne == null) {
            lazyOne = new LazyOne();
        }
        return lazyOne;

    }
}
