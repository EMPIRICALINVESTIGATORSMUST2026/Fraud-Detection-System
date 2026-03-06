package fraud;

public class Transaction {
    public final String id;
    public final double amount;
    public final String location;
    public final double riskScore;

    public Transaction(String id, double amount, String location) {
        this(id, amount, location, 0.0);
    }

    public Transaction(String id, double amount, String location, double riskScore) {
        this.id = id;
        this.amount = amount;
        this.location = location;
        this.riskScore = riskScore;
    }
}
