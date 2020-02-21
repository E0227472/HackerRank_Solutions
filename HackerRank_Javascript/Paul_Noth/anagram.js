// What is the problem statement?

// 1. Split the String into 2 contigous substrings (2 substrings that are in sequence)
// 2. The 2 substrings must be of equal length.
// 3. The 2 substrings must contain the same characters but of any order => anagrams

// e.g xyyx
// substring 1: xy :=> xy (sort) :=> loop forward
// substring 2: yx :=> xy (sort) :=> loop forward
// We are going to count the number of matching characters in both substrings.
// We are going to substract the number of matching characters to length of substring
// to find the number of unmatching characters :=> number of characters that need to be changed

class Solution {
  anagram(s) {
    this.satisfy = '';
    let numChanges = 0;
    let countMatchChars = 0;
    if (s.length % 2 !== 0) numChanges = -1;
    // => if string length is odd, cannot split evenly.
    else {
      // get 2 equal length substrings
      const s1Original = s.substring(0, s.length / 2);
      const s2Original = s.substring(s.length / 2);
      // sort the substrings
      let s1 = s1Original.split('');
      s1 = s1.sort();
      s1 = s1.join('');
      let s2 = s2Original.split('');
      s2 = s2.sort();
      s2 = s2.join('');
      // compare both substrings to determine number of matching characters
      // loop Substring s1 in forward direction
      for (let i = 0; i < s1.length; i += 1) {
        const maxIndexS2 = s2.length - 1;
        const s1CurrentChar = s1.charAt(i);
        for (let j = 0; j <= maxIndexS2; j += 1) {
          const s2CurrentChar = s2.charAt(j);
          if (s1CurrentChar === s2CurrentChar) {
            if (j !== maxIndexS2) {
              //= > deleting the char at position j in s2.
              s2 = s2.substring(0, j) + s2.substring(j + 1);
              countMatchChars += 1;
              break;
            } else {
              s2 = s2.substring(0, j); // => deleting char at end of substring
              countMatchChars += 1;
              break;
            }
          }
        }
      }
      numChanges = s2Original.length - countMatchChars;
    }
    return numChanges;
  }
}

const solution = new Solution();

const output = solution.anagram('abcabc');

console.log(output);
