// Trigger second CI run to verify Maven cache
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp chạy chính để kiểm tra hoạt động và log của hệ thống ngân hàng.
 */
public class BankSystemMain {

  private static final Logger logger = LoggerFactory.getLogger(BankSystemMain.class);

  /**
   * Điểm khởi chạy chương trình.
   *
   * @param args tham số dòng lệnh
   */
  public static void main(String[] args) {
    logger.info("Bat dau he thong");
    BankAccount account = new BankAccount("VN100200300", 5000000.0);

    account.deposit(1500000.0);
    account.withdraw(2000000.0);

    try {
      account.withdraw(10000000.0);
    } catch (IllegalStateException e) {
      logger.error("Giao dich that bai do vi pham nghiep vu: {}", e.getMessage());
    }
    logger.info("Ket thuc");
  }
}
