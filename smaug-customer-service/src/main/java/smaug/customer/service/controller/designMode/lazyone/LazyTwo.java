package smaug.customer.service.controller.designMode.lazyone;

public class LazyTwo {
    private static LazyTwo lazyOne = null;

    public static synchronized LazyTwo getInstance() {
        if (lazyOne == null) {
            lazyOne = new LazyTwo();
        }
        return lazyOne;

    }
}
