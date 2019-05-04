package de.maaxgr.studium.swe1.runlengthcompression.iface;

public interface Compression {

    String compress(String input);

    String decompress(String input);

}
