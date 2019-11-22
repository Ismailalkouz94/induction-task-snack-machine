package com.progressoft.induction;

import java.math.BigDecimal;

public class Snack {
    protected static final int DEFAULT_QUANTITY = 10;

    protected int chewingGumsQuantity = DEFAULT_QUANTITY;
    protected int chipsQuantity = DEFAULT_QUANTITY;
    protected int chocolatesQuantity = DEFAULT_QUANTITY;
    protected static int quantity = 0;

    private BigDecimal chewingGumsPrice = BigDecimal.valueOf(0.5);
    private BigDecimal chipsPrice = BigDecimal.valueOf(1);
    private BigDecimal chocolatesPrice = BigDecimal.valueOf(2);

    public Snack chewingGums() {
        setQuantity(chewingGumsQuantity);
        return new Snack();
    }

    public Snack chips() {
        setQuantity(chipsQuantity);
        return new Snack();
    }

    public Snack chocolates() {
        setQuantity(chocolatesQuantity);
        return new Snack();
    }

    public int quantity() {
        return quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getChewingGumsPrice() {
        return chewingGumsPrice;
    }

    public void setChewingGumsPrice(BigDecimal chewingGumsPrice) {
        this.chewingGumsPrice = chewingGumsPrice;
    }

    public BigDecimal getChipsPrice() {
        return chipsPrice;
    }

    public void setChipsPrice(BigDecimal chipsPrice) {
        this.chipsPrice = chipsPrice;
    }

    public BigDecimal getChocolatesPrice() {
        return chocolatesPrice;
    }

    public void setChocolatesPrice(BigDecimal chocolatesPrice) {
        this.chocolatesPrice = chocolatesPrice;
    }
}
