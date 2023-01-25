package net.java.chapter;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BuilderBufferJoiner {
    public static void main(String[] args) {
        //stringBuilderExample();
        stringBufferExample();

//        stringBufferTimeAndMemory();
//        stringBuilderTimeAndMemory();
        //stringJoinerExample();

    }

    static void stringBuilderExample() {
        /*
        StringBuilder class is used to create mutable (modifiable) strings. This means that a StringBuilder object can be modified after it is created, unlike a String object which is immutable.
        StringBuilder is a part of the Java Standard Library and it is present in the java.lang package
        It is a direct alternative to StringBuffer class with the difference being that StringBuffer is thread-safe and StringBuilder is not.
        */
        StringBuilder stringBuilder = new StringBuilder("Hello ");
        stringBuilder.append("world!");
        System.out.println(stringBuilder);

        StringBuilder stringBuilder1 = new StringBuilder("Hello ");
        stringBuilder1.append("world!");
        stringBuilder1.reverse();
        System.out.println(stringBuilder1);

        StringBuilder stringBuilder2 = new StringBuilder("Hello ");
        stringBuilder2.append("world!");
        stringBuilder2.insert(1,"INSERT");
        System.out.println(stringBuilder2);

        StringBuilder stringBuilder3 = new StringBuilder("Hello ");
        stringBuilder3.append("world!");
        stringBuilder3.replace(1,3,"REPLACE");
        System.out.println(stringBuilder);
    }

    static void stringBufferExample() {
        //StringBuffer
        //In Java, the StringBuffer class is used to create mutable (modifiable) strings.
        // It is similar to the StringBuilder class, but with the difference that StringBuffer is thread-safe, while StringBuilder is not.
        // StringBuffer is a part of the Java Standard Library and it is present in the java.lang package.

        StringBuffer stringBuffer = new StringBuffer("Hello ");
        stringBuffer.append("world!");
        System.out.println(stringBuffer);

        StringBuffer stringBuffer1 = new StringBuffer("Hello ");
        stringBuffer1.append("world!");
        stringBuffer1.insert(3,"INSERT");
        System.out.println(stringBuffer1);

        StringBuffer stringBuffer2 = new StringBuffer("Hello ");
        stringBuffer2.append("world!");
        stringBuffer2.replace(1,3,"REPLACE");
        System.out.println(stringBuffer2);

        StringBuffer stringBuffer3 = new StringBuffer("Hello ");
        stringBuffer3.append("world!");
        stringBuffer3.reverse();
        System.out.println(stringBuffer3);
    }

    static void stringBuilderTimeAndMemory() {
        System.gc();
        long start=new GregorianCalendar().getTimeInMillis();
        StringBuilder sb = new StringBuilder();
        Set s = new HashSet();
        IntStream.range(1,10000000).parallel().forEach(x -> sb.append(",").append(x));
        long end=new GregorianCalendar().getTimeInMillis();
        System.out.println("(StringBuilder) Time Taken:"+(end-start));
    }

    static void stringBufferTimeAndMemory() {
        System.gc();
        long start=new GregorianCalendar().getTimeInMillis();
        StringBuffer sb = new StringBuffer();
        var tCount = new HashSet();
        IntStream.range(1,10000000).parallel().forEach(x -> sb.append(",").append(x));
        long end=new GregorianCalendar().getTimeInMillis();
        System.out.println("(StringBuffer) Time Taken:"+(end-start));

    }

    static void stringJoinerExample() {
        // StringJoiner is a class used to construct a sequence of characters separated by a delimiter and optionally starting with a supplied prefix and ending with a supplied suffix.
        // It was introduced in Java 8 as part of the java.util package.

        StringJoiner joiner = new StringJoiner(", ");
        joiner.add("apple");
        joiner.add("banana");
        joiner.add("orange");
        System.out.println(joiner.toString()); // "apple, banana, orange"

        //prefix, suffix & setEmptyValue
        StringJoiner joiner1 = new StringJoiner(",", "[", "]");
        joiner1.add("apple");
        joiner1.add("banana");
        joiner1.add("orange");
        System.out.println(joiner1.toString()); // "[apple, banana, orange]"
        joiner1.setEmptyValue("");
        System.out.println(joiner1.toString()); // ""

        //merge
        StringJoiner joiner01 = new StringJoiner(", ");
        joiner01.add("apple");
        joiner01.add("banana");
        StringJoiner joiner02 = new StringJoiner(", ");
        joiner02.add("orange");
        joiner02.add("mango");
        joiner01.merge(joiner02);
        System.out.println(joiner01.toString()); // "apple, banana, orange, mango"

        StringJoiner sj = new StringJoiner(":", "[", "]");
        sj.add("George").add("Sally").add("Fred");
        System.out.println(sj.toString());
        /*
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        String commaSeparatedNumbers = numbers.stream()
                .map(i -> i.toString())
                .collect(Collectors.joining(", "));

         */
    }
}