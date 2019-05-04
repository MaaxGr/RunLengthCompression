import de.maaxgr.studium.swe1.runlengthcompression.RunLengthCompression;
import de.maaxgr.studium.swe1.runlengthcompression.iface.Compression;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MainTest {

    public static Map<String, String> testStrings = new HashMap<>() {{
        put("abcxxxxxdeeeeeeeeeeex", "");
        put("~dkjfjdkf", "");
        put("~", "");
        put("~~", "");
    }};

    @Test
    public void test() {
        final Compression compression = new RunLengthCompression();

        for (String testString : testStrings.keySet()) {
            System.out.printf("Compressing string '%s'%n", testString);

            final String compressedString = compression.compress(testString);
            System.out.printf("Result is: '%s'%n", compressedString);

            System.out.printf("Decompressing string '%s'%n", compressedString);
            final String decompressedString = compression.decompress(compressedString);
            System.out.printf("Result is: '%s'%n%n", decompressedString);
        }
    }

}
