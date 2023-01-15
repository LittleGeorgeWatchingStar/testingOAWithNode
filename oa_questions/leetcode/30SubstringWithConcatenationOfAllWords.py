#30SubstringWithConcatenationOfAllWords
class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        n, numOfWords, word_length = len(s), len(words), len(words[0])
        substring_size = numOfWords * word_length
        res = []
        
        for left in range(word_length):
            counter = Counter(words)
            for right in range(left, n - word_length + 1, word_length):
                word = s[right : right + word_length]
                counter[word] -= 1
                
                while counter[word] < 0:
                    counter[s[left : left + word_length]] += 1
                    left += word_length
                
                if left + substring_size == right + word_length:
                    res.append(left)
        
        return res