n=int(input())
f=1
s=1
for i in range(2,n+1):
    s +=f * i
    f *=i
    print(s)
