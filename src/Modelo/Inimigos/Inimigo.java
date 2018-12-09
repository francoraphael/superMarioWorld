package Modelo.Inimigos;

import Modelo.Item;

public abstract class Inimigo extends Item {
    protected int resistenciaFogo;

    public int getResistenciaFogo() { return resistenciaFogo; }

    public void setResistenciaFogo(int resistenciaFogo){ this.resistenciaFogo = resistenciaFogo; }
}
