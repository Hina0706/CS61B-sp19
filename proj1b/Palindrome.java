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
      Deque<Character> p2 = new LinkedListDeque<Character>();
      for (int i = 0; i < word.length(); i++) {
        p2.addFirst(word.charAt(i));
      }
      return p1.equals(p2);
  }
}
