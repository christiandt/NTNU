'''
Created on 28. sep. 2011

@author: christian
'''

from sys import *
import traceback

#stdin = file("input.txt")

def subgraftetthet(nabomatrise, startnode):
    #from pdb import set_trace; set_trace()
    n = len(nabomatrise)
    liste = []
    besoktenoder = set()
    node = startnode
    while(True):
        liste.extend(finnabonoder(nabomatrise, node, besoktenoder))
        besoktenoder.add(node)
        if(len(liste)==0):
            break
        node = liste.pop()
    #print besoktenoder
    kanter = 0
    noder = (n-len(besoktenoder))
    #print noder
    for i in range(n):
        if(not i in besoktenoder):
            for j in range(len(nabomatrise[i])):
                if(nabomatrise[i][j]==True):
                    if(not j in besoktenoder):
                        kanter+=1
    if noder == 0:
        return 0.0
    else:
        return float(kanter) / float(noder**2)
    
def finnabonoder(nabomatrise, node, besoktenoder):
        #print nabomatrise
        n = len(nabomatrise)
        liste = []
        for i in range(n):
            if(nabomatrise[node][i]==True): 
                if(not node in besoktenoder):
                    liste.append(i)
        return liste
        
try:
    n = int(stdin.readline())
    nabomatrise = [None] * n # rader
    for i in range(0, n):
        nabomatrise[i] = [False] * n # kolonner
        linje = stdin.readline()
        for j in range(0, n):
            nabomatrise[i][j] = (linje[j] == '1')
    for linje in stdin:
        start = int(linje)
        print "%.3f" % (subgraftetthet(nabomatrise, start) + 1E-12)
except:
    traceback.print_exc(file=stderr)
