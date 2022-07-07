package com.ashish.lmax.handlers;

import com.ashish.lmax.events.ValueEvent;
import com.lmax.disruptor.EventHandler;

public class ValueEventHandler implements EventHandler<ValueEvent> {

    private final long ordinal;
    private final long numberOfConsumers;

    public ValueEventHandler(final long ordinal, final long numberOfConsumers)
    {
        this.ordinal = ordinal;
        this.numberOfConsumers = numberOfConsumers;
    }

    @Override
    public void onEvent(ValueEvent event, long sequence, boolean endOfBatch)
    {
        if ((sequence % numberOfConsumers) == ordinal)
        {
            System.out.println("Id is " + event.getValue() + " sequence id that was used is " + sequence);
        }

    }
}
