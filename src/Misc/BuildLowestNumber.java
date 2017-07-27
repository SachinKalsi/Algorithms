package Misc;

/**
 * Created by kalsi on 27/07/17.
 */
public class BuildLowestNumber {
    //    Given a string ‘str’ of digits and an integer ‘n’, build the lowest possible number by removing ‘n’ digits from the string
//and not changing the order of input digits
    public static void main(String[] args) {
        int n = 765028321;
        int k = 5;
//        Input: n = "4325043", k = 3
//        Output: "2043"
//        Input: n = "121198", k = 2
//        Output: "1118"
        String lowestNumber = new BuildLowestNumber().getLowestNumber(n, k);
        if (lowestNumber == "e") {
            System.out.println("Invalid input");

        } else {
            System.out.println("Lowest number, after removing " + k + " digits is " + lowestNumber);
        }
    }

    private String getLowestNumber(int n, int k) {
        int lowestNumber = 0;
        String nInString = n + "";
        if (nInString.length() <= k) {
            return "e";
        }
        StringBuilder finalNumber = new StringBuilder();
        int totalDigitsInFinalString = nInString.length() - k;
        int min = 10;
        int index = 0;
        for (int i = 0; i < totalDigitsInFinalString; i++) {
            min = 10;
            for (int j = index; j < nInString.length(); j++) {
                if (Character.getNumericValue(nInString.charAt(j)) < min) {
                    int remainedCharacters = nInString.length() - j - 1;
                    int neededCharacters = totalDigitsInFinalString - finalNumber.length();
                    if (remainedCharacters >= neededCharacters-1) {
                        min = Character.getNumericValue(nInString.charAt(j));
                        index = j + 1;
                    }
                }
            }
            finalNumber.append(min);
        }
        return finalNumber.toString();
    }
}
