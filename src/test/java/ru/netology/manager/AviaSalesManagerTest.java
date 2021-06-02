package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.AviaSales;
import ru.netology.repository.AviaSalesRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

class AviaSalesManagerTest {
    private AviaSalesRepository repository = new AviaSalesRepository();
    private AviaSalesManager manager = new AviaSalesManager(repository);
    private AviaSales first = new AviaSales(1, 3_390, 60, "KUF", "DME");
    private AviaSales second = new AviaSales(2, 4_080, 60, "KUF", "LED");
    private AviaSales thirst = new AviaSales(3, 4_000, 60, "KUF", "RTW");
    private AviaSales fourth = new AviaSales(4, 13_340, 60, "KUF", "KHV");
    private AviaSales fifth = new AviaSales(5, 2_585, 60, "KUF", "SVO");
    private AviaSales sixth = new AviaSales(6, 2_900, 60, "KUF", "LED");

    @BeforeEach
    public void setup() {
        repository.save(first);
        repository.save(second);
        repository.save(thirst);
        repository.save(fourth);
        repository.save(fifth);

    }

    @Test // Тест использование метода переопределения
    public void shouldEseOverridedMethod() {
        AviaSales aviaSales = new AviaSales();
        aviaSales.toString();
    }

    @Test // тест добавления еще одного элемента
    public void shouldAddOneMore() {
        repository.save(sixth);
        AviaSales[] actual = repository.findAll();
        AviaSales[] expected = new AviaSales[]{first, second, thirst, fourth, fifth, sixth};
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(expected));
    }

    @Test // Тест сортировка по времени
    public void shouldSortByTime() {
        AviaSales[] actual = manager.findAll("KUF", "DME");
        AviaSales[] expected = new AviaSales[]{first};
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(expected));

    }

    @Test // Тест неверный аэропорт вылета
    public void shouldWrongFrom() {
        AviaSales[] actual = manager.findAll("", "RTW");
        AviaSales[] expected = new AviaSales[]{};
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }
    @Test // Тест неверный аэропорт прилета
    public void shouldWrongTo() {
        AviaSales[] actual = manager.findAll("KUF", "");
        AviaSales[] expected = new AviaSales[]{};
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }

    @Test // Тест удаление одного элемента
    public void shouldRemoveExist() {
        repository.removeById(4);
        assertEquals(repository.findAll().length, 4);
    }

    @Test // Тест сохранить элементы
    public void shouldSaveAndFindAll() {
        assertEquals(repository.findAll().length, 5);
    }
}