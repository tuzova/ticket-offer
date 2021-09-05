package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketOffer;

import static org.junit.jupiter.api.Assertions.*;

public class TicketOfferRepositoryTest {
    private TicketOfferRepository repository = new TicketOfferRepository();

    private TicketOffer LR_1896 = new TicketOffer(262685, 1896, "LON", "ROM", 140);
    private TicketOffer LR_1723 = new TicketOffer(249258, 1723, "LON", "ROM", 705);
    private TicketOffer LR_717 = new TicketOffer(248112, 717, "LON", "ROM", 352);
    private TicketOffer SL_2215 = new TicketOffer(285471, 2215, "STO", "LON", 135);
    private TicketOffer SL_737 = new TicketOffer(364888, 737, "STO", "LON", 500);
    private TicketOffer SL_818 = new TicketOffer(311948, 818, "STO", "LON", 680);

    @Test
    public void shouldSaveOneItem() {
        repository.save(SL_737);

        TicketOffer[] expected = new TicketOffer[]{SL_737};
        TicketOffer[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repository.save(LR_1896);
        repository.save(LR_1723);
        repository.save(LR_717);
        repository.removeById(249258);

        TicketOffer[] expected = new TicketOffer[]{LR_1896, LR_717};
        TicketOffer[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}
