package com.camila;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TP_Q3 {
    public static void main(String[] args) throws IOException {
 
        System.out.println("Digite o nome do arquivo:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        ObjectMapper mapper =  new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Pokemon pokemons = mapper.readValue(new File(input), Pokemon.class);

        // Writer writer = Files.newBufferedWriter(Paths.get("pokemons.csv"));
        // CSVWriter csvWriter = new CSVWriter(writer);
        // csvWriter.writeAll(pokemons);

        scanner.close();
    }
}