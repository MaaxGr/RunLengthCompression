package de.maaxgr.studium.swe1.runlengthcompression.manager;

import de.maaxgr.studium.swe1.runlengthcompression.entity.CompressSequence;
import de.maaxgr.studium.swe1.runlengthcompression.util.CompressSequenceFinder;
import de.maaxgr.studium.swe1.runlengthcompression.util.CompressSequenceConverter;

import java.util.List;

public class RunLengthCompressor {

    public String run(String input) {
        //get all sequences
        final List<CompressSequence> sequences = CompressSequenceFinder.getAll3(input);

        //convert sequences to encoded string
        return applyCompressedSequencesToInputString(input, sequences);
    }

    private String applyCompressedSequencesToInputString(String input, List<CompressSequence> sequences) {
        StringBuilder finalString = new StringBuilder();

        int currentIndex = 0;

        for (CompressSequence sequence : sequences) {
            final String beforeCompressedSequence = input.substring(currentIndex, sequence.getStartIndex());
            finalString.append(beforeCompressedSequence);

            final String compressedSequence = CompressSequenceConverter.convert(sequence);
            finalString.append(compressedSequence);

            currentIndex = sequence.getStartIndex() + sequence.getLength();
        }

        finalString.append(input, currentIndex, input.length());

        return finalString.toString();
    }

}
