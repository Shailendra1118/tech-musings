package com.sports.rafael;

import com.sports.rafael.pojo.AzureUsageReportBean;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicJava {


    @Test
    public void testConsumerForEach() {

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.forEach(i -> System.out.println(Integer.toBinaryString(i)));

    }

    @Test
    public void testCharToInt() {
        char ch = (char)(9 + '0');
        System.out.println(ch);

        int count = 12;
        while(count > 0) {
            int rem = count%10;
            System.out.println(rem);
            count = count/10;
        }
    }

    @Test
    public void findComplement() {
        int num = 5;
        int n = 0;
        while (n < num) {
            n = (n << 1) | 1;
            System.out.println("now n: "+n);
        }
        System.out.println("N:: "+n);
        System.out.println(n - num);
    }

    @Test
    public void toBinary(){
        int num = 5; // 0101 0011
        String binary = Integer.toBinaryString(num);
        System.out.println(binary);
        System.out.println("highestOneBit:: " +(Integer.highestOneBit(num) << 1));
        System.out.println("negate ::"+~num);

        StringBuilder sb = new StringBuilder();
        for(char c : binary.toCharArray()){
            sb.append(c == '0'? '1' : '0');
        }
        String comp = sb.toString();
        int res = Integer.parseInt(comp, 2);
        System.out.println(res);

    }

    @Test
    public void testSet() {
        Set<Integer> set = new HashSet<>();
        set.add(200);
        set.add(100);
        set.add(200);
        List<Integer> list = set.stream().collect(Collectors.toList());
        System.out.println(list);
        int a = -2;
        int b = -1;
        System.out.println(a*b);
    }

    public class OuterClass {
         int value = 20;
    }

    public static class OuterStatic {
        public static int value = 10;
    }

    public static void main(String[] args) {
        OuterClass outerClassObj = new BasicJava().new OuterClass();
        System.out.println(outerClassObj.value);

        System.out.println(OuterStatic.value);
        // OuterClass outerClassObj1 = new OuterClass(); Error
    }

    @Test
    void testSortArray() {
        int[] nums = {2, 34, 2, 51, 35};
        Arrays.sort(nums, 2, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testOptional() {
        // Optional object is used to represent null with absent value
        Optional<String> op = Optional.of("Shailendra");
        System.out.println(op);
        System.out.println(op.isPresent());
    }

    @Test
    public void testEmptyOptional() {
        // Optional object is used to represent null with absent value
        String val = null;
        Optional<String> op = Optional.ofNullable(null);
        System.out.println(op);
        System.out.println(op.isPresent());
    }

    @Test
    public void testOrElse() {
        String s = null;
        Optional<String> op = Optional.ofNullable(s);
        String strValue = Optional.ofNullable(s).orElseGet(() -> "DefaultValue");
       // System.out.println(op.get().length());
        if(op.isPresent()) { // ~null check
            System.out.println(op.get().length());
        }

        op.ifPresent(str -> System.out.println(str.length()));
        op.ifPresentOrElse(str -> System.out.println(str.length()), () -> System.out.println("is EMPTY"));
    }

    @Test
    public void testFilter() {
        List<String> list = Arrays.asList("Shailendra","Singh", "Yadav");
        Optional.ofNullable(list)
                .stream()
                .forEach(s -> System.out.println(s));

        //list = null;
        boolean isValid = Optional.ofNullable(list)
                .map(List::iterator)
                .filter(stringIterator -> {
                    String val = stringIterator.next();
                    return val.length() > 10 || val.length() < 2;
                })
                .isPresent();
        System.out.println("IsValid: "+ isValid);

    }


    @Test
    public void testMap() {
        List<List<String>> foo = new ArrayList<>();
        foo.add(Arrays.asList("A","B","C"));
        foo.add(Arrays.asList("10","20","30"));

        for(List<String > list : foo) {
            for (String s : list) {
                System.out.println("Val: "+s);
            }
        }

        // post Java 8 way
        foo.stream().flatMap(strings -> strings.stream())
               .forEach(s -> System.out.println(s));
    }



    @Test
    public void testIt() {
        AzureUsageReportBean bean = new AzureUsageReportBean();
        Map<String, String> map = Map.ofEntries(Map.entry("iaasProvider", "AZURE_RI"),
                Map.entry("orderId", bean.getOrderId()),
                Map.entry("orderDate", bean.getOrderDate().toString()),
                Map.entry("productId", bean.getProductId()),
                Map.entry("skuId", bean.getSku()),
                Map.entry("availabilityId", bean.getAvailabilityId()),
                Map.entry("productName", bean.getProductName()),
                Map.entry("skuName", bean.getSkuName()),
                Map.entry("chargeType", bean.getChargeType()),
                Map.entry("unitPrice", bean.getUnitPrice().toString()),
                Map.entry("effectiveUnitPrice", bean.getEffectiveUnitPrice().toString()),
                Map.entry("termAndBillingCycle", bean.getTermAndBillingCycle()),
                Map.entry("alternateId", bean.getAlternateId()),
                Map.entry("priceAdjustmentDescription", bean.getPriceAdjustmentDescription()),
                Map.entry("pcToBcExchangeRate", bean.getPcToBCExchangeRate().toString()),
                Map.entry("pcToBcExchangeRateDate", bean.getPcToBcExchangeRateDate().toString()),
                Map.entry("billingFrequency", bean.getBillingFrequency()),
                Map.entry("reservationOrderId", String.valueOf(bean.getAdditionalInfo().get("reservationOrderId"))));

        System.out.println("Size: "+map.size());


    }


    @Test
    public void testTree() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(12);
        set.add(4);
        set.add(8);
        System.out.println(set.lower(11));
        System.out.println(set.higher(4));
        System.out.println(set.ceiling(4));
    }

    @Test
    public void testArray() {

        int arr[][] = new int[][] {{0,2},{5,10},{13,23},{24,25}};
        int tempo[] = Arrays.stream(arr).flatMapToInt(Arrays::stream).toArray();
        int temp[] = arr[3];
        System.out.println(Arrays.toString(tempo));

        List<AzureUsageReportBean> list = new ArrayList<>();
        list.add(AzureUsageReportBean.builder().id("1").build());
        list.add(AzureUsageReportBean.builder().id("2").build());
        AzureUsageReportBean[] beans = list.toArray(new AzureUsageReportBean[0]);
        System.out.println(Arrays.toString(beans));
    }


    @Test
    public void testFilterPredicate() {
        Predicate<String> filter = input -> "Vinayak".equals(input);
        Stream.of("Aman", "Vinayak","Shailendra")
                .filter(filter)
                .forEach(s -> System.out.println(s));
    }


    class Animal {
        public void display() {
            System.out.println("animal display");
        }
    }

    class Horse extends Animal {
        public void display() {
            System.out.println("Horse display");
        }
    }

    class Goat extends Animal {
        public void display() {
            System.out.println("Goat display");
        }
    }

    public void methodOne(Horse animal) {
        System.out.println("Passed Horse");
        animal.display();
    }

    public void methodOne(Goat animal) {
        System.out.println("Passed Goat");
        animal.display();
    }

    @Test
    public void testInheritance() {

        Goat g = new Goat();
        methodOne(g);
        Horse h = new Horse();
        methodOne(h);

        Animal animal = new Horse();
        //methodOne(animal);

        List<Animal> animals = new ArrayList<>();
        animals.add(new Horse());
        animals.add(new Goat());

        for(Animal a: animals) {
            System.out.println(a.getClass().toString());
            a.display();
        }
    }


    @Test
    public void testFinally() {
        boolean success = false;
        int val = -110;
        try{
            if(val > 10) {
                success = true;
                System.out.println("Special case...");
                return;
            }
            //else
            System.out.println("Not so special case...");
        }catch(Exception ex) {
            System.out.println("Error: "+ex);
        }finally {
            callMethod();
            System.out.println("Success was="+success);
        }
    }

    private void callMethod() {
        System.out.println("In method callMethod()...");
    }



    @Test
    public void findDuplicate() {
        int arr[] = {1,2,5,6,2,4,5,2,2,2};
        Set<Integer> set = new HashSet<>();
        List<Integer> duplicates = Arrays.stream(arr).mapToObj(n->n)
                .filter(n -> !set.add(n))
                .collect(Collectors.toList());
        for (Integer duplicate : duplicates) {
            System.out.println(duplicate);
        }
    }

    @Test
    public void findDups(){
        int arr[] = {1,2,5,6,2,4,5,2,2,2,4};
        Set<Integer> duplicates = Arrays.stream(arr).mapToObj(n->n)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1)
                .map(e-> e.getKey())
                .collect(Collectors.toSet());
        System.out.println(duplicates);

    }

    @Test
    public void findDupsFreq() {
        int arr[] = {1,2,5,6,2,4,5,2,2,2,4};
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Set<Integer> set = list.stream()
                .filter(i -> Collections.frequency(list, i) > 1)
                .collect(Collectors.toSet());
        System.out.println(set);
    }

    @Test
    public void convertIntArrayToIntegerArray() {
        int arr[] = {2,3,5,6,7};
        Integer arr1[] = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        System.out.println(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    @Test
    public void convertIntegerArrayToIntArray() {
        Integer arr[] = {2,3,5,6,7};
        int arr1[] = new int[arr.length];
        final AtomicInteger count = new AtomicInteger(0);
        Arrays.stream(arr).forEach(i -> arr1[count.getAndIncrement()] = i.intValue());
        System.out.println(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    @Test
    public void modAndDivide() {

    }

    @Test
    public void precedenceOps() {
        int a = 10;
        int b = -a++; //assign first then increment
        int c = --b;



        System.out.println("A is: "+a); //11
        System.out.println("B is: "+b); // -10
        System.out.println("C is: "+c); //-11
        System.out.println("Now B is: "+b); //-11
        System.out.println(-a++); // -11 first

        System.out.println("BEFORE---");
        System.out.println("B is: "+b); // -10
        System.out.println("C is: "+c); //-11
        int d = (--b + c--);
        System.out.println("AFTER---");
        System.out.println("B is: "+b); // -10
        System.out.println("C is: "+c); //-11
        System.out.println("D is: "+d);
    }


    @Test
    public void testSorting() {
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(2);
        Collections.sort(list);
        System.out.println(list);

        System.out.println("Map ------");
        Map<Integer,Integer> map = new HashMap<>();
        map.put(500,5);
        map.put(30,4);
        map.put(11,2);
        map.put(244,2);
        //map.entrySet().stream().sorted().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("Using treeMap ---");
        Map<Integer, Integer> treeMap = new TreeMap<>(map);
        System.out.println(treeMap);

        System.out.println("Another way --- Reverse Order");
        treeMap = new TreeMap<>(Comparator.reverseOrder());
        treeMap.putAll(map);
        System.out.println(treeMap);

        System.out.println("Sort by Value !!!!!");
        List<Map.Entry<Integer,Integer>> listOfEntries = new ArrayList<>(map.entrySet());
        Collections.sort(listOfEntries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        // o1.compareTo(o2) increasing order sorting
        //another way
        Collections.sort(listOfEntries, Comparator.comparing(Map.Entry::getValue));
        Map<Integer, Integer> tempMap = listOfEntries.stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (x, y) -> y, LinkedHashMap::new));
        System.out.println(tempMap);


        System.out.println("Another Lambda way ----");
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(System.out::println);

        //System.out.println(map);
        // another way
        tempMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldV, newV) -> oldV, LinkedHashMap::new));
        System.out.println("Lamda :: "+tempMap);





    }


}
