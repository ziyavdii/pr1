#-- coding: utf-8 --
age=int(input())
name=input()
if name != 'Иван' :   
    if age >= 16 and age < 75 :       
        print('Поздравляем вы поступили в ВГУИТ')
elif age > 0 and age < 16 :
    print('Сначала нужно окончить школу!')
else:
    print('Абитуриентов с именем Иван не берем')

