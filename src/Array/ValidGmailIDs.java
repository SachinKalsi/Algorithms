package Array;

/**
 * Created by kalsi on 23/08/17.
 */
public class ValidGmailIDs {
    public static void main(String[] args) {
        new ValidGmailIDs().demo();
    }

    private void demo() {
        String emailId = "abcdefghijk@gmail.com"; // assuming no repeated characters
        displayValidEmailIds(emailId);
    }

    private void displayValidEmailIds(String emailId) {
        String name = emailId.split("@")[0];
        int count = name.length() - 1;
        StringBuilder sb = null;
        int total = 1 << count;
        // abcd
        for (int i = 0; i < total; i++) {
            sb = new StringBuilder(name);
            for (int j = 0; j < count; j++) {
                if ((1 & (i >> j)) == 1) {
                    sb = placeDot(sb, j, name);
                }
            }
            System.out.println(sb.toString() + "@gmail.com");
        }
    }

    private StringBuilder placeDot(StringBuilder sb, int index, String name) {
        int end = sb.indexOf(name.charAt(index) + "");
        return new StringBuilder(sb.substring(0, end+1) + '.' + sb.substring(end+1, sb.length()));
    }
}
