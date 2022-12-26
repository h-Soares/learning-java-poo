package models.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private int roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private static DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(int roomNumber, LocalDate checkIn, LocalDate checkOut) {
        if(checkIn.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Check-in date must be future date!");
        if(checkOut.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Check-out date must be future date!");

        if(checkOut.isAfter(checkIn)) {
            this.roomNumber = roomNumber;
            this.checkIn = checkIn;
            this.checkOut = checkOut; 
        }
        else
            throw new IllegalArgumentException("Check-out date must be after check in date");
    }

    public long duration() {
        return Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay()).toDays();
    }

    public void updateDate(LocalDate checkIn, LocalDate checkOut) { //sem setters para as datas.
        if(checkIn.isAfter(this.checkIn))
            this.checkIn = checkIn;
        else
            throw new IllegalArgumentException("New check-in date must be after current check-in date");

        if(checkOut.isAfter(this.checkIn))
            this.checkOut = checkOut;
        else
        throw new IllegalArgumentException("New check-out date must be after current check-in date");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Reservation: Room " + roomNumber);
        sb.append(", check-in: " + checkIn.format(fmt));
        sb.append(", check-out: " + checkOut.format(fmt));
        sb.append(", " + duration() + " nights");

        return sb.toString();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    } 
}