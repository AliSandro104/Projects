
import numpy as np

file_name = input("Please input the file name (e.g. hw1_short.txt): ")
f = open(file_name, "r")

# read the file
temp = False
for line in f:

    # if the line starts with ">" or "\n", we ignore it
    if (line[0] != ">") and (line[0] != "\n") and (not temp):
        S = line[:-1]   # we remove the last char, i.e. "\n", from S
        temp = True

    # if we already stored a line in S, we store the second one in T
    elif (line[0] != ">") and (line[0] != "\n") and (temp):
        T = line
        break

# close the file
f.close()  

matchScore = int(input("Please input the score for matches (e.g. 1): "))
mismatchScore = int(input("Please input the score for mismatches (e.g. -1): "))
c = int(input("Please input the gap penalty (e.g. -1): "))
      

#S = "ABBD" 
#T = "BD"

m = len(S)
n = len(T)

X = np.zeros((m + 1, n + 1))

X_arrows  = np.zeros((m + 1, n + 1))
# we will store 0,1 or 2 for each entry:
# store 0 if the arrow is diagonal
# store 1 if the arrow is vertical
# store 2 if the arrow is horizontal


# Initialization
for j in range(n + 1):
    X[0][j] = c * j
    X_arrows[0][j] = 2

for i in range(m + 1):
    X[i][0] = c * i
    X_arrows[i][0] = 1


# Matrix filling using Needleman-Wunsch Algorithm
for i in range(1, m + 1):
    for j in range(1, n + 1):

        s_i = S[i - 1]
        t_j = T[j - 1]

        if (s_i == t_j):
            score = matchScore
        else:
            score = mismatchScore

        max_list = [(X[i-1][j-1] + score), (X[i - 1][j] + c), (X[i][j - 1] + c)]

        max_score = max(max_list)

        max_index = max_list.index(max_score)

        X[i][j] = max_score

        X_arrows[i][j] = max_index


# Traceback procedure
i = m
j = n

new_S = ''
new_T = ''

while (i != 0 or j != 0):

    s_i = S[i - 1]
    t_j = T[j - 1]

    if (X_arrows[i][j] == 0):

        new_S = s_i + " " + new_S
        new_T = t_j + " " + new_T

        i -= 1
        j -= 1

    elif(X_arrows[i][j] == 1):

        new_S = s_i + " " + new_S
        new_T = "_" + " " + new_T

        i -= 1

    else:

        new_S = "_" + " " + new_S
        new_T = t_j + " " + new_T

        j -= 1

print("Optimal Score: " + str(X[m][n]))
print("S': " + new_S)
print("T': " + new_T)
