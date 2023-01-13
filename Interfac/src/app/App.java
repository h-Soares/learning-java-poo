package app;

public class App {
    public static void main(String[] args) {
        //CONCEITO PADRÃO: é parecido com uma classe abstrata, com métodos abstratos. Uma classe pode implementar várias interfaces:
        //fazendo implements Interface1, Interface2, ..., InterfaceN.
        //Estabelece um contrato que a classe deve seguir. Também é uma relação do tipo É UM --> Polimorfismo.
        //Qualquer interface que contém um único método é conhecida como interface funcional.
        //Não possuem construtores. 
        //Uma interface pode declarar constantes. As constantes são implicitamente public, static e final (não precisa escrever). É 
        //melhor usar se TODAS as classes que implementam a interface forem utilizar essas constantes. É comum ter uma INTERFACE DE
        //CONSTANTES.
        //Todos os métodos declarados em uma interface são implicitamente métodos public abstract (não precisa escrever).
        //Permite que objetos de classes não relacionadas sejam processados polimorficamente.
        /*HERANÇA x INTERFACE: 
          Herança: reúso (de atributos, métodos, etc.).  Interface: contrato a ser seguido. */
        //É útil para minimizar a dependência entre classes (útil em composição) e para deixar a manutenção menos dificultosa.
        //Uma interface é abstrata, seus métodos são abstratos e suas variáveis são static final
        //"O problema é que se você instanciar as dependências dentro da classe que você está trabalhando você vai acoplar 
        //essas classes."
        /* ""Dependa em abstrações e não em implementações concretas". Isso significa basicamente, que se as dependências 
        de um de seus componentes são instâncias concretas vai ficar mais difícil pra você manter o software, você vai ter 
        que mexer em um código que está muito acoplado."" */
        //"Em OOP para reduzir o acoplamento devemos programar para a INTERFACE e não para a implementação."
        //"A boa prática é desenvolver sempre orientado a interfaces."
        //Assim: private nomeInterface... e quando for instanciar essa classe que tem uma interface, passar como argumento,
        //no construtor dessa classe, na CLASSE PRINCIPAL, a classe que implementa a interface (upcasting).
        //No construtor da classe que tem uma interface, passar a interface como argumento.
        /*Inversão de controle: padrão de desenvolvimento que consiste em retirar da classe a responsabilidade de instanciar 
        suas dependências.  O responsável, geralmente, é a classe principal. */
        /* Injeção de dependência - uma das formas de realizar a inversão de controle: um componente externo instancia a dependência,
        que é então injetada no objeto "pai".  O responsável, geralmente, é o Construtor. */   

        /* A coesão é o grau com o qual um módulo tem uma responsabilidade única e bem definida. 
        O acoplamento é o grau com o qual um módulo depende de outros módulos para seu funcionamento. 
        O ideal, para que um sistema seja flexível e compreensível, são módulos com alta coesão e baixo acoplamento. */

        //A interface Comparable<T> define os critérios de comparação de uma classe. É preciso implementá-la em uma classe 
        //que deseja ordenar em uma lista. < 0; = 0; > 0; para menor, igual ou maior na comparação, respectivamente.
        //essa interface possui apenas um método: int compareTo(T outro); nesse T coloca-se a própria classe.
        //"O Comparable permite que uma instância de classe seja comparada com outra instância dela mesma."

        //CONCEITO DEFAULT METHODS:  exemplificado em Exercicio03Interface
        //A partir do Java 8, interfaces podem conter métodos concretos.
        //Serve para evitar a repetição de implementação em toda classe que implemente a interface e também a necessidade de 
        //se criar classes abstratas para fazer reuso da implementação. 
        //Usa-se quando, EM UMA FUNÇÃO, os parâmetros, contas a serem feitas, etc. são os MESMOS para algumas classes que implementam
        //a interface. No lugar de public usa-se DEFAULT. Pode ser sobrescrito.

        /* De acordo com a especificação da linguagem Java, o estilo adequado é declarar métodos abstract de uma interface sem as 
        palavras-chave public e abstract, porque elas são redundantes nas declarações de método da interface. De maneira semelhante, as
        constantes da interface devem ser declaradas sem as palavras-chave public, static e final, porque elas também são redundantes.*/
    }
}