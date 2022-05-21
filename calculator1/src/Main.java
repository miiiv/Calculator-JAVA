import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static int sum(int a, int b){
        int c = a + b;
        return c;
    }

    public static int sub(int a, int b){
        int c = a - b;
        return c;
    }

    public static int mul(int a, int b){
        int c = a * b;
        return c;
    }

    public static int div(int a, int b){
        int c = a / b;
        return c;
    }

    public static int rimtoarab(String rim) throws IOException {
        if (rim.equals("I")) {
            return 1;
        } else if (rim.equals("II")) {
            return 2;
        } else if (rim.equals("III")) {
            return 3;
        } else if (rim.equals("IV")) {
            return 4;
        } else if (rim.equals("V")) {
            return 5;
        } else if (rim.equals("VI")) {
            return 6;
        } else if (rim.equals("VII")) {
            return 7;
        } else if (rim.equals("VIII")) {
            return 8;
        } else if (rim.equals("IX")) {
            return 9;
        } else if (rim.equals("X")) {
            return 10;
        } else{
            throw new IOException();
        }
    }

    public static String arabtorim(int arab) throws ArithmeticException{
        if (arab < 1){
            throw new ArithmeticException();
        }
        int[] roman_value_list = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman_char_list = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < roman_value_list.length; i += 1) {
            while (arab >= roman_value_list[i]){
                arab -= roman_value_list[i];
                res.append(roman_char_list[i]);
            }
        }
        return res.toString();
    }


    public static void main(String[] args) throws IOException{

        Scanner in = new Scanner(System.in);
        String task = in.nextLine();
        in.close();

        String delimeter = "\\s"; // Разделитель
        String[] subStr = task.split(delimeter);
//        for(int i = 0; i < subStr.length; i++) {
//            System.out.println(subStr[i]);
//        }

        if (subStr.length != 3) {
            throw new IOException();
        }

        int a = 1000;
        int b = 1000;
        int c = 1000;
        String type = "arab";
        String d;

        try {
            a = Integer.parseInt(subStr[0]);
            b = Integer.parseInt(subStr[2]);
        } catch (NumberFormatException e) {
            a = rimtoarab(subStr[0]);
            b = rimtoarab(subStr[2]);
            type = "rim";
        }

        if (subStr[1].equals("+")){
            c = sum(a, b);
        } else if (subStr[1].equals("-")) {
            c = sub(a, b);
        } else if (subStr[1].equals("*")) {
            c = mul(a, b);
        } else if (subStr[1].equals("/")) {
            c = div(a, b);
        } else {
            throw new IOException();
        }

        if (type.equals("rim")){
            d = arabtorim(c);
        } else{
            d = Integer.toString(c);
        }

        System.out.println(d);


    }
}