class Node:
  def __init__(self, cargo=None, next=None):
    self.cargo = cargo
    self.next  = next
    node1 = Node(1) 
    node1.next = node2 
    node2 = Node(2) 
    printList(node1) 

  def __str__(self):
    return str(self.cargo) 
    
  def printList(node):
    while node:
      print node,
      node = node.next
    print 