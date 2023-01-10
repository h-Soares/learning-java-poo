package app;

public class App {
    public static void main(String[] args) {
        //CONCEITO PADRÃO: é parecido com uma classe abstrata, com métodos abstratos. Uma classe pode implementar várias interfaces.
        //Estabelece um contrato que a classe deve seguir.
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
    }
}