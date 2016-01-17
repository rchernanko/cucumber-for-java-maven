package implementation.chapter_7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*

This class was created by the guys who wrote the cucumber book. I have downloaded it from the source code.

 */

public final class Money {

    private final int pounds;
    private final int pence;

    public Money() {
        this.pounds = 0;
        this.pence = 0;
    }

    public Money(int pounds, int pence) {
        this.pounds = pounds;
        this.pence = pence;
    }

    //We could have used this method below instead of the MoneyConverter class...
    //The reason that we created the MoneyConverter class was to answer the question - what if the 'Money' class doesn't
    //have a string constructor and isn't ours to modify?? To get around this, we can use Cucumber's "Transformer" class
    //See page 126 of the cucumber for java book for more details...
    public Money(String amount) {
        Pattern pattern = Pattern.compile("^[^\\d]*([\\d]+)\\.([\\d][\\d])$");
        Matcher matcher = pattern.matcher(amount);

        matcher.find();
        this.pounds = Integer.parseInt(matcher.group(1));
        this.pence = Integer.parseInt(matcher.group(2));
    }

    public int pounds() {
        return pounds;
    }

    public int pence() {
        return pence;
    }

    public Money add(Money amount){
        int newPence = pence + amount.pence();
        int newPounds = pounds + amount.pounds();

        if (newPence >= 100){
            newPence -= 100;
            newPounds++;
        }

        return new Money(newPounds, newPence);
    }

    public Money minus(Money amount){
        int newPence = pence - amount.pence();
        int newPounds = pounds - amount.pounds();

        if (newPence < 0){
            newPence += 100;
            newPounds--;
        }

        return new Money(newPounds, newPence);
    }

    @Override
    public boolean equals(Object other){
        boolean equal = false;

        if (other instanceof Money){
            Money otherMoney = (Money)other;
            equal = (this.pounds() == otherMoney.pounds()
                    && this.pence() == otherMoney.pence());
        }

        return equal;
    }

    @Override
    public String toString() {
        return String.format("$%01d.%02d", this.pounds(), this.pence());
    }
}