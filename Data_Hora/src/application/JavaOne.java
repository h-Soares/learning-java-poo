package application;
//import entities.*;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;;

public class JavaOne {  //Debbugger for Java - Console (para arrumar onde sai a mensagem) - 
    //PROGRAMAR EM INGLÊS!!
    public static void main(String[] args){ //Gerar Setter e Getters automaticamente: Na classe, Source Action - Generate Getters and Setters - Seleciona e dar OK.                                                                                   
        //em 2022-07-23T14:52:09-03:00 , -03:00 representa o atraso em relação ao Z: Zulu Time (GMT), 3 horas de atraso. Seguir o padrão.
        //GMT também é chamado de UTC.

        LocalDate data01 = LocalDate.now(); //data LOCAL atual.
        System.out.println(data01);
        //Resultado: 2022-12-19  ano-mês-dia

        LocalDateTime data02 = LocalDateTime.now();
        System.out.println(data02);
        //Resultado: 2022-12-19T21:23:48.765871300  T significa Time. 48.765871300 significa 48 segundos e os milissegundos.
        //Thoras:minutos:segundos

        Instant data03 = Instant.now();
        System.out.println(data03);
        //Resultado: 2022-12-20T00:27:06.126800300Z  Z significa Zulu Time (GMT), é o horário de Londres, a referência global.

        LocalDate data04 = LocalDate.parse("2023-03-07");
        System.out.println(data04);
        //Resultado: 2023-03-07   Transforma um texto padrão ISO 8601 em forma de data.

        LocalDateTime data05 = LocalDateTime.parse("2023-03-07T00:00:00");
        System.out.println(data05);
        //Resultado: 2023-03-07T00:00  Transforma um texto padrão ISO 8601 em forma de data e hora.

        Instant data06 = Instant.parse("2023-09-03T12:59:53Z");
        System.out.println(data06);
        //Resultado: 2023-09-03T12:59:53Z Transforma um texto padrão ISO 8601 em forma de data e hora em relação ao Zulu Time (GMT).

        Instant data07 = Instant.parse("2023-09-03T12:59:53-03:00");
        System.out.println(data07);
        //Resultado: 2023-09-03T15:59:53Z  3 horas adiante, pois atrasa 3, mas em Z está adiantando 3, e o resultado sai em Z.

        DateTimeFormatter formato01 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //estabelece um padrão  dia/mês/ano.
        LocalDate data08 = LocalDate.parse("07/03/2023", formato01);
        System.out.println(data08);
        //Resultado: 2023-03-07  converte de um padrão para o padrão ISO 8601.

        DateTimeFormatter formato02 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); //estabelece um padrão dia/mês/ano horas:minutos. 
        LocalDateTime data09 = LocalDateTime.parse("07/03/2023 00:00", formato02);
        System.out.println(data09);
        //Resultado: 2023-03-07T00:00  converte de um padrão para o padrão ISO 8601.

        LocalDate data10 = LocalDate.of(2023, 3, 7);
        System.out.println(data10);
        //Resultado: 2023-03-07  converte ano, mês e dia, isoladamente, para o padrão ISO 8601.

        //LocalDate data04 = LocalDate.parse("2023-03-07");
        //DateTimeFormatter formato01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(data04.format(formato01));
        //Resultado: 07/03/2023  converte de ISO 8601 para um determinado padrão.

        //LocalDateTime data05 = LocalDateTime.parse("2023-03-07T00:00:00");
        //DateTimeFormatter formato02 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println(data05.format(formato01));
        System.out.println(data05.format(formato02));

        //Para fazer um format em uma data Instant (global) é preciso especificar um fuso - horário.
        DateTimeFormatter formato03 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        //Considerando o fuso - horário da máquina que está rodando o programa. 
        //Instant não tem método format, assim, deve-se usar o método format de formato 03.
        //Instant data06 = Instant.parse("2023-09-03T12:59:53Z");
        System.out.println(formato03.format(data06));
        //Resultado: 03/09/2023 09:59  do padrão ISO 8601 para determinado padrão de data e GMT-3.

        //Também é possível fazer DateTimeFormatter formato = DateTimeFormatter.(...) e escolher uma das opções de padrão. 

        //CONVERTER GLOBAL PARA LOCAL:
        //Instant data06 = Instant.parse("2023-09-03T12:59:53Z");
        LocalDateTime convert1 = LocalDateTime.ofInstant(data06, ZoneId.systemDefault());  
        System.out.println(convert1);
        //Resultado: 2023-09-03T09:59:53  3 horas antes, GMT -3 em São Paulo.

        LocalDateTime convert2 = LocalDateTime.ofInstant(data06, ZoneId.of("Japan"));
        System.out.println(convert2);
        //Resultado: 2023-09-03T21:59:53  9 horas adiante, no Japão em relação à Londres. */

         
        //PEGAR DIA, MÊS OU ANO DE UMA DATA:
        //LocalDate data04 = LocalDate.parse("2023-03-07");
        System.out.println(data04.getYear()); //entre outros get... Horas, etc... 

        //CÁLCULOS COM DATA E HORA, DURAÇÃO
        
        //LocalDate data04 = LocalDate.parse("2023-03-07");
        LocalDate data04plusOneYear = data04.plusYears(3); //entre outros... Mês, dias, etc. Menos(minus), mais (plus)....
        System.out.println(data04plusOneYear);  //Para LocalDateTime é o mesmo.

        //Instant data06 = Instant.parse("2023-09-03T12:59:53Z"); 
        Instant data06plusOneYear = data06.minus(3, ChronoUnit.DAYS); //Hours, weeks, month.... 
        System.out.println(data06plusOneYear); //com anos dá problema, melhor passar para a LocalDate.
        //Problema no ChronoUnit.YEARS: You will need to convert the instant to a LocalDateTime and then add units like years.

        //LocalDate data04 = LocalDate.parse("2023-03-07");
        LocalDate data04plusOneWeek = data04.plusWeeks(3);
        System.out.println(ChronoUnit.DAYS.between(data04, data04plusOneWeek)); //Para LocalDate. Se quiser segundos, horas.. Passar para LocalDateTime, com
                                                                                //(nome).atStartOfDay nos dois!! E usar o Duration.between
        //LocalDateTime data05 = LocalDateTime.parse("2023-03-07T00:00:00"); 
        LocalDateTime data05plusOneWeek = data05.plusWeeks(3);
        Duration duration01 = Duration.between(data05, data05plusOneWeek); //Esse funciona com LocalDateTime! 
        System.out.println(duration01.toSeconds());

        //Para Instant é a mesma coisa. 

        //Também é bom utilizar a classe Period.

        for(String name : ZoneId.getAvailableZoneIds()) //fusos - horários permitidos.
            System.out.println(name);

        LocalDateTime teste = LocalDateTime.now(ZoneId.of("Japan")).withNano(0); //Horário local para o do japão, sem os milissegundos.
        System.out.println(teste);   
    }
}








