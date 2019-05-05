package de.maaxgr.studium.swe1.runlengthcompression.manager;

import de.maaxgr.studium.swe1.runlengthcompression.entity.DecompressSequence;
import de.maaxgr.studium.swe1.runlengthcompression.util.DecompressSequenceConverter;
import de.maaxgr.studium.swe1.runlengthcompression.util.DecompressSequenceFinder;

import java.util.List;

public class RunLengthDecompressor {

    public String run(String input) {
        final List<DecompressSequence> sequences = DecompressSequenceFinder.findAll(input);

        final StringBuilder builder = new StringBuilder();

        int startIndex = 0;

        for (DecompressSequence sequence : sequences) {
            final String beforeSequence = input.substring(startIndex, sequence.getStartIndex());
            builder.append(beforeSequence);

            final String decompressedSequence = DecompressSequenceConverter.convert(sequence);
            builder.append(decompressedSequence);

            startIndex = sequence.getStartIndex() + (sequence.isDoubleTilde() ? 2 : 3);
        }

        final String rest = input.substring(startIndex);
        builder.append(rest);

        return builder.toString();
    }
}
