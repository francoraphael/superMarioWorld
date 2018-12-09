package Modelo.Personagens;

import Modelo.Item;

public class Mario extends Item {

    private int quantidadeMoedas, quantidadeVidas;
    private boolean possuiPoderFogo;
    private static Mario ourInstance;

    private Mario(){

        this.quantidadeMoedas = 0;
        this.quantidadeVidas = 3;
        this.possuiPoderFogo = false;
        setIcone('M');
        setIconeUnicode("U+1F385");
    }

    public static Mario getInstance() {

        if(ourInstance == null)
            ourInstance = new Mario();
        return ourInstance;
    }

    public int getQuantidadeMoedas() { return quantidadeMoedas; }

    public int getQuantidadeVidas() { return quantidadeVidas; }

    public boolean getPossuiPoderFogo() { return possuiPoderFogo; }

    public void setQuantidadeMoedas(int quantidadeMoedas) { this.quantidadeMoedas = quantidadeMoedas; }

    public void setQuantidadeVidas(int quantidadeVidas) { this.quantidadeVidas = quantidadeVidas; }

    public void setPossuiPoderFogo(boolean possuiPoderFogo) { this.possuiPoderFogo = possuiPoderFogo; }

    public static void destroy(){
        ourInstance = null;
    }
}
