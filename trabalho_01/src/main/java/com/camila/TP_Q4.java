package com.camila;

import java.io.File;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.zip.ZipOutputStream;

public class TP_Q4 {
    public static void main(String[] args){

        final int TAMANHO_BUFFER = 4096;    //4kb

        System.out.println("Digite o nome do arquivo:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int cont = 0;
        byte[] dados = new byte[TAMANHO_BUFFER];  

        try {
            FileOutputStream destino = new FileOutputStream(new File("pokemons.zip"));
            ZipOutputStream saida = new ZipOutputStream(new BufferedOutputStream(destino));
            File file = new File(input);
            FileInputStream entrada = new FileInputStream(file);
            BufferedInputStream origem = new BufferedInputStream(entrada, TAMANHO_BUFFER);
            ZipEntry entry = new ZipEntry(file.getName());
            saida.putNextEntry(entry);

            while ((cont = origem.read(dados, 0, TAMANHO_BUFFER)) != -1) {
                saida.write(dados, 0, cont);
            }
            origem.close();
            saida.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
