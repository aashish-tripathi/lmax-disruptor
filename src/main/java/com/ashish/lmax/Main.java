package com.ashish.lmax;

import com.ashish.lmax.events.ValueEvent;
import com.ashish.lmax.handlers.ValueEventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int bufferSize = 16;
        Disruptor<ValueEvent> disruptor =
                new Disruptor<>(ValueEvent::new, bufferSize, DaemonThreadFactory.INSTANCE);
        ValueEventHandler[] eventHandlers = {new ValueEventHandler(0,4),
                new ValueEventHandler(1,4),
                new ValueEventHandler(2,4),
                new ValueEventHandler(3,4)};
        disruptor.handleEventsWith(eventHandlers);
      /*  LongEventHandler [] eventHandlers = {new LongEventHandler(0,4),
                new LongEventHandler(1,4),
                new LongEventHandler(2,4),
                new LongEventHandler(3,4)};
        disruptor.handleEventsWith(eventHandlers);*/
        disruptor.start();

        RingBuffer<ValueEvent> ringBuffer = disruptor.getRingBuffer();
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (int l = 0; true; l++) {
            bb.putInt(0, l);
            ringBuffer.publishEvent((event, sequence, buffer) -> event.setValue(buffer.getInt(0)), bb);
            Thread.sleep(1);
        }
    }



}
