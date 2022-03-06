package lab01.example.model;

public class SimpleBankAccountWithAtm extends AbstractBankAccount {

    public SimpleBankAccountWithAtm(final double balance, final AccountHolder holder) {
        super(balance, holder);
    }

    @Override
    protected int getFee() {
        return 1;
    }

}
