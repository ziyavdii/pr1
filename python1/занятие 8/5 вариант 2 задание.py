# -- coding: utf-8 --
def code(n):
    d=[]
    for i in range(1,n+1):
        if n % i==0:
            d.append(i)
    print(d)
r=code(15)
print(r)
    
