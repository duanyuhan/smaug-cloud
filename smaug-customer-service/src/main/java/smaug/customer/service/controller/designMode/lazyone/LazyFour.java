package smaug.customer.service.controller.designMode.lazyone;

public class LazyFour {
    private static class LazyFourHolder {
        public static LazyFour instance = new LazyFour();
    }

    public static LazyFour getInstance() {
        return LazyFourHolder.instance;
    }
}
