package app;

//import entities.PrintServiceNoGenerics;
import entities.PrintServiceWithGenerics;

public class App {
    public static void main(String[] args) {

        //Permitem que classes, interfaces e métodos possam ser parametrizados por tipo. Benefícios: Reuso, type safety, performance. 
        //Type safety (segurança de tipo): prevenir que erros de tipos aconteçam, como adicionar uma String a uma lista do tipo Object que contém apenas Integer.
        //Uso comum: em coleções, como as listas: List<Parametrizando> ... = ....;
        //Para parametrizar com Generics: nomeDaClasse<Tipo>, geralmente: nomeDaClasse<T> 
        
        /* 
        PrintServiceNoGenerics printServiceNoGenerics =  new PrintServiceNoGenerics();
        printServiceNoGenerics.addValue(10);
        printServiceNoGenerics.addValue(8);
        printServiceNoGenerics.addValue(23);

        PrintServiceNoGenerics.print();
        System.out.println();
        System.out.println(PrintServiceNoGenerics.first()); */

        PrintServiceWithGenerics<String> pswg = new PrintServiceWithGenerics<>();
        pswg.addValue("SPFC");
        pswg.addValue("SCCP");
        pswg.addValue("FLA");
        //Se trocasse para String funcionaria normalmente, com os argumentos String.

        pswg.print();
        System.out.println();
        System.out.println("FIRST: " + pswg.first());

        /* List<Object> NÃO É o super tipo de qualquer lista. Também serve para outras superclasses com suas subclasses.
            List<?> É o super tipo de qualquer lista. ?: tipo coringa:
            List<?> myObjs = new ArrayList<Object>();
            List<Integer> myIntegers = new ArrayList<>();
            myObjs = myIntegers; (upcasting)
        */
        //Com tipos coringas podemos fazer MÉTODOS que recebem um genérico de "qualquer tipo", como um argumento List<?> list e 
            //iterar usando for(Object obj : list) ....
        //Mas NÃO É POSSÍVEL adicionar dados a uma coleção de tipo coringa. 
        //Diferença entre criar a lista com "<?>" e" com <T>": 
            //com T o tipo vai ser setado em algum momento, já com o ? o tipo vai ser inferido em tempo de execução.
        //List<? super Tipo>: pode ser Tipo ou qualquer super tipo de Tipo. Atribuir listas...
        //Para aceitar uma lista que é subtipo de um Tipo: List<? extends Tipo> , aceita Tipo e suas subclasses. Mas ainda NÃO É
            //POSSÍVEL adicionar membros nessa lista. É possível fazer upcasting das listas, atribuindo à lista super tipo.
            //isso é a Covariância:
        //Princípio get/put - Covariância: get permitido, put negado.
        //Princípio get/put - Contravariância: get negado, put permitido:
            /* Ex: List<Object> myObjs = new ArrayList()<>;
                myObjs.add("Maria"); //permitido: String subtipo de Object.
                myObjs.add("Alex");

                //Super tipo de Number: Object
                List<? super Number> myNums = myObjs;
                myNums.add(10);
                myNums.add(3.14);
                myNums.add("Andrew");

                Number x = myNumbs.get(0) //não permitido: index 0 pode não ser um Number, pode ser uma String.
             */

        ////em geral: <T> T nomeDoMetodo(T obj)..., quando a classe não é parametrizada.
    }
}