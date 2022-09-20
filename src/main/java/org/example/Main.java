package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String dir = System.getProperty("user.dir");
        System.out.println(dir);

        Scanner fileScanner;
        if (args.length == 0) {
            File file = new File("src/main/java/org/example/tadeusz.txt");
            fileScanner = new Scanner(file);
        } else {
            File file = new File("org/example/" + args[0]);
            fileScanner = new Scanner(file);
        }

        Map<String, String> hashMap = new HashMap<>();

        for (Scanner it = fileScanner; it.hasNext(); ) {
            String next = it.next().strip();
            if (hashMap.containsKey(next)) {
                int appearancesNumber = Integer.parseInt(hashMap.get(next)) + 1;
                hashMap.replace(next, ("" + appearancesNumber));
            } else {
                hashMap.put(next, "1");
            }
        }
        fileScanner.close();

        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;

        do {
            System.out.println("Jakiego słowa szukasz w \"Panu Tadeuszu\"? ");
            String word = scanner.next();

            if (hashMap.containsKey(word)) {
                System.out.println("Słowo \"" + word + "\" wystąpiło " + Integer.parseInt(hashMap.get(word))
                        + " razy w \"Panu Tadeuszu\" Adama Mickiewicza.");
            } else {
                System.out.println("Nie ma takiego słowa w \"Panu Tadeuszu\"");
            }

            System.out.println("Czy chcesz zakończyć? (Y)");
            String decisionToBreak = scanner.next();
            if (decisionToBreak.equals("Y")) {
                shouldContinue = false;
            }

        } while (shouldContinue);

    }
}