'''
Created on 1. sep. 2011

@author: christian
'''

from sys import stdin


class Node:
    barn = None 
    ratatosk = None
    nesteBarn = None    # bare til bruk i DFS
    def __init__(self):
        self.barn = []
        self.ratatosk = False
        self.nesteBarn = 0

def dfs(rot):
    niva = 0
    stack = []
    node = rot
#    for i in range(antall_noder):
    while(True):
        if(node.ratatosk):
            return niva
        if(len(node.barn)>0):
            stack.append(node)
            node = node.barn.pop()
            niva+=1
        else:
            node = stack.pop()
            niva-=1
            
def bfs(rot):
    niva = 0
    queue = [rot]
    while(True):
        newqueue = []
        for i in range(len(queue)):
            if(queue[i].ratatosk):
                return niva
            newqueue.extend(queue[i].barn)
        queue = newqueue
        niva+=1


funksjon = stdin.readline().strip()
antall_noder = int(stdin.readline())
noder = []
for i in range(antall_noder):
    noder.append(Node())
start_node = noder[int(stdin.readline())]
ratatosk_node = noder[int(stdin.readline())]
ratatosk_node.ratatosk = True
for linje in stdin:
    tall = linje.split()
    temp_node = noder[int(tall.pop(0))]
    for barn_nr in tall:
        temp_node.barn.append(noder[int(barn_nr)])

if funksjon == 'dfs':
    print dfs(start_node)
elif funksjon == 'bfs':
    print bfs(start_node)
elif funksjon == 'velg':
    print bfs(start_node)
