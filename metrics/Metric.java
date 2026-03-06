package metrics;

import java.util.List;

public interface Metric<T> {
    String getName();
    double measure(List<T> data);
}
