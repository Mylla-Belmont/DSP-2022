public class Pokemon {
    
    private String nome;
    private int hp;                        // Quantidade de vida
    private int ataque;                    // Quantidade de danos que pode causar
    private int defesa;                    // Quantidade de dano que pode sofre
    private int velocidade;                // Valociade em batalha
    private int ataque_especial;           // Quant. dano com especial
    private int defesa_especial;           // Quant. dano por especial inimigo

    public Pokemon() {}

    public Pokemon(String nome, int hp, int ataque, int defesa, int velocidade, int ataque_especial,
            int defesa_especial) {
        this.nome = nome;
        this.hp = hp;
        this.ataque = ataque;
        this.defesa = defesa;
        this.velocidade = velocidade;
        this.ataque_especial = ataque_especial;
        this.defesa_especial = defesa_especial;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public void setAtaque_especial(int ataque_especial) {
        this.ataque_especial = ataque_especial;
    }

    public void setDefesa_especial(int defesa_especial) {
        this.defesa_especial = defesa_especial;
    }

    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getAtaque_especial() {
        return ataque_especial;
    }

    public int getDefesa_especial() {
        return defesa_especial;
    }

    public String toString() {
        return "Personagem [ataque=" + ataque + ", ataque_especial=" + ataque_especial + ", defesa=" + defesa
                + ", defesa_especial=" + defesa_especial + ", hp=" + hp + ", nome=" + nome + ", velocidade="
                + velocidade + "]";
    }
}
