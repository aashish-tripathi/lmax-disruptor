package com.ashish.lmax.domain;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class Trade implements Serializable {

    private double price;
    private long quantity;
    private long tradeTime;
    private String symbol;
    private String exchange;

    public static Trade getInstance(){
        Trade trade = new Trade();
        trade.setTradeTime(System.nanoTime());
        trade.setExchange("NSE");
        trade.setPrice(ThreadLocalRandom.current().nextDouble(99.0));
        trade.setQuantity(ThreadLocalRandom.current().nextLong(999));
        trade.setSymbol("Dummy");
        return trade;
    }

    private  Trade(){

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(long tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "price=" + price +
                ", quantity=" + quantity +
                ", tradeTime=" + tradeTime +
                ", symbol='" + symbol + '\'' +
                ", exchange='" + exchange + '\'' +
                '}';
    }
}
