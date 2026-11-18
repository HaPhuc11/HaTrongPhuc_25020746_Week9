import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathUtils {
    private static final Logger logger = LoggerFactory.getLogger(MathUtils.class);

    public int divide(int a, int b) {
        logger.info("Thuc hien phep chia {} cho {}", a, b);
        if (b == 0) {
            logger.error("Loi chia cho 0 voi so bi chia a = {}", a);
            throw new IllegalArgumentException("Khong the chia cho 0");
        }
        return a / b;
    }
}