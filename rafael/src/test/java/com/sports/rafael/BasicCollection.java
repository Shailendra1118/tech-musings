package com.sports.rafael;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BasicCollection {

    @Test
    public void testWildCards() {
        //unbounded
        List<String> strList = new ArrayList<>();
        strList.add("Shailendra");
        List<Integer> intList = new ArrayList<>();
        intList.add(100);
        printList(strList);
        printList(intList);
    }

    private void printList(List<?> list) {
       list.forEach(s -> System.out.println(s));
       // argument uses unbounded wildcard so implementation restricted to
       // 1 - methods from this class only
       // 2 - methods from Object
    }




    @Test
    public void testEleven() {
        System.out.println(" ".isBlank()); // isEmpty was there in Java 8
        String str = "Shailendra \nSingh";
        System.out.println(str);
        // lines
        System.out.println(str.lines().count());
        System.out.println(str.lines().max(Comparator.comparing(String::length)).get());
        // strip
        String s = " Shailendra ";
        System.out.println(s.strip());
        // repeat
        String s1 = "Shailendra";
        System.out.println(s1.repeat(5));

    }

    @Test
    public void langFeature() {
        var list = new ArrayList<>();
        list.add("Shailendra");
        list.add(Integer.valueOf(10));
        printList(list);
    }

    public class Main {
        public void myPublic() {
            System.out.println("myPublic");
        }
        private void myPrivate() {
            System.out.println("myPrivate");
        }
        public class Nested {
            public void nestedPublic() {
                myPrivate();
            }
        }
    }

    @Test
    public void testNested() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Main main = new Main();
        Main.Nested nested = main.new Nested();
        nested.nestedPublic();

        Method method = main.getClass().getDeclaredMethod("myPrivate");
        method.invoke(main);
        // it works with marking property accessing = true unlike java 8
    }
}
