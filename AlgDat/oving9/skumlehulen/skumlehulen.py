'''
Created on 2. nov. 2011

@author: christian
'''

from sys import stdin, stderr
#stdin = file("input1.txt")

# kapasiteter er den opprinnelige kapasitetsmatrisen, som inneholder n x n elementer (hvor n er antall noder).
# startrom er en liste med indeksene til nodene som tilsvarer startrommene.
# utganger er en liste med indeksene til nodene som tilsvarer utgangene.

def antallIsolerteStier(kapasiteter, startrom, utganger):
    kapasiteter2 = []
    n=len(kapasiteter[0])
    flyt = []
    teller = 0
    for a in range(2*n+2):
        kapasiteter2.append([0]*(2*n+2))    #Lager 2dim. array (2n+2 x 2n+2) med nuller. "+2" er for aa legge paa super-source, og super-drain (jf. oppgave)
        flyt.append([0]*(2*n+2))            #Lager 2dim. array i samme stoerrelse som kapasiteter2 for aa lagre flyt i (kommer til det senere).
    for i in range(2*n):                    #Under her skal jeg fylle kapasiteter2 med den den skal ha.
        for j in range(2*n+2):              
            if i<n and j<n:                 #fyller 2. kvadrant med nuller
                kapasiteter2[i][j]=0
            elif i<n and j>=n :             #fyller 1. kvadrant med ettall paa diagonalen
                if(i==j-n):
                    kapasiteter2[i][j]=1
                else:
                    kapasiteter2[i][j]=0
            elif(i>=n and j<n):             #kopierer kapasiteter til 3. kvadrant i kapasiteter2
                kapasiteter2[i][j]=kapasiteter[i-n][j-n]
            elif(i>=n and j>=n):            #fyller 4. kvadrant med nuller
                kapasiteter2[i][j]=0
    kilde = 2*n                             #definerer hvilken plass kilden er paa
    for b in range(len(startrom)):          #setter 1 der kilden har kanter til noder (0 og 1 i eksempelinput1)
        kapasiteter2[kilde][startrom[b]] = 1
    sluk = 2*n+1                            #definerer hvilken plass kilden er paa
    for c in range(len(utganger)):          #setter 1 der noder har kanter til sluket (4 og 5 i eksempelinput1)
        kapasiteter2[n+utganger[c]][sluk] = 1
    while(True):                            #Bruker finnFlytsti til aa finne flytsti, helt til None blir returnert
        sti = finnFlytsti(kilde, sluk, flyt, kapasiteter2)
        if sti == None:
            break
        for c in range(1, len(sti)):
            flyt[sti[c-1]][sti[c]]=1        #setter 1 fremover der parene har kant (parene i listen "finnFlytsti" returnerer)
            flyt[sti[c]][sti[c-1]]=-1       #setter -1 bakover der parene har kant (parene i listen "finnFlytsti" returnerer)
        teller+=1                           #Holder styr paa hvor mange veier vi har funnet (svaret paa oppgaven)
    return teller
    
    # Du kan bruke metoden finnFlytsti for aa forenkle oppgaven.
    # SKRIV DIN KODE HER


# Finner en sti fra noden med indeks 'kilde' til noden med indeks 'sluk'
# med ledig kapasitet i et flytnettverk med flyt F og kapasitet C.
# Returnerer en liste hvor foerste element er indeksen til en av startnodene, 
# siste element er indeksen til en av utgangene, og elementene imellom er 
# indeksene til de andre nodene paa veien som ble funnet, i riktig rekkefoelge.
# Eksempel: en sti fra startnoden 4 til node 3, node 9, node 7 og til slutt til 
# utgangen 12 vil representeres som [4, 3, 9, 7, 12].

def finnFlytsti(kilde, sluk, F, C):
    n = len(F)
    oppdaget = [False] * n
    forelder = [None] * len(F)
    koe = [kilde]
    while koe:
        node = koe.pop()
        if node == sluk:
            # Har funnet sluken, lager en array med passerte noder
            sti = []
            i = node
            while True:
                sti.append(i)
                if i == kilde:
                    break
                i = forelder[i]
            sti.reverse()
            return sti;
        for nabo in range(n):
            if not oppdaget[nabo] and F[node][nabo] < C[node][nabo]:
                koe.append(nabo);
                oppdaget[nabo] = True;
                forelder[nabo] = node;
    return None

noder, _, _ = [int(x) for x in stdin.readline().split()]
startrom = [int(x) for x in stdin.readline().split()]
utganger = [int(x) for x in stdin.readline().split()]
nabomatrise = []
for linje in stdin:
    naborad = [int(nabo) for nabo in linje.split()]
    nabomatrise.append(naborad)
print antallIsolerteStier(nabomatrise, startrom, utganger)
