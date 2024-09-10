package fundamentals.chapter5;

public class UnionFindSecondVersion {
    private int[] id;
    private int count;

    public UnionFindSecondVersion(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    // Apesar de parecer mais rápido que a versão anterior,
    // por não ter que modificar cada um dos valores do componente
    // antigo, sempre que um novo componente é criado,
    // o quick-union, dependendo da ordem das entradas,
    // pode ter o tempo de complexidade de O(N²), iguai ao
    // quick-find.
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (qRoot == pRoot) return;

        id[qRoot] = pRoot;

        count--;
    }
}
