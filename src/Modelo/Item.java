package Modelo;

import Modelo.Adicional.Coordenada;

public abstract class Item {

    private Coordenada coordenada;
    private char icone;
    private String iconeUnicode;

    public void setIconeUnicode(String iconeUnicode){

        this.iconeUnicode = iconeUnicode;
    }

    public char[] getIconeUnicode(){

        int codepoint=Integer.parseInt(iconeUnicode.substring(2),16);
        char[] ch = Character.toChars(codepoint);
        return ch;
    }
    public char getIcone() { return this.icone; }

    public void setIcone(char icone) { this.icone = icone; }

    public Coordenada getCoordenada() { return this.coordenada; }

    public void setCoordenada(Coordenada coordenada) { this.coordenada = coordenada; }
}
