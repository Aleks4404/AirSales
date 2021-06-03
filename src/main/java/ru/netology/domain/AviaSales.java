package ru.netology.domain;

public class AviaSales implements Comparable<AviaSales>{
    private int id;
    private int price; // Стоимость билета
    private int time; // Время полета
    private String from; // Аэропорт вылета
    private String to; // Аэропорт прилета

    public AviaSales() {
    }

    public AviaSales(int id, int price, int time, String from, String to) {
        this.id = id;
        this.price = price;
        this.time = time;
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "AviaSales{" +
                "id=" + id +
                ", price=" + price +
                ", time=" + time +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }

    @Override
    public int compareTo(AviaSales comparePrice) {
        return this.price - comparePrice.price;
    }
}