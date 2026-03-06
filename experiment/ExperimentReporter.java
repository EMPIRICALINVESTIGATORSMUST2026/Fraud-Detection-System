package experiment;

import fraud.DetectionResult;
import java.util.Map;

public interface ExperimentReporter {
    void beforeExperiment();
    void reportRun(int run, String algorithmName, DetectionResult result, Map<String, Double> metrics);
    void reportRunComplete(int run, Map<String, DetectionResult> results);
    void afterExperiment();
}
