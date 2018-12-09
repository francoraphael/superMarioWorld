package Visao;

import java.util.Scanner;

public interface Tela {

    Scanner entrada = new Scanner(System.in);
    void criaTela();
    void criaMensagem();
    void criaMenu();
}
