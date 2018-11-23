import java.io.*;


public class AccountValidation {

      public void validation() throws IOException {

        String textLine;
        FileReader fileReader = new FileReader("accountNumbers.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String wrongDigit = "?";
        textLine = bufferedReader.readLine();

        while (textLine != null) {
            if (textLine.contains(wrongDigit)) {
                textLine += " ILL ";
            } else {
                if (!(AccountNumber.checkSum(textLine))) {
                    textLine += " ERR ";
                }
            }
            PrintWriter writeToFile = new PrintWriter(new FileOutputStream(
                    new File("verifiedAccountNumbers.txt"),
                    true));
            writeToFile.println(textLine);
            writeToFile.close();
            textLine = bufferedReader.readLine();
        }
        bufferedReader.close();
    }
}