package Modelo.Personagens;

import Modelo.Item;

public class Princesa extends Item {

    private static Princesa ourInstance;

    private Princesa(){

        setIcone('#');
        setIconeUnicode("U+1F478");
    }

    public static Princesa getInstance() {

        if(ourInstance == null)
            ourInstance = new Princesa();
        return ourInstance;
    }

    public static void destroy(){
        ourInstance = null;
    }
}
