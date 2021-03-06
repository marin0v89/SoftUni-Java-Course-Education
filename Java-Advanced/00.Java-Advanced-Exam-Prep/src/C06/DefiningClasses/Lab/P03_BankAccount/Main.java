package C06.DefiningClasses.Lab.P03_BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Integer, BankAccount> vault = new HashMap<>();
        String output;

        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);
                    if (vault.containsKey(id)){
                        vault.get(id).deposit(amount);
                        output = String.format("Deposited %d to ID%d", amount, id);
                    }else {
                        output = "Account does not exist";
                        break;
                    }
                    break;
                case "SetInterest":
                    double interestRate = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interestRate);
                    output = null;
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    if (vault.containsKey(id)){
                        double interest = vault.get(id).getInterestRate(years);
                        output = String.format("%.2f", interest);
                    }else {
                        output = "Account does not exist";
                        break;
                    }
                    break;
                default:
                    BankAccount bankAccount = new BankAccount();
                    vault.put(bankAccount.getId(), bankAccount);
                    output = "Account ID" + bankAccount.getId() + " created";
                    break;
            }
            if(output!=null){
                System.out.println(output);
            }
            input = scan.nextLine();
        }
    }
}
