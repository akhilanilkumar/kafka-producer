package com.wavelabs.ai.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * The type Market data.
 */
public class MarketData {

    private BigDecimal price;
    private String ricCode;
    private String lastUpdatedTime;

    /**
     * Instantiates a new Market data.
     */
    public MarketData() {
    }

    /**
     * Instantiates a new Market data.
     *
     * @param price           the price
     * @param ricCode         the ric code
     * @param lastUpdatedTime the last updated time
     */
    public MarketData(BigDecimal price, String ricCode, String lastUpdatedTime) {
        this.price = price;
        this.ricCode = ricCode;
        this.lastUpdatedTime = lastUpdatedTime;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Gets ric code.
     *
     * @return the ric code
     */
    public String getRicCode() {
        return ricCode;
    }

    /**
     * Sets ric code.
     *
     * @param ricCode the ric code
     */
    public void setRicCode(String ricCode) {
        this.ricCode = ricCode;
    }

    /**
     * Gets last updated time.
     *
     * @return the last updated time
     */
    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    /**
     * Sets last updated time.
     *
     * @param lastUpdatedTime the last updated time
     */
    public void setLastUpdatedTime(String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketData that = (MarketData) o;
        return price.equals(that.price) && ricCode.equals(that.ricCode) && lastUpdatedTime.equals(that.lastUpdatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, ricCode, lastUpdatedTime);
    }

    @Override
    public String toString() {
        return "MarketData{" +
                "price=" + price +
                ", ricCode='" + ricCode + '\'' +
                ", lastUpdatedTime='" + lastUpdatedTime + '\'' +
                '}';
    }
}
