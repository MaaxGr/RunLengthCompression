package de.maaxgr.studium.swe1.runlengthcompression.entity;

public class CompressSequence {

    private char targetChar;
    private int startIndex;
    private int length;

    public CompressSequence(char targetChar, int startIndex, int length) {
        this.targetChar = targetChar;
        this.startIndex = startIndex;
        this.length = length;
    }

    @Override
    public String toString() {
        return "CompressSequence{" +
                "targetChar=" + targetChar +
                ", startIndex=" + startIndex +
                ", length=" + length +
                '}';
    }

    public char getTargetChar() {
        return targetChar;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getLength() {
        return length;
    }
}
