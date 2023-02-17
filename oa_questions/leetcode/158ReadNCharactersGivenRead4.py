#158ReadNCharactersGivenRead4
"""
The read4 API is already defined for you.
@param buf a list of characters
@return an integer
you can call Reader.read4(buf)
"""


class Solution:
    def __init__(self):
        self.buf4 = ['']*4
        self.currUsed = 0
        self.currRead = 0
        self.eof = False

    # @param {char[]} buf destination buffer
    # @param {int} n maximum number of characters to read
    # @return {int} the number of characters read
    def read(self, buf, n):
        numRead = 0
        while numRead < n and not self.eof:
            if self.currUsed == self.currRead:
                self.currRead = Reader.read4(self.buf4)
                self.currUsed = 0
                if self.currRead == 0:
                    self.eof = True
            else:
                progress = min(self.currRead-self.currUsed, n - numRead)
                buf[numRead:numRead+progress] = self.buf4[self.currUsed:self.currUsed+progress]
                numRead += progress
                self.currUsed += progress
        return numRead



