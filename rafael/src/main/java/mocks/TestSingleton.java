package mocks;

import java.util.HashMap;
import java.util.Map;

public class TestSingleton {

    private static TestSingleton INSTANCE;
    private final Map<String, String> set;
    private TestSingleton() {
        //private;
        set = new HashMap<>();
        set.put("Hello", "World");
        set.put("Hello111", "World111");
    }

    public String getValue(String key) {
        return set.get(key);
    }
    public static TestSingleton getInstance() {
        synchronized (INSTANCE) {
            if (INSTANCE == null) {
                INSTANCE = new TestSingleton();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        TestSingleton obj = TestSingleton.getInstance();
        String res = obj.getValue("Hello");
        System.out.println(res);
    }
}
