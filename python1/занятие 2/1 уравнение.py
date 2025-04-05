#-- coding: utf-8 --
import math
x = 14.26
y = - 1.22
z = 3.5*10**-2
a1 = 2*math.cos(x-2/3)
b1 = 1/2 + math.sin(y)**2
c1 = (1 +(z**2)/(3-(z**2)/5))
a2 = a1/b1
d = a2 * c1
print(d)

