// creating an object using ECMA 6 js
class Solution {
  beautifulBinaryString(s) {
    let count = 0;
    let newIndexb = 0;
    while (newIndexb <= s.length - 3 && newIndexb >= 0) {
      // if substring matches
      if (s.substring(newIndexb, newIndexb + 3) === '010') {
        count++;
        if (newIndexb + 3 >= s.length) break;
        else s = s.substring(newIndexb + 3);
        newIndexb = 0;
      } else {
        newIndexb++;
      }
    } // end of while loop

    return count;
  } // end of method
}

const solution = new Solution();
solution.beautifulBinaryString()
