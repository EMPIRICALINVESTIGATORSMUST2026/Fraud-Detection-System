package main;

import fraud.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TransactionGenerator {

    private static final Random RAND = new Random();
    private static final String[] LOCATIONS = {"Local", "Foreign"};

    public static List<Transaction> generate(int count) {
        List<Transaction> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String id = "T" + (i + 1);
            double amount = 1_000 + RAND.nextDouble() * 5_000_000;
            String location = LOCATIONS[RAND.nextInt(2)];
            list.add(new Transaction(id, amount, location));
        }
        return list;
    }
}