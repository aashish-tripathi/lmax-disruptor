package com.ashish.lmax;

import com.lmax.disruptor.EventHandler;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

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
