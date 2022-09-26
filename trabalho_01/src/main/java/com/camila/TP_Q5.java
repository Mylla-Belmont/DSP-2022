package com.camila;

import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class TP_Q5 {
    public static void main(String[] args){

        System.out.println("Digite o nome do arquivo:");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        String checksum = "D83ABDB5F631BCEEEE0C30E2BB2C5BB9";

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(Files.readAllBytes(Paths.get(fileName)));
            byte[] digest = md.digest();
            String myChecksum  = DatatypeConverter.printHexBinary(digest).toUpperCase();

            System.out.println("Checksum: " + checksum);
            System.out.println("Hash SHA-1: " + myChecksum);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
