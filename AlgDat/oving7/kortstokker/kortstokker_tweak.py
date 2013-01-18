from sys import stdin
from itertools import repeat

stdin = file("input.txt")

decks = []
for line in stdin:
    (index, list) = line.split(':')
    decks.append(index[i])
print decks
#print decks
