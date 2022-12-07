class 8StringToInt:
    def myAtoi(self, s: str) -> int:
        s = s.lstrip()
        if not s:
            return 0
        if len(s)==1 and not s[0].isdigit():
            return 0

        i = 0
        sign = 1
        if s[i]=="+":
            i+=1
            
        if s[i]=="-":
            sign = -1
            i+=1

        if i==2:
            return 0
        
        parsed = 0
        while i<len(s):
            if not (s[i]).isdigit():
                break
            else:
                parsed = parsed*10 + int(s[i])
            i+=1
        parsed = sign*parsed
        if parsed>2**31-1:
            return 2**31-1
        elif parsed<=-2**31:
            return -2**31
        else:
            return parsed