package com.camila;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "lista_pokemons")
public class Pokemons {

    @JacksonXmlElementWrapper(localName = "pokemons")
    @JacksonXmlProperty(localName = "pokemon")
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