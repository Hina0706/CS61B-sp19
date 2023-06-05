public class Palindrome {
  public Deque<Character> wordToDeque(String word) {
      Deque<Character> res = new LinkedListDeque<Character>();
      for (int i = 0; i < word.length(); i++) {
        res.addLast(word.charAt(i));
      }
      return res;
  }

  public boolean isPalindrome(String word) {
      Deque<Character> p1 = wordToDeque(word);
      Deque<Character> p2 = wordToDeque(word);
      for(int i = 0; i < word.length(); i++){
          if(p1.removeFirst() != p2.removeLast()){
              return false;
          }
      }
      return true;
  }

  public boolean isPalindrome(String word, CharacterComparator cc) {
        for(int i = 0; i < word.length(); i++) {
            if(! cc.equalChars(word.charAt(i), word.charAt(word.length()-1-i))) {
                return false;
            }
        }
        return true;
  }
}
