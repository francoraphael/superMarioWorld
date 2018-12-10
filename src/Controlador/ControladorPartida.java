package Controlador;
import Modelo.*;
import Modelo.Adicional.*;
import Modelo.Inimigos.Boo;
import Modelo.Inimigos.Goomba;
import Modelo.Inimigos.Inimigo;
import Modelo.Inimigos.PiranhaPlant;
import Modelo.Personagens.Mario;
import Modelo.Personagens.Princesa;

import java.util.ArrayList;
import java.util.Collections;

public class ControladorPartida {

    public static EstadoJogo estadoJogo;

    public void prepararPartida() {

        int i;
        ArrayList<Item> itens = new ArrayList<>();
        for (i = 0; i < 98; i++) {
            if (i < 30)
                itens.add(new Bonus("Moeda"));
            else if (i >= 30 && i < 40)
                itens.add(new Bonus("FirePlant"));
            else if (i >= 40 && i < 50)
                itens.add(new Goomba());
            else if (i >= 50 && i < 57)
                itens.add(new PiranhaPlant());
            else if (i >= 57 && i < 62)
                itens.add(new Boo());
            else
                itens.add(null);
        }
        Collections.shuffle(itens);
        itens.add(0, Mario.getInstance());
        itens.add(99, Princesa.getInstance());

        for(i=0; i<=99; i++){
            Coordenada coordenada = new Coordenada();
            coordenada.setX(i/10);
            coordenada.setY(i%10);
            Mapa.getInstance().salvarItem(itens.get(i), coordenada);
        }
    }

    public void efetuarAcao(Acao acao, Direcao direcao) {

        Coordenada coordenadaDestinoItem1;
        Coordenada coordenadaDestinoItem2;
        Item item;
        coordenadaDestinoItem1 = ControladorMario.buscaCoordenadaAdjacente(Mario.getInstance().getCoordenada(), direcao);

        if(coordenadaDestinoItem1 != null) {
            item = Mapa.getInstance().consultaItem(coordenadaDestinoItem1);
            if (item instanceof Inimigo){
                ControladorInimigos.interageInimigo((Inimigo) item, acao);
            }else if (item instanceof Bonus) {
                ControladorBonus.interageBonus((Bonus) item, acao);
            }else if ((item == null || item == Princesa.getInstance()) && (acao == Acao.PULAR || acao == Acao.ANDAR)){
                Mapa.getInstance().salvarItem(null, Mario.getInstance().getCoordenada());
                Mapa.getInstance().salvarItem(Mario.getInstance(), coordenadaDestinoItem1);
            }
            if(acao == Acao.DISPARAR) {
                coordenadaDestinoItem2 = ControladorMario.buscaCoordenadaAdjacente(coordenadaDestinoItem1, direcao);
                if(item instanceof Bonus || item == null) {
                    if(coordenadaDestinoItem2 != null) {
                        item = Mapa.getInstance().consultaItem(coordenadaDestinoItem2);
                        if (item instanceof Inimigo)
                            ControladorInimigos.interageInimigo((Inimigo)item, acao);
                    }
                }
            }
        }else{
            System.out.println("\nA ação extrapola os limites do mapa ! Por favor escolha outra direção !\n");
        }
        ControladorInimigos.verificaPiranhaPlantAdjacente();
        verificaEstadoJogo();
    }

    public static void verificaEstadoJogo(){

        if(Mario.getInstance().getQuantidadeVidas() > 0 && !ControladorMario.encontrouPrincesa())
            estadoJogo = EstadoJogo.EM_ANDAMENTO;
        else if(ControladorMario.encontrouPrincesa())
            estadoJogo = EstadoJogo.VITORIA;
        else
            estadoJogo = EstadoJogo.DERROTA;
    }

    public static void reiniciaJogo(){

        Mario.destroy();
        Princesa.destroy();
        Mapa.destroy();
    }
}
