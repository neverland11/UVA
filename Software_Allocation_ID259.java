/***
 * Max-flow question
 * Resource:https://f0rth3r3c0rd.wordpress.com/2011/10/06/uva-259-software-allocation/
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Software_Allocation_ID259 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (in.ready()) {
            // node 0 denotes source
            // nodes 1-26 denotes programs
            // nodes 27-36
            // node 37 denotes sink
            int[][] res = new int[38][38];
            for (int i = 27; i <= 36; i++) {
                //sink node
                res[i][37] = 1;
            }
            String inp;
            int target = 0; // the numbers we need(all lines)
            int maxflow = 0;
            //connect computer and software and source
            while (in.ready() && !(inp = in.readLine()).equals("")) {
                //source. record the number of computers we need.
                res[0][inp.charAt(0) - 'A' + 1] += inp.charAt(1) - '0';
                target += inp.charAt(1) - '0';
                // connect the available computers to the specific software
                for (int i = 3; inp.charAt(i) != ';'; i++)
                    res[inp.charAt(0) - 'A' + 1][inp.charAt(i) - '0' + 27] = 1;
            }
            char[] result = new char[10];
            Arrays.fill(result, '_');
            // Then we run max flow from source to sink
            boolean done = false;
            while (!done) {
                done = true;
                Queue<Integer> Q = new LinkedList<Integer>();
                int[] parent = new int[38];
                parent[0] = 0;
                Q.add(0);
                long vis = 1L;
                while (!Q.isEmpty()) {
                    int n = Q.poll();
                    if (n == 37) {
                        done = false;
                        break;
                    } else
                        for (int i = 0; i < res[n].length; i++)
                            if (res[n][i] > 0 && (vis & ((1L << i))) == 0) {
                                parent[i] = n;
                                vis |= (1L << i);
                                Q.add(i);
                            }
                }
                // then we augment the path found
                if (!done) {
                    maxflow++;
                    int node = 37;
                    while (parent[node] != node) {
                        res[parent[node]][node]--;
                        res[node][parent[node]]++;
                        node = parent[node];
                    }
                }
            }
            // now we generate the allocation from backward edges
            for (int i = 27; i < 37; i++)
                for (int j = 1; j < 27; j++)
                    if (res[i][j] == 1) {
                        result[i - 27] = (char) (j + 'A' - 1);
                        break;
                    }
            if (maxflow == target)
                System.out.println(new String(result));
            else
                System.out.println("!");
        }
    }
}