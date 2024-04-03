import java.util.Random;

public class Matrix {
    private int[][] matrix;

    public Matrix(int size) {
        matrix = new int[size][size];
        Random rand = new Random();


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = rand.nextInt(9) + 1;
            }
        }
    }

    public int summa() {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public int raznost() {
        int raznost = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < i; j++) {
                raznost -= matrix[i][j];
            }
        }
        return raznost;
    }

    public int proizvedenie() {
        int proizvedenie = 1;
        for (int i = 0; i < 3; i++) {
            proizvedenie *= matrix[i][i];
        }
        return proizvedenie;
    }

    public void printMatrix() {
        System.out.println("Матрица:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

