package app;

public class App {
    public static void main(String[] args) {
        /* Map<K,V> : K = Key;  V = Value.
        É uma coleção de pares chave/valor.
        Não admite repetições da chave no mesmo map. Se ocorrer, o value é sobrescrito, mas apenas uma chave é permitida.
        Os elementos são indexados pelo objeto chave e não possuem posição.
        Acesso, inserção e remoção de elementos são rápidos.
        Uso comum: cookies, local storage, qualquer modelo chave-valor.

        Implementações:
        HashMap - mais rápido (O(1) em tabela hash) e não ordenado.
        TreeMap - mais lento (O(logN) em árvore rubro-negra) e ordenado pelo compareTo do objeto ou por Comparator.
        LinkedHashMap - velocidade intermediária e elementos na ordem em que são inseridos.

        Métodos importantes:
        put(key,value) , remove(key) - remove a chave e o value associado a ela , containsKey(key) , get(key) - retorna o value associado a key. Se essa key não existir, retorna null. | são baseados em hashCode e equals.
            Se hashCode e equals não existirem, é usada a comparação de ponteiros.
        clear(), size(), keySet() - retorna um Set<K> , values() - retorna um Collection<V>
         */
    }
}