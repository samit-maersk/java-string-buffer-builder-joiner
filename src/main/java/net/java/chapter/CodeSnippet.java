package net.java.chapter;


public class CodeSnippet {
    /**
     * How to write a text file with Java 7:
     *
     * <pre><b>try</b> (BufferedWriter writer = Files.<i>newBufferedWriter</i>(path)) {
     *  writer.write(text);
     *}</pre>
     */
    public static void java7docsSample(){
        System.out.println("java7docsSample");
    }

    /**
     * How to write a text file with Java 7:
     *
     * <pre>{@code try (BufferedWriter writer = Files.newBufferedWriter(path)) {
     *  writer.write(text);
     *}}</pre>
     */
    public static void java7docsSampleV2(){
        System.out.println("java7docsSample with <pre> and @code");
    }

    /**
     * How to write a text file with Java 7:
     *
     * {@snippet :
     * try (BufferedWriter writer = Files.newBufferedWriter(path)) {
     *   writer.write(text);
     * }
     * }
     */
    public static void java18CodeSnippet() {

    }

    /**
     * {@snippet :
     * try (BufferedWriter writer = Files.newBufferedWriter(path)) {
     *   writer.write(text);  // @highlight substring="text"
     * }
     * }
     */
    public static void java18CodeSnippetV2() {

    }

    /**
     * {@snippet :
     * // @highlight region regex="\bwrite.*?\b" type="highlighted"
     * try (BufferedWriter writer = Files.newBufferedWriter(path)) {
     *   writer.write(text);
     * }
     * // @end
     * }
     */
    public static void java18CodeSnippetV3() {

    }

    /**
     * {@snippet :
     * // @link substring="BufferedWriter" target="java.io.BufferedWriter" :
     * try (BufferedWriter writer = Files.newBufferedWriter(path)) {
     *   writer.write(text);
     * }
     * }
     */
    public static void java18CodeSnippetV4() {

    }
    /**
     * How to write a text file with Java 7:
     *
     * {@snippet file="FileWriter.java" region="writeFile"}
     */
    public static void java18CodeSnippetV5(){

    }

}

