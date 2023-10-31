# -- coding: utf-8 --
def code(n,k):
    fib=[0,1]
    sum=0
    for i in range(2,n+k):
        fib.append(fib[i-1]+fib[i-2])
        if i >= k:
            sum += fib[i]
    return sum   
n=int(input("Введите количество чисел ряда Фибоначчи:"))
k=int(input("Введите порядковый номер, с которого нужно начать:"))
r=code(n,k)
print(r)
