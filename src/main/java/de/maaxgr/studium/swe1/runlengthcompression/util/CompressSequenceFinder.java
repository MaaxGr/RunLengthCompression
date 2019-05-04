package de.maaxgr.studium.swe1.runlengthcompression.util;

import de.maaxgr.studium.swe1.runlengthcompression.entity.CompressSequence;

import java.util.ArrayList;
import java.util.List;

public class CompressSequenceFinder {

    public static List<CompressSequence> getAll3(String input) {
        final List<CompressSequence> sequences = new ArrayList<>();

        Character lastChar = null;

        int charIndex = 0;
        int charNumbers = 1;

        for (int i = 0; i < input.toCharArray().length; i++) {
            char currentChar = input.charAt(i);

            if (lastChar != null) {

                if (lastChar == currentChar) {
                    charNumbers++;
                } else {

                    if (lastChar == '~' || charNumbers >= 4) {
                        sequences.add(new CompressSequence(lastChar, charIndex, charNumbers));
                    }

                    charIndex = i;
                    charNumbers = 1;
                }
            }

            lastChar = currentChar;
        }

        if (lastChar != null) {
            if (lastChar == '~' || charNumbers >= 4) {
                sequences.add(new CompressSequence(lastChar, charIndex, charNumbers));
            }
        }

        return sequences;

    }

    public static List<CompressSequence> getAll2(String input) {
        final List<CompressSequence> sequences = new ArrayList<>();

        if (input.equals("~")) {
            sequences.add(new CompressSequence('~', 0, 1));
            return sequences;
        }

        Character lastChar;
        Character currentChar;

        int charIndex = 0;
        int charNumbers = 1;

        for (int i = 0; i < input.toCharArray().length - 1; i++) {
            lastChar = input.charAt(i);
            currentChar = input.charAt(i + 1);

            if (lastChar == currentChar) {
                charNumbers++;
            } else {
                if (lastChar == '~') {
                    sequences.add(new CompressSequence(lastChar, charIndex, charNumbers));
                } else if (charNumbers >= 4) {
                    sequences.add(new CompressSequence(lastChar, charIndex, charNumbers));
                }

                charIndex = i + 1;
                charNumbers = 1;
            }
        }

        return sequences;
    }

    public static List<CompressSequence> getAll(String input) {
        final List<CompressSequence> sequences = new ArrayList<>();

        Character lastChar = null;

        int charIndex = 0;
        int charNumbers = 1;

        for (int i = 0; i < input.toCharArray().length; i++) {

            char currentChar = input.charAt(i);

            if (lastChar != null && lastChar == currentChar) {
                charNumbers++;
            } else {
                if (charNumbers >= 4) {
                    sequences.add(new CompressSequence(lastChar, charIndex, charNumbers));
                }

                charIndex = i;
                charNumbers = 1;
            }

            lastChar = currentChar;
        }

        return sequences;
    }


}
