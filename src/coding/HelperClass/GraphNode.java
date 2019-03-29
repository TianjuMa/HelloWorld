package coding.HelperClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matinaju on 6/10/17.
 */
public class GraphNode {
    public final int key;
    public List<GraphNode> neighbors;

    public GraphNode(int key) {
        this.key = key;
        neighbors = new ArrayList<>();
    }
}
