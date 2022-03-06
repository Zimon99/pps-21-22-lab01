import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;

import org.junit.jupiter.api.*;

public class SimpleBankAccountWithAtmTest extends AbstractBankAccountTest {

   @BeforeEach
   public void beforeEach(){
       accountHolder = new AccountHolder("Simone", "Montanari", 1);
       bankAccount = new SimpleBankAccountWithAtm( 0, accountHolder);
   }

    @Override
    public int getFee() {
        return 1;
    }

}
