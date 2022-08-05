package com.sports.rafael.basics.java;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.stream.Stream;

public class FilesTest {

    @Test
    public void testWriteSmallerFile() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("src/main/resources/testdata.csv", "r");
            long numSplits = 10; //from user input, extract it from args
            long sourceSize = raf.length();
            long bytesPerSplit = sourceSize / numSplits;
            long remainingBytes = sourceSize % numSplits;

            int maxReadBufferSize = 10 * 1024; //8KB
            for (int destIx = 1; destIx <= numSplits; destIx++) {
                BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("split." + destIx));
                if (bytesPerSplit > maxReadBufferSize) {
                    long numReads = bytesPerSplit / maxReadBufferSize;
                    long numRemainingRead = bytesPerSplit % maxReadBufferSize;
                    for (int i = 0; i < numReads; i++) {
                        readWrite(raf, bw, maxReadBufferSize);
                    }
                    if (numRemainingRead > 0) {
                        readWrite(raf, bw, numRemainingRead);
                    }
                } else {
                    readWrite(raf, bw, bytesPerSplit);
                }
                bw.close();
            }
            if (remainingBytes > 0) {
                BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("split." + (numSplits + 1)));
                readWrite(raf, bw, remainingBytes);
                bw.close();
            }
            raf.close();
        } catch (IOException e) {
            System.out.println("Error while reading files...");
            e.printStackTrace();
        }
    }


    static void readWrite(RandomAccessFile raf, BufferedOutputStream bw, long numBytes) throws IOException {
        byte[] buf = new byte[(int) numBytes];
        int val = raf.read(buf);
        if(val != -1) {
            bw.write(buf);
        }
    }


    @Test
    public void testDivideLinesIntoSmallerFiles() {
        try{
            // Reading file and getting no. of files to be generated
            String inputFile = "src/main/resources/testdata.csv"; //  Source File Name.
            double nOfLines = 50000.0; //  No. of lines to be split and saved in each output file.
            File file = new File(inputFile);
            Scanner scanner = new Scanner(file);
            int count = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }
            System.out.println("Lines in the file: " + count);     // Displays no. of lines in the input file.
            double temp = count/nOfLines;
            int tempInt = (int) temp;
            int nOfFiles = 0;
            if(tempInt == temp) {
                nOfFiles = tempInt;
            }
            else {
                nOfFiles = tempInt+1;
            }
            System.out.println("No. of files to be generated :"+nOfFiles); // Displays no. of files to be generated.
            //---------------------------------------------------------------------------------------------------------
            // Actual splitting of file into smaller files

            FileInputStream fstream = new FileInputStream(inputFile);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in)); String strLine;
            for (int j=1; j<=nOfFiles; j++) {
                FileWriter fstream1 = new FileWriter("/Users/shailendra.yadav/Documents/csvData/"+j+".txt");     // Destination File Location
                BufferedWriter out = new BufferedWriter(fstream1);
                for (int i=1; i<=nOfLines; i++) {
                    strLine = br.readLine();
                    if (strLine != null) {
                        out.write(strLine);
                        if(i != nOfLines) {
                            out.newLine();
                        }
                    }
                }
                out.close();
            }

            in.close();
        }catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

    @Test
    public void testReadFileInChunks() {
        try (
                InputStream inputStream = new FileInputStream("src/main/resources/testdata.csv");
                //BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                //OutputStream outputStream = new FileOutputStream(target);
                Stream<String> linesStream = bufferedReader.lines();
        ) {
//            byte[] buffer = new byte[4 * 1024];
//            int read;
//            while ((read = bufferedInputStream.read(buffer, 0, buffer.length)) != -1) {
//                //outputStream.write(buffer, 0, read);
//                System.out.println(read);
            linesStream.forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
