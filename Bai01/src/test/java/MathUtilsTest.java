import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {
    @Test
    void testDivideSuccess() {
        MathUtils math = new MathUtils();
        assertEquals(5, math.divide(10, 2));
    }

    @Test
    void testDivideByZero() {
        MathUtils math = new MathUtils();
        assertThrows(IllegalArgumentException.class, () -> math.divide(10, 0));
    }
}
