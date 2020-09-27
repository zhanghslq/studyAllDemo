package test;

/**
 * @author: zhs
 * @since: 2020/9/25 16:09
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

        stringThreadLocal.set("test");
        stringThreadLocal.get();
        stringThreadLocal.remove();
    }
}
