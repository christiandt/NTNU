from sys import stdin
stdin = file('input.txt')

def main():
    for test in range(int(stdin.readline())):
        nabomatrise = []
        svar = 0
        stdin.readline()
        rekkefolge = [int(by) for by in stdin.readline().split()]
        for by in range(len(rekkefolge)):
            test = [int(by) for by in stdin.readline().split()]
            for d in range(len(test)):
                if(test[d] == -1):
                    test[d] = 999999
            nabomatrise.append(test)
        for k in range(len(rekkefolge)):
            for i in range(len(rekkefolge)):
                for j in range(len(rekkefolge)):
                    nabomatrise[i][j] = min(nabomatrise[i][j], nabomatrise[i][k] + nabomatrise[k][j])
        for c in range(1, len(rekkefolge)):
            svar += nabomatrise[rekkefolge[c-1]][rekkefolge[c]]
        svar += nabomatrise[rekkefolge[len(rekkefolge)-1]][rekkefolge[0]]
        if(svar >= 999999):
            print "umulig"
        else:
            print svar
main()