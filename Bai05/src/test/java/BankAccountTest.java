import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import org.junit.jupiter.api.Test;

/**
 * Kiểm thử đơn vị cho lớp BankAccount.
 */
public class BankAccountTest {

  /**
   * Kiểm thử nạp tiền hợp lệ.
   */
  @Test
  public void testDepositValidAmount() {
    BankAccount account = new BankAccount("VN100200300", 1000.0);
    account.deposit(500.0);
    assertEquals(1500.0, account.getBalance(), 0.001);
  }

  /**
   * Kiểm thử rút tiền hợp lệ.
   */
  @Test
  public void testWithdrawValidAmount() {
    BankAccount account = new BankAccount("VN100200300", 1000.0);
    account.withdraw(400.0);
    assertEquals(600.0, account.getBalance(), 0.001);
  }

  /**
   * Kiểm thử rút tiền vượt quá số dư.
   */
  @Test
  public void testWithdrawInsufficientBalance() {
    BankAccount account = new BankAccount("VN100200300", 1000.0);
    assertThrows(IllegalStateException.class, () -> account.withdraw(2000.0));
  }

  /**
   * Kiểm thử định dạng đường dẫn tệp sao kê theo hệ điều hành.
   */
  @Test
  public void testGetStatementPath() {
    BankAccount account = new BankAccount("VN100200300", 1000.0);
    String expected = "statements" + File.separator + "VN100200300.txt";
    assertEquals(expected, account.getStatementPath("statements"));
  }
  /** Kiểm tra luồng chạy chính của BankSystemMain và thông tin tài khoản. */
  @Test
  void testMainAndAccountGetters() {
    BankSystemMain.main(new String[] {});
    BankAccount account = new BankAccount("ACC999", 500.0);
    assertEquals("ACC999", account.getAccountNumber());
    assertEquals(500.0, account.getBalance());
  }
}