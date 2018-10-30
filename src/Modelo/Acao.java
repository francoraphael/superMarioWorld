package Modelo;

public enum Acao {
    ANDAR(1), PULAR(2), DISPARAR(3);

    private int valorAcao;

    Acao(int valorAcao){

        this.valorAcao = valorAcao;
    }

    public int getValorAcao() {

            return valorAcao;
    }
}
