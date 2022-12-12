import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        int[] arr = {2,7,11,15};
        int target = 9;
        Set<Integer> set = new HashSet<>();

        for(int n : arr) {
            if(set.contains(target-n)) { //7
                System.out.println("found");
            }else{
                set.add(n); //2
            }
        }


        /**
         * Input: strs = ["eat","tea","tan","ate","nat","bat"]
         * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
         */

        //group anagram

        String input = bitmask("a");
        System.out.println(input);

        test();

    }

    private static void test() {
        Map<String, List<String>> map = new HashMap<>();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        for(String cur : strs) {
            String key = createKey(cur);
            if(map.containsKey(key)) {
                map.get(key).add(cur);
            }else{
                map.put(key, new ArrayList<>());
            }
        }

        List<String> res = new ArrayList<>();
        //List<String> res = map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        res = map.values().stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println(res);

        List<List<String>> listOfStr = new ArrayList<>();
        listOfStr = map.values().stream().collect(Collectors.toList());

    }

    private static String createKey(String str) {
        int[] arr = new int[26];
        for(char ch : str.toCharArray()) {
            arr[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int n : arr) {
            sb.append(n);
            sb.append("#");
        }
        return sb.toString();
    }

    private static String bitmask(String str) {

        char[] arr = new char[26];
        for(char c : str.toCharArray()) {
            arr[c-'a'] = '1';
        }
        return String.valueOf(arr);
    }
}
