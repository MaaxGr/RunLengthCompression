import de.maaxgr.studium.swe1.runlengthcompression.RunLengthCompression;
import de.maaxgr.studium.swe1.runlengthcompression.iface.Compression;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MainTest {

    public static Map<String, String> testStrings = new HashMap<>() {{
        put("abcxxxxxdeeeeeeeeeeex", "abc~#xd~)ex");
        put("~dkjfjdkf", "~~dkjfjdkf");
        put("~", "~~");
        put("~~", "~ ~");
        put("xyzdddd", "xyz~\"d");
        put("aiooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooox", "ai~}ox");
        put("aioooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooox", "ai~|o~ ox");
    }};

    @Test
    public void test() {
        final Compression compression = new RunLengthCompression();

        for (Map.Entry<String, String> testEntry : testStrings.entrySet()) {
            //test string
            final String originalTestString = testEntry.getKey();

            //expected compression value
            final String expectedTestValue = testEntry.getValue();

            //do compression
            System.out.printf("Compressing string '%s'%n", originalTestString);
            final String realValue = compression.compress(originalTestString);
            System.out.printf("Result is: '%s'%n", realValue);

            //check if real compression value equals to expected compression value
            Assert.assertEquals(realValue, expectedTestValue);

            //do decompression
            System.out.printf("Decompressing string '%s'%n", realValue);
            final String realString = compression.decompress(realValue);
            System.out.printf("Result is: '%s'%n%n", realString);

            //check if real uncompressed string is equals to original test string
            Assert.assertEquals(realString, originalTestString);
        }
    }

}
