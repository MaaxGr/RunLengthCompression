import de.maaxgr.studium.swe1.runlengthcompression.util.AsciiUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AsciiUtilTest {

    @Test
    public void asciiTest() {
        Map<Integer, Character> mapping = new HashMap<>() {{
            put(2, ' ');
            put(3, '!');
            put(95, '}');
        }};

        mapping.forEach((number, character) -> {
            System.out.printf("Testing number %d => Should be ascii-char '%s'%n", number, character);
            char convertedChar = AsciiUtil.getAsciiCharForNumber(number);
            assertEquals((char) character, convertedChar);

            System.out.printf("Converting '%s' back to number%n", convertedChar);
            int convertedNumber = AsciiUtil.getNumberForAsciiChar(convertedChar);
            assertEquals((int) number, convertedNumber);

            System.out.println();
        });
    }

}
