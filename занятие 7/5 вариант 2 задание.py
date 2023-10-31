# -- coding: utf-8 --
def code(c):
    n = []
    for num in c:
        if num not in n:
            n.append(num)
    return n
c=[1,2,3,3,4,4,5,6,7,7]
r=code(c)
print(r)
