# -- coding: utf-8 --
def code(matrix):
    new_matrix=[]
    for row in matrix:
        min_n=min(row)
        new_row=[]
        for n in row:
            if n == min_n:
                new_row.append(0 if n % 2 == 0 else 1)
            else:
                new_row.append(n)
        new_matrix.append(new_row)
    return new_matrix
def p():
    matrix = [[2,2,3],[4,5,6],[7,8,9]]
    r=code(matrix)
    print(r)
p()
