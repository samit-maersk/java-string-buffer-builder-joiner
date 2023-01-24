package net.java.chapter;

import java.util.GregorianCalendar;

public class Demo {
    public static void main(String[] args) {
        //stringBuilderExample();
        //stringBufferExample();
        stringBufferTimeAndMemory();
        stringBuilderTimeAndMemory();
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
        long startMemory=Runtime.getRuntime().freeMemory();
        //StringBuffer sb = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<10000000; i++){
            sb.append(":").append(i);
        }
        long end=new GregorianCalendar().getTimeInMillis();
        long endMemory=Runtime.getRuntime().freeMemory();
        System.out.println("(StringBuilder) Time Taken:"+(end-start));
        System.out.println("(StringBuilder) Memory used:"+(startMemory-endMemory));
    }

    static void stringBufferTimeAndMemory() {
        System.gc();
        long start=new GregorianCalendar().getTimeInMillis();
        long startMemory=Runtime.getRuntime().freeMemory();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i<10000000; i++){
            sb.append(":").append(i);
        }
        long end=new GregorianCalendar().getTimeInMillis();
        long endMemory=Runtime.getRuntime().freeMemory();
        System.out.println("(StringBuffer) Time Taken:"+(end-start));
        System.out.println("(StringBuffer) Memory used:"+(startMemory-endMemory));
    }

    static void stringJoinerExample() {
        //StringJoiner
    }
}