public class Pessoa {

    private int id;
    private String name;
    private String email;
    private int number;

    public Pessoa() {}

    public Pessoa(int id, String nome, String email, int number) {
        this.id = id;
        this.name = nome;
        this.email = email;
        this.number = number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() { 
        return id; 
    }

    public String getname() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getNumber() {
        return number;
    }

    public String toString() {
        return "\n" + "{id = " + id +
                ", nome = " + name +
                ", email = " + email +
                ", numero = " + number +
                "}";
    }
}
