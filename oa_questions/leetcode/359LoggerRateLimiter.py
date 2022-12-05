class Logger:

    def __init__(self):
        self.mDict = {}
        

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.mDict:
            self.mDict[message] = timestamp
            return True
        if timestamp - self.mDict[message] >= 10:
            self.mDict[message] = timestamp
            return True
        elif timestamp - self.mDict[message] < 10:
            return False
        


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)