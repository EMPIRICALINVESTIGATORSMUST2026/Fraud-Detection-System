package metrics;

import java.util.List;
import java.util.Map;

public class MeasurementContext<T> {
    private final String goal;
    private final String question;
    private final List<Metric<T>> metrics;
    private final Map<String, Object> parameters;

    public MeasurementContext(
            String goal,
            String question,
            List<Metric<T>> metrics,
            Map<String, Object> parameters
    ) {
        this.goal = goal;
        this.question = question;
        this.metrics = metrics;
        this.parameters = parameters;
    }

    public String getGoal() { return goal; }
    public String getQuestion() { return question; }
    public List<Metric<T>> getMetrics() { return metrics; }
    public Map<String, Object> getParameters() { return parameters; }
}
