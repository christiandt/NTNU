'''
Created on 12. nov. 2011

@author: christian
'''


for rownumber in range(20):
    newValue = 1
    PrintingList = [newValue]
    for iteration in range(rownumber):
        newValue = newValue*(rownumber-iteration)*1/(iteration+1)
        PrintingList.append(int(newValue))
    print(PrintingList)
