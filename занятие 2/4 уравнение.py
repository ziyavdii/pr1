Python 3.11.5 (tags/v3.11.5:cce6ba9, Aug 24 2023, 14:38:34) [MSC v.1936 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> import math
>>> x = 0.4*10**4
>>> y = -0.875
>>> z = -0.475*10**-3
>>> s = (math.fabs(math.cos(x)-math.cos(y))**(1+2*math.sin(y)**2))*(1+z+z**2/2+z**3/3+z**4/4)
>>> print(s)
1.9872670808332158
