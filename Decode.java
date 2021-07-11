package com.example.encsms;

public class Decode {


        public static String dec(String s){
            if ((s.length() % 8 != 3) || (s.indexOf("@#$") != 0)) {
                return "ERROR :  code was not encrypted !";
            }

            String data = s.substring(3, s.length() - 7); //removing prefix and suffix .
            int[] binary = new int[] { 128, 64, 32, 16, 8, 4, 2, 1 };

            String res = "";
            int sum=0;
            for (int i = 0; i < data.length(); i++) {

                int bindex = i % 8;
                if (i % 8 == 0) {
                    res = res + (char) sum;
                    sum = 0;
                }
                if (data.charAt(i) == '1') {
                    sum = sum + binary[bindex];
                }
            }
            return res;
        }


}
