package smaug.customer.service.controller.designMode.lazyone;

public class LazyTree {
    private static LazyTree instance = null;

    public static LazyTree getInstance() {
        if (instance == null) {
            synchronized (LazyTree.class) {
                if (instance == null) {
                    instance = new LazyTree();
                }
            }
        }
        return instance;
    }
}
