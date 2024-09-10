package fundamentals.chapter5;

public class UnionFindFirstVersion {
    private int[] id;
    private int count;

    public UnionFindFirstVersion(int N) {
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

    // Quick-find: A operação find é rápida, só precisa de uma única verificação no array,
    // o que a torna uma operação de tempo constante O(1).
    public int find(int p) {
        return id[p];
    }

    // A operação Union é muito custosa, seguindo essa implementação, pois
    // como ela precisa alterar todas as correspondências de uma nova união,
    // para que os componentes sejam iguais ao novo, ela precisa percorrer
    // o array inteiro, mudando cada um dos valores do componente antigo para o
    // novo. Considerando que temos N sites, e que para termos apenas um único
    // componente ao fim do programa, é necessário N - 1 processamentos de union,
    // ou seja, vamos precisar percorrer o array inteiro com relação a quantidade
    // de componentes inseridos inicialmente. Dessa forma, a operação union tem
    // a complexidade de tempo de O(N²), pois precisa, para cada um dos componentes
    // originais, percorrer o array todo.
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }

        count--;
    }
}
