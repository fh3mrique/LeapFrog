# LeapFrog
1. Leap Frog é um jogo de tabuleiro e estratégia para dois jogadores. Ele é jogado em um tabuleiro
retangular onde diversas peças estão posicionadas. Cada jogador, alternadamente, move uma peça.
Uma peça pode ser movimentada desde que esteja adjacente (na horizontal ou vertical mas não
na diagonal) a outra peça adversária e possa saltar por cima desta ficando na casa imediatamente
a seguir (que tem de estar desocupada). A peça saltada é capturada e removida do tabuleiro (à
semelhança das Damas) e uma pontuação associada à peça é somada à pontuação do jogador. Isto
significa que devem ocorrer capturas em todos os lances de uma partida. Após uma captura, a
peça movimentada pode, opcionalmente e se houver essa possibilidade, continuar a capturar peças
adversárias ortogonalmente adjacentes. O jogo termina quando não for possível fazer mais saltos.
Ganha o jogador que tiver mais pontos. Duas variações existem neste jogo:
• Na versão Froglet, existem quatro peças. Peças azuis devem aparecer em 40% das casas
do tabuleiro; peças vermelhas, em 30% das casas; peças verdes, em 20% das casas; e peças
laranjas, no restante. Aleatoriamente, uma peça deve ser removida do tabuleiro. Peças azuis
valem 1 ponto; vermelhas, 2 pontos; verdes, 3 pontos; e laranjas, 4 pontos.
• Na versão tradicional, só existem peças de um tipo. Preencher todo o tabuleiro com essas
peças. Aleatoriamente, uma peça deve ser removida do tabuleiro. Cada peça vale 1 ponto.
Desta forma, utilizar um padrão de projeto para que o usuário possa escolher as regras do jogo no
início da partida.
(a) (2,5) Permitir ao jogador escolher a versão do jogo. Utilizar um padrão de projeto para
atribuir as regras do jogo dinamicamente.
(b) (1,0) Inicialmente, o jogador deve poder escolher a versão que quer jogar. Apresentar um
tabuleiro 6 × 6 preenchido com as peças de acordo com a versão escolhida, de quem é a vez
de jogar e uma tabela com a pontuação dos jogadores.

(c) (2,5) Implementar uma movimentação de peça. Informar as coordenadas da peça a ser movi-
mentada. Depois, informar todas as casas vazias que fazem parte do caminho a ser percorrido.

Remover as peças adversárias caso a movimentação seja válida. A casa inicial deve conter
uma peça, as casas do caminho devem estar vazias, e as casas intermediárias devem conter
peças. Caso a jogada seja inválida, apresentar uma mensagem na tela e permitir que o usuário
tente novamente.
(d) (1,0) Atualizar a pontuação do jogador após cada movimentação, de acordo com a versão
escolhida.
(e) (0,5) Alterar a vez de jogar dos jogadores apresentando uma mensagem informando a vez do
jogador corrente.
(f) (2,0) Implementar a condição de final de jogo. Quando o jogador corrente não puder realizar
uma jogada, quem possuir mais pontos ganha a partida.
(g) (0,5) Criar um diretório chamado PPOO-Prova1-NomeSobrenome, colocar os arquivos na raiz
dele e compactá-lo usando o formato ZIP.
