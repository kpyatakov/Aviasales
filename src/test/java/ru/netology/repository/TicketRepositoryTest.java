package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    private TicketRepository repository = new TicketRepository();
    private Ticket first = new Ticket(1, 1000, "AAA", "AAB", 100);
    private Ticket second = new Ticket(2, 2000, "AAC", "AAE", 200);
    private Ticket third = new Ticket(3, 3000, "AAA", "AAB", 300);
    private Ticket five = new Ticket(5, 1500, "AAH", "AAI", 150);
    private Ticket ten = new Ticket(10, 4000, "AAJ", "AAK", 250);
    private Ticket seven = new Ticket(7, 2500, "AAA", "AAB", 350);

    @Test
    void mustSave() {
        repository.save(first);
        Ticket[] expected = new Ticket[]{first};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowEmpty() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowNotEmpty() {
        repository.save(first);
        repository.save(second);
        Ticket[] expected = new Ticket[]{first, second};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }


}