package com.ashish.lmax;

import com.ashish.lmax.domain.Trade;
import com.ashish.lmax.events.TradeEvent;
import com.ashish.lmax.events.ValueEvent;
import com.ashish.lmax.handlers.TradeEventHandler;
import com.ashish.lmax.handlers.ValueEventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;
import org.apache.commons.lang3.SerializationUtils;

import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int bufferSize = 1024;
        Disruptor<TradeEvent> disruptor =
                new Disruptor<>(TradeEvent::new, bufferSize, DaemonThreadFactory.INSTANCE);
        TradeEventHandler[] eventHandlers = {new TradeEventHandler(0,4),
                new TradeEventHandler(1,4),
                new TradeEventHandler(2,4),
                new TradeEventHandler(3,4)};
        disruptor.handleEventsWith(eventHandlers);

       /*   ValueEventHandler[] eventHandlers = {new ValueEventHandler(0,4),
                new ValueEventHandler(1,4),
                new ValueEventHandler(2,4),
                new ValueEventHandler(3,4)};
        disruptor.handleEventsWith(eventHandlers);
      LongEventHandler [] eventHandlers = {new LongEventHandler(0,4),
                new LongEventHandler(1,4),
                new LongEventHandler(2,4),
                new LongEventHandler(3,4)};
        disruptor.handleEventsWith(eventHandlers);*/
        disruptor.start();


        RingBuffer<TradeEvent> ringBuffer = disruptor.getRingBuffer();
        ByteBuffer bb = ByteBuffer.allocate(1024);
        for (int l = 0; true; l++) {
            Trade trade = Trade.getInstance();
            byte[] data = SerializationUtils.serialize(trade);
            bb.put(data,0,data.length);
            ringBuffer.publishEvent((event, sequence, buffer) -> event.setTrade(bb.array()));
            bb.rewind();
            Thread.sleep(1000);
        }
    }



}
