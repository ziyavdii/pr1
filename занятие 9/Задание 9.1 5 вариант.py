# -- coding: utf-8 --
def sort_rows(matrix):
    sorted_matrix = [sorted(row) for row in matrix]
    return sorted_matrix
def read_matrix(n, m):
    matrix = []
    print("Введите элементы матрицы:")
    for i in range(n):
        row = []
        print(f"")
        while len(row) != m:
            elements = input().split()
            if len(elements) + len(row) <= m:
                row.extend(map(int, elements))
            else:
                print(f"")
        matrix.append(row)
    return matrix
def display_matrix(matrix):
    print("")
    for row in matrix:
        print(*row)
n = int(input("Введите количество строк (n): "))
m = int(input("Введите количество столбцов (m): "))
user_matrix = read_matrix(n, m)
sorted_matrix = sort_rows(user_matrix)
display_matrix(sorted_matrix)
