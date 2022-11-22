class Solution {

  Set<String> dict;
  Map<String, Boolean> map;

  public boolean wordBreak(String s, List<String> wordDict) {
    dict = new HashSet<>(wordDict);
    map = new HashMap<>();
    return helper(s);
  }

  boolean helper(String s) {
    if (s.length() == 0) {
      //store the ans
      map.put(s, true);
      return true;
    }
    if (map.containsKey(s)) return map.get(s);
    //Rather than going char by char, we can go word by word
    for (String w : dict) {
      if (s.startsWith(w)) {
        String sub = s.substring(w.length());
        if (helper(sub)) {
          //store the answer for future use
          map.put(sub, true);
          return true;
        }
      }
    }
    //store the answer
    map.put(s, false);
    return false;
  }
}

class Solution {

  public boolean wordBreak(String s, List<String> wordDict) {
    return wordBreakMemo(
      s,
      new HashSet<>(wordDict),
      0,
      new Boolean[s.length()]
    );
  }

  private boolean wordBreakMemo(
    String s,
    Set<String> wordDict,
    int start,
    Boolean[] memo
  ) {
    if (start == s.length()) {
      return true;
    }
    if (memo[start] != null) {
      return memo[start];
    }
    for (int end = start + 1; end <= s.length(); end++) {
      if (
        wordDict.contains(s.substring(start, end)) &&
        wordBreakMemo(s, wordDict, end, memo)
      ) {
        return memo[start] = true;
      }
    }
    return memo[start] = false;
  }
}
