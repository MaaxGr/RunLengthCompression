import de.maaxgr.studium.swe1.runlengthcompression.entity.CompressSequence;
import de.maaxgr.studium.swe1.runlengthcompression.util.CompressSequenceConverter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SequenceToStringConverterTest {

    @Test
    public void test() {

        List<CompressSequence> testSequences = Arrays.asList(
                new CompressSequence('~', 0, 2),
                new CompressSequence('~', 0, 1),
                new CompressSequence('x', 3, 5),
                new CompressSequence('e', 9, 11),
                new CompressSequence('b', 11, 94),
                new CompressSequence('b', 20, 95),
                new CompressSequence('b', 20, 96),
                new CompressSequence('b', 20, 97),
                new CompressSequence('b', 10, 180)
        );


        for (CompressSequence testSequence : testSequences) {
            System.out.printf("Testing sequence '%s'%n", testSequence);

            final String result = CompressSequenceConverter.convert(testSequence);
            System.out.printf("Result: '%s'%n%n", result);
        }


    }

}
