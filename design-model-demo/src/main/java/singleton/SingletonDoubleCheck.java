package singleton;

/**
 * @author: zhs
 * @since: 2020/10/9 10:20
 */
public class SingletonDoubleCheck {
    private volatile static SingletonDoubleCheck singleton;
    private SingletonDoubleCheck (){}
    public static SingletonDoubleCheck getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new SingletonDoubleCheck();
                }
            }
        }
        return singleton;
    }
}
