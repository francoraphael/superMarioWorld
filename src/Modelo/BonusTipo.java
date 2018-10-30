package Modelo;

public enum BonusTipo {
    MOEDA(0), FIREPLANT(1);

    private int valorItemBonus;

    BonusTipo(int valorItemBonus){

        this.valorItemBonus = valorItemBonus;
    }

    public int getValorItemBonus() {

        return valorItemBonus;
    }
}
