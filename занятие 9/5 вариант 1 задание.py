# -- coding: utf-8 --
def code(matrix):
    s=[]
    for row in matrix:
        s_row=sorted(row)
        s.append(s_row)
    return s
def p(matrix):
    for row in matrix:
        print(row)
matrix=[[3,5,4,7],[1,5,7,4],[5,9,0,8],[3,2,1,7]]
s=code(matrix)
print(s)
