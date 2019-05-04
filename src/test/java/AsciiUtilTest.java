import de.maaxgr.studium.swe1.runlengthcompression.util.AsciiUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AsciiUtilTest {

    @Test
    public void numberToAsciiCharacter() {
        Map<Integer, Character> mapping = new HashMap<>() {{
            put(2, ' ');
            put(3, '!');
            put(95, '}');
        }};

        mapping.forEach((number, character) -> {
            System.out.printf("Testing number %d => Should be ascii-char '%s'%n", number, character);
            assertEquals((char) character, AsciiUtil.getAsciiCharForNumber(number));
        });
    }

    @Test
    public void asciiCharacterToNumber() {
        Map<Character, Integer> mapping = new HashMap<>() {{
            put(' ', 2);
            put('!', 3);
            put('}', 95);
        }};

        mapping.forEach((character, number) -> {
            System.out.printf("Testing character '%s' => Should be number '%d'%n", character, number);
            assertEquals((int) number, AsciiUtil.getNumberForAsciiChar(character));
        });
    }

}
