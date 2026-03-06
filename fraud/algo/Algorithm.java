package fraud.algo;

import fraud.DetectionResult;
import fraud.Transaction;
import java.util.List;
import java.util.Map;

public interface Algorithm {
    String getName();
    DetectionResult analyze(List<Transaction> transactions, Map<String, Object> parameters);
}
