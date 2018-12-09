package Modelo.Adicional;

public class Coordenada {

    private int x;
    private int y;

    public Coordenada(Coordenada coordenada){

        this.x = coordenada.getX();
        this.y = coordenada.getY();
    }

    public Coordenada(){ }

    public int getX() { return x; }

    public int getY() { return y; }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }
}
