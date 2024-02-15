/*
 * author: Itmam Alam
 * class: TelNumber
 * date: 30.09.2023
 * */

public class TelNumber {
    private String number;

    private TelNumber(String number) {
        setNumber(number);
    }

    public static TelNumber getInstance(String number) {
        String cleanNumber = number.replaceAll("[^0-9]", "");
        if (isCorrect(cleanNumber)) {
            return new TelNumber(number);
        } else {
            return null;
        }
    }

    private static boolean isCorrect(String number) {
        int sum = 0;
        char[] digits = number.toCharArray();
        if (digits.length != 10) {
            return false;
        }
        for (char digit : digits) {
            if (digit >= '0' && digit <= '9') {
                sum += Character.getNumericValue(digit);
            }
        }
        return sum % 4 == 0;
    }

    public String getNumber() {
        return number;
    }

    private void setNumber(String number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "@" + getNumber();
    }
}
