package app;

public class App {
    public static void main(String[] args) {
        /* Set<T> (interface) representa um conjunto de elementos e:
        não admite repetições;
        elementos não possuem posição;
        acesso, inserção e remoção de elementos são rápidos;
        tem operações eficientes de conjuntos: intersecção, união, diferença;
        Quando usar: quando a ordem não importar e não se quer repetições. É útil, também, para excluir as repetições de um ArrayList, com addAll ou pelo Construtor.
        Implementações:
            HashSet - mais rápido ( O(1) em tabela hash ) e não ordenado. É A MAIS USADA, pois é a MAIS RÁPIDA.
            TreeSet - mais lento ( O(longN) em árvore rubro-negra) e ordenado pelo compareTo ou Comparator do objeto. T tem que implementar Comparable<T> e 
                implementar compareTo. Por padrão, é ordenado em ordem ascendente.
            LinkedHashSet - velocidade intermediária e elementos na ordem em que são adicionados, pois é implementado como uma lista duplamente encadeada, em que
                cada elemento tem um ponteiro apontando para o elemento anterior e para o próximo. Segundo mais rápido.
        Métodos importantes:
            add(obj), remove(obj), contains(obj), são baseados em EQUALS e HASH CODE. Se equals e hashCode não existirem, é usada a comparação de ponteiros.
            clear(), size(), removeIf(predicate)
            addAll(other) - UNIÃO: adiciona no conjunto os elementos do conjunto other, sem repetição.
            retainAll(other) - INTERSECÇÃO: remove do conjunto os elementos não contidos em other. Resta apenas a intersecção.
            removeAll(other) - diferença: remove do conjunto os elementos contidos em other.
                addAll, retainAll e removeAll são parecidos com a Álgebra.
            Como Set testa igualdade:
                se hashCode e equals estiverem implementados, primeiro usa hashCode para achar, se achar, usa equals para confirmar.
                se hashCode e equals não estiverem implementados, compara as referências (ponteiros) dos objetos.
                hashCode e equals são herdados de Object e podem ser implementados novamente (sobrescritos).
                String, Integer, Double, etc. já possuem hashCode e equals implementados.
         */
    }
}