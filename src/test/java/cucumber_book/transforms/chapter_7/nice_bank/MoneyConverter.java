package cucumber_book.transforms.chapter_7.nice_bank;

/*

This is a transformer class. This is a cool Cucumber feature.

It basically allows you to match a regex in a step def (as a string) and then transform / convert it to something
else - in this example, we are converting the String into an instance of the Money class.

For further information on transformer classes, have a look at page 126 in the cucumber for java book

*/

import cucumber.api.Transformer;
import implementation.chapter_7.nice_bank.Money;

public class MoneyConverter extends Transformer<Money>{

    @Override //from Transformer class
    public Money transform(String amount) {
        String[] numbers = amount.substring(1).split("\\.");

        int pounds = Integer.parseInt(numbers[0]);
        int pence = Integer.parseInt(numbers[1]);

        return new Money(pounds, pence);

    }
}
