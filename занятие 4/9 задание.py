n=int(input('Введите число Фибоначчи:'))
if n<=2:
    print(n)
    exit(0)
a=1
b=1
s=2
for i in range(n-2):
    c = a+b
    a=b
    b=c
    s += c
    print('Ответ:',s)
