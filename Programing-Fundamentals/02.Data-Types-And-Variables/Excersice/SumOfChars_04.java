package Excersice;

import java.util.Scanner;

public class SumOfChars_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int sum = 0;

        for (int i = 0; i < n; i++) {
            char symbol = scan.nextLine().charAt(0);

            sum += (int) symbol;
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
