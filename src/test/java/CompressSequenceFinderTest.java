import de.maaxgr.studium.swe1.runlengthcompression.util.CompressSequenceFinder;
import org.junit.Test;

public class CompressSequenceFinderTest {

    @Test
    public void findAll() {
        for (String testString : MainTest.testStrings.keySet()) {
            System.out.println("Testing string: " + testString);
            System.out.println("V1: " + CompressSequenceFinder.getAll(testString));
            System.out.println("V2: " + CompressSequenceFinder.getAll2(testString));
            System.out.println("V3: " + CompressSequenceFinder.getAll3(testString));
            System.out.println();
        }
    }

}
