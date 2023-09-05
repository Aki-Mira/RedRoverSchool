import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        List<Edge> edges = new ArrayList<>();
        int maxWeight = 0;

        for (int i = 0; i < m; i++) {
            String[] roadInfo = reader.readLine().split(" ");
            int u = Integer.parseInt(roadInfo[0]);
            int v = Integer.parseInt(roadInfo[1]);
            int w = Integer.parseInt(roadInfo[2]);
            edges.add(new Edge(u, v, w));
            maxWeight = Math.max(maxWeight, w);
        }

        int left = 0;
        int right = maxWeight;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canKeepStates(n, edges, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    static class Edge {
        int u, v, weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static class DSU {
        int[] parent;
        int[] size;

        public DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int u) {
            if (u == parent[u]) return u;
            return parent[u] = find(parent[u]);
        }

        boolean union(int u, int v) {
            u = find(u);
            v = find(v);
            if (u != v) {
                if (size[u] < size[v]) {
                    int temp = u;
                    u = v;
                    v = temp;
                }
                parent[v] = u;
                size[u] += size[v];
                return true;
            }
            return false;
        }
    }

    static boolean canKeepStates(int n, List<Edge> edges, int x) {
        Collections.sort(edges, Comparator.comparingInt(e -> e.weight));
        DSU dsu = new DSU(n);

        for (Edge edge : edges) {
            if (edge.weight <= x && dsu.union(edge.u, edge.v)) {
                n--;
            }
        }

        return n == 1;
    }
}
