/* tabela podmiany cyfr. x oznacza, ze nie ma na co podmieniac
0 -> 8
1 -> 7
2 -> x
3 -> 9
4 -> x
5 -> 6, 9
6 -> 5, 8
7 -> 1
8 -> 0, 6, 9
9 -> 3, 5, 8
*/

class ErrorCorrection {

    //zwraca poprawiony nr konta lub kod bledu (AMB lub ILL) jesli sie nie uda znalezc pasujacego numeru
    static String guessNumber (String incorrectAccountNumber) {

        int numberOfAlternatives = 0;
        StringBuilder tryAccountNumber = new StringBuilder( AccountNumber.NO_OF_ACC_DIGITS );
        StringBuilder newAccountNumber = new StringBuilder( AccountNumber.NO_OF_ACC_DIGITS );

//        if (incorrectAccountNumber.length() != AccountNumber.NO_OF_ACC_DIGITS) return "ILL";
        if (!AccountNumber.isValidIntegerN(incorrectAccountNumber)) return "ILL";
        else {
            for (int position = 0; position < AccountNumber.NO_OF_ACC_DIGITS; position++) {
                char digit =  incorrectAccountNumber.charAt(position);
                switch (digit) {
                    case '0':
                        tryAccountNumber.replace(0, tryAccountNumber.length(), replaceAccountDigitAt(incorrectAccountNumber, position, 8));
                        if (AccountNumber.checkSum(tryAccountNumber.toString())) {
                            numberOfAlternatives++;
                            newAccountNumber.replace(0, tryAccountNumber.length(), tryAccountNumber.toString());
                        }
                        break;
                    case '1':
                        tryAccountNumber.replace(0, tryAccountNumber.length(), replaceAccountDigitAt(incorrectAccountNumber, position, 7));
                        if (AccountNumber.checkSum(tryAccountNumber.toString())) {
                            numberOfAlternatives++;
                            newAccountNumber.replace(0, tryAccountNumber.length(), tryAccountNumber.toString());
                        }
                        break;
                    case '3':
                        tryAccountNumber.replace(0, tryAccountNumber.length(), replaceAccountDigitAt(incorrectAccountNumber, position, 9));
                        if (AccountNumber.checkSum(tryAccountNumber.toString())) {
                            numberOfAlternatives++;
                            newAccountNumber.replace(0, tryAccountNumber.length(), tryAccountNumber.toString());
                        }
                        break;
                    case '5':
                        tryAccountNumber.replace(0, tryAccountNumber.length(), replaceAccountDigitAt(incorrectAccountNumber, position, 6));
                        if (AccountNumber.checkSum(tryAccountNumber.toString())) {
                            numberOfAlternatives++;
                            newAccountNumber.replace(0, tryAccountNumber.length(), tryAccountNumber.toString());
                        }
                        tryAccountNumber.replace(0, tryAccountNumber.length(), replaceAccountDigitAt(incorrectAccountNumber, position, 9));
                        if (AccountNumber.checkSum(tryAccountNumber.toString())) {
                            numberOfAlternatives++;
                            newAccountNumber.replace(0, tryAccountNumber.length(), tryAccountNumber.toString());
                        }
                        break;
                    case '6':
                        tryAccountNumber.replace(0, tryAccountNumber.length(), replaceAccountDigitAt(incorrectAccountNumber, position, 5));
                        if (AccountNumber.checkSum(tryAccountNumber.toString())) {
                            numberOfAlternatives++;
                            newAccountNumber.replace(0, tryAccountNumber.length(), tryAccountNumber.toString());
                        }
                        tryAccountNumber.replace(0, tryAccountNumber.length(), replaceAccountDigitAt(incorrectAccountNumber, position, 8));
                        if (AccountNumber.checkSum(tryAccountNumber.toString())) {
                            numberOfAlternatives++;
                            newAccountNumber.replace(0, tryAccountNumber.length(), tryAccountNumber.toString());
                        }
                        break;
                    case '7':
                        tryAccountNumber.replace(0, tryAccountNumber.length(), replaceAccountDigitAt(incorrectAccountNumber, position, 1));
                        if (AccountNumber.checkSum(tryAccountNumber.toString())) {
                            numberOfAlternatives++;
                            newAccountNumber.replace(0, tryAccountNumber.length(), tryAccountNumber.toString());
                        }
                        break;
                    case '8':
                        tryAccountNumber.replace(0, tryAccountNumber.length(), replaceAccountDigitAt(incorrectAccountNumber, position, 0));
                        if (AccountNumber.checkSum(tryAccountNumber.toString())) {
                            numberOfAlternatives++;
                            newAccountNumber.replace(0, tryAccountNumber.length(), tryAccountNumber.toString());
                        }
                        tryAccountNumber.replace(0, tryAccountNumber.length(), replaceAccountDigitAt(incorrectAccountNumber, position, 6));
                        if (AccountNumber.checkSum(tryAccountNumber.toString())) {
                            numberOfAlternatives++;
                            newAccountNumber.replace(0, tryAccountNumber.length(), tryAccountNumber.toString());
                        }
                        tryAccountNumber.replace(0, tryAccountNumber.length(), replaceAccountDigitAt(incorrectAccountNumber, position, 9));
                        if (AccountNumber.checkSum(tryAccountNumber.toString())) {
                            numberOfAlternatives++;
                            newAccountNumber.replace(0, tryAccountNumber.length(), tryAccountNumber.toString());
                        }
                        break;
                    case '9':
                        tryAccountNumber.replace(0, tryAccountNumber.length(), replaceAccountDigitAt(incorrectAccountNumber, position, 3));
                        if (AccountNumber.checkSum(tryAccountNumber.toString())) {
                            numberOfAlternatives++;
                            newAccountNumber.replace(0, tryAccountNumber.length(), tryAccountNumber.toString());
                        }
                        tryAccountNumber.replace(0, tryAccountNumber.length(), replaceAccountDigitAt(incorrectAccountNumber, position, 5));
                        if (AccountNumber.checkSum(tryAccountNumber.toString())) {
                            numberOfAlternatives++;
                            newAccountNumber.replace(0, tryAccountNumber.length(), tryAccountNumber.toString());
                        }
                        tryAccountNumber.replace(0, tryAccountNumber.length(), replaceAccountDigitAt(incorrectAccountNumber, position, 8));
                        if (AccountNumber.checkSum(tryAccountNumber.toString())) {
                            numberOfAlternatives++;
                            newAccountNumber.replace(0, tryAccountNumber.length(), tryAccountNumber.toString());
                        }
                        break;
//                    case '?':
//                        return "ILL";
                }
                if (numberOfAlternatives > 1) return "AMB";
            }
        }
        if (numberOfAlternatives == 0) return "ILL";
        return newAccountNumber.toString();
    }

    public static String replaceAccountDigitAt (String accountNumber, int position, int digit) {
        if (accountNumber == null || position < 0 || position >= accountNumber.length()) return accountNumber;
        else
            return accountNumber.substring(0, position) + String.valueOf(digit) + accountNumber.substring(position+1);
    }
}
