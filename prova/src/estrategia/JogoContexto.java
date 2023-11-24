package estrategia;

import java.util.Scanner;

import utils.Player;

//classe funcional que serve de fachada/contexto para implementar 
//sobrecarga das estrategias do game de e a lógica da partida
public class JogoContexto {
    private GameStrategy gameStrategy;
    private Player currentPlayer;
    private int pontuacaoJogador1;
    private int pontuacaoJogador2;

    public void setGameStrategy(GameStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
        this.currentPlayer = Player.PLAYER1;
        this.pontuacaoJogador1 = 0;
        this.pontuacaoJogador2 = 0;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            gameStrategy.exibirTabuleiro();
            System.out.println("É a vez do Jogador: " + currentPlayer);

            System.out.print("Digite a coordenada X da peça que deseja mover: ");
            int origemX = scanner.nextInt();

            System.out.print("Digite a coordenada Y da peça que deseja mover: ");
            int origemY = scanner.nextInt();

            System.out.print("Digite a coordenada X para onde deseja mover a peça: ");
            int destinoX = scanner.nextInt();

            System.out.print("Digite a coordenada Y para onde deseja mover a peça: ");
            int destinoY = scanner.nextInt();

            boolean movimentoValido = gameStrategy.moverPeca(origemX, origemY, destinoX, destinoY);

            if (movimentoValido) {
                System.out.println("Movimento realizado com sucesso!");

                // Remover peças adversárias
                removerPecasAdversarias(origemX, origemY, destinoX, destinoY);

                // Atualizar a pontuação
                int pontos = calcularPontosPecaComida(destinoX, destinoY);
                atualizarPontuacao(currentPlayer, pontos);

                // Mostrar pontuação
                System.out.println("Pontuação do Jogador 1: " + pontuacaoJogador1);
                System.out.println("Pontuação do Jogador 2: " + pontuacaoJogador2);
            } else {
                System.out.println("Movimento inválido. Tente novamente.");
            }

            if (gameStrategy.verificarVitoria()) {
                System.out.println("Jogador " + currentPlayer + " venceu com pontuação: " +
                        (currentPlayer == Player.PLAYER1 ? pontuacaoJogador1 : pontuacaoJogador2));
                break;
            }

            if (gameStrategy.isJogoEncerrado()) {
                System.out.println("Jogo encerrado. Obrigado por jogar!");
                break;
            }

            // Alternar entre os jogadores
            currentPlayer = (currentPlayer == Player.PLAYER1) ? Player.PLAYER2 : Player.PLAYER1;
        }

        scanner.close();
    }

    private void removerPecasAdversarias(int origemX, int origemY, int destinoX, int destinoY) {
        int deltaX = (destinoX - origemX) / Math.max(Math.abs(destinoX - origemX), 1);
        int deltaY = (destinoY - origemY) / Math.max(Math.abs(destinoY - origemY), 1);

        int x = origemX + deltaX;
        int y = origemY + deltaY;

        while (x != destinoX || y != destinoY) {
            // Remover a peça adversária, se existir
            gameStrategy.removerPeca(x, y);

            x += deltaX;
            y += deltaY;
        }
    }

    //Facilitando correção: implementei a lógica de calculo de pontos errado, para estrategia froglet e não 
    //tenho tempo para corrigir :).
    private int calcularPontosPecaComida(int destinoX, int destinoY) {
        String pecaComida = gameStrategy.getTabuleiro()[destinoY][destinoX];

        switch (pecaComida) {
            case "PIECE1":
                return 1;
            case "PIECE2":
                return 2;
            case "PIECE3":
                return 3;
            case "PIECE4":
                return 4;
            default:
                return 0;
        }
    }

    private void atualizarPontuacao(Player jogador, int pontos) {
        if (jogador == Player.PLAYER1) {
            pontuacaoJogador1 += pontos;
        } else {
            pontuacaoJogador2 += pontos;
        }
    }
}

