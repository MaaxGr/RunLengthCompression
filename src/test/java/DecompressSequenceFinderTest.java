import de.maaxgr.studium.swe1.runlengthcompression.util.DecompressSequenceFinder;
import org.junit.Test;

public class DecompressSequenceFinderTest {

    @Test
    public void findAll() {
        for (String testString : MainTest.testStrings.values()) {
            System.out.println("Testing string: " + testString);
            System.out.println("V1: " + DecompressSequenceFinder.findAll(testString));
            System.out.println();
        }
    }

}
