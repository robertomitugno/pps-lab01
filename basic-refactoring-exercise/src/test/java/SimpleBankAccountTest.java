import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private static final int USER_ID = 1;
    private static final int USER_ID_WRONG = 2;
    private static final double INITIAL_AMOUNT = 0;
    private static final double FIRST_DEPOSIT_AMOUNT = 100;
    private static final double WITHDRAW_AMOUNT = 70;
    private static final double FEE = 1;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", USER_ID);
        bankAccount = new SimpleBankAccount(accountHolder, INITIAL_AMOUNT, FEE);
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), FIRST_DEPOSIT_AMOUNT);
        assertEquals(FIRST_DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongUserDeposit() {
        double deposit_amount_to_wrong_user = 50;
        bankAccount.deposit(accountHolder.getId(), FIRST_DEPOSIT_AMOUNT);
        bankAccount.deposit(USER_ID_WRONG, deposit_amount_to_wrong_user);
        assertEquals(FIRST_DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongAmountDeposit() {
        double deposit_wrong_amount = -50;
        bankAccount.deposit(accountHolder.getId(), deposit_wrong_amount);
        assertEquals(INITIAL_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        double amount_after_withdraw = 30;
        bankAccount.deposit(accountHolder.getId(), FIRST_DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), WITHDRAW_AMOUNT);
        assertEquals(amount_after_withdraw - FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongUserWithdraw() {
        bankAccount.deposit(accountHolder.getId(), FIRST_DEPOSIT_AMOUNT);
        bankAccount.withdraw(USER_ID_WRONG, WITHDRAW_AMOUNT);
        assertEquals(FIRST_DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongAmountWithdraw() {
        int wrong_withdraw_amount = 150;
        bankAccount.deposit(accountHolder.getId(), FIRST_DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), wrong_withdraw_amount);
        assertEquals(FIRST_DEPOSIT_AMOUNT, bankAccount.getBalance());
    }
}
