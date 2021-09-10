package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketOfferRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TicketOfferManagerTest {

    @Mock
    private TicketOfferRepository repository;
    @InjectMocks
    private TicketOfferManager manager;
    private TicketOffer LR_1896 = new TicketOffer(262685, 1896, "LON", "ROM", 140);
    private TicketOffer LR_1723 = new TicketOffer(249258, 1723, "LON", "ROM", 705);
    private TicketOffer LR_717 = new TicketOffer(248112, 717, "LON", "ROM", 352);
    private TicketOffer SL_2215 = new TicketOffer(285471, 2215, "STO", "LON", 135);
    private TicketOffer SL_737 = new TicketOffer(364888, 737, "STO", "LON", 500);
    private TicketOffer SL_818 = new TicketOffer(311948, 818, "STO", "LON", 680);

    @BeforeEach
    public void setUp() {
        manager.add(LR_1896);
        manager.add(LR_1723);
        manager.add(LR_717);
        manager.add(SL_2215);
        manager.add(SL_737);
        manager.add(SL_818);
    }

    @Test
    public void shouldFindAllLONROM() {

        TicketOffer[] returned = new TicketOffer[]{LR_1896, LR_1723, LR_717, SL_2215, SL_737, SL_818};
        doReturn(returned).when(repository).findAll();

        TicketOffer[] expected = new TicketOffer[]{LR_717, LR_1723, LR_1896};
        TicketOffer[] actual = manager.findAll("LON", "ROM");
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldFindAllSTOLON() {
        TicketOffer[] returned = new TicketOffer[]{LR_1896, LR_1723, LR_717, SL_2215, SL_737, SL_818};
        doReturn(returned).when(repository).findAll();

        TicketOffer[] expected = new TicketOffer[]{SL_737, SL_818, SL_2215};
        TicketOffer[] actual = manager.findAll("STO", "LON");
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldFindAllSTOROM() {
        TicketOffer[] returned = new TicketOffer[]{LR_1896, LR_1723, LR_717, SL_2215, SL_737, SL_818};
        doReturn(returned).when(repository).findAll();

        TicketOffer[] expected = new TicketOffer[]{};
        TicketOffer[] actual = manager.findAll("STO", "ROM");
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}

