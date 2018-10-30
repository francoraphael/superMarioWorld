package VisaoControlador;
import Modelo.*;

import java.util.ArrayList;
import java.util.Collections;
import java.lang.Class;

public class ControladorPartida {

    private Boo boo;
    private Goomba goomba;
    private PiranhaPlant piranhaPlant;
    private Bonus bonus;
    private int i;
    private ArrayList<Item> itens = new ArrayList<>();

    public void prepararPartida() {

        for (i = 0; i < 98; i++) {
            if (i < 30)
                itens.add(bonus = new Bonus("Moeda"));
            else if (i >= 30 && i < 40)
                itens.add(bonus = new Bonus("FirePlant"));
            else if (i >= 40 && i < 50)
                itens.add(goomba = new Goomba());
            else if (i >= 50 && i < 57)
                itens.add(piranhaPlant = new PiranhaPlant());
            else if (i >= 57 && i < 62)
                itens.add(boo = new Boo());
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
        ControladorInimigos.verificaPiranhaPlantAdjacente();
    }

    public void efetuarAcao(Acao acao, Direcao direcao) {
        Coordenada coordenadaDestinoItem1;
        Coordenada coordenadaDestinoItem2;
        Item item;
        coordenadaDestinoItem1 = ControladorMario.buscaCoordenadaAdjacente(Mario.getInstance().getCoordenada(), direcao);
        coordenadaDestinoItem2 = ControladorMario.buscaCoordenadaAdjacente(coordenadaDestinoItem1, direcao);

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
                if(item instanceof Bonus || item == null) {
                    if(coordenadaDestinoItem2 != null) {
                        item = Mapa.getInstance().consultaItem(coordenadaDestinoItem2);
                        if (item instanceof Inimigo)
                            ControladorInimigos.interageInimigo((Inimigo)item, acao);
                    }
                }
            }
        }else{
            System.out.println("A ação extrapola os limites do mapa ! Por favor escolha outra direção !");
        }
        ControladorInimigos.verificaPiranhaPlantAdjacente();
    }

    public void exibirMapa() {
        Coordenada coordenada = new Coordenada();
        for (i = 0; i <= 9; i++) {
            coordenada.setX(i);
            for (int j = 0; j <= 9; j++) {
                coordenada.setY(j);
                if (Mapa.getInstance().consultaItem(coordenada) == null)
                    System.out.printf(" |");
                else
                    System.out.printf("%c|", Mapa.getInstance().consultaItem(coordenada).getIcone());
            }
            System.out.printf("\n---------------------\n");
        }
        System.out.println("Quantidade de vidas Mario: "+ Mario.getInstance().getQuantidadeVidas());
        System.out.println("Quantidade de moeda Mario: "+ Mario.getInstance().getQuantidadeMoedas());
    }
}
