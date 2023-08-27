package app;

import java.util.HashMap;
import java.util.Map;

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
        TreeMap - mais lento (O(logN) em árvore rubro-negra) e ordenado pela CHAVE.
        LinkedHashMap - velocidade intermediária e elementos na ordem em que são inseridos.

        Métodos importantes:
        put(key,value) , remove(key) - remove a chave e o value associado a ela , containsKey(key) , get(key) - retorna o value associado a key. Se essa key não existir, retorna null. | são baseados em hashCode e equals.
            Se hashCode e equals não existirem NA KEY (tem que ter) (também implementar em VALUE), é usada a comparação de ponteiros.
        clear(), size(), keySet() - retorna um Set<K> , values() - retorna um Collection<V>
         */
        
        Map<String, String> infos = new HashMap<>();

        infos.put("username", "jhon");
        infos.put("email", "jhon321@gmail.com");
        infos.put("phone", "401575425");


        //infos.remove("phone");
        //infos.put("phone", "32155");

        for(String info : infos.keySet())
            System.out.println(info + ": " + infos.get(info));

        System.out.println(infos.containsKey("username"));

        Map<String, Integer> election = new HashMap<>();
        election.put("Alex", 10);
        election.put("Joana", 15);
        System.out.println(election);
        System.out.println();

        if(election.containsKey("Alex")) { //fazer assim no exercício
            election.replace("Alex", election.get("Alex") + 10);
        }
        System.out.println(election);
    }
}
