package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AviaSales implements Comparable<AviaSales> {
    private int id;
    private int price; // Стоимость билета
    private int time; // Время полета
    private String from; // Аэропорт вылета
    private String to; // Аэропорт прилета

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