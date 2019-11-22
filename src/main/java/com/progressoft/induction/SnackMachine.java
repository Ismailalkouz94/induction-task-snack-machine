package com.progressoft.induction;

import java.math.BigDecimal;

public class SnackMachine extends Snack {

    private BigDecimal moneyInside = BigDecimal.valueOf(0);
    private Money moneyInTrx = new Money(moneyInside);
    private Money money = new Money(moneyInside);

    public SnackMachine() {
    }

    public Money moneyInside() {
        return this.money;
    }

    public void insertMoney(Money money) {
        if (!Money.validMoney.contains(money)) {
            throw new IllegalArgumentException();
        }
        this.moneyInTrx = this.moneyInTrx.add(money);
    }

    public Money moneyInTransaction() {
        return this.moneyInTrx;
    }

    public Money buySnack(SnackType type) {
        if (this.moneyInTrx.getMoney().compareTo(BigDecimal.valueOf(0)) == 0) {
            throw new IllegalStateException();
        }

        checkQuantity(type);
        Money change = checkPrice(type);
        decreaseQuantity(type);
        this.money = this.moneyInTrx;
        this.moneyInTrx = Money.ZERO;
        return change;
    }

    private void checkQuantity(SnackType type) {
        switch (type) {
            case CHEWING_GUM:
                if (chewingGumsQuantity <= 0) {
                    throw new IllegalStateException();
                }
                break;
            case CHIPS:
                if (chipsQuantity <= 0) {
                    throw new IllegalStateException();
                }
                break;
            case CHOCOLATE:
                if (chocolatesQuantity <= 0) {
                    throw new IllegalStateException();
                }
                break;
        }
    }

    private Money checkPrice(SnackType type) {
        Money change = new Money(BigDecimal.valueOf(0));
        switch (type) {
            case CHEWING_GUM:
                if (this.moneyInTrx.getMoney().compareTo(getChewingGumsPrice()) < 0) {
                    throw new IllegalStateException();
                } else if (this.moneyInTrx.getMoney().compareTo(getChewingGumsPrice()) > 0) {
                    change = new Money(this.moneyInTrx.getMoney().subtract(getChewingGumsPrice()));
                }
                break;
            case CHIPS:
                if (this.moneyInTrx.getMoney().compareTo(getChipsPrice()) < 0) {
                    throw new IllegalStateException();
                } else if (this.moneyInTrx.getMoney().compareTo(getChipsPrice()) > 0) {
                    change = new Money(this.moneyInTrx.getMoney().subtract(getChipsPrice()));
                }
                break;
            case CHOCOLATE:
                if (this.moneyInTrx.getMoney().compareTo(getChocolatesPrice()) < 0) {
                    throw new IllegalStateException();
                } else if (this.moneyInTrx.getMoney().compareTo(getChocolatesPrice()) > 0) {
                    change = new Money(this.moneyInTrx.getMoney().subtract(getChocolatesPrice()));
                }
                break;
        }
        return change;
    }

    private void decreaseQuantity(SnackType type) {
        switch (type) {
            case CHEWING_GUM:
                chewingGumsQuantity--;
                break;
            case CHIPS:
                chipsQuantity--;
                break;
            case CHOCOLATE:
                chocolatesQuantity--;
                break;
        }
    }

}
