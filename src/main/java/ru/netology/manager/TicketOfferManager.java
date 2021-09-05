package ru.netology.manager;

import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketOfferRepository;

public class TicketOfferManager {
    private TicketOfferRepository repository;

    public TicketOfferManager(TicketOfferRepository repository) {
        this.repository = repository;
    }

    public TicketOfferRepository getRepository() {
        return repository;
    }

    public void setRepository(TicketOfferRepository repository) {
        this.repository = repository;
    }

    public void add(TicketOffer ticket) {
        repository.save(ticket);
    }

    public TicketOffer[] findAll(String from, String to) {
        TicketOffer[] result = new TicketOffer[0];
        for (TicketOffer ticket : repository.findAll()) {
            if (ticket.getDepartureAirport().equals(from) && ticket.getArrivalAirport().equals(to)) {
                TicketOffer[] tmp = new TicketOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }
}

