package org.wc;

import picocli.CommandLine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@CommandLine.Command(name = "Word Count", description = "Project to mimic Linux's wc command", mixinStandardHelpOptions = true)
public class WordCount implements Runnable{

    @CommandLine.Option(names = {"-l"}, description = "Enable counting of lines")
    private boolean enableLines;

    @CommandLine.Option(names = {"-w"}, description = "Enable counting of words")
    private boolean enableWords;

    @CommandLine.Option(names = {"-m"}, description = "Enable counting of characters")
    private boolean enableCharacters;

    @CommandLine.Parameters(index = "0", description = "The file to process.")
    private String FILE_NAME;

    public static void main(String[] args) {
        CommandLine cmd = new CommandLine(new WordCount());
        cmd.execute(args);
    }

    @Override
    public void run() {
        int lines = 0;
        int words = 0;
        int characters = 0;

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(FILE_NAME))) {
            String currLine;
            while ((currLine = bufferedReader.readLine()) != null) {
                String line = currLine.trim();
                String[] wordsInCurrentLine = line.split("\\s+");
                lines++;
                // empty line check
                if (wordsInCurrentLine.length == 1 && wordsInCurrentLine[0].length() == 0) {
                    continue;
                }
                words += wordsInCurrentLine.length;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // -m character counting will work only using bufferedReader.read() and not using bufferedReader.readLine()
        // because of encoding issues.
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            while (bufferedReader.read() != -1) {
                characters++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] filenameArr = FILE_NAME.split("/");
        if (!(enableLines || enableWords || enableCharacters)) {
            System.out.println("\t" + lines + "\t" + words + "\t" + characters + "\t" + filenameArr[filenameArr.length - 1]);
        } else {
            System.out.print("\t");
            if (enableLines) {
                System.out.print(lines + "\t");
            }
            if (enableWords) {
                System.out.print(words + "\t");
            }
            if (enableCharacters) {
                System.out.print(characters + "\t");
            }
            System.out.print(filenameArr[filenameArr.length - 1]);
        }
    }
}