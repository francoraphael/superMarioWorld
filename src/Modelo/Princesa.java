package Modelo;

public class Princesa extends Item {

    private static Princesa ourInstance;

    private Princesa(){

        setIcone('#');
    }

    public static Princesa getInstance() {
        if(ourInstance == null)
            ourInstance = new Princesa();
        return ourInstance;
    }
}
