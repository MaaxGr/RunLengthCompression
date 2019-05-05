package de.maaxgr.studium.swe1.runlengthcompression.entity;

public class DecompressSequence {

    private int startIndex;
    private char targetChar;
    private char lengthChar;
    private boolean doubleTilde;

    public DecompressSequence(int startIndex, char targetChar, char lengthChar) {
        this.startIndex = startIndex;
        this.targetChar = targetChar;
        this.lengthChar = lengthChar;
    }

    public DecompressSequence(int startIndex, boolean doubleTilde) {
        this.startIndex = startIndex;
        this.doubleTilde = doubleTilde;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public char getTargetChar() {
        return targetChar;
    }

    public char getLengthChar() {
        return lengthChar;
    }

    public boolean isDoubleTilde() {
        return doubleTilde;
    }

    @Override
    public String toString() {
        return "DecompressSequence{" +
                "startIndex=" + startIndex +
                ", targetChar=" + targetChar +
                ", lengthChar=" + lengthChar +
                ", doubleTilde=" + doubleTilde +
                '}';
    }
}
