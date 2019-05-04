package de.maaxgr.studium.swe1.runlengthcompression.util;

import de.maaxgr.studium.swe1.runlengthcompression.entity.CompressSequence;

import java.util.ArrayList;
import java.util.List;

public class CompressSequenceConverter {

    private static final int MAX_LENGTH = 95;

    public static String convert(CompressSequence sequence) {

        final List<CompressSequence> parts = splitIntoCompressibleParts(sequence);
        final StringBuilder builder = new StringBuilder();

        for (CompressSequence part : parts) {
            builder.append(
                    convertSequencePart(part.getTargetChar(), part.getLength())
            );
        }

        return builder.toString();
    }

    private static List<CompressSequence> splitIntoCompressibleParts(CompressSequence sequence) {
        List<CompressSequence> parts = new ArrayList<>();

        char targetChar = sequence.getTargetChar();
        int length = sequence.getLength();

        if (length <= MAX_LENGTH) {
            parts.add(new CompressSequence(targetChar, -1, length));
            return parts;
        }

        int divisor = MAX_LENGTH;

        //find suitable divisor
        //rest cannot be one because one can not converted to ascii char (See AsciiUtil::getAsciiCharForNumber)
        while ((length % divisor) == 1) {
            divisor--;
        }

        int count = length / divisor;
        int rest = length % divisor;

        for (int i = 0; i < count; i++) {
            parts.add(new CompressSequence(targetChar, -1, divisor));
        }

        if (rest > 0) {
            parts.add(new CompressSequence(targetChar, -1, rest));
        }

        return parts;
    }

    private static String convertSequencePart(char character, int length) {

        if (character == '~') {

            if (length == 1) {
                return "~~";
            }

        }

        return "~" + AsciiUtil.getAsciiCharForNumber(length) + character;
    }
}
