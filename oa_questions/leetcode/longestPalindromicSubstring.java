class Solution {

  public String longestPalindrome(String s) {
    // low and high represents the bounds of the substring of s that is palindromic and largest
    // inclusive
    int low = 0, high = 0;

    for (int idx = 0; idx < s.length(); idx++) {
      int[] even_bounds = bounds(s, idx, idx + 1);
      int[] odd_bounds = bounds(s, idx, idx);

      int even_len = even_bounds[1] - even_bounds[0] + 1;
      int odd_len = odd_bounds[1] - odd_bounds[0] + 1;
      int curr_len = high - low + 1;

      // If the palindrome we found cenetered at idx is larger than the previous palindrome we found
      // update the bounds of our output substring
      if (even_len > curr_len) {
        low = even_bounds[0];
        high = even_bounds[1];
      }

      curr_len = high - low + 1;

      if (odd_len > curr_len) {
        low = odd_bounds[0];
        high = odd_bounds[1];
      }
    }

    // Return the substring with bounds low and high inclusive
    return s.substring(low, high + 1);
  }

  public int[] bounds(String s, int low, int high) {
    // If this is the case there are no valid substrings that are palindromic starting with
    // char at low and high
    if (high >= s.length() || s.charAt(low) != s.charAt(high)) {
      return new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE };
    }

    int[] bounds_arr = new int[2];

    while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
      low--;
      high++;
    }

    // Our end condition is when low is either too small, high is either too large, or the char at
    // low and high no longer match. That is why we adjust our bounds. To go back to the most recent             // state where s.charAt(low) == s.charAt(high)
    bounds_arr[0] = low + 1;
    bounds_arr[1] = high - 1;

    return bounds_arr;
  }
}



class Solution {
    public String longestPalindrome(String s) {
        char[] letters = s.toCharArray();

        int[] longestPalindrome = new int[0];
        int[] firstPalindrome;
        int[] secondPalindrome;
        for (int i = 0; i < letters.length; i++) {
            // checks for palindromes like 'abba'
            firstPalindrome = findPalindromeRange(letters, i, i + 1);
            // checks for palindromes like 'abcba'
            secondPalindrome = findPalindromeRange(letters, i - 1, i + 1);
            if (firstPalindrome.length > 0 && getPalindromeLength(firstPalindrome) > getPalindromeLength(longestPalindrome)) {
                longestPalindrome = firstPalindrome;
            }
            if(secondPalindrome.length > 0 && getPalindromeLength(secondPalindrome) > getPalindromeLength(longestPalindrome)) {
                longestPalindrome = secondPalindrome;
            }
        }

        // if max length of palindrome is 1, we return first symbol
        if(longestPalindrome.length == 0 && s.length() > 0) {
            return s.substring(0, 1);
        }
        else if(longestPalindrome.length == 0) {
            return "";
        }

        return s.substring(longestPalindrome[0], longestPalindrome[1] + 1);
    }

    private int[] findPalindromeRange(char[] letters, int inputLeft, int inputRight) {
        if (inputLeft < 0 || inputRight >= letters.length) {
            return new int[0];
        }
        int left = inputLeft;
        int right = inputRight;
        boolean isPalindrome = true;
        while (isPalindrome && left >= 0 && right < letters.length) {
            if (letters[left] == letters[right]) {
                left--;
                right++;
            } else {
                isPalindrome = false;
            }
        }
        // this means, that we failed first check, and letters[left] != letters[right]
        if (right - 1 < inputRight) {
            return new int[0];
        }

        return new int[]{left + 1, right - 1};
    }

    private int getPalindromeLength(int[] palindromeIndex) {
        return  palindromeIndex.length > 0 ? palindromeIndex[1] - palindromeIndex[0] : 0;
    }
}