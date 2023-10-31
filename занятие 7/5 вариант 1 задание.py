# -- coding: utf-8 --
def code(a):
    p=[]
    for i in range(len(a)-1):
        if a[i] < 0 and a[i+1] < 0:
            p.append((a[i],a[i+1]))
    return p
a=[1,-2,-3,4,-5,-6,7,8,-9,-10]
r=code(a)
print(r)
