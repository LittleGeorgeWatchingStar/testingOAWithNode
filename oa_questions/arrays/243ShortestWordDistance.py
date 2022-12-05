class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        dist = float("inf")
        i, index1, index2 = 0, None, None

        while i < len(wordsDict):
            if wordsDict[i] == word1:
                index1 = i
            elif wordsDict[i] == word2:
                index2 = i

            if index1 is not None and index2 is not None:
                dist = min(dist, abs(index1 - index2))

            i += 1
        return dist