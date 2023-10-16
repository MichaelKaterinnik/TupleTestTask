# TupleTestTask

There are given a string S of length n that contains only the characters A and B. For each query, the program determines the match for the k-th character in the substring S[l…r].
If the k-th character in substring S[l..r] is A and this is x-th occurrence of A in the substring, then the match will be the position for x-th occurrence of B, and vice versa if k-th character in S[l..r] is B.
If there is no match, prints -1.

Input file
The first line of the input contains two integers n and q, where n is the length of the string S and q is the number of queries.
The second line of the input contains the string S, which consists of only the characters A and B.
The next q lines each contain a query in the form of three integers l, r, and k, representing a tuple (l, r, k).

Input values range:
n, q - 1...105
l, r - 1...n
k - 1...n
l <= r
k <= r - l + 1

Example of input file:
8 3
ABBABAAB
1 4 4
2 6 1
3 7 5

Output file
Example of output file (for this input file):
3
3
-1

There is an an executable .jar file inside and input.txt file with the contents described in the section Input/Output data format.
Run java -Xmx128M -jar your_solution.jar to execute the program


