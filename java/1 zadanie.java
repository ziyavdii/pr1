import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = rand.nextInt(9) + 1;
            }
        }
        System.out.println("Матрица:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        int summa = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                summa += matrix[i][j];
            }
        }
        int raznost = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < i; j++) {
                raznost -= matrix[i][j];
            }
        }
        int proizvedenie = 1;
        for (int i = 0; i < 3; i++) {
            proizvedenie *= matrix[i][i];
        }
        System.out.println("Сумма элементов верхнего треугольника: " + summa);
        System.out.println("Разность элементов нижнего треугольника: " + raznost);
        System.out.println("Произведение элементов главной диагонали: " + proizvedenie);
    }
}