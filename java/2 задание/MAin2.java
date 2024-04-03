public class MAin2 {
    public static void main(String[] args) {
        Matrix matrixOp = new Matrix(3);
        matrixOp.printMatrix();

        System.out.println("Сумма элементов верхнего треугольника: " + matrixOp.summa());
        System.out.println("Разность элементов нижнего треугольника: " + matrixOp.raznost());
        System.out.println("Произведение элементов главной диагонали: " + matrixOp.proizvedenie());
    }
}