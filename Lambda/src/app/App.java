package app;

import java.math.BigDecimal;
import java.util.ArrayList;
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

        EX:    
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
    }
}