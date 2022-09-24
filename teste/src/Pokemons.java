import java.util.List;

public class Pokemons {

    private List<Pokemon> pokemons;
    
    public  Pokemons() {}

    public Pokemons(List<Pokemon> pokemons){
        this.pokemons = pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public String toString() {
        return "[Pokemons: " + pokemons + "]";
    }
}
