import DataStructures.LinkedList.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class StringAlgorithms {

    public static boolean isAnagram(String string1, String string2) {
        int[] ASCIITable = new int[256];
        Arrays.fill(ASCIITable, 0);
        for (int i = 0; i < string1.length(); i++) {
            ASCIITable[string1.charAt(i)]++;
        }
        for (int i = 0; i < string2.length(); i++) {
            ASCIITable[string2.charAt(i)]--;
        }
        for (int charFrequency : ASCIITable) {
            if (charFrequency != 0) {
                return false;
            }
        }
        return true;
    }

    public static String reverseOrderOfTheWordsInString(String string) {

        StringBuilder reversedString = new StringBuilder("");
        StringBuilder stringBuilder = new StringBuilder(string);

        stringBuilder.insert(0, " ");
        stringBuilder.append(" ");

        ArrayList<String> StringSentence = new ArrayList<>();
        int initial = 0;
        int terminal = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
//            System.out.println(i + " iteration:");
            if (stringBuilder.charAt(i) == ' ') {
                if (i == stringBuilder.length() - 1) {
                    terminal = stringBuilder.length() - 1;
                } else {
                    terminal = i;
                }
                StringSentence.add(stringBuilder.substring(initial, terminal));
//                System.out.println("Initial: "+initial+" Terminal: "+terminal+"\n"+"The word is:"+StringSentence);
            }
            initial = terminal;
        }

        for (int i = StringSentence.size() - 1; i > -1; i--) {
            reversedString.append(StringSentence.get(i));
        }

        return reversedString.toString();

    }

    public static char[] reverseString(char[] chars, int start, int end) {

        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
        return chars;
    }

    public static String reverseOrderOfTheWordsInStringOptimized(String string) {
        char[] givenString = string.toCharArray();

        int start = 0;
        int end = 0;

        for (; end < givenString.length; end++) {
            if (givenString[end] == ' ') {
                reverseString(givenString, start, end - 1);
                start = end + 1;
            }
        }
        reverseString(givenString, start, end - 1);
        return new String(reverseString(givenString, 0, givenString.length - 1));
    }

    public static ArrayList<Pair> PatternMatchingOfString(String string, String pattern) {
        ArrayList<Pair> FoundAt = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == pattern.charAt(0)) {
                for (int j = 0; j < pattern.length(); j++) {
                    if (pattern.charAt(j) == string.charAt(i + j)) {
                        if (j == pattern.length() - 1) {
                            FoundAt.add(new Pair(i, (i + j)));
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return FoundAt;
    }

    public static int HashCode(String string, int start, int end) {
        int basevalue = 256;
        int hashcode = 0;
        for (int i = start; i <= end; i++) {
            hashcode = hashcode + (((int) string.charAt(i)) * (Mathematics.FastPower(basevalue, (end-i))));
        }
        return hashcode;
    }

    public static int HashCode(String string) {
        int basevalue = 256;
        int hashcode = 0;
        for (int i = 0; i < string.length(); i++) {
            hashcode = hashcode + ((int)string.charAt(i))*Mathematics.FastPower(basevalue,string.length()-1-i);
        }
        return hashcode;
    }
    //%(Mathematics.FastPower(10,9)+7)

    public static ArrayList<Pair> RabinKarp(String string, String pattern,int method) {
        int patternHashCode = HashCode(pattern);
        int lengthOfPattern = pattern.length();
        int initialHashCode = HashCode(string,0,lengthOfPattern-1);
        int dynamicHashCode = 0;
        ArrayList<Pair> intervals = new ArrayList<>();

        switch(method){
            case 1:
                for(int i = 0; i<=string.length()-pattern.length();i++){
                    dynamicHashCode = HashCode(string,i,i+pattern.length()-1);
                    if(dynamicHashCode == patternHashCode){
                        intervals.add(new Pair(i,i+pattern.length()));
                    }
                }
                break;
            case 2:
                dynamicHashCode = initialHashCode;
                if(initialHashCode == patternHashCode){
                    intervals.add(new Pair(1,lengthOfPattern));
                }
                for(int i = 0;i<(string.length()-lengthOfPattern);i++){
                    dynamicHashCode = (((dynamicHashCode)-((int)string.charAt(i)*Mathematics.FastPower(256,lengthOfPattern-1)))*256)+(int)string.charAt(i+lengthOfPattern);
                    if(dynamicHashCode == patternHashCode){
                        intervals.add(new Pair(i+1,i+lengthOfPattern));
                    }
                }
                break;
        }
        return intervals;
    }
}
