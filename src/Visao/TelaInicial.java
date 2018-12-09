package Visao;

import Modelo.Personagens.Mario;

public class TelaInicial implements Tela {

    public void criaTela(){

        criaMensagem();
        criaMenu();
    }

    public void criaMensagem(){

        System.out.println(" ____                        __  __            _    __        __         _     _ \n" +
                "/ ___| _   _ _ __   ___ _ __|  \\/  | __ _ _ __(_) __\\ \\      / /__  _ __| | __| |\n" +
                "\\___ \\| | | | '_ \\ / _ \\ '__| |\\/| |/ _` | '__| |/ _ \\ \\ /\\ / / _ \\| '__| |/ _` |\n" +
                " ___) | |_| | |_) |  __/ |  | |  | | (_| | |  | | (_) \\ V  V / (_) | |  | | (_| |\n" +
                "|____/ \\__,_| .__/ \\___|_|  |_|  |_|\\__,_|_|  |_|\\___/ \\_/\\_/ \\___/|_|  |_|\\__,_|\n" +
                "            |_|                                                                  \n");
    }

    public void criaMenu(){

        System.out.println("PRESSIONE [ENTER] PARA JOGAR !");
        try {
            System.in.read();
            System.in.skip(System.in.available());
            TelaJogo telaJogo = new TelaJogo();
            telaJogo.criaTela();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
