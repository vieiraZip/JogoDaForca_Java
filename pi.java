import java.util.ArrayList;
import java.util.Scanner;

public class pi {

      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Jogador 1, digite a palavra: ");
        String palavra = scanner.nextLine().toUpperCase();

        ArrayList<Character> acertos = new ArrayList<>();
        ArrayList<Character> erros = new ArrayList<>();
        int tentativas = 6;
        int tamanho = palavra.length();
        StringBuilder forca = new StringBuilder("_".repeat(tamanho));

        System.out.println(forca.toString());

        while (tentativas >= 0) {
            System.out.printf("A palavra tem %d letras.%n", tamanho);
            System.out.println("Tente adivinhar!");
            String rdd = scanner.nextLine().toUpperCase();
            if (rdd.equals(palavra)) {
              System.out.println("Você advinhou a palavra! Parabéns!");
              break;
              } else{
              if (acertos.contains(rdd.charAt(0)) || erros.contains(rdd.charAt(0))) {
                  System.out.println("Essa letra já foi digitada, tente outra letra.\n" + forca.toString());
              } else {
                  if (palavra.contains(rdd)) {
                      acertos.add(rdd.charAt(0));
                      System.out.println("Você acertou uma letra!\n");
                      System.out.printf("Seu número de tentativas é %d%n", tentativas);
                      System.out.printf("Letras que você errou: %s%n", erros.toString());
                      for (int i = 0; i < tamanho; i++) {
                          if (palavra.charAt(i) == rdd.charAt(0)) {
                              forca.setCharAt(i, rdd.charAt(0));
                          }
                      }
                      System.out.println(forca.toString());
                  } else {
                      erros.add(rdd.charAt(0));
                      System.out.println("Você errou, tente de novo!\n");
                      System.out.printf("Seu número de tentativas é %d%n", tentativas);
                      System.out.printf("Letras que você errou: %s%n", erros.toString());
                      System.out.println(forca.toString());
                      tentativas--;
                  }
              }
  
              if (forca.indexOf("_") == -1) {
                  System.out.println("Parabéns, você acertou todas as letras!");
                  break;
              }
  
              if (tentativas == 0) {
                  System.out.printf("Que pena, você perdeu todas as suas tentativas!%nA palavra era %s%n", palavra);
                  break;
              }
            }
        }

        scanner.close();
    }
}
