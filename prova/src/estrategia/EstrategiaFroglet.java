package estrategia;

import java.util.Random;

import utils.ConsoleColors;

public class EstrategiaFroglet implements GameStrategy {
    private String[][] tabuleiro;

    public EstrategiaFroglet() {
        tabuleiro = new String[6][6];
        inicializarTabuleiroFroglet();
    }

    /* @Override
    public String getPeca(int x, int y) {
        return tabuleiro[y][x];
    } */

    @Override
    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    private void inicializarTabuleiroFroglet() {
    Random random = new Random();

    // eibe o tabuleiro com com suas porcentagens
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++) {
            int chance = random.nextInt(100); 

            /*Facilitando correção: Provavelmente existe uma maneira mais facil, mas a lógica é:
             * "PIECE2" (P2): É atribuído quando chance é maior ou igual a 40% e 
             * menor que 70%. Isso cobre a faixa de 40% a 70%, então P2 aparecerá 
             * em 30% das casas (70% - 40%).
             */
            if (chance < 40) {
                tabuleiro[i][j] = "PIECE1"; 
            } else if (chance < 70) {
                tabuleiro[i][j] = "PIECE2"; 
            } else if (chance < 90) {
                tabuleiro[i][j] = "PIECE3"; 
            } else {
                tabuleiro[i][j] = "PIECE4"; 
            }
        }
    }

    // Remover aleatoriamente uma peça do tabuleiro
    int linhaRemover = random.nextInt(6);
    int colunaRemover = random.nextInt(6);
    tabuleiro[linhaRemover][colunaRemover] = "";
}

@Override
public void exibirTabuleiro() {
    // Exibir números de colunas
    System.out.print("  ");
    for (int i = 0; i < 6; i++) {
        System.out.print("       " + i);
    }
    System.out.println();

    // Exibir tabuleiro com números de linhas
    for (int i = 0; i < 6; i++) {
        System.out.print(i + " ");
        for (int j = 0; j < 6; j++) {
            System.out.print(" | " + (tabuleiro[i][j].isEmpty() ? "      " : tabuleiro[i][j]));
        }
        System.out.println(" |");
    }
}
    @Override
    public boolean moverPeca(int origemX, int origemY, int destinoX, int destinoY) {
        // Verifica se a movimentação está dentro dos limites do tabuleiro
        if (origemX < 0 || origemX >= 6 || origemY < 0 || origemY >= 6 ||
                destinoX < 0 || destinoX >= 6 || destinoY < 0 || destinoY >= 6) {
            return false;
        }

        // Verifica se a origem contém uma peça válida para movimentação
        if (tabuleiro[origemY][origemX].equals("")) {
            return false;
        }

        // Verifica se a posição de destino está vazia
        if (!tabuleiro[destinoY][destinoX].equals("")) {
            return false;
        }

        tabuleiro[destinoY][destinoX] = tabuleiro[origemY][origemX];
        tabuleiro[origemY][origemX] = "";

        return true;
    }

    @Override
    public void removerPeca(int x, int y) {
        if (x >= 0 && x < 6 && y >= 0 && y < 6) {
            tabuleiro[y][x] = ""; 
        }
    }

    /*essa é uma implementação mockada para teste */
    @Override
    public boolean verificarVitoria() {
        // Verifica se ainda há peças no tabuleiro
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (!tabuleiro[i][j].equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isJogoEncerrado() {
        return verificarVitoria();
    }
}
