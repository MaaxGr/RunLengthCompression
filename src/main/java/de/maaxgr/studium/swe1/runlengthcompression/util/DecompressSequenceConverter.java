package de.maaxgr.studium.swe1.runlengthcompression.util;

import de.maaxgr.studium.swe1.runlengthcompression.entity.DecompressSequence;

public class DecompressSequenceConverter {

    public static String convert(DecompressSequence sequence) {

        if (sequence.isDoubleTilde()) {
            return "~";
        }

        int length = AsciiUtil.getNumberForAsciiChar(sequence.getLengthChar());

        return String.valueOf(sequence.getTargetChar()).repeat(length);

    }

}
