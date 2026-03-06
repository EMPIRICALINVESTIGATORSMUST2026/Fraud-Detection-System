package fraud;

import java.util.List;

public class DetectionResult {
    public final String algorithmName;
    public final double timeMs;
    public final int fraudFound;
    public final List<Transaction> flagged;

    public DetectionResult(
            String algorithmName,
            double timeMs,
            int fraudFound,
            List<Transaction> flagged
    ) {
        this.algorithmName = algorithmName;
        this.timeMs = timeMs;
        this.fraudFound = fraudFound;
        this.flagged = flagged;
    }
}