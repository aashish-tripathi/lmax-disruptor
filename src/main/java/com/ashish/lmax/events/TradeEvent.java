package com.ashish.lmax.events;

import com.ashish.lmax.domain.Trade;

public class TradeEvent {
private Trade trade;

    public Trade getTrade() {
        return trade;
    }

    public void setTrade(Trade trade) {
        this.trade = trade;
    }
}
