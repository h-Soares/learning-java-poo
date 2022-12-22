package entities.enums;

public enum OrderStatus2 { //Dar um número para cada, usa construtor em cada um.
    WAITING(1),
    PROCESSING(2),
    DONE(3),
    DELIVERING(4),
    DELIVERED(5);

    public final int numberTest;

    OrderStatus2(int numberTest)
    {
        this.numberTest = numberTest;
    }
}
