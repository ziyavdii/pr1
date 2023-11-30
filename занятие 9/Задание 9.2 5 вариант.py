# -- coding: utf-8 --
def replace_elements(matrix):
    new_matrix = []
    for row in matrix:
        min_value = min(row)
        new_row = [0 if val == min_value and min_value % 2 == 0 else 1 if val == min_value and min_value % 2 != 0 else val for val in row]
        new_matrix.append(new_row)
    return new_matrix
def read_matrix(n, m):
    matrix = []
    print(f"Введите {m} элемента матрицы построчно, разделяя числа пробелами:")
    for i in range(n):
        row = list(map(int, input().split()))
        matrix.append(row)
    return matrix
def display_matrix(matrix):
    print("Новая матрица:")
    for row in matrix:
        print(*row)
n = int(input("Введите количество строк (n): "))
m = int(input("Введите количество столбцов (m): "))
user_matrix = read_matrix(n, m)
modified_matrix = replace_elements(user_matrix)
display_matrix(modified_matrix)
