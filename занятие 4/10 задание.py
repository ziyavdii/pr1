n=int(input("Введите количество чисел ряда Фибоначчи:"))
k=int(input("Введите порядковый номер, с которого нужно начать:"))
fib=[0,1]
for i in range(2,n+k):
    fibonacci.append(fib[i-1]+fib[i-2])
    print(s(fib[k:]))
