package estrategia;

public interface GameStrategy {
    void exibirTabuleiro();

    String[][] getTabuleiro();

    void removerPeca(int x, int y);

    boolean moverPeca(int origemX, int origemY, int destinoX, int destinoY);

    //Facilitando correção: métodos mocados com lógica para teste, não conseguir 
    //implementar a versão conconcreta funcional
    boolean verificarVitoria();

    boolean isJogoEncerrado();

    //String getPeca(int x, int y);

}
