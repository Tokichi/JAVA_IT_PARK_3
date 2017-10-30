import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DataReader {
    private final static int MAX_STRING_SIZE = 15;
    private final static int MAX_INTEGER_SIZE = 2;

    private InputStream input;

    public DataReader(String fileName) {
        try {
            input = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

//    public int stringNumber() {
//        try {
//            return stringNumber0();
//        } catch (IOException e) {
//            throw new IllegalArgumentException(e);
//        }
//    }

//    private int stringNumber0() throws IOException {
//        int stringNum = 0;
//        int currentByte = input.read();
//        while (currentByte != -1) {
//            while (currentByte != 13 && currentByte != -1) {
//                currentByte = input.read();
//            }
//            currentByte = input.read();
//            stringNum++;
//        }
//        return stringNum - 1;
//    }

    public Human readHuman() {
        try {
            return readHuman0();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }


    private Human readHuman0() throws IOException {
        char currentWord[] = new char[MAX_STRING_SIZE];
        int currentNumber[] = new int[MAX_INTEGER_SIZE];
        int lettersCountName = 0;
        int digitsCountAge = 0;
        int currentByte = input.read();
        String name = null;
        int age = 0;
        while (currentByte != 13 && currentByte != -1) {
            if (currentByte >= 'A' && currentByte <= 'Z' ||
                    currentByte >= 'a' && currentByte <= 'z') {
                currentWord[lettersCountName] = (char) currentByte;
                lettersCountName++;
            }
            if (currentByte >= '0' && currentByte <= '9') {
                currentNumber[digitsCountAge] = currentByte - '0';
                digitsCountAge++;
            }
            currentByte = input.read();
        }
        if (currentByte == -1) {
            Human newhuman = new Human("Finish", 0);
            return newhuman;
        }
        name = new String(currentWord, 0, lettersCountName);
        int pow = 1;
        for (int i = digitsCountAge - 1; i >= 0; i--) {
            age = age + currentNumber[i] * pow;
            pow = pow * 10;
        }
        Human newhuman = new Human(name, age);
        return newhuman;
    }
}