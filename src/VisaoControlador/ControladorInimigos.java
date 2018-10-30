package VisaoControlador;

import Modelo.*;
import java.util.Random;

public class ControladorInimigos {

    public static void interageInimigo (Inimigo inimigo, Acao acao){
        if (inimigo instanceof Goomba){
            interageGoomba((Goomba)inimigo, acao);
        }else if (inimigo instanceof Boo){
            interageBoo(acao);
        }else if(inimigo instanceof PiranhaPlant){
            interagePiranhaPlant((PiranhaPlant)inimigo, acao);
        }
    }

    private static void interageBoo(Acao acao){

        if(acao == Acao.ANDAR || acao == Acao.PULAR){
            ControladorMario.interageMario();
        }
    }

    private static void interageGoomba(Goomba goomba, Acao acao){
        Random aleatorio = new Random();
        if(acao == Acao.ANDAR){
            ControladorMario.interageMario();
        }else if(acao == Acao.PULAR){
            if(aleatorio.nextBoolean()){
                Mapa.getInstance().salvarItem(null, Mario.getInstance().getCoordenada());
                Mapa.getInstance().salvarItem(Mario.getInstance(), goomba.getCoordenada());
            }else{
                ControladorMario.interageMario();
            }
        }else if(acao == Acao.DISPARAR){
            Mapa.getInstance().salvarItem(null, goomba.getCoordenada());
        }
    }

    private static void interagePiranhaPlant(PiranhaPlant piranhaPlant, Acao acao){
        Random aleatorio = new Random();
        if(acao == Acao.ANDAR){
            ControladorMario.interageMario();
        }else if(acao == Acao.PULAR){
            if(aleatorio.nextInt(4) == 3){
                Mapa.getInstance().salvarItem(null, Mario.getInstance().getCoordenada());
                Mapa.getInstance().salvarItem(Mario.getInstance(), piranhaPlant.getCoordenada());
            }else{
                ControladorMario.interageMario();
            }
        }else if(acao == Acao.DISPARAR){
            piranhaPlant.setResistenciaFogoAtual(piranhaPlant.getResistenciaFogoAtual() - 25);
            if(piranhaPlant.getResistenciaFogoAtual() == 0){
                Mapa.getInstance().salvarItem(null, piranhaPlant.getCoordenada());
            }
        }
    }

    public static void verificaPiranhaPlantAdjacente(){
        Item item;
        Coordenada coordenada;
        for (Direcao direcao : Direcao.values()) {
            coordenada = ControladorMario.buscaCoordenadaAdjacente(Mario.getInstance().getCoordenada(), direcao);
            if(coordenada != null){
                item = Mapa.getInstance().consultaItem(coordenada);
                if (item instanceof PiranhaPlant)
                    ControladorMario.interageMario();
            }
        }
    }
}
