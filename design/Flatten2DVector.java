// You have to implement an iterator for ‘FLATTEN_2D’ to flatten a two-dimensional array ‘ARR_2D’ into a one-dimensional array ‘ARR_1D’. The iterator should support the following two operations:

// ‘NEXT’: The first call to ‘NEXT’ should return the first element of ‘ARR_2D’. Each subsequent call should return the next element in the row-wise traversal of ‘ARR_2D’.
// ‘HAS_NEXT’: It should return ‘true’ if the iteration has more elements to traverse; otherwise, if ‘NEXT’ has traversed the entire ‘ARR_2D’, return ‘false’.
// Try to code this using only iterators in C++ or iterators in Java.

// The ‘FLATTEN_2D’ object will be instantiated and called as follow:
//   FLATTEN_2D it = new FLATTEN_2D(ARR_2d);
//   while (it.hasNext()) {
//       arr1d.append(it.next());
//   }

// Example:
// ARR_2D = [ 
//           [0, 1],
//           [2, 3, 4],
//           [],
//           [5] 
//         ]
// The computed ‘ARR_1D’ should be as follows:
// ARR_1D = [0, 1, 2, 3, 4, 5]
// So, the printed output will be: 0 1 2 3 4 5
// 
// Constraints:
// 1 <= T <= 10
// 1 <= N <= 100
// 0 <= M <= 100
// -10^6 <= Value in each element of ‘ARR_2D’ <= 10^6

import java.util.* ;
import java.io.*; 
/****************************************************************

    'arr2d' and 'arr1d' are declared as follow:
        ArrayList<ArrayList<Integer>> arr2d;
        ArrayList<Integer> arr1d;

    The 'Flatten2D' object is instantiated and called as follow:
        Flatten2D* it = new Flatten2D(arr2d[i]);
        while (it->hasNext()) {
            arr1d.push_back(it->next());
        }

*****************************************************************/

import java.util.ArrayList;

public class Flatten2D {
  ArrayList<ArrayList<Integer>> arr2d;
  ArrayList<Integer> arr1d;
  int itr, arr;

  public  Flatten2D(ArrayList<ArrayList<Integer>> arr2d) {
    this.arr2d = arr2d;
    itr = 0;
    arr = 0;
    arr1d = new ArrayList<>();
  }

  public int next() {
    return arr2d.get(arr).get(itr++);
  }

  public boolean hasNext() {
    while(arr < arr2d.size() && itr >= arr2d.get(arr).size()) {
      itr = 0;
      arr++;
    }
    return arr < arr2d.size();
  }
}
