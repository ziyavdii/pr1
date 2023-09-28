def calculate_lace_length(a, b, l, N):
return=b * (N - 1) + a * (N // 2) + l
a=int(input("Введите расстояние между рядами дырочек(a):"))
b=int(input("Введите расстояние между дырочками в ряду(b):"))
c=int(input("Введите длину свободного конца шнурка(l):"))
N=int(input("Введите количество дырочек в каждом ряду(N):"))
length=calculate_lace_length(a, b, l, N)
print(length)
