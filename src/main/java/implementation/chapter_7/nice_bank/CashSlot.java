package implementation.chapter_7.nice_bank;

public class CashSlot {

    private int contents;

    public int getContents() {
        return contents;
    }

    public void dispense(int pounds) {
        contents = pounds;
    }
}
