package com.toys.lottogame.round.event;

import com.toys.lottogame.round.service.EventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AnnounceEventPublisher implements EventPublisher {

    private final ApplicationEventPublisher publisher;

    public AnnounceEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(Object event) {
        publisher.publishEvent(event);
    }
}
