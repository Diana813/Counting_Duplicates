import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountingDuplicates {


    private static int numberOfCharsDuplicated;


    public static int duplicateCount(String text) {


        text = text.replaceAll("\\s", "");
        text = text.toLowerCase();
        String[] textArray = text.split("");
        Arrays.sort(textArray);
        int frequency = 0;
        List<String> dubbledCharsArray = new ArrayList<>();
        List<String> repeatedCharArray = new ArrayList<>();
        List<String> repeatedCharsAre = new ArrayList<>();

        System.out.println("Duplicated chars are: ");
        for (int i = 1; i < textArray.length; i++) {
            if (textArray[i].equals(textArray[i - 1])
                    || (!textArray[i].equals(textArray[textArray.length - 1])
                    && textArray[i].equals(textArray[i + 1]))) {
                dubbledCharsArray.add(textArray[i]);
            }
            if (textArray[0].equals(textArray[i])) {
                dubbledCharsArray.add(textArray[i]);
            }

        }

        if (dubbledCharsArray.size() != 0) {

            for (int j = 1; j < dubbledCharsArray.size(); j++) {

                if (dubbledCharsArray.get(j).equals(dubbledCharsArray.get(j - 1))) {
                    repeatedCharArray.add(dubbledCharsArray.get(j));
                    frequency = Collections.frequency(dubbledCharsArray, dubbledCharsArray.get(j));

                } else {
                    repeatedCharsAre.add(frequency + " " + dubbledCharsArray.get(j - 1));
                }
            }
            repeatedCharsAre.add(frequency + " " + dubbledCharsArray.get(dubbledCharsArray.size() - 1));
            System.out.println(repeatedCharsAre);
            numberOfCharsDuplicated = repeatedCharsAre.size();
            System.out.println("Number of chars duplicated is: " + numberOfCharsDuplicated);
        } else {
            numberOfCharsDuplicated = 0;
            System.out.println("Number of chars duplicated is: " + numberOfCharsDuplicated);
        }

        return numberOfCharsDuplicated;
    }

    public static void main(String[] args) {

        duplicateCount("ZaMrozony Tort");
    }
}
