import java.util.regex.Matcher;
import java.util.regex.Pattern;

class AccountNumber {

    //ilosc cyfr skladajacych sie na numer konta
    final static int NO_OF_ACC_DIGITS = 9;

    //oblicza sume kontrolna i zwraca wartosc true gdy jest poprawna lub false w przeciwnym przypadku
    //zawsze zwraca false jesli dlugosc przekazanego numeru konta jest różna od zadanej
    static boolean checkSum (String accountNumber) {

        //niepotrzebne
        //if (accountNumber.length() != NO_OF_ACC_DIGITS) throw new IllegalArgumentException("Nr konta musi miec 9 znakow : " + accountNumber);

        if (!isValidIntegerN(accountNumber)) return false;
        else {
            int digit;
            int chksum = 0;

            for (int i = 0; i < NO_OF_ACC_DIGITS; i++) {
                digit = Integer.parseInt(accountNumber.substring(NO_OF_ACC_DIGITS - 1 - i, NO_OF_ACC_DIGITS - i));
                chksum += (i + 1) * digit;
            }

            return chksum % 11 == 0;
        }
    }

    //sprawdza czy accountNumber jest liczbą (bez znaku) o NO_OF_ACC_DIGITS ilości cyfr
    public static boolean isValidIntegerN (String accountNumber) {
        String regex = "[0-9]{" + NO_OF_ACC_DIGITS + "}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(accountNumber);
        if(m.find() && m.group().equals(accountNumber))
            return true;
        else
            return false;
    }

//    public static int getNoOfAccDigits() {
//        return NO_OF_ACC_DIGITS;
//    }
}
