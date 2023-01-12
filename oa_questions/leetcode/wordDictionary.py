#wordDictionary
# we can build a dictionary of dictionary (trie) using defaultdict, 
# we can use lambda(inner/anonymous function) to return defaultdict

# _trie = lambda: defaultdict(_trie)
# This builds a trie and trie = _trie() calls the function 
# to create a trie.

# After adding every word: add Terminate symbol (i.e. $ or #), 
# so we know that it's a whole word.

# To search: we want to support .: which means that if we encounter. 
# In the pattern, we want to skip that character and move on to 
# next character, so we need to use dfs because from this point, 
# the answer could lie anywhere in the sub-trie - so recursively 
# check if any of the sub-trie returns True.
class WordDictionary(object):

    def __init__(self):
        _trie=lambda: collections.defaultdict(_trie)
        self.trie = _trie()
        self.Terminate = "#"

    def addWord(self, word):
        c_trie = self.trie
        for c in word:
            c_trie=c_trie[c]
        c_trie[self.Terminate]

    def search(self, word):
        c_trie = self.trie
        def dfs(word,i,c_trie):
            if i == len(word):
                return self.Terminate in c_trie
            c=word[i]
            if c in c_trie:
                c_trie = c_trie[c]
                return dfs(word,i+1,c_trie)
            elif c == ".":
                for key in c_trie.keys():
                    if dfs(word,i+1,c_trie[key]):
                        return True
                return False
            return False
        return dfs(word,0,c_trie)