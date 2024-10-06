package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

public class CompressString {

    @Test
    void testCompression() {
        String input = "azzzabbcccddd";
        int res = compress(input.toCharArray());
        System.out.println("Res: "+res);

    }

    private int compress(char[] chars) {
        int n = chars.length;
        int index = 0;  // Pointer to place the compressed result
        int i = 0;      // Pointer to iterate through chars

        while (i < n) {
            char currentChar = chars[i];
            int count = 0;

            // Count the number of consecutive occurrences of chars[i]
            while (i < n && chars[i] == currentChar) {
                i++;
                count++;
            }

            // Write the current character to the array
            chars[index++] = currentChar;

            // If count is greater than 1, we need to write the digits of the count
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        // Return the new length of the compressed array
        System.out.println(chars);
        return index;
    }
}
