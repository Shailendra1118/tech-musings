package com.sports.rafael.ques;

public class BinaryAdd {

    public static void main(String[] args) {
        char arr[] = "10010".toCharArray();
        int carry = 1;
        char res;
        char val = (char)(arr[0] + carry);
       // System.out.println(val);

        BinaryAdd obj = new BinaryAdd();
        String ans = obj.addBinary("11", "1");
        System.out.println(ans);
    }

    private String addBinary(String a, String b) {
        char arr1[] = a.toCharArray();
        char arr2[] = b.toCharArray();

        int i = arr1.length-1;
        int j = arr2.length-1;
        int carry = 0;

        //char res[] = new char[maxLen+1];
        StringBuilder sb = new StringBuilder();
        //int k = res.length-1;
        while(i >=0 && j >= 0){
            int val = Integer.valueOf(String.valueOf(arr1[i])) + Integer.valueOf(String.valueOf(arr2[j])) + carry;
            carry = 0;
            if(val > 1){
               sb.append("0");
                carry = 1;
            }else{
                sb.append(val);
            }
            i--;
            j--;
        }

        while(i >=0){
            int val = Integer.valueOf(String.valueOf(arr1[i])).intValue() + carry;
            carry = 0;
            if(val > 1){
                sb.append("0");
                carry = 1;
            }else{
                sb.append(val);
            }
            i--;
        }

        while(j >=0){
            int val = Integer.valueOf(String.valueOf(arr2[j])) + carry;
            carry = 0;
            if(val > 1){
                sb.append("0");
                carry = 1;
            }else{
                sb.append(val);
            }
            j--;
        }
        //last carry
        if(carry == 1){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
