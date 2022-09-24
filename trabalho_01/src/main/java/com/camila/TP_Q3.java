package com.camila;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class TP_Q3 {
    public static void main(String[] args) throws IOException {
 
        System.out.println("Digite o nome do arquivo:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        JsonNode jsonTree = new ObjectMapper().readTree(new File(input));
        com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
        
        scanner.close();
    }
}