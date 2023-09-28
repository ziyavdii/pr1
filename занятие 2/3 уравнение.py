Python 3.11.5 (tags/v3.11.5:cce6ba9, Aug 24 2023, 14:38:34) [MSC v.1936 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> import math
>>> x = 3.74*10**-2
>>> y = -0.825
>>> z = 0.16*10**2
>>> a = (1+math.sin(x+y)**2)
>>> b = abs(x-2*y/(1+x**2*y**2))
>>> c = math.cos(math.atan(1/z))**2
>>> s = a/b*(x**abs(y))+c
>>> print(s)
1.0553378150154775
