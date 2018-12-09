package Visao;

import Controlador.ControladorPartida;
import Modelo.Adicional.*;
import Modelo.Personagens.Mario;

public class TelaJogo implements Tela {
    private Coordenada coordenada = new Coordenada();
    private Acao acao;
    private Direcao direcao;
    private ControladorPartida controladorPartida = new ControladorPartida();
    private int movimentacao, opcaoTela;
    private boolean flag;

    public void criaTela(){

        criaMenu();
    }

    public void criaMensagem(){

        char c;
        String caractereVazio = "U+3000";
        int codepoint=Integer.parseInt(caractereVazio.substring(2),16);
        char[] ch = Character.toChars(codepoint);
        for (int i = 0; i <= 9; i++) {
            coordenada.setX(i);
            for (int j = 0; j <= 9; j++) {
                coordenada.setY(j);
                if (Mapa.getInstance().consultaItem(coordenada) == null) {
                    if(opcaoTela == 1) {
                        System.out.print(ch);
                        System.out.print("|");
                    }else{
                        System.out.printf(" |");
                    }
                }
                else {
                    if(opcaoTela == 1) {
                        System.out.print(Mapa.getInstance().consultaItem(coordenada).getIconeUnicode());
                        System.out.print("|");
                    }else{
                        System.out.printf("%c|", Mapa.getInstance().consultaItem(coordenada).getIcone());
                    }
                }
            }
            if (opcaoTela == 1)
                System.out.printf("\n---------------------------\n");
            else
                System.out.printf("\n--------------------\n");
        }
        c = (Mario.getInstance().getPossuiPoderFogo()) ? 'V' : 'F';
        System.out.printf("╔═══════════════════════════╗\n" +
                "║Quantidade de vidas:  %d    ║\n" +
                "╠═══════════════════════════╣\n" +
                "║Quantidade de moedas: %d    ║\n" +
                "╠═══════════════════════════╣\n" +
                "║Possui poder de fogo: %c    ║\n" +

                "╚═══════════════════════════╝", Mario.getInstance().getQuantidadeVidas(),Mario.getInstance().getQuantidadeMoedas(), c);
    }

    public void defineTela(){

        do {
            System.out.println("Esolha um dos modos de exibição");
            System.out.println("1. Mapa com ícones (NECESSITA SUPORTE À UNICODE).");
            System.out.println("2. Mapa com caracteres.");
            opcaoTela = entrada.nextInt();
        }while(opcaoTela != 1 && opcaoTela != 2
        );
    }

    public void criaMenu() {

        controladorPartida.prepararPartida();
        defineTela();
        do {
            criaMensagem();
            System.out.println("\nESCOLHA UMA AÇÃO");
            System.out.println("1. Andar->Cima      5. Pular->Cima      9.  Disparar->Cima");
            System.out.println("2. Andar->Baixo     6. Pular->Baixo     10. Disparar->Baixo");
            System.out.println("3. Andar->Direita   7. Pular->Direita   11. Disparar->Direita");
            System.out.println("4. Andar->Esquerda  8. Pular->Esquerda  12. Disparar->Esquerda");
            movimentacao = entrada.nextInt();
            flag = false;
            switch (movimentacao){
                case 1: acao = Acao.ANDAR; direcao = Direcao.CIMA; break;
                case 2: acao = Acao.ANDAR; direcao = Direcao.BAIXO; break;
                case 3: acao = Acao.ANDAR; direcao = Direcao.DIREITA; break;
                case 4: acao = Acao.ANDAR; direcao = Direcao.ESQUERDA; break;
                case 5: acao = Acao.PULAR; direcao = Direcao.CIMA; break;
                case 6: acao = Acao.PULAR; direcao = Direcao.BAIXO; break;
                case 7: acao = Acao.PULAR; direcao = Direcao.DIREITA; break;
                case 8: acao = Acao.PULAR; direcao = Direcao.ESQUERDA; break;
                case 9: acao = Acao.DISPARAR; direcao = Direcao.CIMA; break;
                case 10: acao = Acao.DISPARAR; direcao = Direcao.BAIXO; break;
                case 11: acao = Acao.DISPARAR; direcao = Direcao.DIREITA; break;
                case 12: acao = Acao.DISPARAR; direcao = Direcao.ESQUERDA; break;
                default: flag = true;
            }
            if(!flag)
                controladorPartida.efetuarAcao(acao, direcao);
        }while(ControladorPartida.estadoJogo == EstadoJogo.EM_ANDAMENTO);
        TelaFinal telaFinal = new TelaFinal();
        telaFinal.criaTela();
    }
}
