package de.maaxgr.studium.swe1.runlengthcompression.util;

import de.maaxgr.studium.swe1.runlengthcompression.entity.DecompressSequence;

import java.util.LinkedList;
import java.util.List;

public class DecompressSequenceFinder {

    public static List<DecompressSequence> findAll(String input) {
        final LinkedList<DecompressSequence> sequences = new LinkedList<>();

        if (input.equals("~~")) {
            sequences.push(new DecompressSequence(0, true));
            return sequences;
        }

        Character lastChar = null;

        for (int i = 0; i < input.toCharArray().length - 1; i++) {
            char currentChar = input.charAt(i);
            char nextChar = input.charAt(i + 1);

            if (lastChar != null) {
                if (lastChar == '~') {
                    if (currentChar == '~') {
                        sequences.add(new DecompressSequence(i - 1, true));

                        //skip one step, if two ~ next to each other
                        i++;
                        lastChar = nextChar;
                        continue;
                    } else {
                        sequences.add(new DecompressSequence(i - 1, nextChar, currentChar));
                    }
                }
            }
            lastChar = currentChar;
        }

        return sequences;
    }


}
