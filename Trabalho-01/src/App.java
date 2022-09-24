import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
    public static void main(String[] args) {

        System.out.println("Qual é esse pokemon?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pokemons pokemons = new Pokemons();

        while(true) {
            if(input.equals("stop"))
                break;

            System.out.println("Nome:");
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

            List<Pokemon> pokemon = new ArrayList<Pokemon>();
            pokemon.add(new Pokemon(nome, 
                                    hp, 
                                    ataque, 
                                    defesa, 
                                    velocidade, 
                                    ataque_especial, 
                                    defesa_especial));

            pokemons.setPokemons(pokemon);
        }

        try {
            ObjectMapper jsonString = new ObjectMapper();
            jsonString.writerWithDefaultPrettyPrinter().writeValue(new File("pokemons.json"), pokemons);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(pokemons);
        scanner.close();
    }
}
