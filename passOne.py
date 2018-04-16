# passOne.py

inCode =open("input.txt","r")
opCodeFile = open("opcode.txt","r")

opLines = opCodeFile.readlines()

opCodes = {}
for line in opLines:
    line = line.replace("\n","")
    sp = line.split()
    opCodes[sp[0]] = sp[1]


line1 = inCode.readline()

sp = line1.split()

location_counter = int(sp[1])

cnt =0 

symbol_tables = {}

lines = inCode.readlines()

for line in lines:
    
    line = line.replace("\n","")
    sp = line.split()
    
    if sp[0] == "END":
        break
    elif sp[0] in opCodes:
        location_counter += 1
    elif sp[1] == "DS" or sp[1] == "DC":
        d = int(sp[2])
        location_counter += d
        symbol_tables[sp[0]] = location_counter
        
    else:
        symbol_tables[sp[0]] = location_counter
        location_counter += 1
    

print symbol_tables


registers = ["NULL","AREG","BREG","CREG","DREG"]

p = 1
cnt1 = 0
op = []


for line in lines:
    tmp = [0,0,0]
    sp = line.split()
    
    if sp[0] == "END":
        break

    if sp[0] in opCodes:        
        tmp[0] = opCodes[sp[0]]
 
    elif sp[1] in opCodes:        
        
        tmp[0] = opCodes[sp[1]]

    elif sp[1] == "DS":
        p = int(sp[2])
    
    elif sp[1] == "DC":
        tmp[2] = int(sp[2])

    if sp[2] in registers:
        tmp[1] = registers.index(sp[2])

    if sp[1] in registers:
        tmp[1] = registers.index(sp[1])


    if sp[-1] in symbol_tables:
        mn = int(symbol_tables[sp[-1]]) 
        tmp[2] = mn
    
    op.append(tmp)


print "MOT Table"
dlc = 101
for t in op:
    print dlc, t
    dlc +=1
    



# input.txt
START  101
MOVER  BREG  ONE  
AGAIN  MULT  BREG  TERM  
MOVER  CREG  TERM  
ADD  CREG  N  
MOVEM  CREG  TERM  
N  DS  2    
RESULT  DS  2    
ONE  DC  1    
TERM  DS  1    
END

#opcode.txt

MOVER 1
MULT 2
ADD 3
MOVEM 4

# how to run:python passOne.py












