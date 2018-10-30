package Modelo;

public class PiranhaPlant extends Inimigo{
    private int resistenciaFogoAtual;

    public PiranhaPlant(){

        this.resistenciaFogoAtual = 100;
        setIcone('P');
    }

    public int getResistenciaFogoAtual() {

        return resistenciaFogoAtual;
    }

    public void setResistenciaFogoAtual(int resistenciaFogoAtual) {

        this.resistenciaFogoAtual = resistenciaFogoAtual;
    }

}
