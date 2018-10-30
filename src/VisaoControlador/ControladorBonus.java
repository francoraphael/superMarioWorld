package VisaoControlador;

import Modelo.*;

public class ControladorBonus {

    public static void interageBonus(Bonus bonus, Acao acao){

        if(acao == Acao.ANDAR || acao == Acao.PULAR){
            if(bonus.getBonus() == BonusTipo.MOEDA){
                Mario.getInstance().setQuantidadeMoedas(Mario.getInstance().getQuantidadeMoedas() + 1);
                if(Mario.getInstance().getQuantidadeMoedas() == 10){
                    Mario.getInstance().setQuantidadeVidas(Mario.getInstance().getQuantidadeVidas() + 1);
                    Mario.getInstance().setQuantidadeMoedas(0);
                }
            }else if(bonus.getBonus() == BonusTipo.FIREPLANT){
                Mario.getInstance().setPossuiPoderFogo(true);
            }
            Mapa.getInstance().salvarItem(null, Mario.getInstance().getCoordenada());
            Mapa.getInstance().salvarItem(Mario.getInstance(), bonus.getCoordenada());
        }
    }
}
