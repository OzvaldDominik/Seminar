import sys
class Clause: # klasa koja modelira klauzulu satoji se od refernce na klazule iz kojih je nastala ako postje i
                # i skupa stringova koji predstavljaju literale
    def __init__(self,clauseString = None,parentOne = None,parentTwo = None):
        self.parentOne=parentOne
        self.parentTwo=parentTwo
        self.literalSet=set()
        if clauseString:
            for literal in clauseString.split(" "):
                if literal!="v" and literal!="" :
                    self.literalSet.add(literal)

    def __hash__(self):
        return hash(tuple(sorted(self.literalSet)))

    def __eq__(self, other):
        return self.literalSet == other.literalSet

    def __str__(self):
        literalList=list(sorted(self.literalSet))
        clauseString=""
        for literal in literalList:
            clauseString+= literal +" v "
        return clauseString[:len(clauseString)-3]

    def __len__(self):
        return len(self.literalSet)


    def getLiterals(self):
        return self.literalSet
    def setLiterals(self,setLiterals):
        self.literalSet=setLiterals

def loadClauses(clausesPath):
    lines = []
    clausesList = []
    with open(clausesPath, "r", encoding="utf-8") as file:
        lines = file.readlines()
    for line in lines:
        if line[0]!="#":
            clausesList.append(Clause(line[:len(line)-1].lower()))
    return clausesList


def negateLiteral(literal):
    if literal[0]=="~":
        return literal[1:]
    else:
        return "~"+literal


def getSos(clauses):
    targetClause=clauses.pop()
    sos=[]
    for literal in targetClause.getLiterals():
        sos.append(Clause(negateLiteral(literal)))
    return sos


def selectClausesSos(clauses, sos,newSet):
    pairs=set() # stvori novi skup parovoa

    for clauseNew in newSet: # stvori par za svaku klazulu iz pocetnog skupa i novo pornađenih klauzula
        for clauseStart in clauses:
            pairs.add((clauseNew, clauseStart))
    for clauseSos in sos:# stvori par za svaku klazulu iz sos i novo pornađenih klauzula
        for clauseNew in newSet:
            pairs.add((clauseNew, clauseSos))

    return pairs # vrati parove


def resolve(clausePair,sos):
    clauseOneLiterals = clausePair[0].getLiterals() # dohati literale prve klauzule u paru
    clauseTwoLiterals = clausePair[1].getLiterals() # dohati literale druge klauzule u paru
    negated=0       # broj komplementarnih literala
    newClauseSet = set() # set literala nove kaluzule
    for literalOne in clauseOneLiterals: # za svaki literal iz prve klazule provjeri
        if negateLiteral(literalOne) not in clauseTwoLiterals: # nalzaili se njegov komplement u drugoj
            newClauseSet.add(literalOne)  # ako se ne nalazi dodaj u skup nove klauzule
        else:
            negated+=1  # ako se nalazi povecaj broj komplementarnih literala
    for literalTwo in clauseTwoLiterals:  # provejri nalaze komlementi literala iz druge u proj i dodati ih ako se ne nalaze
        if negateLiteral(literalTwo) not in clauseOneLiterals:
            newClauseSet.add(literalTwo)


    if negated == 1: # a ko je bi samo jedan komlementarni literal
        newClause = Clause(parentOne=clausePair[0], parentTwo=clausePair[1]) # stvori novu klauzulu koja je nastalo od para klazula
        newClause.setLiterals(newClauseSet)
        if not any(newClauseSet.issuperset(sosClause.getLiterals()) for sosClause in sos): # provjeri jeli klauzla redundantna
            return newClause # ako nij redundantna ni tautologija vrati klauzulu
        else:
            return False

    else:
        return False


def checkExtra(clauses):
    sortedListOfClauses=list(sorted(clauses,key=len))
    for i , currentClause in enumerate(sortedListOfClauses):
        for otherClause in sortedListOfClauses[:i]:
            if currentClause.getLiterals().issuperset(otherClause.getLiterals()):
                clauses.remove(currentClause)
                break

def plResolution(clauses, sos):
    newSet=sos.copy()  #postavi novi skup na sos

    while True:
        slectedClauses=selectClausesSos(clauses,sos,newSet)# izaberi parove klauzula
        sos = sos.union(newSet)  # dodaj nove klauzule u sos
        newSet.clear() # postavi novi skup na prazan set
        for pair in slectedClauses: # za savaki par klauzula

            resolvents = resolve(pair,sos) # izracunaj rezolvente
            if not resolvents is False: # ako postoji rezolventa
                if len(resolvents) == 0: # provjeri jeli nil
                    return resolvents
                if not resolvents in sos: # dodaj u novi skup ako se ne nalazi u sos
                    newSet.add(resolvents)
        if newSet.issubset(sos): # ako nije pronadeno nista novo vrati Fales
            return False


def outputSolution(solution,testedClause):
    if not solution is False:

        steps = [solution]
        i = 0
        while i < len(steps):
            if steps[i].parentOne:
                steps.append(steps[i].parentOne)
                steps.append(steps[i].parentTwo)
            i += 1
        steps.reverse()
        startingClauses = []
        for step in steps:
            if not step.parentOne and step not in startingClauses:
                startingClauses.append(step)
        i = 0
        parentedClauses = []
        for step in steps:
            if step.parentOne:
                parentedClauses.append(step)

        printed = [False for _ in range(len(parentedClauses))]

        for clause in startingClauses:
            i += 1
            print(str(i) + '.', clause)
        print("===============")
        i = 0
        while False in printed:
            if (parentedClauses[i].parentOne in startingClauses and parentedClauses[i].parentTwo in startingClauses
                    and not printed[i] and parentedClauses[i] not in startingClauses):
                outClause = parentedClauses[i]
                if len(outClause) == 0:
                    outClause = "NIL"
                print(str(len(startingClauses) + 1) + '.', outClause,
                      "(", startingClauses.index(parentedClauses[i].parentOne) + 1, ",",
                      startingClauses.index(parentedClauses[i].parentTwo) + 1, ")")
                startingClauses.append(parentedClauses[i])
                printed[i] = True
            elif parentedClauses[i] in parentedClauses:
                printed[i] = True
            i = (i + 1) % len(parentedClauses)
        # print(str(len(startingClauses)+1)+'.',"NIL","(",startingClauses.index(solution.parentOne)+1,",",startingClauses.index(solution.parentTwo)+1,")")
        print("[CONCLUSION]:", testedClause, "is true")
    else:
        print("[CONCLUSION]:", testedClause, "is unknown")


def loadActions(actionsPath):
    lines = []
    clausesList = []
    with open(actionsPath, "r", encoding="utf-8") as file:
        lines = file.readlines()
    for line in lines:
        if line[0] != "#":
            clausesList.append([Clause(line[:len(line) - 2].lower()),line[len(line)-2]])
    return clausesList


def createSosFormClause(clause):
    sos=set()
    for literal in clause.getLiterals():
        sos.add(Clause(negateLiteral(literal)))
    return sos


if __name__ == "__main__":
    args = sys.argv
    clausesPath = None
    clausesBasePath=None
    actionsPath=None


    try:
        clausesPath=args[args.index("resolution")+1]
    except:
        clausesPath = None

    clauses = None

    try:
        clausesBasePath=args[args.index("cooking")+1]
        actionsPath=args[args.index("cooking")+2]
    except:
        actionsPath=None


    if clausesPath:
        clauses = loadClauses(clausesPath)
        testedClause=clauses[len(clauses)-1]
        sos=getSos(clauses)
        clauses=set(clauses)
        sos=set(sos)
        checkExtra(clauses)
        solution=plResolution(clauses,sos)
        outputSolution(solution,testedClause)
    if clausesBasePath and actionsPath:
        clausesBase=loadClauses(clausesBasePath)
        actions=loadActions(actionsPath)

        for action in actions:
            actionToPreforme=action[1]
            actionClause=action[0]
            print("Users comand:",actionClause,actionToPreforme)
            if actionToPreforme=="+":
                print("Added",actionClause)
                clausesBase.append(actionClause)
            elif actionToPreforme=="-":
                print("Removed",actionClause)
                clausesBase.remove(actionClause)
            elif actionToPreforme=="?":
                startingClauses=set(clausesBase.copy())
                sos=createSosFormClause(actionClause)
                checkExtra(startingClauses)
                solution=plResolution(startingClauses,sos)
                outputSolution(solution,actionClause)
            print()