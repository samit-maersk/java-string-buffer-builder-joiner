package net.java.chapter;

import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.ServiceLoader;

/**
 * 1. JEP 400: UTF-8 by Default
 * 2. JEP 408: Simple Web Server
 * 3. JEP 413: Code Snippets in Java API Documentation
 * 4. JEP 418: Internet-Address Resolution SPI
 * 5. JEP 420: Pattern Matching for switch (Second Preview)
 * 6. JEP 416: Reimplement Core Reflection with Method Handles
 * 7. JEP 417: Vector API (Third Incubator)
 * 8. JEP 419: Foreign Function & Memory API (Second Incubator)
 * 9. JEP 421: Deprecate Finalization for Removal
 */

//https://www.happycoders.eu/java/java-18-features/
public class Java18 {
    public static void main(String[] args) throws Exception {

        // 1.) JEP 400: UTF-8 by Default
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

        //2.) JEP 408: Simple Web Server (jwebserver)
        /**
         * Provides a command-line tool, jwebserver to start a simple web server to serve static files, suitable for prototyping, ad-hoc coding, testing, and educational purpose, not for a production server.
         * It has some limitation
         * The only supported protocol is HTTP/1.1.
         * HTTPS is not provided.
         * Only the HTTP GET and HEAD methods are allowed.
         */

        // 3.) JEP 413: Code Snippets in Java API Documentation
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

        // 4.) JEP 418: Internet-Address Resolution SPI
        /**
         * Since 1.0
         * To find out the IP address(es) for a hostname in Java, we can use InetAddress.getByName(…) or InetAddress.getAllByName(…).
         */
        /*
        var allByName = InetAddress.getAllByName("www.maersk.com");
        Arrays.stream(allByName).forEach(System.out::println);
        //For reverse lookups (i.e., resolving an IP address to a hostname), the JDK provides the methods
        // InetAddress::getCanonicalHostName and InetAddress::getHostName.
        */

        /**
         * By default, InetAddress uses the operating system's resolver, i.e., it usually consults the hosts file and the configured DNS servers.
         *
         * In this release java.net.InetAddress API to use service loader to find the resolver instead of using the operating system’s built-in resolver (InetAddress::loadResolver)
         * private static InetAddressResolver loadResolver() {
         *       return ServiceLoader.load(InetAddressResolverProvider.class)
         *               .findFirst()
         *               .map(nsp -> nsp.get(builtinConfiguration()))
         *               .orElse(BUILTIN_RESOLVER);
         *   }
         */

        // 5.) Pattern Matching for switch (Second Preview)
        /**
         * "Pattern Matching for switch" was first introduced in Java 17 and enables switch statements (and expressions) such as following
         */

        /*
        switch ((Object)"foobar") {
            case String s && s.length() > 5 -> System.out.println(s.toUpperCase());
            case String s                   -> System.out.println(s.toLowerCase());
            case Integer i                  -> System.out.println(i * i);
            default -> {}
        }

        // Java 17
        switch ("foobar") { //Label is dominated by a preceding case label 'String s && s.length() > 5'
            case String s && s.length() > 5 -> System.out.println(s.toUpperCase());
            case CONSTANT                   -> System.out.println("baz");
            default -> {}
        }

        // Java 18
        switch ("foobar") { //Label is dominated by a preceding case label 'String s && s.length() > 5'
            case String s && s.length() > 5 -> System.out.println(s.toUpperCase());
            case CONSTANT                   -> System.out.println("baz");
            default -> {}
        }

        switch (o) { // Error - pattern is dominated by previous pattern
            case CharSequence cs -> System.out.println("A sequence of length " + cs.length());
            case String s ->
                    System.out.println("A string: " + s);
            default -> {
                break;
            }
        }

        switch (o) {         // Error - not exhaustive
            case String s  -> s.length();
            case Integer i -> i;
        }

        */

    }



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
