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

public class CompressFilesTest {

    private List<String> testFiles = Arrays.asList(
            "test_file_a.txt"
    );

    @Test
    public void compressAll() {
        //get test folder
        final String testFolder = getClass().getResource("/compress_files").getFile();

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

        //go through test folder and compress each file
        for (String testFileName : testFiles) {
            compressFile(doneFolder, testFileName);
        }
    }

    private void compressFile(File doneFolder, String testFileName){
        System.out.printf("Compressing file '%s'%n", testFileName);

        //get file to compress
        final File file = new File(getClass().getResource("compress_files/" + testFileName).getFile());

        //calculate file size
        long uncompressedFileSize = file.length();
        System.out.printf("Uncompressed file is %d bytes big.%n", uncompressedFileSize);

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
        final String newFilePath = testFileName + ".cmprd";

        final File compressedFile = new File(doneFolder, newFilePath);

        final List<String> compressedLines = new ArrayList<>();

        //collect compressed lines
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String compressedLine = compression.compress(line);

            compressedLines.add(compressedLine);
        }

        //create file writer
        try (FileWriter fileWriter = new FileWriter(compressedFile)) {

            fileWriter.write(String.join(System.lineSeparator(), compressedLines));

        } catch (IOException ex) {
            Assert.fail(ex.getMessage());
        }

        long compressedFileSize = compressedFile.length();
        System.out.printf("Compressed file is %d bytes big.%n", compressedFileSize);
        System.out.printf("=> The compression removed %d bytes!%n", (uncompressedFileSize - compressedFileSize));
        System.out.println();
    }

}
