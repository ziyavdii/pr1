#-- coding: utf-8 --
def code(n,m,k):
    if k<n*m and ((k%n==0) or (k%m==0)) :
        print('ДА')
    else:
        print('НЕТ')
n=int(input())
m=int(input())
k=int(input())
r=code(n,m,k)
print(r)
