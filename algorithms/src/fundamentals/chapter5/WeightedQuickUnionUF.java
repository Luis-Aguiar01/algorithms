package fundamentals.chapter5;

public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnionUF(int N) {
        count = N;

        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;

        sz = new int[N];
        for (int i = 0; i < N; i++)
            sz[i] = 1;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    // Esse algoritmo é mais eficiente do que os dois últimos, pois
    // a sua complexidade de tempo é logarítmica. Como adicionamos
    // a menor árvore a maior, as árvores produzidas pelo algoritmo
    // tem uma tendência a terem poucos níveis, e a cada nova árvore
    // adicionada, é necessário apenas uma verificação a mais para chegar
    // até a raiz. As árvores crescem em 2^n, sendo o 2 representando a
    // quantidade de nós e o n representando os níveis. Ou seja, para dobrarmos
    // o tamanho de uma árvore com 4 nós (2²), só precisamos adicionar mais um nível,
    // ou seja, 8 = (2³). Dessa forma, podemos garantir que as árvores não cresçam
    // muito em profundidade, o que diminui a quantidade de verificações até
    // chegar ao nó raiz.
    public void union(int p, int q) {
        int i = find(p); // root of tree for p.
        int j = find(q); // root of tree for q.

        if (i == j) return; // Os dois já fazem parte do mesmo componente.

        // Verifica o peso das árvores antes de conectá-las.
        // Sempre adiciona a menor árvore a maior.
        if (sz[i] > sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }

        count--;
    }
}
