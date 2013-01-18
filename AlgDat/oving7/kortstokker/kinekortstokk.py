from sys import stdin
from itertools import repeat

stdin = file("input.txt")

def merge(decks):
    while len(decks) > 1:           #sorterer listene i merge-lignende stil
        liste1 = decks.pop(0)
        liste2 = decks.pop(0)
        listami = []
        
        while len(liste1) > 0 and len(liste2) > 0:
            if liste1[0] < liste2[0]:
                listami.append(liste1.pop(0))
            else:
                listami.append(liste2.pop(0))
            print "liste1 " + str(liste1)
            print "liste2 " + str(liste2)
            print "listami: " + str(listami)
            print "\n"
        listami.extend(liste1)
        listami.extend(liste2)
        print listami
        decks.append(listami)
        bokstavliste = []
    for (tall,bokstav) in decks[0]:
        bokstavliste.append(bokstav)
    return ''.join(bokstavliste)

decks = []
for line in stdin:
    (index, list) = line.split(':')
    deck = zip(map(int, list.split(',')), repeat(index))    #en liste med fem lister med tupler i
    decks.append(deck)
print merge(decks)
