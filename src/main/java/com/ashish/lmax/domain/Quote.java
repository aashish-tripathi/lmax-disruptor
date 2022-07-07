package com.ashish.lmax.domain;

import java.io.Serializable;

public class Quote implements Serializable {

    private double bestBid;
    private double bestAsk;
    private long bestBidQty;
    private long bestAskQty;
    private long time;
    private String symbol;
    private String exchange;

    public static Quote getInstance(){
        return null;
    }

    private Quote(double bestBid, double bestAsk, long bestBidQty, long bestAskQty, long time, String symbol, String exchange) {
        this.bestBid = bestBid;
        this.bestAsk = bestAsk;
        this.bestBidQty = bestBidQty;
        this.bestAskQty = bestAskQty;
        this.time = time;
        this.symbol = symbol;
        this.exchange = exchange;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "bestBid=" + bestBid +
                ", bestAsk=" + bestAsk +
                ", bestBidQty=" + bestBidQty +
                ", bestAskQty=" + bestAskQty +
                ", time=" + time +
                ", symbol='" + symbol + '\'' +
                ", exchange='" + exchange + '\'' +
                '}';
    }

    public double getBestBid() {
        return bestBid;
    }

    public void setBestBid(double bestBid) {
        this.bestBid = bestBid;
    }

    public double getBestAsk() {
        return bestAsk;
    }

    public void setBestAsk(double bestAsk) {
        this.bestAsk = bestAsk;
    }

    public long getBestBidQty() {
        return bestBidQty;
    }

    public void setBestBidQty(long bestBidQty) {
        this.bestBidQty = bestBidQty;
    }

    public long getBestAskQty() {
        return bestAskQty;
    }

    public void setBestAskQty(long bestAskQty) {
        this.bestAskQty = bestAskQty;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
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
}
