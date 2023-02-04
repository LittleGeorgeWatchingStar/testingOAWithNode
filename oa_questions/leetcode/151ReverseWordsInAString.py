#151ReverseWordsInAString
class Solution:
    def reverseWords(self, s: str) -> str:
        return ' '.join([w for w in s.split(" ") if w][::-1])
    
    # l=s.split()
    # l=l[::-1]
    # return ' '.join(l)
    
class Solution:
    def reverseWords(self, s: str) -> str:
        result = ""
        i = 0
        n = len(s)

        while i < n:
            while i < n and s[i] == ' ': 
                i += 1
            if i >= n: 
                break
            j = i + 1
            while j < n and s[j] != ' ': 
                j += 1
            sub = s[i:j]
            if len(result) == 0: 
                result = sub
            else: 
                result = sub + " " + result
            i = j+1

        return result
    
class Solution:
    def reverseWords(self, s: str) -> str:
        sList = s.split()
        n=len(sList)-1
        output =""
        while n >=0:
            output += " "+sList[n]
            n -=1
        return output.strip()