package com.camila;

import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TP_Q2 {
    public static void main(String[] args){

        System.out.println("Qual é esse pokemon?");
        Scanner scanner = new Scanner(System.in);
        List<Pokemon> pokemon = new ArrayList<Pokemon>();
       
        while(true) {
            System.out.println("\n" + "Nome:");
            String nome = scanner.nextLine();

            System.out.println("HP:");
            String N_hp = scanner.nextLine();
            int hp = Integer.parseInt(N_hp);

            System.out.println("Ataque:");
            String N_ataque = scanner.nextLine();
            int ataque = Integer.parseInt(N_ataque);

            System.out.println("Defesa:");
            String N_defesa = scanner.nextLine();
            int defesa = Integer.parseInt(N_defesa);

            System.out.println("Velocidade:");
            String N_velocidade = scanner.nextLine();
            int velocidade = Integer.parseInt(N_velocidade);

            System.out.println("Ataque especial:");
            String N_ataque_especial = scanner.nextLine();
            int ataque_especial = Integer.parseInt(N_ataque_especial);

            System.out.println("Defesa especial:");
            String N_defesa_especial = scanner.nextLine();
            int defesa_especial = Integer.parseInt(N_defesa_especial);

            pokemon.add(new Pokemon(nome, 
                                    hp, 
                                    ataque, 
                                    defesa, 
                                    velocidade, 
                                    ataque_especial, 
                                    defesa_especial));
            
            System.out.println("\nContinua? (Digite 1 para sim)");
            String input = scanner.nextLine();
            if (!input.equals("1"))
                break;
        }
        
        try {
            Pokemons pokemons = new Pokemons(pokemon);
            ObjectMapper jsonString = new ObjectMapper();
            jsonString.writerWithDefaultPrettyPrinter().writeValue(new File("pokemons.json"), pokemons);
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}