import de.maaxgr.studium.swe1.runlengthcompression.RunLengthCompression;
import de.maaxgr.studium.swe1.runlengthcompression.iface.Compression;
import de.maaxgr.studium.swe1.runlengthcompression.util.FileUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DecompressFilesTest {

    private List<String> testFiles = Arrays.asList(
            "test_file_a.txt"
    );

    @Test
    public void decompressAll() {
        //get test folder
        final String testFolder = getClass().getResource("/decompress_files").getFile();

        //get done folder in test folder
        final File doneFolder = new File(testFolder + "/done");

        //check if folder already exist and delete if so
        if (doneFolder.exists()) {
            System.out.println("Output folder already exist! Deleting it...");

            if (!FileUtil.deleteFolder(doneFolder)) {
                Assert.fail("Error. Cannot delete done/ folder!");
                return;
            }
        }

        //(re)create done folder
        if (!doneFolder.mkdir()) {
            Assert.fail("Error. Cannot create done/ folder!");
            return;
        }

        System.out.println();

        //go through test folder and decompress each file
        for (String testFileName : testFiles) {
            decompressFile(doneFolder, testFileName);
        }
    }

    private void decompressFile(File doneFolder, String testFileName) {
        System.out.printf("Decompressing file '%s'%n", testFileName);

        //get file to decompress
        final File file = new File(getClass().getResource("decompress_files/" + testFileName).getFile());

        //calculate file size
        long compressedFileSize = file.length();
        System.out.printf("Compressed file is %d bytes big.%n", compressedFileSize);

        //read in file via scanner
        final Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            Assert.fail(e.getMessage());
            return;
        }

        //create run length compression class
        final Compression compression = new RunLengthCompression();

        //create compressed file
        final String newFilePath = testFileName + ".decmprd";

        //build file instance
        final File decompressedFile = new File(doneFolder, newFilePath);

        final List<String> decompressedLines = new ArrayList<>();

        //collect decompressed lines
        while (scanner.hasNextLine()) {
            String fileLine = scanner.nextLine();
            String decompressedLine = compression.decompress(fileLine);

            decompressedLines.add(decompressedLine);
        }

        //open file writer
        try (FileWriter fileWriter = new FileWriter(decompressedFile)) {

            //write decompressed lines to file writer
            fileWriter.write(String.join(System.lineSeparator(), decompressedLines));

        } catch (IOException ex) {
            Assert.fail(ex.getMessage());
        }

        long uncompressedFileSize = decompressedFile.length();
        System.out.printf("Uncompressed file is %d bytes big.%n", uncompressedFileSize);
        System.out.printf("=> The decompression added %d bytes!%n", (uncompressedFileSize - compressedFileSize));
        System.out.println();
    }

}
