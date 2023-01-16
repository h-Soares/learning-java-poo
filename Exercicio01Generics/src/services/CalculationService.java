package services;

import java.util.List;

public class CalculationService {
    public static <T extends Comparable<? super T >> T max(List<T> list) { //um MÉTODO genérico (do tipo T qualquer) que implementa a interface Comparable.
        if(list.isEmpty()) //<T extends Comparable<? super T >> : T ou qualquer super classe de T.                                          
            throw new IllegalStateException("The list can't be empty");
        
        T max = list.get(0);
        for(T member : list) {
            if(member.compareTo(max) > 0)
                max = member;
        }
        return max;
        //T extends Comparable por causa do implements Comparable que implementamos na classe, ela que viabiliza essa volta
            //pra usar como extends.
        //nesse caso T pode ser qualquer tipo que implementa Comparable<T>, ou então um tipo que herda de um tipo que 
        //  implementa Comparable<T>.

        //em geral: <T> T nomeDoMetodo(T obj)..., quando a classe não é parametrizada.
    }
}