package application;
//import entities.*;

import java.time.LocalDateTime;

import entities.Order;
import entities.enums.OrderStatus;
import entities.enums.OrderStatus2;

public class JavaOne {  //Debbugger for Java - Console (para arrumar onde sai a mensagem) - 
    //PROGRAMAR EM INGLÊS!!
    public static void main(String[] args){ //Gerar Setter e Getters automaticamente: Na classe, Source Action - Generate Getters and Setters - Seleciona e dar OK.                                                                                   
        Order orderOne = new Order(1540, LocalDateTime.now(), OrderStatus.PROCESSING);
        System.out.println(orderOne);
        
        OrderStatus one = OrderStatus.WAITING;
        OrderStatus two = OrderStatus.valueOf("WAITING");

        System.out.println();
        System.out.println(one);
        System.out.println(two);
        System.out.println();

        for(OrderStatus order : OrderStatus.values())
            System.out.println(order);

        System.out.println(OrderStatus2.DELIVERED.numberTest);
        System.out.println(OrderStatus2.DELIVERED.ordinal());

        System.out.println();
        for(OrderStatus2 number : OrderStatus2.values())
            System.out.println(number.numberTest);
    }
}








