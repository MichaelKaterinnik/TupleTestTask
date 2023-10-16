package com;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

 */
public class App {
    public static void main( String[] args )
    {
        List<String> inputLines = new ArrayList<>();
        List<String> outputLines;

        try (BufferedReader fileReader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter("output.txt", true))) {
            // reading input data
            while (fileReader.ready()) {
                inputLines.add(fileReader.readLine());
            }

            System.out.println("checking reading the file");
            for (String s : inputLines) System.out.println(s);

            // working with requests
            outputLines = formTheResponse(inputLines);

            // writing the result
            System.out.println("checking for writing file");
            for (String s : outputLines) System.out.println(s);
            for (String s : outputLines) {
                fileWriter.write(s + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> formTheResponse(List<String> inputData) {
        List<String> outputData = new ArrayList<>();
        char[] mainString = inputData.get(1).toCharArray();
        System.out.println("checking line: " + Arrays.toString(mainString));

        for (int i = 2; i < inputData.size(); i++) {
            // getting the 3 digits of request - l,r,k as ints
            int[] request = Arrays.stream(inputData.get(i).split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println("checking request: " + Arrays.toString(request));

            outputData.add(String.valueOf(extractTheMatch(mainString, request)));
        }
        return outputData;
    }

    public static int extractTheMatch(char[] mainString, int[] request) {
        int l = request[0]; // number of the first symbol of request substring
        int r = request[1]; // number of the last symbol of request substring
        int k = request[2]; // number of checking symbol of request substring
        // making request substring from original input AB string
        char[] requestLine = Arrays.copyOfRange(mainString, l - 1, r);
        System.out.println("checking substring line: " + Arrays.toString(requestLine));

        // finding the match
        Character checkingSymbol = requestLine[k - 1];
        System.out.println("checking checkingSymbol: " + checkingSymbol);
        int otherLetterPosition = -1;
        if (checkingSymbol.equals('A')) {
            int aCounter = 0;
            int bCounter = 0;
            for (int j = 0; j < k; j++) {
                if (requestLine[j] == 'A') aCounter++;
            }
            System.out.println("checking otherLetterPosition: " + otherLetterPosition);
            for (int f = 0; f < requestLine.length; f++) {
                if (requestLine[f] == 'B') bCounter++;
                if (bCounter == aCounter) {
                    otherLetterPosition = f + 1;
                    System.out.println("checking otherLetterPosition: " + otherLetterPosition);
                    break;
                }
            }
        }
        if (checkingSymbol.equals('B')) {
            int aCounter = 0;
            int bCounter = 0;
            for (int j = 0; j < k; j++) {
                if (requestLine[j] == 'B') bCounter++;
            }
            System.out.println("checking otherLetterPosition: " + otherLetterPosition);
            for (int f = 0; f < requestLine.length; f++) {
                if (requestLine[f] == 'A') aCounter++;
                if (bCounter == aCounter) {
                    otherLetterPosition = f + 1;
                    System.out.println("checking otherLetterPosition: " + otherLetterPosition);
                    break;
                }
            }
        }
        System.out.println("checking otherLetterPosition: " + otherLetterPosition);
        return otherLetterPosition;
    }
}
