package Modelo;

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

    public static Coordenada deslocaCoordenada(Coordenada coordenada, Direcao direcao){
        if(direcao == Direcao.BAIXO || direcao == Direcao.CIMA)
            coordenada.setX(coordenada.getX() + direcao.getValorDirecao());
        else if(direcao == Direcao.DIREITA || direcao == Direcao.ESQUERDA)
            coordenada.setY(coordenada.getY() + direcao.getValorDirecao());
        return coordenada;
    }
}
