package VisaoControlador;

import Modelo.*;

import java.util.Scanner;

public class InterfaceUsuario {

    public static void main(String[] args) {

        int entradaAcao, entradaDirecao;
        Acao acao;
        Direcao direcao;
        Scanner entrada = new Scanner(System.in);
        ControladorPartida controladorPartida = new ControladorPartida();
        controladorPartida.prepararPartida();

        do{
            controladorPartida.exibirMapa();
            System.out.println("=== Escolha a ação ===");
            System.out.println("1. Andar");
            System.out.println("2. Pular");
            System.out.println("3. Disparar");
            entradaAcao = entrada.nextInt();
            System.out.println("=== Escolha a Direção ===");
            System.out.println("1. Cima");
            System.out.println("2. Baixo");
            System.out.println("3. Direta");
            System.out.println("4. Esquerda");
            entradaDirecao = entrada.nextInt();

            if (entradaAcao == 1)
                acao = Acao.ANDAR;
            else if (entradaAcao == 2)
                acao = Acao.PULAR;
            else
                acao = Acao.DISPARAR;

            if (entradaDirecao == 1)
                direcao = Direcao.CIMA;
            else if (entradaDirecao == 2)
                direcao = Direcao.BAIXO;
            else if (entradaDirecao == 3)
                direcao = Direcao.DIREITA;
            else
                direcao = Direcao.ESQUERDA;

            controladorPartida.efetuarAcao(acao, direcao);
        }while (Mario.getInstance().getQuantidadeVidas() > 0 && !ControladorMario.encontrouPrincesa());
    }
}
