package Modelo;

public class Bonus extends Item{
    private BonusTipo bonusTipo;

    public Bonus(String opcao) {
        if(opcao.equals("FirePlant")) {
            bonusTipo = BonusTipo.FIREPLANT;
            setIcone('Y');
        }
        else if(opcao.equals("Moeda")){
            bonusTipo = BonusTipo.MOEDA;
            setIcone('*');
        }
    }

    public BonusTipo getBonus() {
        return bonusTipo;
    }
}
