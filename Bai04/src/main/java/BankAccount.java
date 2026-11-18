import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Đại diện cho một tài khoản ngân hàng với các thao tác nạp và rút tiền.
 */
public class BankAccount {

  private static final Logger logger = LoggerFactory.getLogger(BankAccount.class);
  private static final double MIN_TRANSACTION_AMOUNT = 0.0;

  private final String accountNumber;
  private double balance;

  /**
   * Khởi tạo tài khoản ngân hàng mới.
   *
   * @param accountNumber  số tài khoản định danh
   * @param initialBalance số dư ban đầu
   */
  public BankAccount(String accountNumber, double initialBalance) {
    this.accountNumber = accountNumber;
    this.balance = initialBalance;
    logger.debug("Tao tai khoan {} voi so du ban dau: {}", accountNumber, initialBalance);
  }

  /**
   * Thực hiện nạp tiền vào tài khoản.
   *
   * @param amount số tiền cần nạp
   */
  public void deposit(double amount) {
    logger.info("Yeu cau nap tien: Tai khoan={}, so tien={}", accountNumber, amount);
    if (amount <= MIN_TRANSACTION_AMOUNT) {
      logger.warn("Tu choi nap tien - So tien k hop le: Tai khoan={}, So tien={}",
          accountNumber, amount);
      throw new IllegalArgumentException("So tien nap phai lon hon 0");
    }
    balance += amount;
    logger.info("Nap thanh cong: Tai khoan={}, So du moi={}", accountNumber, balance);
  }

  /**
   * Thực hiện rút tiền từ tài khoản.
   *
   * @param amount số tiền cần rút
   */
  public void withdraw(double amount) {
    logger.info("Yeu cau rut tien: tai khoan={}, So tien={}", accountNumber, amount);
    if (amount <= MIN_TRANSACTION_AMOUNT) {
      logger.warn("Tu choi rut tien - So tien k hop le: Tai khoan={}, So tien={}",
          accountNumber, amount);
      throw new IllegalArgumentException("So tien rut phai lon hon 0");
    }
    if (amount > balance) {
      logger.warn("Tu choi rut tien - So du k du: tai khoan={}, Yeu cau={}, Hien co={}",
          accountNumber, amount, balance);
      throw new IllegalStateException("So du k du");
    }
    balance -= amount;
    logger.info("Rut tien thanh cong: Tai khoan={}, So tien rut={}, So du moi={}",
        accountNumber, amount, balance);
  }

  public double getBalance() {
    return balance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  /**
   * Tạo đường dẫn tệp sao kê tài khoản (cố tình dùng dấu gạch chéo cứng của Windows).
   *
   * @param folder thư mục lưu trữ
   * @return đường dẫn đầy đủ tới tệp sao kê
   */
  public String getStatementPath(String folder) {
    return folder + "\\" + accountNumber + ".txt";
  }
}
