package com.sports.rafael.basics.java;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestOverriding {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        Parent p = new Parent();
        p.display(new String("Powered through"));
        // p.display(null); When two methods like String and Integer param, now JVM confused about which one to call, so compilation error
        p.display(new Object());
        p.display(Integer.valueOf(100));

        System.out.println("Hacking starts....");
        Child c = new Child();
        System.out.println(c.hack1(0));

        System.out.println("-------");

        try{
            Class clazz = p.getClass();
            //Class clz = Class.forName("Parent");
            Class<Parent> param = clazz;
            Constructor[] cons = clazz.getConstructors();
            for(Constructor con: cons)
                System.out.println(con);
        }catch(Exception e){
            System.out.println("Caught exception: "+e.getMessage());
        }

        //System.out.println("Constructor: "+cons);
        //Method[] methods = clazz.getMethods();
        //for(Method m :methods)
        ///    System.out.println(m.getName());
 /*       Method method1 = clazz.getDeclaredMethod("method1");
        method1.setAccessible(true);
        method1.invoke(p);*/
    }
}

class Parent {

    public Parent() {
        System.out.println("Constructor of Parent");
    }

    public void display(String str) {
        System.out.println("Got String: "+str);
    }

    public void display(Object str) {
        System.out.println("Got Object: "+str);
    }

    public void display(Integer str) {
        System.out.println("Got Integer: "+str);
    }

    private int hack1(int i){
        return i++;
    }

    private void method1(){
        System.out.println("P' private method is called...");
    }

    public int hack2(int i) {
        System.out.println(i);
        return hack1(i++);
    }
}

class Child extends Parent{
    int hack1(int i) {
        return hack2(++i);
    }
}
