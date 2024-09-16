package com.dev.controller;

public class ChayDeHackNASA {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hacking loading..." + i * 5 + "%");
            Thread.sleep(1000);
        }
        System.out.println("Hacking NASA complete!");
    }
}
