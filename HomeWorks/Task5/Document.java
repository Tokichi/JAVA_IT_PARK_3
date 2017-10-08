public class Document {
    // каждый объект класса будет иметь свои копии
    // count и lines
    int count = 0;
    String lines[] = new String[5];
    String documetName;

    void showDocument() {
        for (int i = 0; i < lines.length; i++) {
            // тернарный условный оператор e ? a : b
            String lineToOut = lines[i] == null ? "_______" : lines[i];
            System.out.println(i + ": " + lineToOut);
        }
    }

    void addLineToBegin(String newLine) {
        for (int i = count; i > 0; i--) {
            lines[i] = lines[i - 1];
        }
        lines[0] = newLine;
        count++;
    }

    void addLineToEnd(String newLine) {
        lines[count] = newLine;
        count++;
    }

    void deleteLine(int numLine) {
        for (int i = numLine; i < lines.length - 1; i++) {
            lines[i] = lines[i + 1];
        }
        lines[lines.length - 1] = null;
        count--;
    }

    void changeLine(int numLine, String newLine) {
        lines[numLine] = newLine;
    }

    void clearLine(int numLine) {
        lines[numLine] = null;
    }

}