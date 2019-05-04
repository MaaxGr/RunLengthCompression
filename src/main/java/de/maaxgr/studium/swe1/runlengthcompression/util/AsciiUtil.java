package de.maaxgr.studium.swe1.runlengthcompression.util;

public class AsciiUtil {

    private static final int minNumber = 2;
    private static final int maxNumber = 95;
    private static final char minChar = ' ';
    private static final char maxChar = '}';

    public static char getAsciiCharForNumber(int number) {

        if (number < minNumber || number > maxNumber) {
            throw new IllegalArgumentException(String.format(
                    "Argument number has to be between '%d' and '%d'", minNumber, maxNumber
            ));
        }

        return (char) (number + 30);
    }

    public static int getNumberForAsciiChar(char character) {

        if (character < minChar || character > maxChar) {
            throw new IllegalArgumentException(String.format(
                    "Argument character has to be between '%c' and '%c'", minChar, maxChar
            ));
        }

        return character - 30;
    }

}
