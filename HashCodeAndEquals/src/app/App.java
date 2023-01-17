package app;

public class App {
    public static void main(String[] args) {
        /* Operações da classe Object para comparar a igualdade de objetos.
        Equals: LENTO, mas 100% de resposta. Compara se um objeto é igual ao outro, retornando TRUE OU FALSE.
            String a = "Maria";
            String b = "Alex";
            System.out.println(a.equals(b)); //false
            Por padrão, o método equals só retornará true se os dois objetos apontarem pro mesmo endereço de memória. É preciso sobrescrevê-lo.
        hashCode: RÁPIDO, mas resposta não é 100%, PEQUENA chance de falhar. Retorna um NÚMERO INTEIRO representando um código gerado a partir das informações do objeto.
            Dados com o MESMO CONTEÚDO terão o mesmo código Hash, MAS: new(...) --> hashCodes diferentes, pois são objetos diferentes (SE NÃO FOR SOBRESCRITO).
            Dados com o CONTEÚDO DIFERENTE terão diferentes código Hash.
            Se o código Hash de dois objetos for igual, MUITO PROVAVELMENTE eles são o mesmo objeto.
            Mas PODE OCORRER de objetos diferentes terem o mesmo hashCode -> Colisão. Pode acontecer, MAS É DIFÍCIL.
            "O código hash pode servir para identificar que algo é diferente mais rapidamente do que olhar um objeto enorme com o equals".
            String a = "Maria";
            String b = "Alex";
            System.out.println(a.hashCode()); //74113750
            System.out.println(b.hashCode()); //2043454

            String c = "Maria";
            System.out.println(a.hashCode()); //74113750
            System.out.println(c.hashCode()); //74113750
        Tipos comuns do Java já possuem esses métodos sobrepostos. Classes novas precisam sobrepor. 
        UMA MANEIRA DE USAR: procurar um hash code em uma lista muito grande, percorrendo todos os elementos da lista e comparando com o hash code procurado. Quando
            encontrar, confirmar se o hash code encontrado na lista representa realmente o mesmo objeto, utilizando equals. 
        COMO GERAR: Source action -> Generate hashCode() and equals()...
        "Com os hashCode() e equals() implementados, o equals só será executado nos objetos que tiverem o mesmo código hash, o que reforça o desempenho."
        RESUMINDO: Hash Code para a identificação a partir de uma pequena parte (ou não) do objeto, Equals para determinar a igualdade, pois 
            PODE OCORRER de objetos diferentes terem o mesmo hashCode.
        == compara as referências dos objetos. new(...) vai dar false, pois está CRIANDO uma nova referência no heap:
            Test1 test1 = new Test1("name");
            Test1 test1Two = new Test1("name");
                System.out.println(test1 == test1Two); //FALSE

            Test1 test1 = new Test1("name");
            Test1 test1Two = test1;
                System.out.println(test1 == test1Two); //TRUE

            Expressões Strings LITERAIS: "name", "Car".... (sem usar o new String("...")) são mantidas em um "pool de Strings" pela JVM e duas variáveis com 
            o mesmo literal String apontam para a MESMA POSIÇÃO NO HEAP.  
        */
    }
}