package Visao;

import Controlador.ControladorPartida;
import Modelo.Adicional.EstadoJogo;

public class TelaFinal implements Tela {

    public void criaTela(){

        criaMensagem();
        criaMenu();
    }

    public void criaMensagem(){

        if(ControladorPartida.estadoJogo == EstadoJogo.VITORIA){
            System.out.println("                                                                                                                                          \n" +
                    "YYYYYYY       YYYYYYY     OOOOOOOOO     UUUUUUUU     UUUUUUUUWWWWWWWW                           WWWWWWWWIIIIIIIIIINNNNNNNN        NNNNNNNN\n" +
                    "Y:::::Y       Y:::::Y   OO:::::::::OO   U::::::U     U::::::UW::::::W                           W::::::WI::::::::IN:::::::N       N::::::N\n" +
                    "Y:::::Y       Y:::::Y OO:::::::::::::OO U::::::U     U::::::UW::::::W                           W::::::WI::::::::IN::::::::N      N::::::N\n" +
                    "Y::::::Y     Y::::::YO:::::::OOO:::::::OUU:::::U     U:::::UUW::::::W                           W::::::WII::::::IIN:::::::::N     N::::::N\n" +
                    "YYY:::::Y   Y:::::YYYO::::::O   O::::::O U:::::U     U:::::U  W:::::W           WWWWW           W:::::W   I::::I  N::::::::::N    N::::::N\n" +
                    "   Y:::::Y Y:::::Y   O:::::O     O:::::O U:::::D     D:::::U   W:::::W         W:::::W         W:::::W    I::::I  N:::::::::::N   N::::::N\n" +
                    "    Y:::::Y:::::Y    O:::::O     O:::::O U:::::D     D:::::U    W:::::W       W:::::::W       W:::::W     I::::I  N:::::::N::::N  N::::::N\n" +
                    "     Y:::::::::Y     O:::::O     O:::::O U:::::D     D:::::U     W:::::W     W:::::::::W     W:::::W      I::::I  N::::::N N::::N N::::::N\n" +
                    "      Y:::::::Y      O:::::O     O:::::O U:::::D     D:::::U      W:::::W   W:::::W:::::W   W:::::W       I::::I  N::::::N  N::::N:::::::N\n" +
                    "       Y:::::Y       O:::::O     O:::::O U:::::D     D:::::U       W:::::W W:::::W W:::::W W:::::W        I::::I  N::::::N   N:::::::::::N\n" +
                    "       Y:::::Y       O:::::O     O:::::O U:::::D     D:::::U        W:::::W:::::W   W:::::W:::::W         I::::I  N::::::N    N::::::::::N\n" +
                    "       Y:::::Y       O::::::O   O::::::O U::::::U   U::::::U         W:::::::::W     W:::::::::W          I::::I  N::::::N     N:::::::::N\n" +
                    "       Y:::::Y       O:::::::OOO:::::::O U:::::::UUU:::::::U          W:::::::W       W:::::::W         II::::::IIN::::::N      N::::::::N\n" +
                    "    YYYY:::::YYYY     OO:::::::::::::OO   UU:::::::::::::UU            W:::::W         W:::::W          I::::::::IN::::::N       N:::::::N\n" +
                    "    Y:::::::::::Y       OO:::::::::OO       UU:::::::::UU               W:::W           W:::W           I::::::::IN::::::N        N::::::N\n" +
                    "    YYYYYYYYYYYYY         OOOOOOOOO           UUUUUUUUU                  WWW             WWW            IIIIIIIIIINNNNNNNN         NNNNNNN");
        }else{
            System.out.println("                                                                                                                                                 \n" +
                    "YYYYYYY       YYYYYYY     OOOOOOOOO     UUUUUUUU     UUUUUUUULLLLLLLLLLL                  OOOOOOOOO        SSSSSSSSSSSSSSS EEEEEEEEEEEEEEEEEEEEEE\n" +
                    "Y:::::Y       Y:::::Y   OO:::::::::OO   U::::::U     U::::::UL:::::::::L                OO:::::::::OO    SS:::::::::::::::SE::::::::::::::::::::E\n" +
                    "Y:::::Y       Y:::::Y OO:::::::::::::OO U::::::U     U::::::UL:::::::::L              OO:::::::::::::OO S:::::SSSSSS::::::SE::::::::::::::::::::E\n" +
                    "Y::::::Y     Y::::::YO:::::::OOO:::::::OUU:::::U     U:::::UULL:::::::LL             O:::::::OOO:::::::OS:::::S     SSSSSSSEE::::::EEEEEEEEE::::E\n" +
                    "YYY:::::Y   Y:::::YYYO::::::O   O::::::O U:::::U     U:::::U   L:::::L               O::::::O   O::::::OS:::::S              E:::::E       EEEEEE\n" +
                    "   Y:::::Y Y:::::Y   O:::::O     O:::::O U:::::D     D:::::U   L:::::L               O:::::O     O:::::OS:::::S              E:::::E             \n" +
                    "    Y:::::Y:::::Y    O:::::O     O:::::O U:::::D     D:::::U   L:::::L               O:::::O     O:::::O S::::SSSS           E::::::EEEEEEEEEE   \n" +
                    "     Y:::::::::Y     O:::::O     O:::::O U:::::D     D:::::U   L:::::L               O:::::O     O:::::O  SS::::::SSSSS      E:::::::::::::::E   \n" +
                    "      Y:::::::Y      O:::::O     O:::::O U:::::D     D:::::U   L:::::L               O:::::O     O:::::O    SSS::::::::SS    E:::::::::::::::E   \n" +
                    "       Y:::::Y       O:::::O     O:::::O U:::::D     D:::::U   L:::::L               O:::::O     O:::::O       SSSSSS::::S   E::::::EEEEEEEEEE   \n" +
                    "       Y:::::Y       O:::::O     O:::::O U:::::D     D:::::U   L:::::L               O:::::O     O:::::O            S:::::S  E:::::E             \n" +
                    "       Y:::::Y       O::::::O   O::::::O U::::::U   U::::::U   L:::::L         LLLLLLO::::::O   O::::::O            S:::::S  E:::::E       EEEEEE\n" +
                    "       Y:::::Y       O:::::::OOO:::::::O U:::::::UUU:::::::U LL:::::::LLLLLLLLL:::::LO:::::::OOO:::::::OSSSSSSS     S:::::SEE::::::EEEEEEEE:::::E\n" +
                    "    YYYY:::::YYYY     OO:::::::::::::OO   UU:::::::::::::UU  L::::::::::::::::::::::L OO:::::::::::::OO S::::::SSSSSS:::::SE::::::::::::::::::::E\n" +
                    "    Y:::::::::::Y       OO:::::::::OO       UU:::::::::UU    L::::::::::::::::::::::L   OO:::::::::OO   S:::::::::::::::SS E::::::::::::::::::::E\n" +
                    "    YYYYYYYYYYYYY         OOOOOOOOO           UUUUUUUUU      LLLLLLLLLLLLLLLLLLLLLLLL     OOOOOOOOO      SSSSSSSSSSSSSSS   EEEEEEEEEEEEEEEEEEEEEE");
        }
        criaMenu();
    }

    public void criaMenu(){

        int opcao;
        System.out.println("ESCOLHA UMA OPÇÃO");
        System.out.println("1. JOGAR NOVAMENTE");
        System.out.println("2. SAIR");
        entrada.nextLine();
        opcao = entrada.nextInt();
        if(opcao == 1) {
            ControladorPartida.reiniciaJogo();
            TelaInicial telaInicial = new TelaInicial();
            telaInicial.criaTela();
        }else{
            System.exit(0);
        }
    }
}
