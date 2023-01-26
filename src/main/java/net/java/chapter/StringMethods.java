package net.java.chapter;

import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

public class StringMethods {
    //https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html
    public static void main(String[] args) {


        /*Java 1.5*/

        //The java string format() method returns the formatted string by given locale, format and arguments.
        //If you don't specify the locale in String.format() method, it uses default locale by calling Locale.getDefault() method

        /*
            %a	floating point (except BigDecimal)	Returns Hex output of floating point number.
            %b	Any type	"true" if non-null, "false" if null
            %c	character	Unicode character
            %d	integer (incl. byte, short, int, long, bigint)	Decimal Integer
            %e	floating point	decimal number in scientific notation
            %f	floating point	decimal number
            %g	floating point	decimal number, possibly in scientific notation depending on the precision and value.
            %h	any type	Hex String of value from hashCode() method.
            %n	none	Platform-specific line separator.
            %o	integer (incl. byte, short, int, long, bigint)	Octal number
            %s	any type	String value
            %t	Date/Time (incl. long, Calendar, Date and TemporalAccessor)	%t is the prefix for Date/Time conversions. More formatting flags are needed after this. See Date/Time conversion below.
            %x	integer (incl. byte, short, int, long, bigint) Hex string.
        */
        String format = String.format("Hello %s", "World");
        System.out.println(format); // Hello World

        String multiLineString = String.format("""
                Hello %s
                I am years %d old
                which is not %b
                """, "World", 10000, "");
        System.out.println(multiLineString);
        /*
        Hello World
        I am years 10000 old
        which is not true
         */


        /*Java 8*/
        // join()
        String joined = String.join("-", "apple", "banana", "orange");
        System.out.println(joined); // "apple-banana-orange"

        //lines()
        String s = "line1\nline2\nline3";
        Stream<String> lines = s.lines();
        lines.forEach(System.out::println);
        /*
        line1
        line2
        line3
         */

        //repeat()
        String repeated = "hello".repeat(3);
        System.out.println(repeated); // "hellohellohello"

        /*java 9*/
        //chrs() codePoints() - override method

        /*Java 10*/

        /*Java 11*/

        //isBlank()
        String s2 = "";
        System.out.println(s2.isBlank()); // true
        s2 = "   ";
        System.out.println(s2.isBlank()); // true
        s2 = "hello";
        System.out.println(s2.isBlank()); // false

        //strip()
        String s1 = "   hello world   ";
        System.out.println(s1.strip()); // "hello world"
        //stripLeading()
        System.out.println(s1.stripLeading()); // "hello world   "
        //stripTrailing()
        System.out.println(s1.stripTrailing()); // "   hello world"

        //Java 12
        //describeConstable() Returns an Optional containing the nominal descriptor for this instance, which is the instance itself
        String s4 = "hello";
        Optional<String> optional = s4.describeConstable(); //Optional[hello]
        optional.ifPresent(value -> {
            System.out.println("Value: " + optional.get());
        });

        //indent()
        String s3 = "Hello World";
        System.out.println(s3.indent(4)); // "    Hello World"

        //transform()
        var result = s3.transform(String::toUpperCase).transform(String::toCharArray);
        System.out.println(Arrays.toString(result)); // "HELLO WORLD" - [H, E, L, L, O,  , W, O, R, L, D]

        /*Java 13*/

        /*Java 15*/
        //formatted(Object... args) - is not a static method
        var singleLineF = "Hello %s".formatted("world");
        System.out.println(singleLineF);

        var multiLineFormatted = """
        Hello %s
        I am years %d old
        which is not %b
        """.formatted("World", 10000, "");
        System.out.println(multiLineFormatted);

        var stringObj = new String("Hello %s").formatted("World");
        System.out.println(stringObj);


        //translateEscapes() - which returns a new string by replacing escape sequences in the original string with the corresponding characters
        String s6 = "Hey, \\n This is not normally a line break."; // \\b,\\f,\\n,\\r,\\t,\\s,\\",\\',\\
        System.out.println(s6); //Hey, \n This is not normally a line break.
        System.out.println(s6.translateEscapes());
        /*
        Hey,
          This is not normally a line break.
        */

        //stripIndent()- which removes the common leading white space from every line in the string.
        String s7 = " line1\n line2\n line3";
        System.out.println(s7.stripIndent());
        /*
        line1
        line2
        line3
        */


        /* Java 17 */

        /*Java 1.1*/
        //toUpperCase(Locale locale) - which returns a new string in which all the characters in the string are in upper case, using the given locale's rules
        String s8 = "istanbul";
        System.out.println(s8.toUpperCase(Locale.ENGLISH)); // ISTANBUL
        System.out.println(s8.toUpperCase(new Locale("tr","TR"))); //İSTANBUL (in Turkish)

    }
}
