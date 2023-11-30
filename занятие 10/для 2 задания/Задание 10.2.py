# -- coding: utf-8 --
def replace_elements(matrix):
    new_matrix = []
    for row in matrix:
        min_value = min(row)
        new_row = [0 if val == min_value and min_value % 2 == 0 else 1 if val == min_value and min_value % 2 != 0 else val for val in row]
        new_matrix.append(new_row)
    return new_matrix
def read_matrix_from_file(file_name):
    matrix = []
    with open(file_name, 'r') as file:
        for line in file:
            row = list(map(int, line.split()))
            matrix.append(row)
    return matrix
def write_matrix_to_file(matrix, file_name):
    with open(file_name, 'w') as file:
        for row in matrix:
            file.write(' '.join(map(str, row)) + '\n')
input_file_name = 'Movsarov_Y232_vvod.txt'
output_file_name = 'Movsarov_Y232_vivod.txt'
user_matrix = read_matrix_from_file(input_file_name)
modified_matrix = replace_elements(user_matrix)
write_matrix_to_file(modified_matrix, output_file_name)
print(f"Новая матрица записана в файл '{output_file_name}'.")
