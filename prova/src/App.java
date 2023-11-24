import java.util.Scanner;

import estrategia.EstrategiaFroglet;
import estrategia.EstrategiaTradicional;
import estrategia.JogoContexto;

public class App {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.print("Qual regra você quer jogar (0 - Tradicional, 1 - Froglet)?: ");
      int escolha = sc.nextInt();

      JogoContexto jogo = new JogoContexto();
      
      if (escolha == 0){
        jogo.setGameStrategy(new EstrategiaTradicional());
      }
      else if (escolha == 1){
        jogo.setGameStrategy(new EstrategiaFroglet());
      }

      jogo.play();

      sc.close();

    }
}
