package entities.enums;

public enum OrderStatus { //no Construtor não se usa nada antes.
    WAITING,    //ordinal 0          //se for escrito um que não existe, ocorre uma exceção.       
    PROCESSING, //ordinal 1
    DONE,       //ordinal 2         .ordinal();
    DELIVERING, //ordinal 3
    DELIVERED;  //ordinal 4
}
