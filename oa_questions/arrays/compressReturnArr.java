class Main {
    public String compress(String input) {
        char[] chars = new char[input.length()];
  
        for (int i = 0; i < input.length(); i++) {
            chars[i] = input.charAt(i);
        }
        if (chars.length == 1) return input;

        int index = 0, newChar_start_at = 0,start = 0;
        while (start< chars.length) {
            int count = 0;
            char val = chars[newChar_start_at];
            for (;start < chars.length && chars[start] == val;count++,start++); 
            chars[index] = val;
            index++;
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[index] = c;
                    index++;
                }
                System.out.println(index);
            }
            newChar_start_at = start;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length()-1; i++) {
            sb.append(chars[i]);
        }
        String result = sb.toString();

        return result;
    }
}