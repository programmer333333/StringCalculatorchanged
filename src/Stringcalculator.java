import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stringcalculator {
    static String result;
    static Scanner sc;
    static String input;

    static String[] str;

    public static void main(String[] args) throws Exception {
        initialization();

        lengthString();


        if (input.contains("+")) {
            addition();}

        else if (input.contains("-")) {
            subtraction();}

        else if (input.contains("*")) {
            multiplication();}

        else if (input.contains("/")) {
            division();}

        else {throw new Exception("Incorrect expression!!!");}

        if (result.toCharArray().length > 40) {
            System.out.println("\"" + result + "..." + "\"");}

        else {System.out.println("\"" + result + "\"");}
    }


    public static void initialization() {
        result = "";
        sc = new Scanner(System.in);
        System.out.println("Enter expression: ");
        input = sc.nextLine();
        input = input.replace("\"", "");
        str = input.split("[+ \\- * /]");}

    public static void lengthString() throws Exception {
        for (int i = 0; i < str.length; i++) {
            if (str[i].toCharArray().length > 10) {
                throw new Exception("Enter from 1 to 10 symbols");}
        }
    }


    public static void addition() {
        result = str[0] + str[str.length - 1];
    }


    public static void subtraction() {
        List<String> strArr = new ArrayList<>(List.of(str));
        while (strArr.remove(str[str.length - 1])) ;
        result = String.join(" ", strArr).trim();
    }

    public static void multiplication() throws Exception {
        int number = Integer.parseInt(str[str.length - 1]);
        if (number > 10) {throw new Exception("Enter numbers from 1 to 10 inclusive");}

        for (int i = 0; i < number; i++) {result += str[0];}
    }

    public static void division() throws Exception {
        int length = str[0].toCharArray().length;
        int num = Integer.parseInt(str[str.length - 1]);
        if (num > 10) {
            throw new Exception("Enter numbers from 1 to 10 inclusive");}
        int res = length / num;
        if (res > 10) {
            throw new Exception("Enter numbers from 1 to 10 inclusive");}
        result = str[0].substring(0, length / num);}
}








