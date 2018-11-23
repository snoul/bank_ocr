
import java.io.*;
import java.util.*;

public class ReadFromOCR {



    void test() throws IOException {
       SaveToFile fileWithAcc= new SaveToFile();
       fileWithAcc.save();
        BufferedReader br;
        br = new BufferedReader(new FileReader("c://bank_ocr_dojo_us4"));
        ArrayList<String> phrases = new ArrayList<String>();
        while (br.ready()) {
            phrases.add(br.readLine());
        }

        int firstIndex = 0;
        int lastIndex = 4;
        int longArr = phrases.size() / 4;
        for (int ii = 0; ii < longArr; ii++) {
           // System.out.print("Account number: ");
            ArrayList<String> digit = new ArrayList<String>((phrases));
            List<String> numberArray = digit.subList(firstIndex, lastIndex);

            StringBuilder builder = new StringBuilder();   // tworze stringa z arraylisty zeby
            for (String value : numberArray) {                // zeby zaraz go spowrotem przerobic na array liste
                builder.append(value);                     // bo wtedy ladnie sie dzieli na mniejsze arralisty i latwo wyciagnac
            }                                              // poszczegolne indeksy
            String testDigit = builder.toString();

            ArrayList<String> wordArrayList = new ArrayList<String>();
            for (String word : testDigit.split("")) {           // rozbicie stringa na arraylist
                wordArrayList.add(word);
            }

            int a = 0;
            int r= 9;
            for (int k = 0; k < 9; k++) {    r--;                             // wybranie poszczegolnych czesci arraylisty
                ArrayList<String> digitArray = new ArrayList<String>();       // zeby mozna bylo podzielic na poszczegolne cyferki
                for (int j = 0; j < 81; j = j + 27) {                    // i je skolei latwo porownac do stringow
                    for (int i = 0; i < 3; i++) {
                        digitArray.add(wordArrayList.get(i + j + a));
                    }
                }
                a = a + 3;

                StringBuilder builder1 = new StringBuilder();         // i kolejna zamiana arraylisty na stringa
                for (String value : digitArray) {                         // zrobilem to dlatego ze jak porownywlem arraylisty
                    builder1.append(value);                           // to nic nie wychodzilo a ze stringami poszlo gladko
                }                                                     // ten fragment mozna zmienic jesli wiesz jak porownac arraylisty zeby bylo dobrze
                String text = builder1.toString();                    // digitArray to arraylista z wybrana cyferka i ja trzeb by bylo porownac
                String zero = " _ | ||_|";
                String one = "     |  |";
                String two = " _  _||_ ";
                String three = " _  _| _|";
                String four = "   |_|  |";
                String five = " _ |_  _|";
                String six = " _ |_ |_|";
                String seven = " _   |  |";
                String eight = " _ |_||_|";
                String nine = " _ |_| _|";

                if (text.equals(zero)) {
                    System.out.print("0");
                } else if (text.equals(one)) {
                    System.out.print("1");
                } else if (text.equals(two)) {
                    System.out.print("2");
                } else if (text.equals(three)) {
                    System.out.print("3");
                } else if (text.equals(four)) {
                    System.out.print("4");
                } else if (text.equals(five)) {
                    System.out.print("5");
                } else if (text.equals(six)) {
                    System.out.print("6");
                } else if (text.equals(seven)) {
                    System.out.print("7");
                } else if (text.equals(eight)) {
                    System.out.print("8");
                } else if (text.equals(nine)) {
                    System.out.print("9");
                }else System.out.print("?");

            }

            firstIndex = firstIndex + 4;
            lastIndex = lastIndex + 4;
            System.out.println("");

        }


    }
}