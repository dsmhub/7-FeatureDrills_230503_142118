import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
shorthand character class - a shorter way of representing a specific set of characters in a regex pattern

\d: Represents any digit, equivalent to [0-9].
\D: Represents any non-digit character, equivalent to [^0-9].
\w: Represents any word character (alphanumeric characters and underscore), equivalent to [A-Za-z0-9_].
\W: Represents any non-word character, equivalent to [^A-Za-z0-9_].
\s: Represents any whitespace character (spaces, tabs, and line breaks), equivalent to [ \t\n\x0B\f\r].
\S: Represents any non-whitespace character, equivalent to [^ \t\n\x0B\f\r].

*/

public class jt3 {

    public static void main(String[] args) {
        String dateStr = "03/05/2023";
        String time = "12:48:00";
        String url = "https://www.programiz.com/java-programming/variables-primitive-data-types";
        String ptn = "(\\d{2})/(\\d{2})/(\\d{4})";  //search key with capture groups delimited by "()"

        Pattern pattern = Pattern.compile(ptn);
        Matcher matcher = pattern.matcher(dateStr);
        StringBuilder sb = new StringBuilder(dateStr);

        String protocol, domain, path;
        char [] arr1;

        System.out.println(dateStr.lastIndexOf("0", 4));
        System.out.println(dateStr.length());
        //System.out.println(dateStr.matches("../../...."));
        //System.out.println(dateStr.matches(".*/.*/.*"));
        //System.out.println(dateStr.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}"));
        System.out.println(dateStr.matches("\\d{2}/\\d{2}/\\d{4}"));
        System.out.println(dateStr.contains("2023"));

        String day, month, year, hour, min, seconds;
        System.out.println("Matcher: " + matcher.find());
        day = dateStr.substring(0, 2);
        day = matcher.group(1);
        month = matcher.group(2);
        year = matcher.group(3);

        System.out.println(dateStr.replace("03", "07"));
        System.out.println(sb.reverse().toString());

        /**
         Regex
          . = ? single char wildcard (apart from new line char)
          .* = multi char wildcard (apart from new line char)

          ^.. startsWith
          ..$ endsWith

          Quantifiers
          (key)*..  - 0 or more times
          (key)+..  - 1 or more times
          (key)?..  - 0 or once
          (key){n}..  - n times

          \\d - digits
          \\D - non-digit character

          a dotall flag changes the behaviour of . to include newline characters
          (?s)pattern  - python/java
          /pattern/s - javascript

         */
    }

}
