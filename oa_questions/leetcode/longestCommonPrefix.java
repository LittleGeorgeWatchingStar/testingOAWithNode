class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }  
        }
        return prefix;
    }
}


class Solution {
    public String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs[0].length(); i++) 
        {
            char tmpChar = strs[0].charAt(i); 
            for (int j = 0; j < strs.length; j++) 
            {
                if (strs[j].length() == i || strs[j].charAt(i) != tmpChar) 
                {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0]; 
    }
}