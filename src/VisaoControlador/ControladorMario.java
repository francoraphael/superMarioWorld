package VisaoControlador;

import Modelo.*;

public class ControladorMario {

    public static void interageMario(){

        if(Mario.getInstance().getPossuiPoderFogo()== true){
            Mario.getInstance().setPossuiPoderFogo(false);
        }else{
            Mario.getInstance().setQuantidadeVidas(Mario.getInstance().getQuantidadeVidas() - 1);
        }
    }

    public static boolean encontrouPrincesa(){
        if(Mario.getInstance().getCoordenada().getX() == 9 && Mario.getInstance().getCoordenada().getY() == 9)
            return true;
        return false;
    }

    public static Coordenada buscaCoordenadaAdjacente(Coordenada coordenada, Direcao direcao){
        Coordenada coordenadaUso = new Coordenada(coordenada);
        if (direcao == Direcao.CIMA || direcao == Direcao.BAIXO)
            coordenadaUso.setX(coordenadaUso.getX() + direcao.getValorDirecao());
        else if (direcao == Direcao.DIREITA || direcao == Direcao.ESQUERDA)
            coordenadaUso.setY(coordenadaUso.getY() + direcao.getValorDirecao());
        if (coordenadaUso.getX() >= 0 && coordenadaUso.getX() <= 9 && coordenadaUso.getY() >= 0 && coordenadaUso.getY() <= 9)
            return coordenadaUso;
        return null;
    }
}
