package experiment;

import fraud.DetectionResult;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class ConsoleReporter implements ExperimentReporter {

    private boolean headerPrinted = false;
    private String algo1Name = "";
    private String algo2Name = "";

    @Override
    public void beforeExperiment() {
        System.out.println("\n");
    }

    @Override
    public void reportRun(int run, String algorithmName, DetectionResult result, Map<String, Double> metrics) {
        // Individual reporting is now deprecated; we use reportRunComplete instead
    }

    @Override
    public void reportRunComplete(int run, Map<String, DetectionResult> results) {
        List<String> algoNames = new ArrayList<>(results.keySet());
        
        if (algoNames.size() < 2) {
            return; // Need at least 2 algorithms to compare
        }
        
        algo1Name = algoNames.get(0);
        algo2Name = algoNames.get(1);
        
        // Print header on first run
        if (!headerPrinted) {
            printHeader(algo1Name, algo2Name);
            headerPrinted = true;
        }
        
        DetectionResult result1 = results.get(algo1Name);
        DetectionResult result2 = results.get(algo2Name);
        
        double time1 = result1.timeMs;
        double time2 = result2.timeMs;
        double timeDiff = Math.abs(time1 - time2);
        
        String winner = time1 < time2 ? algo1Name : algo2Name;
        
        System.out.printf("| %3d | %8.2f | %6d | %8.2f | %6d | %-6s | %7.2f |%n",
                run, time1, result1.fraudFound, time2, result2.fraudFound, winner, timeDiff);
    }

    @Override
    public void afterExperiment() {
        System.out.println("=".repeat(85));
        System.out.println("\n=== Experiment Completed ===");
        System.out.println();
    }
    
    private void printHeader(String algo1, String algo2) {
        System.out.println("=".repeat(85));
        System.out.printf("| %3s | %8s | %6s | %8s | %6s | %-6s | %7s |%n",
                "Run", algo1 + "(ms)", "Fraud", algo2 + "(ms)", "Fraud", "Winner", "Diff");
        System.out.println("=".repeat(85));
    }
}
