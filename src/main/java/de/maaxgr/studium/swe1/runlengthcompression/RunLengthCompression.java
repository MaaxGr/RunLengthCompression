package de.maaxgr.studium.swe1.runlengthcompression;

import de.maaxgr.studium.swe1.runlengthcompression.iface.Compression;
import de.maaxgr.studium.swe1.runlengthcompression.manager.RunLengthCompressor;
import de.maaxgr.studium.swe1.runlengthcompression.manager.RunLengthDecompressor;

public class RunLengthCompression implements Compression {

    public String compress(String input) {
        return new RunLengthCompressor().run(input);
    }

    public String decompress(String input) {
        return new RunLengthDecompressor().run(input);
    }

}
