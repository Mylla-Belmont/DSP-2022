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
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

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
            Writer file = Files.newBufferedWriter(Paths.get("pokemons.csv"));
            StatefulBeanToCsv<Pokemon> beanToCsv = new StatefulBeanToCsvBuilder<Pokemon>(file).build();
            beanToCsv.write(pokemon);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ARQUIVO XML
        try {
            Writer file = Files.newBufferedWriter(Paths.get("pokemons.xml"));
            XmlMapper xml = new XmlMapper();
            xml.enable(SerializationFeature.INDENT_OUTPUT);
            xml.writeValue(file, pokemons);
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}