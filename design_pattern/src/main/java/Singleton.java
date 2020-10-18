/**
 * @Author: wuzhijun
 * 单例模式，双重校验
 * @Date: 2020/10/18 18:10
 */
public class Singleton {
    private volatile static Singleton singleton = null;
    private Singleton() {}

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}