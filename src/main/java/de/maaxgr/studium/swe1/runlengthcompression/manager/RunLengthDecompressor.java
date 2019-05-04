package de.maaxgr.studium.swe1.runlengthcompression.manager;

import de.maaxgr.studium.swe1.runlengthcompression.util.AsciiUtil;

public class RunLengthDecompressor {

    public String run(String input) {
        final StringBuilder finalString = new StringBuilder();

        Character right = null;
        Character rightright = null;

        for (int i = 0; i < input.toCharArray().length - 2; i++) {
            char current = input.charAt(i);

            right = input.charAt(i + 1);
            rightright = input.charAt(i + 2);

            if (current == '~' && right != '~') {
                finalString.append(
                        decompressSequence(right, rightright)
                );
                i = i + 2;
            } else {
                finalString.append(current);
            }
        }

        finalString.append(right).append(rightright);

        String decompressedString = finalString.toString();
        decompressedString = decompressedString.replace("~~", "~");

        return decompressedString;
    }

    private String decompressSequence(char lengthChar, char targetChar) {
        return String.valueOf(targetChar).repeat(AsciiUtil.getNumberForAsciiChar(lengthChar) - 1);
    }
}
