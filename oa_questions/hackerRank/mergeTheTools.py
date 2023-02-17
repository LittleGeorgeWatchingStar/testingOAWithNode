#mergeTheTools
def merge_the_tools(string, k):
    # your code goes here
    for i in range(0, len(string), k):
        str = []
        charSet = set()
        for i in range(i, i+k):
            if string[i] not in charSet:
                str.append(string[i])
                charSet.add(string[i])
        print(''.join(str))

if __name__ == '__main__':
    string, k = input(), int(input())
    merge_the_tools(string, k)