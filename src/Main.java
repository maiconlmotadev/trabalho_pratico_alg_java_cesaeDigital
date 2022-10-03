import java.util.*;


public class Main {

    private static int[] numerosAleatoriosOficial;
    private static int[] estrelas_aleiatorio_oficial;

    private static int[] jogo_utilizador_numeros;

    private static int[] jogo_utilizador_estrelas;


    public static void main(String[] args) {

        /*
        GRUPO I
        O Euromilhões é um jogo de sorte ou azar no qual o jogador deve preencher uma chave composta por 5 números de 1 a
        50 e 2 estrelas (números) de 1 a 11. Crie uma aplicação que permita ao utilizador:
        1. Simular um sorteio (sortear uma chave vencedora que deve ser apresentada ao utilizador de forma ordenada).
        2. Criar um boletim com 1 a 5 chaves (inseridas pelo utilizador) e comparar com a chave vencedora desse sorteio.
        3. Criar um boletim com 1 a 5 chaves (criadas aleatoriamente) e comparar com a chave vencedora desse sorteio.
        4. Simular quantas vezes seria necessário jogar (sempre com a mesma chave) de forma a conseguir ganhar o 1º
        prémio (5 números e 2 estrelas).
                Informação extra: https://www.jogossantacasa.pt/web/SCCartazResult/

        GRUPO II
        O jogo dos 21 fósforos coloca dois oponentes a retirar fósforos, à vez, até sobrar o último. Quem ficar com o
        último fósforo
        perde. Em cada jogada é possível retirar 1, 2, 3 ou 4 fósforos. Implemente uma aplicação que permita jogar:
        1. Dois jogadores humanos;
        2. Humano contra computador (sem inteligência);
        3. Humano contra computador (com inteligência);

        GRUPO III
        A “Anabela de Malhadas” queria acertar o valor do peso do saco, mas confundiu-se! No "Jogo do Saco", programa da Rádio
        Brigantia, em Bragança, apresentado pelo locutor Sidónio Costa, era, diariamente, pedido aos ouvintes que acertassem o
        peso de um saco com alguma coisa dentro. Em cada programa era dada aos ouvintes uma margem de 150g (ex.: entre
        4,200kg e 4,350kg) para acertarem no peso do saco. Vídeo: https://www.youtube.com/watch?v=hIrRNFa8OiA
        Faça uma aplicação que permita aos ouvintes jogar no “Jogo do Saco”. Implemente as seguintes opções:
        1. Criar, editar e eliminar ouvintes.
        2. Ver dados de um ouvinte.
        3. Ver ranking de ouvintes (número de vezes que jogaram e número de vezes que acertaram).
        4. Jogar.
        Em cada jogo devem ser selecionados de forma aleatória quais os ouvintes que vão jogar e a sua ordem. Em cada jogo o
        vencedor será o que se aproximar mais do valor do peso do saco.

        NOTAS: Nos grupos I e III deve utilizar orientação a objetos, no grupo II é opcional
        */

        int op = 1;
        while (op != 0) {
            Scanner in = new Scanner(System.in);
            System.out.println();
            System.out.println("O QUE DESEJA JOGAR?");
            System.out.println();
            System.out.println("1- EUROMILHOES");
            System.out.println("2- 21 FOSFOROS");
            System.out.println("3- ANABELA DE MALHADAS");
            System.out.println("0-Sair");
            op = in.nextInt();

            switch (op) {
                case 0:
                    break;
                case 1:
                    jogo_euromilhoes();
                    //chamar jogo
                    break;
                case 2:
                    jogo_fosforos();
                    //chamar jogo
                    break;
                case 3:
                    jogo_anabela();
                    //chamar jogo
                    break;
                default:
                    System.out.println("Número informado inválido!");
                    break;
            }
        }
    }




    //////////// JOGO EUROMILHOES
    private static void jogo_euromilhoes() {

        int op = 1;
        while (op != 0) {
            Scanner in = new Scanner(System.in);
            System.out.println();
            System.out.println("BEM VINDO AO EUROMILHOES!!!");
            System.out.println();
            System.out.println("INFORME SUAS OPCOES!");
            System.out.println();
            System.out.println("1- Sorteio (sortear uma chave vencedora que deve ser apresentada ao " +
                    "utilizador de forma ordenada).");
            System.out.println("2- Criar um boletim com 1 a 5 chaves (inseridas pelo utilizador) e comparar com a" +
                    " chave vencedora desse sorteio.");
            System.out.println("3- Criar um boletim com 1 a 5 chaves (criadas aleatoriamente) e comparar com a chave " +
                    "vencedora desse sorteio.");
            System.out.println("4- Quantas vezes seria necessário jogar (sempre com a mesma chave) de forma a conseguir ganhar o 1º\n" +
                    "prémio (5 números e 2 estrelas).");
            System.out.println("0-Sair");

            op = in.nextInt();
            switch (op) {
                case 0:
                    break;
                case 1:
                    sorteio_aleiatorio_oficial();
                    break;
                case 2:
                    boletin_utilizador();
                    break;
                case 3:
                    boletin_aleatorio();
                    break;
                case 4:
                    calcularNumeroJogadasPremio();
                    break;
                default:
                    System.out.println("Número informado inválido!");
                    break;
            }
        }
    }

    private static void sorteio_aleiatorio_oficial() {
        int estrelas[] = new int[2];
        int numeros[] = new int[5];
        Random generator = new Random();

        for (int i = 0; i < 5; i++) {
            numeros[i] = generator.nextInt(50) + 1;
        }
        for (int i = 0; i < 2 ; i++){
            estrelas[i] = generator.nextInt(11) + 1;
        }
        System.out.println();
        System.out.println();

        Arrays.sort(numeros);
        System.out.print("A chave vencedora ordenada é: ");
        for(int i: numeros){
            System.out.print(i+" ");
        }
        System.out.println();

        Arrays.sort(estrelas);
        System.out.print("As estrelas vencedoras ordenadas são: ");
        /*String test = estrelas.toString().replaceAll("\\s*,\\s*", ",");
        System.out.print(test);*/
        for(int i: estrelas){
            System.out.print(i+" ");
        }
        numerosAleatoriosOficial = numeros;
        estrelas_aleiatorio_oficial = estrelas;

        System.out.println();
        System.out.println();
    }

    private static void boletin_utilizador() {
        int start = 0;
        int estrelas[] = new int[2];
        int numeros[] = new int[5];

        Scanner in = new Scanner(System.in);

        System.out.println();
        System.out.println();

        System.out.println("Insira um valor de 1 a 5, determinando a quantidade de CHAVES DO UTILIZADOR a concorrer: ");
        start = in.nextInt();

        System.out.println();
        System.out.println();

        for (int j = 0; j < start; j++){
            System.out.println("PROCESSANDO CHAVE DO UTILIZADOR - Nº " + (j + 1) + " ...");

            System.out.println();
            System.out.println();

            for (int i = 0; i < 5; i++) {
                // FORMA MAICON
            /*
            System.out.println("Insira o " + (i + 1) + "º valor da chave");
            if (in.hasNextInt()) {
                System.out.println("The number is an integer");
                numeros[i] = in.nextInt();
            }
            else {
                System.out.println("Valor informado inválido!");

                while (!in.hasNextInt()){ // enquanto nao for numero (false)

                    System.out.println("Informe um valor : ");
                    in.hasNextInt();

                   if (in.hasNextInt()) { // se for numero
                       System.out.println("The number is an integer");
                       numeros[i] = in.nextInt();
                        //ver = false;
                    }
                }
            }
            */

                // FORMA WASHIGTON
            /*
            System.out.println("Insira o " + (i + 1) + "º valor da chave");
            boolean value = in.hasNextInt();
            if(value) {
                System.out.println("The number is an integer");
                numeros[i] = in.nextInt();
            } else {
                while(!value) {
                    System.out.println("Insira o " + (i + 1) + "º valor da chave");
                    in.nextInt();
                    value = in.hasNextInt();
                    if(value){
                        System.out.println("The number is an integer");
                        numeros[i] = in.nextInt();
                    }
                }
            }
            */

                // FORMA PROF. PROVISÓRIA
                // Ação não desejada: saindo do método quando diferente de um int.
                int temp = 0;
                try {
                    System.out.println("Insira o " + (i + 1) + "º valor da chave");
                    temp = in.nextInt();
                    while (temp > 50) {  // enquanto isso
                        System.out.println("Informe um valor menor ou igual a 50: ");
                        temp = in.nextInt();
                    }
                    numeros[i] = temp;
                } catch (Exception e) {
                    System.out.println("CHAVE com valor inválido, tente novamente do início!");
                    return;
                }
            }
            System.out.println();


            for (int i = 0; i < 2; i++){
                int temp = 0;
                try{
                    System.out.println("Insira a " + (i + 1) + "º estrela");
                    temp = in.nextInt();

                    while (temp > 11) {  // enquanto isso
                        System.out.println("Informe um valor menor ou igual a 11: ");
                        temp = in.nextInt();
                    }
                    estrelas[i] = temp;
                } catch (Exception e) {
                    System.out.println("ESTRELA com valor inválido, tente novamente do início!");
                    return;
                }
            }
            System.out.println();
            System.out.println();

            Arrays.sort(numeros);
            System.out.print("A chave ordenada do UTILIZADOR é: ");
            for(int i: numeros){
                System.out.print(i+" ");
            }
            System.out.println();

            Arrays.sort(estrelas);
            System.out.print("As estrelas ordenadas do UTILIZADOR são: ");
            for(int i: estrelas){
                System.out.print(i+" ");
            }
            System.out.println();
            System.out.println();
            System.out.print("COMPARANDO COM JOGO OFICIAL: ");
            System.out.println();
            System.out.println();

            System.out.print("A chave ordenada do JOGO OFICIAL: ");
            for (int i = 0; i < numerosAleatoriosOficial.length; i++) {
                System.out.print(numerosAleatoriosOficial[i]+" ");
            }
            System.out.println();
            System.out.print("As estrelas ordenadas do JOGO OFICIAL: ");
            for(int i = 0; i < estrelas_aleiatorio_oficial.length; i++){
                System.out.print(estrelas_aleiatorio_oficial[i]+" ");
            }

            if (Arrays.equals(numeros, numerosAleatoriosOficial)){
                System.out.println();
                System.out.println();
                System.out.println("Você VENCEU!!! PARABÉNS!!");
            }
            else{
                System.out.println();
                System.out.println();
                System.out.println("Você PERDEU! Sempre podes tentar novamente! ");
            }
            System.out.println();
            System.out.println();

        }
        jogo_utilizador_numeros = numeros;
        jogo_utilizador_estrelas = estrelas;
    }

    private static void boletin_aleatorio() {

        int start = 0;
        int estrelas[] = new int[2];
        int numeros[] = new int[5];

        Scanner in = new Scanner(System.in);
        Random generator = new Random();

        System.out.println();
        System.out.println();

        System.out.println("Insira um valor de 1 a 5, determinando a quantidade de CHAVES ALEATÓRIAS a concorrer: ");
        start = in.nextInt();

        System.out.println();
        System.out.println();

        for (int j = 0; j < start; j++) {
            System.out.println("PROCESSANDO CHAVE ALEATÓRIA - Nº " + (j + 1) + " ...");

            System.out.println();

            for (int i = 0; i < 5; i++) {
                numeros[i] = generator.nextInt(50) + 1;
            }
            for (int i = 0; i < 2 ; i++){
                estrelas[i] = generator.nextInt(11) + 1;
            }
            System.out.println();
            System.out.println();

            Arrays.sort(numeros);
            System.out.print("A chave ordenada ALEATÓRIA é: ");
            for(int i: numeros){
                System.out.print(i+" ");
            }
            System.out.println();

            Arrays.sort(estrelas);
            System.out.print("As estrelas ordenadas ALEATÓRIAS são: ");
            for(int i: estrelas){
                System.out.print(i+" ");
            }
            System.out.println();
            System.out.println();
            System.out.print("COMPARANDO COM JOGO OFICIAL: ");
            System.out.println();
            System.out.println();

            System.out.print("A chave ordenada do JOGO OFICIAL: ");
            for (int i = 0; i < numerosAleatoriosOficial.length; i++) {
                System.out.print(numerosAleatoriosOficial[i]+" ");
            }
            System.out.println();
            System.out.print("As estrelas ordenadas do JOGO OFICIAL: ");
            for(int i = 0; i < estrelas_aleiatorio_oficial.length; i++){
                System.out.print(estrelas_aleiatorio_oficial[i]+" ");
            }

            if (Arrays.equals(numeros, numerosAleatoriosOficial)){
                System.out.println();
                System.out.println();
                System.out.println("A chave ALEATÓRIA VENCEU!!! PARABÉNS!!");
            }
            else{
                System.out.println();
                System.out.println();
                System.out.println("A chave ALEATÓRIA PERDEU! Sempre podes tentar novamente! ");
            }
            System.out.println();
            System.out.println();

        }
    }

    private static void calcularNumeroJogadasPremio() {

        // 4. Simular quantas vezes seria necessário jogar (sempre com a mesma chave) de forma a conseguir ganhar o 1º
        //    prémio (5 números e 2 estrelas).

        int chance = 0;
        int n = 0;
        int e = 0;

        // boletin_utilizador
        int start = 0;
        int estrelasUtilizador[] = new int[2];
        int numerosUtilizador[] = new int[5];

        Scanner in = new Scanner(System.in);

        System.out.println();
        System.out.println();

        System.out.println("Insira um valor de 1 a 5, determinando a quantidade de CHAVES DO UTILIZADOR a concorrer: ");
        start = in.nextInt();

        System.out.println();
        System.out.println();

        for (int j = 0; j < start; j++){
            System.out.println("PROCESSANDO CHAVE DO UTILIZADOR - Nº " + (j + 1) + " ...");

            System.out.println();
            System.out.println();

            for (int i = 0; i < 5; i++) {
                // FORMA PROF. PROVISÓRIA
                // Ação não desejada: saindo do método quando diferente de um int.
                int temp = 0;
                try {
                    System.out.println("Insira o " + (i + 1) + "º valor da chave");
                    temp = in.nextInt();
                    while (temp > 50) {  // enquanto isso
                        System.out.println("Informe um valor menor ou igual a 50: ");
                        temp = in.nextInt();
                    }
                    numerosUtilizador[i] = temp;
                } catch (Exception error) {
                    System.out.println("CHAVE com valor inválido, tente novamente do início!");
                    return;
                }
            }
            System.out.println();


            for (int i = 0; i < 2; i++){


                int temp = 0;
                try{
                    System.out.println("Insira a " + (i + 1) + "º estrela");
                    temp = in.nextInt();

                    while (temp > 11) {  // enquanto isso
                        System.out.println("Informe um valor menor ou igual a 11: ");
                        temp = in.nextInt();
                    }
                    estrelasUtilizador[i] = temp;
                } catch (Exception error) {
                    System.out.println("ESTRELA com valor inválido, tente novamente do início!");
                    return;
                }
            }
            System.out.println();
            System.out.println();

            Arrays.sort(numerosUtilizador);
            System.out.print("A chave ordenada do UTILIZADOR é: ");
            for(int i: numerosUtilizador){
                System.out.print(i+" ");
            }
            System.out.println();

            Arrays.sort(estrelasUtilizador);
            System.out.print("As estrelas ordenadas do UTILIZADOR são: ");
            for(int i: estrelasUtilizador){
                System.out.print(i+" ");
            }

        }
            System.out.println();
            System.out.println();

        while (true) {

            // boletim oficial
            int estrelasOficial[] = new int[2];
            int numerosOficial[] = new int[5];
            Random generator = new Random();

            for (int i = 0; i < 5; i++) {
                numerosOficial[i] = generator.nextInt(50) + 1;
            }
            for (int i = 0; i < 2 ; i++){
                estrelasOficial[i] = generator.nextInt(11) + 1;
            }
            System.out.println();
            System.out.println();

            Arrays.sort(numerosOficial);
            Arrays.sort(estrelasOficial);

            // chances...
            if(n < 5){
                for (int i = 0; i < numerosOficial.length; i++) {
                    for (int j = 0; j < numerosUtilizador.length ; j++) {
                        if (numerosOficial[i] == numerosUtilizador[j]) {
                            n++;
                        }
                    }
                }
            }
            if(e < 2){
                for (int i = 0; i < estrelasOficial.length; i++) {
                    for (int j = 0; j < estrelasUtilizador.length; j++) {
                        if (estrelasOficial[i] == estrelasUtilizador[j]) {
                            e++;
                        }
                    }
                }
            }
            chance++;
            if (n == 5 && e == 2) {
                System.out.println("Suas chances de ganhar são: 1 em " + chance + " de tentativas!!");
                n = 0;
                e = 0;
            break;
            }
        }
    }
    

    //////////// JOGO 21 FOSFOROS
    private static void jogo_fosforos() { }

    //////////// JOGO ANABELA
    private static void jogo_anabela() { }

}