# Data Structures & Algorithms — Notes

## BIT Mesra MCA 2026 | Part A, Section 3 & 4

> ⭐ = directly in BIT Mesra syllabus | rest = general knowledge, lower priority

---

## Syllabus Coverage

- Programming in C, Recursion ⭐
- Arrays, Stacks, Queues, Linked Lists, Trees, BST ⭐
- Searching, Sorting ⭐
- Asymptotic worst-case time and space complexity ⭐
- Algorithm design: Greedy, Divide and Conquer ⭐

---

## 1. Basics of Data Structures

- **Data Structure** — way of organizing data for efficient access and modification
- Two types:
  - **Linear** — Array, Stack, Queue, Linked List (elements in sequence)
  - **Non-linear** — Tree, Graph (elements in hierarchy/network)
- **Abstract Data Type (ADT)** — defines what operations are possible, not how they are implemented

---

## 2. Arrays ⭐

- Collection of elements of **same data type** stored in **contiguous memory**
- **Index starts at 0**
- **Random access** — access any element in O(1) using index
- Fixed size (size decided at declaration)

### Operations & Complexity

| Operation               | Time Complexity |
| ----------------------- | --------------- |
| Access by index         | O(1)            |
| Search (unsorted)       | O(n)            |
| Search (sorted, binary) | O(log n)        |
| Insert at end           | O(1)            |
| Insert at middle/start  | O(n)            |
| Delete at middle/start  | O(n)            |

### Types of Arrays

- **1D Array** — single row: `int a[5]`
- **2D Array** — rows and columns (matrix): `int a[3][4]`
- **Row Major** — elements stored row by row (C uses this)
- **Column Major** — elements stored column by column (Fortran uses this)

### Address Formula

- **Row Major:** Address = Base + [ i × C + j ] × size
- **Column Major:** Address = Base + [ j × R + i ] × size
- (where R = rows, C = columns, i = row index, j = column index)

> 🧠 Trick: C language = Row Major. "C goes Row by Row."

---

## 3. Recursion ⭐

- A function that **calls itself**
- Must have a **base case** (termination condition) — else infinite recursion
- Each call is stored on the **call stack**
- Uses more memory than iteration (due to stack frames)

### Key Facts

- **No base case** → infinite recursion → **stack overflow**
- Recursion uses **stack** internally (system call stack)
- Any recursive algorithm can be converted to iterative using an explicit stack

### Common Recursive Problems

| Problem                  | Recurrence         | Result                     |
| ------------------------ | ------------------ | -------------------------- |
| Factorial(n)             | n × Factorial(n-1) | O(n) time                  |
| Fibonacci(n)             | F(n-1) + F(n-2)    | O(2^n) naive, O(n) with DP |
| Tower of Hanoi (n disks) | 2^n - 1 moves      | O(2^n)                     |

> 🧠 Trick: Tower of Hanoi with n disks = **2^n - 1** moves. Very common MCQ.

---

## 4. Stack ⭐

- **LIFO** — Last In First Out
- One end only — the **top**
- Operations: push, pop, peek/top, isEmpty

### Operations & Complexity

| Operation | Time |
| --------- | ---- |
| Push      | O(1) |
| Pop       | O(1) |
| Peek      | O(1) |
| Search    | O(n) |

### Applications of Stack (MCQ favourite)

- **Expression evaluation** — infix, prefix, postfix
- **Balancing parentheses** — check if brackets are matched
- **Function call management** — call stack
- **Undo operation** in editors
- **Non-recursive implementation** of recursive algorithms
- **DFS** (Depth First Search)
- **Infix to Postfix/Prefix conversion**

> 🧠 Trick: Stack = LIFO. Think of a stack of plates — last plate placed is first removed.

### Infix, Prefix, Postfix

| Type                     | Format | Example |
| ------------------------ | ------ | ------- |
| Infix                    | A op B | A + B   |
| Prefix (Polish)          | op A B | + A B   |
| Postfix (Reverse Polish) | A B op | A B +   |

- Computers evaluate **postfix** easily using a stack
- **Infix → Postfix conversion** uses a stack (operators pushed, popped based on precedence)

---

## 5. Queue ⭐

- **FIFO** — First In First Out
- Two ends — **rear** (insert) and **front** (delete)
- Operations: enqueue, dequeue, peek, isEmpty

### Operations & Complexity

| Operation | Time |
| --------- | ---- |
| Enqueue   | O(1) |
| Dequeue   | O(1) |
| Peek      | O(1) |
| Search    | O(n) |

### Types of Queue

- **Simple Queue** — basic FIFO
- **Circular Queue** — rear connects back to front; solves wasted space problem
- **Double Ended Queue (Deque)** — insert/delete from both ends
- **Priority Queue** — element with highest priority dequeued first

### Applications of Queue

- **CPU scheduling** (Round Robin uses queue)
- **BFS** (Breadth First Search)
- **Printer spooling**
- **IO buffers**

> 🧠 Trick: Queue = FIFO. Think of a line at a ticket counter — first person in line gets served first.

### Circular Queue — Key Points

- Solves the "false full" problem of simple queue
- Uses formula: `rear = (rear + 1) % size`
- Both enqueue and dequeue are O(1)

---

## 6. Linked List ⭐

- Collection of **nodes** where each node has:
  - **Data**
  - **Pointer to next node**
- Dynamic size — grows/shrinks at runtime
- No contiguous memory needed
- No random access — must traverse from head

### Types of Linked List

- **Singly Linked List** — each node points to next only
- **Doubly Linked List** — each node has next AND previous pointer
- **Circular Linked List** — last node points back to first node

### Operations & Complexity

| Operation           | Singly LL | Array |
| ------------------- | --------- | ----- |
| Access by index     | O(n)      | O(1)  |
| Insert at beginning | O(1)      | O(n)  |
| Insert at end       | O(n)      | O(1)  |
| Delete at beginning | O(1)      | O(n)  |
| Search              | O(n)      | O(n)  |

### Array vs Linked List

| Feature       | Array              | Linked List            |
| ------------- | ------------------ | ---------------------- |
| Memory        | Contiguous         | Non-contiguous         |
| Size          | Fixed              | Dynamic                |
| Access        | O(1) random        | O(n) sequential        |
| Insert/Delete | O(n)               | O(1) at known node     |
| Memory usage  | Less (no pointers) | More (stores pointers) |

> 🧠 Trick: Array = fast access, slow insert. Linked List = slow access, fast insert.

### Applications of Linked List

- Implementing stacks and queues
- Dynamic memory allocation
- **Circular linked list** used in Round Robin scheduling
- Polynomial representation
- Undo functionality (doubly linked list)

---

## 7. Trees ⭐

- **Non-linear, hierarchical** data structure
- **Root** — topmost node (no parent)
- **Leaf** — node with no children
- **Height of tree** — longest path from root to leaf
- **Depth of node** — distance from root to that node
- **Degree of node** — number of children

### Key Tree Terminology

- **Parent** — node above
- **Child** — node below
- **Sibling** — nodes with same parent
- **Subtree** — a node and all its descendants
- **Level** — root is level 0 (or 1 depending on convention)

### Binary Tree

- Each node has **at most 2 children** (left and right)
- **Full Binary Tree** — every node has 0 or 2 children
- **Complete Binary Tree** — all levels full except last; last level filled left to right
- **Perfect Binary Tree** — all internal nodes have 2 children, all leaves at same level
- **Skewed Tree** — all nodes on one side (left-skewed or right-skewed); worst case

### Binary Tree Properties

- Max nodes at level i = **2^i**
- Max nodes in tree of height h = **2^(h+1) - 1**
- Min height of tree with n nodes = **floor(log2 n)**

> 🧠 Trick: Perfect binary tree with height h has **2^(h+1) - 1** nodes. e.g. height 3 → 2^4 - 1 = 15 nodes.

### Tree Traversals ⭐

| Traversal       | Order               | Use                     |
| --------------- | ------------------- | ----------------------- |
| **Inorder**     | Left → Root → Right | BST gives sorted output |
| **Preorder**    | Root → Left → Right | Copy a tree             |
| **Postorder**   | Left → Right → Root | Delete a tree           |
| **Level Order** | Level by level      | BFS of tree             |

> 🧠 Trick: **In**order = **In** the middle (LRL). **Pre**order = Root **first** (RLL). **Post**order = Root **last** (LLR).

---

## 8. Binary Search Tree (BST) ⭐

- Binary tree with ordering property:
  - **Left subtree** — all values **less than** root
  - **Right subtree** — all values **greater than** root
  - This holds for every node recursively

### BST Operations & Complexity

| Operation | Average  | Worst Case (skewed) |
| --------- | -------- | ------------------- |
| Search    | O(log n) | O(n)                |
| Insert    | O(log n) | O(n)                |
| Delete    | O(log n) | O(n)                |

- Worst case happens when BST is skewed (like a linked list)
- **Inorder traversal of BST always gives sorted (ascending) output** ← MCQ favourite

### BST Deletion Cases

1. **Node is leaf** → simply delete
2. **Node has one child** → replace node with its child
3. **Node has two children** → replace with **inorder successor** (smallest in right subtree) or inorder predecessor

### AVL Tree (general)

- Self-balancing BST
- **Balance factor** = height(left) - height(right)
- Balance factor must be **-1, 0, or 1** for every node
- Rebalanced using **rotations** (LL, RR, LR, RL)
- Guarantees O(log n) for all operations

---

## 9. Searching Algorithms ⭐

### Linear Search

- Check each element one by one
- Works on **unsorted and sorted** arrays
- Time: O(n) | Space: O(1)

### Binary Search

- Works only on **sorted** array
- Divide array in half each time, compare with middle
- Time: O(log n) | Space: O(1) iterative, O(log n) recursive
- **Average comparisons = log2 n** ← MCQ favourite

> 🧠 Trick: Binary Search = sorted array only. Halves the search space each time.

---

## 10. Sorting Algorithms ⭐

### Complexity Table (Most Important for MCQ)

| Algorithm      | Best       | Average    | Worst      | Space    | Stable? |
| -------------- | ---------- | ---------- | ---------- | -------- | ------- |
| Bubble Sort    | O(n)       | O(n²)      | O(n²)      | O(1)     | Yes     |
| Selection Sort | O(n²)      | O(n²)      | O(n²)      | O(1)     | No      |
| Insertion Sort | O(n)       | O(n²)      | O(n²)      | O(1)     | Yes     |
| Merge Sort     | O(n log n) | O(n log n) | O(n log n) | O(n)     | Yes     |
| Quick Sort     | O(n log n) | O(n log n) | O(n²)      | O(log n) | No      |
| Heap Sort      | O(n log n) | O(n log n) | O(n log n) | O(1)     | No      |

> 🧠 Trick: "**M**erge **H**eap **Q**uick" → all O(n log n) average. Quick's worst is O(n²).

### Key Facts (MCQ favourites)

- **Bubble Sort** — repeatedly swaps adjacent elements; easy but slowest
- **Selection Sort** — finds minimum and places it; always O(n²), fewest swaps
- **Insertion Sort** — best for nearly sorted data (O(n) best case)
- **Merge Sort** — uses divide and conquer; always O(n log n); needs extra O(n) space
- **Quick Sort** — uses pivot; worst case O(n²) when already sorted; in practice fastest
- **Heap Sort** — uses heap data structure; always O(n log n); in-place

### Stable vs Unstable Sort

- **Stable** — equal elements maintain original relative order
- Stable: Bubble, Insertion, Merge
- Unstable: Selection, Quick, Heap

> 🧠 Trick: "**B**ig **I**ndians **M**igrate" → Bubble, Insertion, Merge = Stable sorts

---

## 11. Asymptotic Complexity ⭐

### Big O Notation

- Describes **worst-case** time/space as input size grows
- Ignore constants and lower order terms

### Common Complexities (slowest to fastest)

```
O(1) < O(log n) < O(n) < O(n log n) < O(n²) < O(2^n) < O(n!)
```

| Complexity | Name         | Example         |
| ---------- | ------------ | --------------- |
| O(1)       | Constant     | Array access    |
| O(log n)   | Logarithmic  | Binary search   |
| O(n)       | Linear       | Linear search   |
| O(n log n) | Linearithmic | Merge sort      |
| O(n²)      | Quadratic    | Bubble sort     |
| O(2^n)     | Exponential  | Naive Fibonacci |
| O(n!)      | Factorial    | Permutations    |

### Other Notations

- **Big O (O)** — upper bound (worst case)
- **Omega (Ω)** — lower bound (best case)
- **Theta (Θ)** — tight bound (average case, both upper and lower)

> 🧠 Trick: Big O = worst case ceiling. Omega = best case floor. Theta = exact fit.

---

## 12. Algorithm Design Techniques ⭐

### Greedy Algorithm

- Make **locally optimal choice** at each step hoping for global optimum
- Does not always give correct answer (depends on problem)
- Fast — usually O(n log n) or better

**Classic Greedy Problems:**

- **Activity Selection** — select max non-overlapping activities
- **Fractional Knapsack** — take fractions of items (greedy works here)
- **Huffman Coding** — optimal prefix codes for compression
- **Dijkstra's Algorithm** — shortest path (greedy)
- **Prim's / Kruskal's** — Minimum Spanning Tree

> 🧠 Trick: Greedy = "take the best available right now, don't look back"
> Greedy works for Fractional Knapsack but NOT 0/1 Knapsack

### Divide and Conquer ⭐

- **Divide** the problem into smaller subproblems
- **Conquer** each subproblem recursively
- **Combine** results

**Classic D&C Problems:**

- **Merge Sort** — divide array, sort halves, merge
- **Quick Sort** — partition around pivot, sort partitions
- **Binary Search** — divide search space in half
- **Tower of Hanoi**
- **Strassen's Matrix Multiplication**

> 🧠 Trick: D&C = split → solve → combine. Merge Sort is the textbook example.

### Dynamic Programming (general, not in syllabus but common in MCQ)

- Solve subproblems once, store results (memoization/tabulation)
- Used when subproblems overlap
- Examples: 0/1 Knapsack, Fibonacci, LCS, LIS

### Backtracking (general)

- Try all possibilities, undo if wrong
- Examples: N-Queens, Sudoku solver, maze problems

---

## 13. Graph Basics (general OS — not in syllabus but appears in MCQ)

- **Vertex (node)** + **Edge (connection)**
- **Directed** (edges have direction) vs **Undirected**
- **Weighted** (edges have cost) vs **Unweighted**
- **BFS** — uses Queue, level-by-level
- **DFS** — uses Stack (or recursion), depth-first

---

## 14. Key Facts for MCQs ⭐

- Stack = LIFO | Queue = FIFO
- Array access = O(1) | Linked list access = O(n)
- **Inorder traversal of BST = sorted output** ← very common
- Binary Search requires **sorted array**
- Binary Search average comparisons = **log2 n**
- Tower of Hanoi with n disks = **2^n - 1** moves
- Recursive algorithms use **stack** internally
- Non-recursive implementation of recursive algo uses **explicit stack**
- Merge Sort space = O(n) | Quick Sort space = O(log n)
- Quick Sort worst case = O(n²) when array already sorted
- Merge Sort is always O(n log n) — most stable large-input sort
- **Stable sorts**: Bubble, Insertion, Merge
- **Unstable sorts**: Selection, Quick, Heap
- Circular Linked List is used in **Round Robin CPU scheduling**
- Priority Queue is implemented using **Heap**
- AVL tree balance factor must be **-1, 0, or +1**
- Greedy works for **Fractional Knapsack**, NOT **0/1 Knapsack**
- Complete Binary Tree with n nodes has height = **floor(log2 n)**

---

## 15. Practice MCQs

1. Which data structure uses LIFO? → **Stack**
2. Which data structure uses FIFO? → **Queue**
3. Inorder traversal of BST gives? → **Sorted (ascending) output**
4. Tower of Hanoi with 4 disks needs how many moves? → **15 (2^4 - 1)**
5. Binary search works on? → **Sorted array only**
6. Which sorting is stable among these: Quick, Merge, Heap, Selection? → **Merge**
7. Worst case of Quick Sort? → **O(n²)** — when pivot is always smallest/largest
8. Which sorting always takes O(n log n) regardless of input? → **Merge Sort**
9. Non-recursive implementation of recursion uses which DS? → **Stack**
10. Which is faster: array access or linked list access? → **Array — O(1) vs O(n)**
11. Circular linked list is used in? → **Round Robin scheduling**
12. AVL tree balance factor can be? → **-1, 0, or +1**
13. Which algorithm design technique does Merge Sort use? → **Divide and Conquer**
14. Greedy works for which knapsack problem? → **Fractional Knapsack**
15. Which traversal is used to delete a tree? → **Postorder**
16. Which traversal is used to copy a tree? → **Preorder**
17. Priority queue is implemented using? → **Heap**
18. Deque allows insert/delete from? → **Both ends**
19. Selection sort makes minimum number of? → **Swaps**
20. Space complexity of Merge Sort? → **O(n)**

---

_End of DSA Notes | Next: Algorithms (Searching, Sorting, Complexity, Greedy, D&C)_
