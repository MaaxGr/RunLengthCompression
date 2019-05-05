import de.maaxgr.studium.swe1.runlengthcompression.entity.CompressSequence;
import de.maaxgr.studium.swe1.runlengthcompression.entity.DecompressSequence;
import de.maaxgr.studium.swe1.runlengthcompression.util.CompressSequenceConverter;
import de.maaxgr.studium.swe1.runlengthcompression.util.DecompressSequenceConverter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DecompressSequenceConverterTest {

    @Test
    public void test() {

        List<DecompressSequence> testSequences = Arrays.asList(
                new DecompressSequence(3, '~', ' '),
                new DecompressSequence(9, 'd', '"'),
                new DecompressSequence(1, 'x', '#'),
                new DecompressSequence(7, 'e', ')')
        );


        for (DecompressSequence testSequence : testSequences) {
            System.out.printf("Testing sequence '%s'%n", testSequence);

            final String result = DecompressSequenceConverter.convert(testSequence);
            System.out.printf("Result: '%s'%n%n", result);
        }


    }

}
