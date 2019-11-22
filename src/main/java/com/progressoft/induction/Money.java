package com.progressoft.induction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Money {

    public static final Money ZERO = new Money(BigDecimal.valueOf(0));
    public static final Money QUARTER_DINAR = new Money(BigDecimal.valueOf(0.25));
    public static final Money HALF_DINAR = new Money(BigDecimal.valueOf(0.50));
    public static final Money DINAR = new Money(BigDecimal.valueOf(1.0));
    public static final Money FIVE_DINAR = new Money(BigDecimal.valueOf(5.0));
    public static final Money TEN_DINAR = new Money(BigDecimal.valueOf(10.0));
    public static List validMoney = null;
    private BigDecimal money;

    public Money(BigDecimal money) {
        if (money.compareTo(new BigDecimal(0)) == -1) {
            throw new IllegalArgumentException();
        }
        this.money = money;
        initializeMoneyList();
    }

    public Money add(Money money) {
        return new Money(this.money.add(money.money).stripTrailingZeros());
    }

    public Money subtract(Money money) {
        return new Money(this.money.subtract(money.money));
    }

    public boolean isLessThan(Money money) {
        if (money == null) {
            return false;
        }
        return this.money.compareTo(money.money) == -1;
    }

    private void initializeMoneyList() {
        validMoney = new ArrayList<Money>();
        validMoney.add(ZERO);
        validMoney.add(QUARTER_DINAR);
        validMoney.add(HALF_DINAR);
        validMoney.add(DINAR);
        validMoney.add(FIVE_DINAR);
        validMoney.add(TEN_DINAR);
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return Objects.equals(money, money1.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
