package Modelo;

public class Mapa {
    private static Item[][] mapa;
    private static Mapa ourInstance;

    public static Mapa getInstance() {

        if (ourInstance == null)
            ourInstance = new Mapa();
        return ourInstance;
    }

    private Mapa() {

        this.mapa = new Item[10][10];
    }

    public void salvarItem(Item item, Coordenada coordenada){

        if(item != null)
            item.setCoordenada(coordenada);
        this.mapa[coordenada.getX()][coordenada.getY()] = item;
    }

    public Item consultaItem(Coordenada coordenada){

        return mapa[coordenada.getX()][coordenada.getY()];
    }


}
