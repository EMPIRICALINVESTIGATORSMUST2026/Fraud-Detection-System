package experiment;

import fraud.DetectionResult;
import fraud.Transaction;
import fraud.algo.Algorithm;
import metrics.Metric;
import java.util.*;

public class Experiment {

    private final List<Algorithm> algorithms;
    private final List<Metric<DetectionResult>> metrics;
    private final List<Map<String, Object>> paramsList;

    public Experiment() {
        this.algorithms = new ArrayList<>();
        this.metrics = new ArrayList<>();
        this.paramsList = new ArrayList<>();
    }

    public void addAlgorithm(Algorithm algo) {
        algorithms.add(algo);
    }

    public void addMetric(Metric<DetectionResult> metric) {
        metrics.add(metric);
    }

    public void addParameters(Map<String, Object> params) {
        paramsList.add(params);
    }

    public void run(
            List<Transaction> data,
            int numRuns,
            ExperimentReporter reporter
    ) {
        reporter.beforeExperiment();

        for (int run = 1; run <= numRuns; run++) {
            Map<String, DetectionResult> runResults = new HashMap<>();

            for (Algorithm algo : algorithms) {
                DetectionResult result =
                    algo.analyze(data, paramsList.get(0));

                Map<String, Double> metricValues = new HashMap<>();
                for (Metric<DetectionResult> m : metrics) {
                    metricValues.put(m.getName(), m.measure(List.of(result)));
                }

                runResults.put(algo.getName(), result);
                reporter.reportRun(run, algo.getName(), result, metricValues);
            }
            
            // Report all results for this run together
            reporter.reportRunComplete(run, runResults);
        }

        reporter.afterExperiment();
    }
}
