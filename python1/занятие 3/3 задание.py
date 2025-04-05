#-- coding: utf-8 --
n=int(input("Введите количество минут"))
h=n%(60*24)//60
m=n%60
print(f'{h}:{m}')
