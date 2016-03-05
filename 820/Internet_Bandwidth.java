import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ge on 16/3/3.
 *
 * Resource:https://sites.google.com/site/indy256/algo/edmonds_karp
 *
 * ID:820 - Internet Bandwidth
 */
public class Internet_Bandwidth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        while (true) {
            int nodes = scanner.nextInt();
            if(nodes == 0){
                System.exit(0);
            }

            MaxFlowEdmondsKarp max = new MaxFlowEdmondsKarp();
            List<MaxFlowEdmondsKarp.Edge>[] graph = max.createGraph(nodes + 2);


            int source = scanner.nextInt();
            int end = scanner.nextInt();
            int lines = scanner.nextInt();
            scanner.nextLine();
            for(int i = 0; i < lines; i++){
                String str = scanner.nextLine();
                String[] temp;
                temp = str.split(" ");
                int[] desribe = new int[3];
                for (int j = 0; j < temp.length; j++) {
                    desribe[j] = Integer.parseInt(temp[j]);
                }
                max.addEdge(graph, desribe[0], desribe[1], desribe[2]);
                max.addEdge(graph, desribe[1], desribe[0], desribe[2]);
                max.addEdge(graph, 0, desribe[0], 0);
                max.addEdge(graph, desribe[1], nodes+1, 0);
            }

            int result = max.maxFlow(graph, source, end);

            System.out.printf("Network %d\n", count);
            System.out.printf("The bandwidth is %d.\n", result);
            System.out.println();
            count++;
        }
    }
}


class MaxFlowEdmondsKarp {
    static class Edge {
        int s, t, rev, cap, f;

        public Edge(int s, int t, int rev, int cap) {
            this.s = s;
            this.t = t;
            this.rev = rev;
            this.cap = cap;
        }
    }

    public static List<Edge>[] createGraph(int nodes) {
        List<Edge>[] graph = new List[nodes];
        for (int i = 0; i < nodes; i++)
            graph[i] = new ArrayList<>();
        return graph;
    }

    public static void addEdge(List<Edge>[] graph, int s, int t, int cap) {
        graph[s].add(new Edge(s, t, graph[t].size(), cap));
        graph[t].add(new Edge(t, s, graph[s].size() - 1, 0));
    }

    public static int maxFlow(List<Edge>[] graph, int s, int t) {
        int flow = 0;
        int[] q = new int[graph.length];
        while (true) {
            int qt = 0;
            q[qt++] = s;
            Edge[] pred = new Edge[graph.length];
            for (int qh = 0; qh < qt && pred[t] == null; qh++) {
                int cur = q[qh];
                for (Edge e : graph[cur]) {
                    if (pred[e.t] == null && e.cap > e.f) {
                        pred[e.t] = e;
                        q[qt++] = e.t;
                    }
                }
            }
            if (pred[t] == null)
                break;
            int df = Integer.MAX_VALUE;
            for (int u = t; u != s; u = pred[u].s)
                df = Math.min(df, pred[u].cap - pred[u].f);
            for (int u = t; u != s; u = pred[u].s) {
                pred[u].f += df;
                graph[pred[u].t].get(pred[u].rev).f -= df;
            }
            flow += df;
        }
        return flow;
    }
}