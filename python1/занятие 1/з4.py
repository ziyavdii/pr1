#-- coding: utf-8 --
seconds = int(input('Введите количество секунд'))
days=seconds//86400
hours=(seconds%86400)//3600
minutes=(seconds%3600)//60
seconds=seconds%60
print(f'{days}{hours}{minutes}{seconds}')

