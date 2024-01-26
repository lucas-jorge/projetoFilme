import java.util.InputMismatchException;
import java.util.Scanner;

public class OutroLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalRating = 0;
        double nota = 0;
        int totalDeNotas = 0;

        try {
            while (nota != -1) {
                System.out.println("Diga sua avaliação para o filme ou -1 para encerrar: ");
                try {
                    nota = scanner.nextDouble();

                    if (nota == -1) {
                        break;
                    }

                    if (nota < 0 || nota > 10) {
                        System.out.println("Avaliação inválida. A nota deve estar entre 0 e 10.");
                        continue;
                    }

                    totalRating += nota;
                    totalDeNotas++;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número válido.");
                    scanner.nextLine(); // Clear invalid input from the scanner
                }
            }

            if (totalDeNotas > 0) {
                double averageRating = totalRating / totalDeNotas;
                System.out.printf("Média de avaliações: %.2f", averageRating);
            } else {
                System.out.println("Nenhuma avaliação foi fornecida.");
            }
        } finally {
            scanner.close();
        }
    }
}
