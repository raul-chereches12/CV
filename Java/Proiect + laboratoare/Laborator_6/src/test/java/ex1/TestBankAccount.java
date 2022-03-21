package ex1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestBankAccount {

    @Test
    public void testareBankAccount(){
        BankAccount bacc1=new BankAccount("Raul-George Chereches",700);

        BankAccount bacc2=new BankAccount("Raul-George Chereches",700);

        BankAccount bacc3=new BankAccount("Patric Berar",50);

        assertEquals(bacc1,bacc2);

        //assertEquals(bacc1,bacc3); //nu este egal

    }
}
