package strategy;

/**
 * @author EDZ
 * 策略模式即多个实现类来实现同一个方法，利用Java的多态，来进行不同的类的调用
 */
public interface Strategy {
   int doOperation(int num1, int num2);
}