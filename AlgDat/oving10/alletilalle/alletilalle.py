'''
Created on 7. nov. 2011

@author: christian
'''

from sys import stdin, maxint
#stdin = file("input.txt")

inf = float('inf')

def korteste_rute(rekkefolge, nabomatrise, byer):
    svar = 0
    for k in range(byer):
        for i in range(byer):
            for j in range(byer):
                nabomatrise[i][j] = min(nabomatrise[i][j], nabomatrise[i][k] + nabomatrise[k][j])
    for c in range(1, byer):
        node=rekkefolge[c-1]
        nestenode=rekkefolge[c]
        svar += nabomatrise[node][nestenode]
    svar += nabomatrise[rekkefolge[byer-1]][rekkefolge[0]]
    if(svar == inf):
        svar = "umulig"
    return svar

    
    # SKRIV DIN KODE HER

testcases = int(stdin.readline())
for test in range(testcases):
    byer = int(stdin.readline())
    rekkefolge = [int(by) for by in stdin.readline().split()]
    nabomatrise = []
    for by in range(byer):
        test = [int(by) for by in stdin.readline().split()]
        for i in range(len(test)):
            if(test[i] == -1):
                test[i] = inf
        nabomatrise.append(test)
    # SKRIV DIN KODE HER
    print korteste_rute(rekkefolge, nabomatrise, byer)
