package net.java.chapter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 1. JEP 400: UTF-8 by Default
 * 2. JEP 408: Simple Web Server
 * 3. JEP 413: Code Snippets in Java API Documentation
 * 4. JEP 416: Reimplement Core Reflection with Method Handles
 * 5. JEP 417: Vector API (Third Incubator)
 * 6. JEP 418: Internet-Address Resolution SPI
 * 7. JEP 419: Foreign Function & Memory API (Second Incubator)
 * 8. JEP 420: Pattern Matching for switch (Second Preview)
 * 8.1. Dominance checking of the same type.
 * 8.2 Exhaustiveness of switch expressions and statements
 * 9. JEP 421: Deprecate Finalization for Removal
 */

//https://www.happycoders.eu/java/java-18-features/
public class Java18 {
    public static void main(String[] args) throws Exception {

        // 1.) Charset = UTF-8
        /** In Java 18, the default encoding standard charset to UTF-8. However, it's still allow configuring the default charset to others by providing the system property ‘file.encoding’. `java -Dfile.encoding=COMPAT`
         *
         * Before Java 18, the default charset was environment-dependent, meaning the Java Virtual Machine (JVM) chooses the default charset during start-up,
         * based on the run-time environment, like the operating system, the user’s locale, and other factors.
         * For example, on macOS, the default charset is UTF-8; on Windows, the default charset is ‘windows-1252’ (if English locale).
         * */

        //~/Library/Java/JavaVirtualMachines/corretto-17.0.3/Contents/Home/bin/java -Dfile.encoding=US-ASCII ./src/main/java/net/java/chapter/Java18.java

        /*Path path = Paths.get("happy-coding.txt");
        var s = "ハッピーコーディング！";
        Files.write(path, s.getBytes());

        String text = Files.readString(path);
        System.out.println(text);*/

        //2.) jwebserver
        /**
         * Provides a command-line tool, jwebserver to start a simple web server to serve static files, suitable for prototyping, ad-hoc coding, testing, and educational purpose, not for a production server.
         * It has some limitation
         * The only supported protocol is HTTP/1.1.
         * HTTPS is not provided.
         * Only the HTTP GET and HEAD methods are allowed.
         */

        // 3.) Code Snippets in Java API Documentation
        /**
         * OLD
         * need to start with <pre>
         * There must be no line breaks between <pre> and the code and between the code and </pre>.
         * The code starts directly after the asterisks; i.e., if there are spaces between the asterisks and the code, they also appear in the JavaDoc.
         * So the code must be shifted one character to the left compared to the rest of the text in the JavaDoc comment.
         *
         * NEW
         * @snippet tag, specifically designed to display source code
         *
         * @highlight – for example, all occurrences of "text" within the second line of code
         *
         * highlights all words starting with "write" within the block marked with @highlight region and @end. With type="…",
         *  we can also specify the type of highlighting: bold, italic, or highlighted (with a colored background).
         *
         * With @link, we can link a part of the text
         *
         * Integrate Snippets from Other Files
         */

    }






    // 3.) Code Snippets in Java API Documentation
    /**
     * <pre>{@code
     *     int sum = widgets.stream()
     *                      .filter(w -> w.getColor() == RED)
     *                      .mapToInt(w -> w.getWeight())
     *                      .sum();
     * }</pre>
     */

    //Inline snippets
    /**
     * The following code shows how to use {@code Optional.isPresent}:
     * {@snippet :
     * if (v.isPresent()) {
     *     System.out.println("v: " + v.get());
     * }
     * }
     */

    //External snippets
    /**
     * The following code shows how to use {@code Optional.isPresent}:
     * {@snippet file="ShowOptional.java" region="example"}
     */
    /*
        public class ShowOptional {
            void show(Optional<String> v) {
                // @start region="example"
                if (v.isPresent()) {
                    System.out.println("v: " + v.get());
                }
                // @end
            }
        }
     */


    // 4.) Reimplement Core Reflection with Method Handles
    /**
     * We can enable back the old implementation via -Djdk.reflect.useDirectMethodHandle=false.
     */

    // 5.) Vector API (Third Incubator)
    /**
     * Java 16, JEP 338 introduced new Vector API as an incubating API.
     * Java 17, JEP 414 enhanced the Vector API second incubator.
     *
     */

    // 6.) Internet-Address Resolution SPI
    /**
     * By default, the java.net.InetAddress API uses the operating system’s built-in resolver to resolve host names to Internet Protocol (IP) addresses
     * In this release java.net.InetAddress API to use service loader to find the resolver instead of using the operating system’s built-in resolver.
     *
     * InetAddress ip = InetAddress.getByName("google.com");
     *
     * private static InetAddressResolver loadResolver() {
     *       return ServiceLoader.load(InetAddressResolverProvider.class)
     *               .findFirst()
     *               .map(nsp -> nsp.get(builtinConfiguration()))
     *               .orElse(BUILTIN_RESOLVER);
     *  }
     */

    // 7.) Foreign Function & Memory API (Second Incubator)
    /**
     * This Foreign Function & Memory API allows the developer to access the code outside the JVM (foreign functions), data stored outside the JVM (off-heap data), and accessing memory not managed by the JVM (foreign memory).
     *
     * This JEP improves the Foreign Function & Memory API and other enhancements
     */

    // 8.) Pattern Matching for switch


    /**
     * Review the below switch pattern matching, every value that matches the String s also matches the CharSequence cs, which makes String s unreadable and will cause a compile-time error.
     *
     */
    /*static void error (Object o){
        switch (o) {
            case CharSequence cs -> System.out.println("A sequence of length " + cs.length());
            case String s ->    // Error - pattern is dominated by previous pattern
                    System.out.println("A string: " + s);
            default -> {
                break;
            }
        }
    }*/

    /**
     * Exhaustiveness of switch expressions and statements
     * The switch expression requires all possible values to be handled in the switch block, else prompts a compile-time error.
     */

    /*static int coverage(Object o) {
        return switch (o) {         // Error - not exhaustive
            case String s  -> s.length();
            case Integer i -> i;
        };
    }*/

    /*static int coverage(Object o) {
        return switch (o) {
            case String s  -> s.length();
            case Integer i -> i;
            default -> 0;
        };
    }*/

    // 9.) Deprecate Finalization for Removal
    /**
     * introduce in 1.0, was used for garbage collection
     * finalization for removal in the future release. In Java 18, we can use the command-line option --finalization=disabled to disable finalization. The finalization remains enabled by default;
     */
}
