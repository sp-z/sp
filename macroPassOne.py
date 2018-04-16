# macroPassOne.py

macroIn = open("macroInput.txt","r")

lines = macroIn.readlines()

mntc = 1
mdtc = 0
alac = 0

mnt  = []
ala = []
mdt = []


prev = ""

flag = 0
for line in lines:
	line = line.replace("\n","")
	sp = line.split()

	if prev =="MACRO" and flag == 1:
		mnt.append([mntc,sp[0],mdtc])
		for arg in sp[1:]:
			sa =  arg.split("=")
			if len(sa) == 2:
				ala.append([alac,mntc,sa[0],sa[1]])
			else:
				ala.append([alac,mntc,sa[0]])

			alac += 1
		mntc += 1


	if sp[0].upper() == "MACRO":
		prev = sp[0].upper()
		flag = 1
		
	elif flag == 1:
		prev = sp[0].upper()
		mdt.append(line)
		mdtc += 1
		if sp[0].upper() == "MEND":
			flag = 0

mntFile = open("mnt.txt","w")
print "MNT Table"
for m in mnt:
	print m


print "argument list table"
for arg in ala:
	print arg

print "macro definition table"
for l in mdt:
	print l

flag = 0
for line in lines:
	line = line.replace("\n","")

	sp = line.split()
	if sp[0] == "START":
		flag  = 1

	if flag ==1:
		for m in mnt:
			if sp[0] == m[1]:
				print "Macro Call found"
				passed = sp[1:]
				# find arguments in argument list
				argumentList= []
				defaultVals = []

				for al in ala:
					if al[1] == m[0]:
						argumentList.append(al[2])
						if len(al) ==4:
							defaultVals.append(al[3])
						else:
							defaultVals.append("-")

				params = {}

				cntr = 0

				for arg in argumentList:
					try:
						params[arg] = passed[cntr] 
					except:
						params[arg] = defaultVals[cntr]
					cntr+=1

					else:
				pass
				#print line




#macroInput.txt

MACRO
INCR1 &FIRST &SECOND=DATA9
A 1 &FIRST
L 2 &SECOND
MEND
MACRO
INCR2 &ARG1 &ARG2=DATA5
L 3 &ARG1
ST 4 &ARG2
MEND
START
 USING * BASE
 INCR1 DATA1
 INCR2 DATA3 DATA4
FOUR DC F'4'
FIVE DC F'5'
BASE EQU 8
TEMP DS 1F
 DROP 8
 END

 





