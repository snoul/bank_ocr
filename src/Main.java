import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        ReadFromOCR r1=new ReadFromOCR();
        r1.test();

        AccountValidation ac1 = new AccountValidation();
        ac1.validation();


        //   poprawia numer konta
//        String numer = "123456788";
//        System.out.println("Suma kontrolna poprawna? : " + AccountNumber.checkSum(numer));
//        System.out.println("Poprawiony nr konta: " + ErrorCorrection.guessNumber(numer));


    }}