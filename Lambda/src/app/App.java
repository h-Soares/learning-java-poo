package app;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import entities.Product;

public class App {
    public static void main(String[] args) {
        /* Expressão lambda é uma FUNÇÃO anônima de primeira classe.
        Função anônima: função não declarada, sem nome.
        De primeira classe: pode ser passada como argumento para outras funções. Também pode ser retornada.

        Uma interface funcional é uma interface que contém APENAS UM MÉTODO ABSTRATO (obrigatório implementar). Pode ter defaults.
            Suas implementações podem ser tratadas como expressões lambda, ao invés de criar uma classe e implementar.
            Isso quer dizer que uma interface funcional tem um mapeamento direto com uma expressão lambda.
            "Podemos dizer que uma expressão lambda representa a implementação do método abstrato da interface funcional".
            O Lambda PRECISA estar em uma associação com uma interface funcional! 
        
        Programação imperativa se preocupa com como o problema será resolvido nos mínimos detalhes, os passos etc. Java, no geral,
            é assim.
        Já na programação funcional, que é declarativa, nos preocupamos mais com o que precisa ser resolvido, feito. 
            O processo imperativo ainda existe, mas a sequência de comandos é abstraída pela API do Java, e nós temos que 
            apenas dizer o que fazer.
        
        A grande vantagem de funções lambda é diminuir a quantidade de código necessária para a escrita de algumas funções.

        Method Reference é uma forma de escrever uma expressão lambda de forma reduzida, quando é preciso chamar um único método já existente.

        O .toList() de stream() foi introduzido no java 16. Diferenças:
            collect(toList()): é mutável e permite nulos.
            collect(toUnmodifiableList()): é imutável e não permite nulos.
            toList(): é imutável e permite nulos.
                
        A função map() é uma função que aplica uma função a todos os elementos de uma stream (fluxos/sequência de dados) 

        Interfaces funcionais comumente usadas: 
            Predicate (boolean) -> verifica
            Consumer (void) -> executa
            Function (R) -> recebe um parâmetro do tipo T e devolve um tipo R. É Function<T,R> 

        EX1:    
         */

        List<Product> products = new ArrayList<>();

        products.add(new Product("TV", BigDecimal.valueOf(900)));
        products.add(new Product("Mouse", BigDecimal.valueOf(50)));
        products.add(new Product("Tablet", BigDecimal.valueOf(350.50)));
        products.add(new Product("HD Case", BigDecimal.valueOf(80.90)));

        products.forEach(p -> System.out.println(p));

        //products.removeIf(p -> p.getPrice().compareTo(BigDecimal.valueOf(100)) >= 0); //Predicate (boolean) -> verifica

        System.out.println();
        products.forEach(p -> System.out.println(p)); //Consumer (void) -> executa

        products.forEach(p -> p.setPrice(p.getPrice().multiply(BigDecimal.valueOf(1.10)))); //aumenta o preço em 10%

        System.out.println();
        products.forEach(System.out::println); //Method Reference

        List<String> productNames = products.stream().map(Product::getName).toList(); //toList retorna uma lista IMUTÁVEL (ImmutableCollections) (não pode add nem sort.)
        System.out.println(productNames);

        BigDecimal sum =  products.stream().filter(p -> p.getName().startsWith("T")).map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sum);
        String name = products.stream().filter(p -> p.getName().startsWith("T")).map(Product::getName).findFirst().get(); //get como String, e não como Optional
        System.out.println(name);

        //EX2:
        List<String> names = new ArrayList<>(Arrays.asList("Z", "Bob", "Trent", "Ana", "Tom", "Joana", "Karl", "Jhon", "Zelius", "Zion"));
        //Stream<Character> namesT = names.stream().filter(name -> name.startsWith("J")).map(name -> name.charAt(1));
        //System.out.println(Arrays.toString(namesT.toArray()));
        names.stream().filter(name2 -> name2.startsWith("T")).forEach(System.out::println);

        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int sum2 = nums.stream().filter(n -> n % 2 == 0).map(n -> n * 10).mapToInt(Integer::intValue).sum();
        System.out.println(sum2);
        System.out.println();
        names.stream().sorted(Comparator.comparingInt(String::length)).limit(3).forEach(System.out::println); 
        System.out.println();
        sum2 = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum2);

        List<Integer> nums2 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        System.out.println(nums2.stream().reduce(0, Integer::sum));

        //STREAMS: 
        /* Uma stream é uma sequência de elementos advinda de uma fonte de dados (coleção, array, iteração, E/S...) que 
            oferece suporte a "operações agregadas". 
        Para grandes quantidades de dados, a Streams API oferece a possibilidade de trabalhar com esses dados de forma paralela, 
            viabilizando uma melhora de desempenho ao tirar proveito do poder de processamento dos computadores modernos.
            Basta trocar o método stream() por parallelStream(). Dessa forma a Streams API irá decompor as ações em várias subtarefas, 
            e as operações serão processadas em paralelo, explorando os recursos oferecidos pelos diversos núcleos do processador.
        
        Streams não armazenam nem modificam os elementos originais. Eles são processados sob demanda;
        Podem ser usada, também, com a interface Map.
        Operações intermediárias: retornam novas streams.
        Operações terminais: retornam algo diferente de streams.
        Operações intermediárias são realizadas apenas quando uma operação terminal é invocada.
        
        Pipeline: Streams são projetadas de tal maneira que a maior parte de suas operações retornam novas streams 
            (operações intermediárias). Dessa forma, é possível criar uma cadeia de operações que formam um fluxo de processamento. 
            Isso é pipeline em java.
        Quando for fazer map com tipos primitivos, fazer mapToInt, mapToDouble etc.. Para evitar overhead.

        O método collect() possibilita coletar os elementos de uma stream na forma de coleções: List, Set ou Map.
        O método count() retorna a quantidade de elementos presentes em uma stream
        o método allMatch() verifica se TODOS os elementos de uma stream atendem a um critério passado como parâmetro, através de
            um Predicate, e retorna um valor boolean.

        Reduce(VALOR_INICIAL, (x, y) -> operação): faz uma operação tendo como valor inicial o VALOR_INICIAL. VALOR_INICIAL recomendado:
            SOMA/SUBTRAÇÃO: 0.    MULTIPLICAÇÃO/DIVISÃO: 1.
        IMPORTANTE: quando for fazer alguma operação, utilizar mapTo... para evitar overhead e boxing and unboxing.
        IMPORTANTE: usar map antes de filter. Porque se fizer filter -> map, determinado método é invocado duas vezes: 
            uma vez dentro do filtro e depois na função de mapeamento. A operação de mapeamento faz parte da operação de filtragem.
        
         Para criar uma stream de linhas a partir do conteúdo de um arquivo texto (I/O), podemos chamar o 
            método estático Files.lines(Path path). Assim, é possível descobrir a quantidade de linhas que um arquivo possui, 
            entre outros. Stream<String> stream = Files.lines(Path path).

        Mais informações: PDF Nélio e https://www.oracle.com/br/technical-resources/articles/java-stream-api.html .
         */
    }
}