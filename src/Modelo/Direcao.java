package Modelo;

public enum Direcao {
    CIMA(-1), BAIXO(1), ESQUERDA(-1), DIREITA(1);

    private int valorDirecao;

    Direcao (int valorDirecao){

        this.valorDirecao = valorDirecao;
    }

    public int getValorDirecao() {

        return valorDirecao;
    }
}
