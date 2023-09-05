import java.util.*;

public class Main {
    static int[] dsu;
    static int[] size;

    // Функция для инициализации DSU
    static void initializeDSU(int n) {
        dsu = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dsu[i] = i;
            size[i] = 1;
        }
    }

    // Функция для нахождения корня элемента
    static int findRoot(int x) {
        if (dsu[x] == x)
            return x;
        dsu[x] = findRoot(dsu[x]);
        return dsu[x];
    }

    // Функция для объединения двух элементов
    static void union(int x, int y) {
        int rootX = findRoot(x);
        int rootY = findRoot(y);
        if (rootX != rootY) {
            if (size[rootX] < size[rootY]) {
                int temp = rootX;
                rootX = rootY;
                rootY = temp;
            }
            dsu[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        initializeDSU(n);

        List<String> results = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int queryType = scanner.nextInt();
            if (queryType == 1) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                union(x, y);
            } else if (queryType == 2) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int rootX = findRoot(x);
                int rootY = findRoot(y);
                if (rootX == rootY) {
                    results.add("YES");
                } else {
                    results.add("NO");
                }
            } else if (queryType == 3) {
                int x = scanner.nextInt();
                int rootX = findRoot(x);
                results.add(Integer.toString(size[rootX]));
            }
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}
