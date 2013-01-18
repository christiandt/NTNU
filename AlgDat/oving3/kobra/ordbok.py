'''
Created on 14. sep. 2011

@author: christian
'''

from sys import stdin, stderr
import traceback

class Node:
    def __init__(self):
        self.barn = {}
        self.posi = []

def bygg(ordliste):
    rotnode = Node()
    for i in range(len(ordliste)):
        node = rotnode
        ordnaa, pos = ordliste[i]
        for j in range(len(ordnaa)):
            bokstav = ordnaa[j]
            if bokstav in node.barn:
                node = node.barn[bokstav]
            else:
                node.barn[bokstav] = Node()
                node = node.barn[bokstav]
        node.posi.append(pos)
    return rotnode


def posisjoner(ord, indeks, node):

    if indeks >= len(ord):                      #Index er for hoy
        posi = node.posi
    elif ord[indeks] == "?":                    #hvis bokstaven er spmtegn
        posi = []
        for barn in node.barn.values():         #sjekke alle barna og barnas barn
            posi += posisjoner(ord, indeks + 1, barn)
    elif ord[indeks] in node.barn:              #Om barnet inneholder bokstaven, sjekk paa nytt med barnet til noden
        posi = posisjoner(ord, indeks + 1, node.barn[ord[indeks]])
    else:                                       #Om ingen er sanne, returner tomt...
        posi = []
    return posi
            


try:
    ord = stdin.readline().split()
    ordliste = []
    pos = 0
    for i in ord:
        ordliste.append((i,pos))
        pos += len(i) + 1
    toppnode = bygg(ordliste)
    for sokeord in stdin:
        sokeord = sokeord.strip()
        print sokeord + ":",
        posi = posisjoner(sokeord, 0, toppnode)
        posi.sort()
        for j in posi:
            print j,
        print
except:
    traceback.print_exc(file=stderr)
