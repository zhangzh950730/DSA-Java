package com.zzh.demo;

public class Message {
    public static void main(String[] args) {
        if ((args.length == 0) || args[0].equals("-h")) {
            System.out.println(args[0]);
        } else if (args[0].equals("-g")) {
            System.out.println("Goodbye,");
        }

        for (int i = 1; i < args.length; i++) {
            System.out.println(" " + args[i]);
        }

        System.out.println("!");
    }
}

