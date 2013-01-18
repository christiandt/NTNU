'''
Created on 12. okt. 2011

@author: christue
'''
#from sys import stdin

stdin = file("input.txt")

def sorter(A):
    mindre = []
    mer = []
    svar = []
    if(len(A)<=1):
        return A
    pivot = A[len(A)/2]
    for i in A:
        if(i<=pivot):
            mindre.append(i)
        else:
            mer.append(i)
    svar.extend(sorter(mindre))
    svar.append(pivot)
    svar.extend(sorter(mer))
    return svar


def finn(A, nedre, ovre):



liste = []
for x in stdin.readline().split():
    liste.append(int(x))

sortert = sorter(liste)

for linje in stdin:
    ord = linje.split()
    minst = int(ord[0])
    maks = int(ord[1])
    resultat = finn(sortert, minst, maks)
    print str(resultat[0]) + " " + str(resultat[1])
