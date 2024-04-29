package com.sports.rafael.aoc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DayOne {

    public Map<String, Integer> digitMap;

    @BeforeEach
    public void initMap() {
        digitMap = new HashMap<>();
        digitMap.put("one", 1);
        digitMap.put("two", 2);
        digitMap.put("three", 3);
        digitMap.put("four", 4);
        digitMap.put("five", 5);
        digitMap.put("six", 6);
        digitMap.put("seven", 7);
        digitMap.put("eight", 8);
        digitMap.put("nine", 9);
    }
    @Test
    public void calibration() {
        //List<String> input = List.of("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet");
        String filePath = "/Users/ssyadav/Documents/inter-workspace/tech-musings/rafael/src/test/java/com/sports/rafael/aoc/input/day1/input.txt";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            int sum = 0;
            while ((line = reader.readLine()) != null) {
                // Process each line as needed
                System.out.println(line);
                int first = findFirst(line);
                System.out.println("First: "+first);
                int sec = findSec(line);
                System.out.println("Sec: "+sec);
                String num = first + String.valueOf(sec);
                //System.out.println("Number: "+num);
                sum += Integer.valueOf(num);
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

    }

    private boolean isDigitStr(String input, int sIndex, int eIndex) {
        String str = input.substring(sIndex, eIndex+1);
        if (digitMap.containsKey(str)) {
            return true;
        }
        return false;
    }

    private int findFirst(String s) {
        //StringBuilder sb = new StringBuilder();
        //int ascii = s.chars().filter(c -> Character.isDigit(c)).findFirst().getAsInt();
        //return ascii-'0';
        int start = 0;
        String firstDigitStr = "";
        while (start < s.length()) {
            if (Character.isDigit(s.charAt(start))) {
                return s.charAt(start)-'0';
            } else if (start < s.length()-2 && isDigitStr(s, start, start+2)) {
                return digitMap.get(s.substring(start, start+3));
            } else if (start < s.length()-3 && isDigitStr(s, start, start+3)) {
                return digitMap.get(s.substring(start, start+4));
            } else if (start < s.length()-4 && isDigitStr(s, start, start+4)) {
                return digitMap.get(s.substring(start, start+5));
            } else {
                start++;
            }
        }
        return 0;
    }
    private int findSec(String s) {
        //StringBuilder sb = new StringBuilder();
        //return new StringBuilder(s).reverse().chars().filter(c -> Character.isDigit(c)).findFirst().getAsInt() - '0';
        int start = s.length()-1;
        while (start >= 0) {
            if (Character.isDigit(s.charAt(start))) {
                return s.charAt(start)-'0';
            } else if (start > 2 && isDigitStr(s, start-2, start)) {
                return digitMap.get(s.substring(start-2, start+1));
            } else if (start > 3 && isDigitStr(s, start-3, start)) {
                return digitMap.get(s.substring(start-3, start+1));
            } else if (start > 4 && isDigitStr(s, start-4, start)) {
                return digitMap.get(s.substring(start-4, start+1));
            } else {
                start--;
            }
        }
        return 0;
    }
}
