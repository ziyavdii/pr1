# -- coding: utf-8 --
def code(a,b):
    while b != 0:
        a,b=b,a%b
    return a
def code2(a,b,c,d):
    n=(a*d)-(c*b)
    k=b*d
    code_v=code(n,k)
    n /= code_v
    k /= code_v
    return int(n),int(k)
a=int(input('Числитель 1 дроби'))
b=int(input('Знаменатель 1 дроби'))
c=int(input('Числитель 2 дроби'))
d=int(input('Знаменатель 2 дроби'))
r=code2(a,b,c,d)
print(f'{r[0]}/{r[1]}')
      
