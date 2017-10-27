package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DataReader {
    private final static int MAX_INTEGER_SIZE = 2;
    private final static int MAX_STRING_SIZE = 50;
    private InputStream input;
    private String string;

    public DataReader(String fileName) {
        try {
            input = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String readString() {
        try {
            return readString0();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private String readString0() throws IOException {
        char currentWord[] = new char[MAX_STRING_SIZE];
        int lettersCount = 0;
        int currentByte = input.read();
        String result = null;
        while (currentByte != -1) {
            currentWord[lettersCount] = (char) currentByte;
            lettersCount++;
            if (lettersCount != 0) {
                result = new String(currentWord, 0, lettersCount);
                return result;
            }
            currentByte = input.read();
        }
        result = new String(currentWord, 0, lettersCount);
        return result;
    }

    public int readInteger() {
        try {
            return readInteger0();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private int readInteger0() throws IOException {
        int currentNumber[] = new int[MAX_INTEGER_SIZE];
        int digitsCount = 0;
        int currentByte = input.read();
        int result = 0;
        while (currentByte != -1) {
            if (currentByte >= '0' && currentByte <= '9') {
                currentNumber[digitsCount] = currentByte - '0';
                digitsCount++;
            } else if (digitsCount != 0) {
                int pow = 1;
                for (int i = digitsCount - 1; i >= 0; i--) {
                    result = result + currentNumber[i] * pow;
                    pow = pow * 10;
                }
                return result;
            }
            currentByte = input.read();
        }
        int pow = 1;
        for (int i = digitsCount - 1; i >= 0; i--) {
            result = result + currentNumber[i] * pow;
            pow = pow * 10;
        }
        return result;
    }
}
