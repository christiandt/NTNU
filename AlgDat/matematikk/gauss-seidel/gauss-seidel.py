'''
Created on 11. nov. 2011

@author: christian
'''
x, y, z = 1.0, 1.0, 1.0

for i in range(1,6):
    x = (1.0/4.0)*(y+21.0)
    y = (1.0/4.0)*(x+z-45.0)
    z = (1.0/4.0)*(y+33.0)
    print "n="+ str(i)
    print "x=" + str(x)
    print "y=" + str(y)
    print "z=" + str(z)