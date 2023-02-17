#157ReadNCharactersGivenRead4
class solution:
    def read(self, buf, n):
        """

        Args:
            buf (_type_): destination buffer (list[str])
            n (_type_): number of character to read (int)
        """
        buf4 = [''] * 4
        numRead = 0
        EOF = False
        while numRead < n and not EOF:
            currRead = read4(buf4)
            progress = min(currRead, n - numRead)
            buf[numRead:numRead+progress] = buf4[:progress]
            numRead += progress
            if currRead < 4:
                EOF = True
        return numRead
        