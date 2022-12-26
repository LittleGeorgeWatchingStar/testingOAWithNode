# The knows API is already defined for you.
# return a bool, whether a knows b
# def knows(a: int, b: int) -> bool:

class 277FindTheCelebrity:
    def findCelebrity(self, n: int) -> int:
        candidate = 0

        def isCeleb(candidate):
            for i in range(n):
                if i == candidate:
                    continue
                else:
                    if not knows(i, candidate) or knows(candidate, i):
                        return False
            return True

        for i in range(1, n):
            if knows(candidate, i):
                candidate = i

        if isCeleb(candidate):
            return candidate
        else:
            return - 1