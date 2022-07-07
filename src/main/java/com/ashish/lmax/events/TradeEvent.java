package com.ashish.lmax.events;

import com.ashish.lmax.domain.Trade;
import org.apache.commons.lang3.SerializationUtils;

import java.nio.ByteBuffer;

public class TradeEvent {
    private Trade trade;
    private byte[] tradeBytes;

    public Trade getTrade() {
        return trade;
    }

    public void setTrade(Trade trade) {
        this.trade = trade;
    }

    public void setTrade(byte[] tradeBytes) {
        this.tradeBytes = tradeBytes;
    }

    public Trade getTradeFromBuffer(){
        return SerializationUtils.deserialize(tradeBytes);
    }
}
