package com.ashish.lmax.handlers;

import com.ashish.lmax.events.LongEvent;
import com.lmax.disruptor.EventHandler;

public class LongEventHandler implements EventHandler<LongEvent>
{
    private final long ordinal;
    private final long numberOfConsumers;

    public LongEventHandler(final long ordinal, final long numberOfConsumers)
    {
        this.ordinal = ordinal;
        this.numberOfConsumers = numberOfConsumers;
    }

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch)
    {
        if ((sequence % numberOfConsumers) == ordinal)
        {
            System.out.println("Id is " + event.get() + " sequence id that was used is " + sequence);
        }

    }
}