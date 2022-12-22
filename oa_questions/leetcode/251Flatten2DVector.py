class 251Flatten2DVector:

    def __init__(self, vec: List[List[int]]):
        self.elements = vec
        self.x = 0
        self.y = 0

    def next(self) -> int:
        while self.x < len(self.elements) and self.y == len(self.elements[self.x]):
            self.x = self.x + 1
            self.y = 0
        value = self.elements[self.x][self.y]
        self.y = self.y + 1
        return value
        
    def hasNext(self) -> bool:
        while self.x < len(self.elements) and self.y == len(self.elements[self.x]):
            self.x = self.x + 1
            self.y = 0
        return self.x < len(self.elements)


# Your Vector2D object will be instantiated and called as such:
# obj = Vector2D(vec)
# param_1 = obj.next()
# param_2 = obj.hasNext()