package work.icu007.day04.regex;

public class RegexDemo {
    public static void main(String[] args) {
        String str = "abc123def456ghi";
        String regex = "\\d+";
        String[] arr = str.split(regex);
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
