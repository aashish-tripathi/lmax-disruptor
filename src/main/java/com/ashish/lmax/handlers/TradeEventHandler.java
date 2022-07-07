package com.ashish.lmax.handlers;

import com.ashish.lmax.events.TradeEvent;
import com.lmax.disruptor.EventHandler;

public class TradeEventHandler implements EventHandler<TradeEvent> {

    private final long ordinal;
    private final long numberOfConsumers;

    public TradeEventHandler(final long ordinal, final long numberOfConsumers) {
        this.ordinal = ordinal;
        this.numberOfConsumers = numberOfConsumers;
    }

    @Override
    public void onEvent(TradeEvent event, long sequence, boolean endOfBatch) {
        if ((sequence % numberOfConsumers) == ordinal) {
            System.out.println("Data received "+event.getTradeFromBuffer()+" on sequence "+sequence);
        }

    }
}
