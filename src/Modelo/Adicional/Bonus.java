package Modelo.Adicional;

import Modelo.Item;

public class Bonus extends Item {
    private BonusTipo bonusTipo;

    public Bonus(String opcao) {

        if(opcao.equals("FirePlant")) {
            bonusTipo = BonusTipo.FIREPLANT;
            setIcone('Y');
            setIconeUnicode("U+1F33B");
        }
        else if(opcao.equals("Moeda")){
            bonusTipo = BonusTipo.MOEDA;
            setIcone('*');
            setIconeUnicode("U+1F4B0");
        }
    }

    public BonusTipo getBonus() { return bonusTipo; }
}
