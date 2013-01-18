'''
Created on 3. okt. 2011

@author: christian
'''

from sys import stdin
stdin = file("input.txt")

Inf = float(1e3000)
False = 0
True = 1
mstre = []
besokte = []

def mst(nm):
    naboer = []
    mstre.append(0)
    minstekant = Inf
    minstekantnode = Inf
    while len(mstre)<n:
        for i in range(len(mstre)):
            if((minstevekt(mstre[i])[1]<minstekant) and not erimst(minstevekt(mstre[i])[0])):
                minstekant = minstevekt(mstre[i])[1]
                minstekantnode = minstevekt(mstre[i])[0]
                mstre.append(minstekantnode)
                besokte.append(minstekantnode)
                print "NODE:"
                print minstekantnode
                print "KANT:"
                print minstekant  
                

            minstekant = Inf
            minstekantnode = Inf
    print mstre

        
    

def erimst(node):
    for i in range(len(mstre)):
        if(node==mstre[i]):
            return True
    return False

    
def minstevekt(node):
    nummer = 0
    svar = Inf
    for i in range(n):
        vekt = nabomatrise[node][i];
        if (vekt<svar) and (vekt != Inf):
            svar = vekt
            nummer = i
    return [nummer, svar]
    

    
def naboer(node):
    svar = []
    for i in range(n):
        if (vekt != Inf):
            svar.append(i)
    return svar



linjer = []
for str in stdin:
    linjer.append(str)
n = len(linjer)
nabomatrise = [None] * n
node = 0
for linje in linjer:
    nabomatrise[node] = [Inf] * n
    for k in linje.split():
        data = k.split(':')
        nabo = int(data[0])
        vekt = int(data[1])
        nabomatrise[node][nabo] = vekt
    node += 1
print mst(nabomatrise)