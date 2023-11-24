package estrategia;

import java.util.Random;

public class EstrategiaTradicional implements GameStrategy {
    private String[][] tabuleiro;

    @Override
    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    /* @Override
    public String getPeca(int x, int y) {
        return tabuleiro[y][x];
    } */

    public EstrategiaTradicional() {
        tabuleiro = new String[6][6];
        inicializarTabuleiroTradicional();
    }

    private void inicializarTabuleiroTradicional() {
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                tabuleiro[i][j] = "PIECE1";
            }
        }

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
