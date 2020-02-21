//  Use Case: Or the situation at hand:
// 1. Strings consists of only A or B.
// 2. Final String should not consist of matching adjacent characters:
// a. Characters should not repeat consequtively.
// e.g AAB :=> AB : 1 deletion
// e.g. AABAAB :=> 1 deletion: ABAAB :=> 1 deletion: ABAB

class Solution {
  alternatingCharacters(s) {
    // empty array to store the characters of string that are non-repeating
    const characterArray = [''];
    // e.g ABAB :=> loop the string, we insert all the characters in the array
    let countDeletions = 0;
    for (let i = 0; i < s.length; i += 1) {
      const lastElementIndex = characterArray.length - 1;
      const currentChar = s.charAt(i);
      const previousChar = characterArray[lastElementIndex];
      if (currentChar === previousChar) countDeletions += 1;
      else characterArray.push(currentChar);
    }
    return countDeletions;
  }
}

const solution = new Solution();

const output = solution.alternatingCharacters('ABABABAB');

console.log(output);
