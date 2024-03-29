#TimeDelta
#!/bin/python3
#Date and time format reference - strftime

import math
import os
import random
import re
import sys
import datetime

# Complete the time_delta function below.
def time_delta(t1, t2):
    return (str(abs(int((datetime.datetime.strptime(t1,"%a %d %b %Y %H:%M:%S %z") - datetime.datetime.strptime(t2,"%a %d %b %Y %H:%M:%S %z")).total_seconds()))))

    dt1 = datetime.datetime.strptime(t1,"%a %d %b %Y %H:%M:%S %z")
    dt2 = datetime.datetime.strptime(t2,"%a %d %b %Y %H:%M:%S %z")
    return (str(abs(int(( dt1 - dt2).total_seconds()))))

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input())

    for t_itr in range(t):
        t1 = input()

        t2 = input()

        delta = time_delta(t1, t2)

        fptr.write(delta + '\n')

    fptr.close()