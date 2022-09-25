package com.camila;

import java.io.File;
import java.util.List;
import java.io.Writer;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TP_Q3 {
    public static void main(String[] args) throws IOException {
 
        System.out.println("Digite o nome do arquivo:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        // ARQUIVO CSV
        ObjectMapper mapper =  new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Pokemons pokemons = mapper.readValue(new File(input), Pokemons.class);

        List<Pokemon> pokemon = new ArrayList<>();
        for (Pokemon pk : pokemons.getPokemons()) {
            pokemon.add(pk);
        }

        try {
            Writer writer = Files.newBufferedWriter(Paths.get("pokemon.csv"));
            StatefulBeanToCsv<Pokemon> beanToCsv = new StatefulBeanToCsvBuilder<Pokemon>(writer).build();
            beanToCsv.write(pokemon);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}