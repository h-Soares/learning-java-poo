package app;

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat; //para formatar números na forma de determinado país ou região

public class App {
    public static void main(String[] args) {
        /* alguns valores double são representados aproximadamente. Qualquer aplicação que requer cálculos precisos de ponto
        flutuante — como aplicações financeiras — deve usar a classe BigDecimal (do pacote java.math). */
        BigDecimal test = BigDecimal.valueOf(Math.PI); //internamente, valueOf transforma em String. Melhor com String.
        System.out.println(test);
        test = test.add(BigDecimal.ONE); //também tem ZERO (0) e TEN (10)
        System.out.println(test);
        test = test.pow(2);
        System.out.println(test);
        System.out.println(NumberFormat.getCurrencyInstance().format(test)); //R$ 17,15; retorna a representação String específica da localidade, arredondada para dois dígitos à direita do ponto decimal.
        /* Se não for especificado como arredondar valores BigDecimal e um determinado
        valor não pode ser representado exatamente — como o resultado de 1 dividido por 3, que é 0,3333333... — ocorre uma
        ArithmeticException. 
        Pode-se especificar o modo de arredondamento para BigDecimal fornecendo um
        objeto MathContext (pacote java.math). Por padrão, cada MathContext pré-configurado usa o chamado “arredondamento contábil”,
        como usado na constante HALF_EVEN RoundingMode .
        O escalonamento de um BigDecimal é o número de dígitos à direita do ponto decimal. Se você precisa de um BigDecimal
        arredondado para um dígito específico, chame o método BigDecimal setScale. 
        A seguinte expressão retorna um BigDecimal com três dígitos à direita do ponto decimal e usa arredondamento contábil:
        System.out.println(test.setScale(3, RoundingMode.HALF_EVEN)); RoundingMode.HALF_EVEN e 4 casas decimais é o PADRÃO BRASILEIRO. */
        Scanner scan = new Scanner(System.in);
        BigDecimal test2 = new BigDecimal(scan.next()); //se for criar um Big Decimal pelo construtor, dar preferência à String.
        System.out.println(test2);
        scan.close();
        BigDecimal test3 = BigDecimal.valueOf(1);
        test3 = test3.divide(BigDecimal.valueOf(3), 100,  RoundingMode.HALF_EVEN);
        System.out.println(test3);
    }
}
