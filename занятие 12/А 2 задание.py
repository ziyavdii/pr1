#-- coding: utf-8 --
def code(a,b):
    if a < b:
        return a
    return code(a - b, b)
a = int(input("Введите число a:"))
b = int(input("Введите число b:"))
result = code(a,b)
print("Остаток от деления", a, "на", b, "равен", result)
