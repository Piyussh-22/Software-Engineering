# VITMEE MCA — Complete Computer Science Notes

### Based on Syllabus + Real Student Exam Experiences (2018–2023)

---

## EXAM PATTERN QUICK FACTS

- Total: 100 MCQs in 2 hours | No negative marking
- 80 questions = Technical (Computer + Math) | 20 = English
- Computer section dominates: ~60–70 questions from CS
- Math questions: only 4–8 (Probability, P&C, Matrices)
- Level: Moderate — mostly conceptual, some code output questions

## MOST REPEATED TOPICS (from real student experiences)

Based on multiple rankers' accounts:

1. Time Complexity / Big O notation (asked EVERY year)
2. OSI Model layers and protocols (asked EVERY year)
3. Tree traversals and Binary Search Tree (asked EVERY year)
4. Sorting algorithm complexities (asked EVERY year)
5. C code output questions — if/else, for, while, switch (5–8 questions)
6. DBMS — Normalization, Keys, Relational model
7. OS — Scheduling algorithms (FCFS, SJF, Round Robin)
8. Computer Architecture — Flip-flops, Von Neumann (more in recent years)
9. Storage classes in C (auto, extern, register, static)
10. CPU scheduling, semaphores, deadlock

---

# 1. DATA STRUCTURES

## Arrays

- Linear collection of elements of same type stored in contiguous memory (cache friendly).
- Indexing starts from 0.
- Access time: O(1) | Search (unsorted): O(n) | Insertion/Deletion: O(n)
- 2D array stored row-major (in C language) or column-major (in Fortran language). **\*\*\*\***\*\*\***\*\*\*\***
- Binary search works only on sorted arrays. ****\*\*\*\*****

## Stacks

- LIFO — Last In First Out.
- Operations: push(), pop(), peek(), isEmpty() — all O(1).
- Applications: models function calls behavior, recursion, expression evaluation, undo operations. \***\*\*\*\*\*\*\***
- VITMEE CLASSIC Q: "Which data structure is used to evaluate factorial/fibonacci?" → Stack (recursion uses stack internally).

- Expression handling (VERY IMPORTANT):
  - infix = operator between operands → (a + b - c \* d) (human readable)
  - postfix = operator after operands → (3 5 2 \* +) (no brackets, no precedence confusion)
  - infix → postfix conversion uses stack
  - postfix evaluation uses stack \***\*\*\*\*\*\*\***

- Stack can be implemented using array or linked list. \***\*\*\*\*\*\*\***
- Overflow (stack full) and Underflow (stack empty) conditions. \***\*\*\*\*\*\*\***

## Queues

- FIFO — First In First Out.
- Operations: enqueue() (insert), dequeue() (remove) — O(1). **\***
- Types: Simple Queue, Circular Queue (to avoid false overflow in linear queue), Priority Queue, Deque (insert/delete from both ends).
- VITMEE Q: "Which queue is used by medium-level scheduler?" → Multilevel Queue / Ready Queue. **\***
- FIFO = Queue | LIFO = Stack (very commonly asked).
- OS connection = Ready queue → processes waiting for CPU
- Uses = scheduling, BFS traversal, printer queue
- Linear queue problem → space wastage after deletion
- Circular queue → space reuse (wrap-around) **\***
- Condition for full circular queue:
  (rear + 1) % size == front **\***
- Priority queue → removal based on priority (not FIFO) **\***

## Linked Lists

- Dynamic data structure; nodes stored in non-contiguous memory and linked via pointers.
- Types: Singly, Doubly, Circular.
- Singly: Each node has data + next pointer.
- Doubly: Each node has data + next + prev pointer.
- Circular: Last node points to first.
- Access: O(n) | Search: O(n)
- Insertion/Deletion: O(1) if position/node known, O(n) if searching required. \***\*\*\*\*\*\*\***
- No shifting required (advantage over array)
- Extra memory required for pointer storage \***\*\*\*\*\*\*\***
- No direct indexing \***\*\*\*\*\*\*\***

## Trees

- Hierarchical structure. Root, nodes, leaves, edges.
- Key Terms: Height, Depth, Degree, Level.
- Binary Tree: max 2 children per node.
- Full Binary Tree: every node has 0 or 2 children.
- Complete Binary Tree: all levels filled except possibly last (filled left to right).
- Perfect Binary Tree: all internal nodes have 2 children, all leaves at same level.

### Tree Traversals (Very Frequently Asked)

- Inorder: Left → Root → Right (gives sorted output for BST)
- Preorder: Root → Left → Right (used for copying tree)
- Postorder: Left → Right → Root (used for deletion)
- Level Order: BFS using a queue.

Example: Tree with root 1, left child 2, right child 3, 2's children are 4 and 5.

- Inorder: 4 2 5 1 3
- Preorder: 1 2 4 5 3
- Postorder: 4 5 2 3 1

### Binary Search Tree (BST)

- Left child < Parent < Right child.
- Search, Insert, Delete: O(log n) average, O(n) worst (skewed tree).
- Inorder traversal of BST gives sorted sequence.

## Graphs

- Set of vertices (V) and edges (E).
- Directed (digraph) vs Undirected.
- Weighted vs Unweighted.
- Degree: number of edges connected to a vertex.
  - Indegree: edges coming in | Outdegree: edges going out (for directed).
- Representation: Adjacency Matrix (O(V²) space) or Adjacency List (O(V+E) space).
- Connected Graph: path exists between every pair of vertices.

### Graph Traversals

- BFS (Breadth First Search): uses Queue. Finds shortest path in unweighted graph.
- DFS (Depth First Search): uses Stack (or recursion). Used for cycle detection, topological sort.

## Sorting Techniques (Frequently Asked — Know complexities!)

| Algorithm      | Best      | Average   | Worst     | Space   | Stable |
| -------------- | --------- | --------- | --------- | ------- | ------ |
| Bubble Sort    | O(n)      | O(n²)     | O(n²)     | O(1)    | Yes    |
| Selection Sort | O(n²)     | O(n²)     | O(n²)     | O(1)    | No     |
| Insertion Sort | O(n)      | O(n²)     | O(n²)     | O(1)    | Yes    |
| Merge Sort     | O(n logn) | O(n logn) | O(n logn) | O(n)    | Yes    |
| Quick Sort     | O(n logn) | O(n logn) | O(n²)     | O(logn) | No     |
| Heap Sort      | O(n logn) | O(n logn) | O(n logn) | O(1)    | No     |
| Counting Sort  | O(n+k)    | O(n+k)    | O(n+k)    | O(k)    | Yes    |

- Quick Sort worst case: when pivot is always smallest/largest (sorted array).
- Quick Sort best case: pivot always divides array into equal halves.
- Merge Sort: always O(n log n) — preferred for linked lists.

## Searching Techniques

- Linear Search: O(n) — works on unsorted data.
- Binary Search: O(log n) — requires sorted data. Divide and conquer.
  - Mid = (low + high) / 2
- Hashing: O(1) average for search, insert, delete.

---

# 2. ALGORITHMS

## Asymptotic Analysis & Time Complexity (Very Frequently Asked)

### Big O Notations (Order from fastest to slowest):

O(1) < O(log n) < O(n) < O(n log n) < O(n²) < O(2ⁿ) < O(n!)

- O(1): Constant — array access, hash table lookup
- O(log n): Binary search, balanced BST operations
- O(n): Linear search, single loop
- O(n log n): Merge sort, heap sort, quick sort (average)
- O(n²): Bubble, selection, insertion sort; nested loops
- O(2ⁿ): Recursive fibonacci (naive), subset generation

### Rules for complexity:

- Drop constants: O(2n) → O(n)
- Drop lower order terms: O(n² + n) → O(n²)
- Nested loops multiply: outer O(n) × inner O(n) = O(n²)
- Sequential blocks: take the maximum

## Design Techniques

### Greedy Algorithm

- Make locally optimal choice at each step hoping for global optimum.
- Does NOT always give optimal solution.
- Examples:
  - Kruskal's and Prim's algorithm (Minimum Spanning Tree) — Greedy
  - Dijkstra's shortest path — Greedy
  - Activity Selection Problem — Greedy
  - Huffman Coding — Greedy
  - Fractional Knapsack — Greedy (0/1 Knapsack is NOT greedy)

### Dynamic Programming (DP)

- Break problem into overlapping subproblems, solve each once, store results (memoization).
- Key property: Optimal Substructure + Overlapping Subproblems.
- Examples:
  - 0/1 Knapsack
  - Longest Common Subsequence (LCS)
  - Matrix Chain Multiplication
  - Floyd-Warshall (all-pairs shortest path)
  - Fibonacci (DP version): O(n)

### Divide and Conquer

- Divide problem into independent subproblems, solve recursively, combine results.
- No overlapping subproblems (unlike DP).
- Examples:
  - Merge Sort
  - Quick Sort
  - Binary Search
  - Strassen's Matrix Multiplication

## Graph Algorithms

### Connected Components

- Undirected graph: use BFS/DFS to find all connected components.
- Directed graph: Strongly Connected Components (SCC) — Kosaraju's or Tarjan's algorithm.

### Spanning Trees

- A spanning tree of graph G is a subgraph that is a tree and includes ALL vertices.
- Minimum Spanning Tree (MST): spanning tree with minimum total edge weight.
- Kruskal's Algorithm: sort edges by weight, add edge if no cycle (uses Union-Find). Greedy. O(E log E).
- Prim's Algorithm: start from any vertex, greedily add minimum edge. O(V²) or O(E log V) with priority queue.

### Shortest Paths

- Dijkstra's Algorithm: single-source shortest path for graphs with non-negative weights. Greedy. O(V²) or O((V+E) log V).
- Bellman-Ford: single-source, works with negative weights, detects negative cycles. O(VE).
- Floyd-Warshall: all-pairs shortest path. DP. O(V³).

---

# 3. PROGRAMMING IN C

## Data Types & Declarations

- int: typically 4 bytes | char: 1 byte | float: 4 bytes | double: 8 bytes
- long int: 4 or 8 bytes | short int: 2 bytes
- Declaration: int a = 5; float b = 3.14;
- Constants: const int x = 10; or #define MAX 100

## Operators

### Arithmetic: +, -, \*, /, % (modulo)

- Integer division: 7/2 = 3 (not 3.5)

### Relational: ==, !=, <, >, <=, >=

### Logical: && (AND), || (OR), ! (NOT)

### Bitwise (Frequently Asked in VITMEE):

- & (AND), | (OR), ^ (XOR), ~ (NOT/complement), << (left shift), >> (right shift)
- Left shift by n = multiply by 2ⁿ → x << 1 = x \* 2
- Right shift by n = divide by 2ⁿ → x >> 1 = x / 2
- 5 & 3 = 1 (0101 & 0011 = 0001)
- 5 | 3 = 7 (0101 | 0011 = 0111)
- 5 ^ 3 = 6 (0101 ^ 0011 = 0110)

### Assignment: =, +=, -=, \*=, /=, %=

### Conditional (Ternary): condition ? value_if_true : value_if_false

- Example: max = (a > b) ? a : b;

### Operator Precedence (High to Low, simplified):

() → Unary → \* / % → + - → << >> → relational → == != → & → ^ → | → && → || → ?: → = (assignment)

## Control Statements (Code output questions frequently from these!)

### if-else:

```c
int x = 10;
if (x > 5) printf("Yes"); // prints Yes
else printf("No");
```

### switch (TRICKY — watch for missing break!):

```c
int x = 2;
switch(x) {
  case 1: printf("One");  // skipped
  case 2: printf("Two");  // prints Two
  case 3: printf("Three");// prints Three (fall-through without break!)
  default: printf("Def"); // also prints if no break!
}
// Output: TwoThreeDef  ← This was asked in VITMEE!
```

- Without break, execution falls through all subsequent cases.

### Loops:

```c
// for loop
for (int i = 0; i < 3; i++) printf("%d ", i); // 0 1 2

// while loop
int i = 0;
while (i < 3) { printf("%d ", i); i++; } // 0 1 2

// do-while (executes at least once)
int i = 5;
do { printf("%d", i); i++; } while(i < 3); // prints 5 (runs once)
```

## Storage Classes (Frequently Asked!)

- auto: default for local variables. Scope = local. Lifetime = function call.
- register: hint to compiler to store in CPU register. Faster access. Cannot take address (&).
- static: retains value between function calls. Initialized once. Local scope but persistent lifetime.
- extern: declared outside function, accessible across files. Global scope.

```c
void counter() {
    static int count = 0; // not reset each call
    count++;
    printf("%d", count);
}
// calling counter() three times prints: 1 2 3
```

## Input/Output Functions

- printf(): formatted output. printf("%d %f %c", i, f, c);
- scanf(): formatted input. scanf("%d", &x); ← note the & for address
- getchar(), putchar(): single character I/O
- gets(), puts(): string I/O (gets is unsafe, use fgets)
- Format specifiers: %d (int), %f (float), %lf (double), %c (char), %s (string), %x (hex), %o (octal)

## Functions & Recursion

- Function declaration: return_type function_name(parameters);
- Call by Value: copy of argument passed. Changes don't affect original.
- Call by Reference: address (pointer) passed. Changes affect original.
- Recursion: function calling itself. Must have a base case to stop.

Fibonacci with recursion (O(2ⁿ)):

```c
int fib(int n) {
    if (n <= 1) return n;       // base case
    return fib(n-1) + fib(n-2); // recursive case
}
```

Factorial with recursion (O(n)):

```c
int fact(int n) {
    if (n == 0) return 1;   // base case
    return n * fact(n-1);   // recursive case
}
```

- VITMEE Q: "Which data structure is used for recursion?" → Stack.

---

# 4. DATABASE MANAGEMENT SYSTEMS (DBMS)

## DBMS Architecture

- 3-Level Architecture (ANSI/SPARC): External → Conceptual → Internal
  - External (View) Level: how users see data (user views)
  - Conceptual (Logical) Level: overall structure of database (schema)
  - Internal (Physical) Level: how data is physically stored

## Data Independence

- Logical Data Independence: change conceptual schema without affecting external schema.
- Physical Data Independence: change internal schema without affecting conceptual schema.

## ER Model

- Entity: real-world object (e.g., Student, Course).
- Attribute: property of entity (e.g., Name, Age).
  - Types: Simple, Composite, Multi-valued, Derived.
- Key Attribute: uniquely identifies entity (underlined in ER diagram).
- Relationship: association between entities.
- Cardinality: 1:1, 1:N, M:N.
- Weak Entity: cannot be uniquely identified by its own attributes; depends on strong entity.

## Relational Model & Keys (Frequently Asked!)

- Relation = Table | Tuple = Row | Attribute = Column
- Super Key: set of attributes that uniquely identifies a tuple.
- Candidate Key: minimal super key (no redundant attributes).
- Primary Key: chosen candidate key. Must be unique + NOT NULL.
- Foreign Key: attribute in one relation that references primary key of another.
- Alternate Key: candidate keys not chosen as primary key.

## Constraints

- Domain Constraint: value must be from a defined domain.
- Entity Integrity: primary key cannot be NULL.
- Referential Integrity: foreign key must match an existing primary key or be NULL.

## Normalization (Frequently Asked!)

Purpose: eliminate redundancy and anomalies (insertion, update, deletion anomalies).

- 1NF (First Normal Form): No repeating groups; all attributes are atomic.
- 2NF: In 1NF + no partial dependency (non-key attribute fully dependent on entire primary key). Applies when PK is composite.
- 3NF: In 2NF + no transitive dependency (non-key attribute not dependent on another non-key attribute).
- BCNF (Boyce-Codd NF): stricter version of 3NF. For every functional dependency X → Y, X must be a super key.

Functional Dependency (FD): X → Y means Y is functionally determined by X.
Armstrong's Axioms: Reflexivity, Augmentation, Transitivity.

## SQL (Know the basics)

```sql
-- SELECT
SELECT column1, column2 FROM table WHERE condition;

-- ORDER BY
SELECT * FROM Student ORDER BY marks DESC;

-- GROUP BY with HAVING
SELECT dept, COUNT(*) FROM Employee GROUP BY dept HAVING COUNT(*) > 5;

-- JOIN
SELECT s.name, c.course FROM Student s JOIN Course c ON s.sid = c.sid;

-- Aggregate functions
SELECT MAX(salary), MIN(salary), AVG(salary), SUM(salary), COUNT(*) FROM Employee;
```

Types of JOIN: INNER JOIN (matching rows), LEFT JOIN (all left + matching right), RIGHT JOIN, FULL OUTER JOIN, CROSS JOIN.

## Indexing

- Index speeds up data retrieval but slows down insert/update.
- Primary Index: on ordered file, based on primary key.
- Secondary Index: on non-ordering field.
- Dense Index: entry for every record.
- Sparse Index: entry for some records (only for ordered files).
- B+ Tree: most commonly used index structure.

---

# 5. OPERATING SYSTEMS

## Process Management

### Process States:

New → Ready → Running → Waiting/Blocked → Terminated

- New: process being created.
- Ready: waiting for CPU.
- Running: instructions being executed.
- Waiting: waiting for I/O or event.
- Terminated: finished execution.

### Process Control Block (PCB):

Contains: Process ID, Process State, Program Counter, CPU registers, Memory info, I/O info, Scheduling info.
Every process has one PCB. OS manages processes using PCBs.

### Threads

- Thread: lightweight process. Shares code, data, files with other threads of same process.
- Benefits: faster context switch, efficient resource sharing.
- Types: User-level threads (managed by user library) vs Kernel-level threads (managed by OS).

## CPU Scheduling Algorithms (Frequently Asked — may include simple numericals!)

### FCFS (First Come First Served):

- Non-preemptive. Simple. High average waiting time. Convoy effect.

### SJF (Shortest Job First):

- Non-preemptive. Optimal average waiting time. Requires knowing burst time in advance.
- Preemptive version = SRTF (Shortest Remaining Time First).

### Round Robin (RR):

- Preemptive. Fixed time quantum. Fair. Good for time-sharing.
- Smaller quantum → better response time but more context switches.

### Priority Scheduling:

- Lower number = higher priority (convention). Can be preemptive or non-preemptive.
- Problem: Starvation. Solution: Aging (gradually increase priority of waiting processes).

### Multilevel Queue Scheduling:

- Multiple queues with different priorities. Each queue has its own scheduling algorithm.
- VITMEE Q: "Which queue does medium-level scheduler use?" → Ready Queue.

### Key Metrics:

- Throughput: processes completed per unit time.
- Turnaround Time = Completion Time − Arrival Time.
- Waiting Time = Turnaround Time − Burst Time.
- Response Time: time from submission until first response.

## Synchronization & Deadlock

### Critical Section Problem:

Requirements: Mutual Exclusion, Progress, Bounded Waiting.

### Semaphore (Frequently Asked!):

- Binary Semaphore (mutex): values 0 or 1. Used for mutual exclusion.
- Counting Semaphore: integer value. Used for resource counting.
- Operations: wait()/P() and signal()/V().

### Deadlock:

Four necessary conditions (all must hold simultaneously — Coffman conditions):

1. Mutual Exclusion: resource held non-sharable.
2. Hold and Wait: process holds resource and waits for another.
3. No Preemption: resources cannot be forcibly taken.
4. Circular Wait: circular chain of processes waiting.

Deadlock Handling: Prevention, Avoidance (Banker's algorithm), Detection & Recovery, Ignorance.

## Memory Management

### Paging:

- Logical address space divided into fixed-size pages.
- Physical memory divided into frames (same size as pages).
- Page Table maps page number → frame number.
- No external fragmentation. Has internal fragmentation.
- Logical address = page number + page offset.

### Segmentation:

- Logical address space divided into variable-size segments (code, stack, data).
- Segment Table maps segment number → base address + limit.
- No internal fragmentation. Has external fragmentation.

### Virtual Memory:

- Allows execution of processes not entirely in memory.
- Demand Paging: load page only when needed.
- Page Fault: page not in memory; OS loads it from disk.
- Page Replacement Algorithms: FIFO, LRU (Least Recently Used), Optimal.

## File Systems

- File: named collection of related data.
- File Attributes: name, type, size, location, protection, creation date.
- File Operations: create, open, read, write, seek, close, delete.

### File Organization:

- Sequential: records in sequence.
- Direct/Random: direct access using key.
- Indexed Sequential: index maintained for faster access.

### Directory Structures:

- Single-level: all files in one directory. Simple but naming conflicts.
- Two-level: separate directory per user.
- Tree-structured: hierarchical. Most common (like Unix file system).
- Acyclic Graph: allows shared subdirectories/files.

---

# 6. COMPUTER NETWORKS

## OSI Model (VERY Frequently Asked — know all 7 layers!)

| Layer | Number | Name         | Function                              | Protocols/Examples         |
| ----- | ------ | ------------ | ------------------------------------- | -------------------------- |
| 7     | Top    | Application  | User interface, network services      | HTTP, FTP, SMTP, DNS, DHCP |
| 6     |        | Presentation | Data formatting, encryption           | SSL/TLS, JPEG, MPEG        |
| 5     |        | Session      | Establish, manage, terminate sessions | NetBIOS, RPC               |
| 4     |        | Transport    | End-to-end communication, reliability | TCP, UDP                   |
| 3     |        | Network      | Routing, logical addressing           | IP, ICMP, ARP              |
| 2     |        | Data Link    | Framing, error detection, MAC         | Ethernet, PPP, Wi-Fi       |
| 1     | Bottom | Physical     | Bit transmission, hardware            | Cables, hubs, repeaters    |

Memory trick: "All People Seem To Need Data Processing" (Application to Physical)
Or bottom-up: "Please Do Not Throw Sausage Pizza Away"

- VITMEE Q: "Which is NOT an application layer protocol?" → TCP/UDP are transport layer!
- VITMEE Q: "Which is a transport layer protocol?" → TCP, UDP.
- IP Address is at Network Layer (Layer 3).
- MAC Address is at Data Link Layer (Layer 2). MAC = 48 bits (6 bytes).
- VITMEE Q: "Which class of IP address does NOT exist?" → Class F (only A, B, C, D, E exist).

## Internet (TCP/IP) Model — 4 layers:

- Application Layer → Presentation + Session + Application of OSI
- Transport Layer → same as OSI
- Internet Layer → Network layer of OSI
- Network Access Layer → Data Link + Physical of OSI

## Physical Layer

- Deals with raw bit transmission.
- Analog signal: continuous. Digital signal: discrete (0s and 1s).
- Baud Rate: number of signal changes per second (signal rate). Frequently asked!
- Bit Rate: number of bits transmitted per second.
- Bit Rate = Baud Rate × number of bits per signal.
- Sampling (Nyquist theorem): sampling rate must be ≥ 2 × maximum frequency.
- Encoding schemes: NRZ, Manchester, Differential Manchester.

## Data Link Layer

### Error Detection:

- Parity Check: single bit parity (even/odd). Detects single-bit errors.
- CRC (Cyclic Redundancy Check): detects burst errors. Polynomial division.
- Checksum: sum of data segments. Used in TCP/UDP/IP.
- Hamming Code: error correction (not just detection).
- VITMEE Q: "If there are multiple bit errors, which method to use?" → CRC (most powerful).

### Flow Control Protocols (Frequently Asked!):

- Stop and Wait: send one frame, wait for ACK. Efficiency = 1/(1+2a) where a = propagation delay/transmission delay.
- Go-Back-N: sender can send multiple frames (window size N). On error, retransmits from error frame. Window size ≤ 2^n - 1.
- Selective Repeat: only retransmit the errored frame. Window size ≤ 2^(n-1).

## Network Layer

- IP Addressing: IPv4 = 32 bits (4 octets). e.g., 192.168.1.1
- Classes:
  - Class A: 1.0.0.0 to 126.255.255.255 (1st bit = 0). Large networks.
  - Class B: 128.0.0.0 to 191.255.255.255 (first 2 bits = 10).
  - Class C: 192.0.0.0 to 223.255.255.255 (first 3 bits = 110). Small networks.
  - Class D: 224.0.0.0 to 239.255.255.255. Multicast.
  - Class E: 240+ . Reserved/Experimental. (Class F does NOT exist!)
- Subnet Mask: determines network and host portions of IP address.
- Routing: unicast (one destination), multicast (group), broadcast (all).
- Routing algorithms: Distance Vector (Bellman-Ford), Link State (Dijkstra's).

---

# 7. COMPUTER ARCHITECTURE

## Boolean Algebra

- Basic laws: Commutative, Associative, Distributive, Identity (A+0=A, A·1=A), Complement (A+A'=1, A·A'=0), Idempotent (A+A=A, A·A=A), De Morgan's.
- De Morgan's Theorems: (A·B)' = A'+B' and (A+B)' = A'·B'
- SOP (Sum of Products) and POS (Product of Sums) forms.
- K-Map: Karnaugh Map used to simplify boolean expressions.

## Logic Gates

- AND, OR, NOT (basic)
- NAND, NOR (universal gates — any logic circuit can be made with just NAND or just NOR)
- XOR (A⊕B = A'B + AB'), XNOR

## Flip-Flops (More questions appearing in recent VITMEE — 4 questions in 2022!)

- SR Flip-Flop: Set-Reset. Forbidden state when S=R=1.
- JK Flip-Flop: Improved SR. When J=K=1, output toggles. No forbidden state.
- D Flip-Flop: Data/Delay. Output follows input D on clock edge.
- T Flip-Flop: Toggle. When T=1, output toggles. When T=0, holds state.

## Combinational vs Sequential Circuits

- Combinational: output depends only on current input. No memory. (Adders, MUX, Decoders)
- Sequential: output depends on current input + past state. Has memory (flip-flops). (Counters, Registers)

## Computer Arithmetic

- Binary addition, subtraction (2's complement), multiplication.
- 2's complement of a number: invert all bits then add 1.
- 2's complement representation: used for signed integers in computers.
- Overflow: result too large to fit in given number of bits.
- Left shift = multiply by 2. Right shift = divide by 2 (frequently asked in VITMEE!).

## Von Neumann Architecture (Frequently Asked!)

- Concept: program and data stored in same memory.
- Components: CPU (ALU + Control Unit) + Memory + Input/Output.
- ALU: performs arithmetic and logic operations.
- Control Unit: fetches, decodes, executes instructions; controls data flow.
- Registers: PC (Program Counter), MAR (Memory Address Register), MDR (Memory Data Register), IR (Instruction Register), ACC (Accumulator).
- Von Neumann Bottleneck: limited bandwidth between CPU and memory.

## Instruction Formats & Addressing Modes

### Instruction Format parts: Opcode + Operand(s)

### Addressing Modes:

- Immediate: operand is constant value in instruction itself. e.g., MOV A, #5
- Direct: instruction contains address of operand. e.g., MOV A, 200H
- Indirect: instruction contains address of a pointer to operand.
- Register: operand is in a register. e.g., MOV A, B
- Register Indirect: register contains address of operand.
- Indexed: effective address = base address + index register value.
- Relative: effective address = PC + offset (used in branches).

## Memory Organization

- Cache Memory: fastest, smallest, most expensive. Between CPU and RAM.
  - Levels: L1 (fastest, in CPU) > L2 > L3.
  - Locality of Reference: temporal (recently used) and spatial (nearby addresses).
- RAM: volatile, Random Access Memory.
- ROM: non-volatile, Read Only Memory.

## Interrupts & Exceptions

- Interrupt: signal to CPU to temporarily halt current task and handle event.
- Types: Hardware interrupt (from devices) and Software interrupt (from program — e.g., system calls).
- Exception: unexpected internal event (e.g., division by zero, page fault).
- Interrupt Service Routine (ISR): code executed when interrupt occurs.

## Instruction Cycle

- Fetch → Decode → Execute (repeat)

1. Fetch: PC → MAR → memory read → MDR → IR. PC incremented.
2. Decode: Control unit decodes instruction in IR.
3. Execute: ALU performs operation; result stored.

## System Bus

- Address Bus: carries memory address (unidirectional, CPU → memory).
- Data Bus: carries data (bidirectional).
- Control Bus: carries control signals (read/write signals).
- Bus width determines how much data can be transferred at once.

## Assembly Language Basics

- Low-level language using mnemonics.
- MOV: move data. ADD, SUB, MUL, DIV: arithmetic.
- JMP: unconditional jump. JZ/JNZ: jump if zero/not zero.
- PUSH/POP: stack operations.
- Assembler: translates assembly language to machine code.

---

# QUICK REVISION — MOST LIKELY VITMEE QUESTIONS

1. Time complexity of Binary Search → O(log n)
2. Time complexity of Bubble Sort worst case → O(n²)
3. Which sorting always gives O(n log n)? → Merge Sort
4. LIFO data structure → Stack | FIFO → Queue
5. Inorder traversal gives sorted output for → BST
6. Recursive programs internally use → Stack
7. Fibonacci/Factorial computed using → Recursion (Stack internally)
8. Which is not application layer protocol? → TCP (it's Transport layer)
9. TCP vs UDP: TCP is connection-oriented (reliable), UDP is connectionless (faster)
10. MAC address size → 48 bits
11. IP address is at which OSI layer → Network Layer (Layer 3)
12. Class of IP that doesn't exist → Class F
13. Primary key property → Unique + Not Null
14. Which normal form removes transitive dependency → 3NF
15. BCNF vs 3NF: BCNF is stricter
16. Process state: when waiting for I/O → Blocked/Waiting state
17. PCB contains → process state, PC, registers, memory info
18. Deadlock condition: ALL 4 Coffman conditions must hold
19. Which scheduling causes starvation → Priority Scheduling
20. Solution to starvation → Aging
21. Banker's algorithm used for → Deadlock Avoidance
22. Von Neumann: program + data in → same memory
23. JK flip-flop when J=K=1 → Output toggles
24. Universal gate → NAND or NOR
25. Left shift by 1 bit → multiply by 2
26. 2's complement: invert bits then → add 1
27. Storage class with persistent value across calls → static
28. In C, switch without break → fall-through (all subsequent cases execute)
29. Greedy works for → Kruskal, Prim, Dijkstra, Fractional Knapsack
30. 0/1 Knapsack solved by → Dynamic Programming (NOT greedy)
31. MST algorithm → Kruskal's or Prim's
32. All-pairs shortest path algorithm → Floyd-Warshall
33. Single-source shortest path (negative edges ok) → Bellman-Ford
34. Paging: no external fragmentation, has → internal fragmentation
35. Semaphore operations → wait() = P() = decrement | signal() = V() = increment
36. Go-Back-N vs Selective Repeat: SR retransmits → only errored frame
37. CRC detects → burst/multiple bit errors
38. Parity check detects → single bit errors
39. DFS uses → Stack | BFS uses → Queue
40. Compiler vs Interpreter: Compiler translates whole program; Interpreter line by line

---

## STRATEGY FOR LAST 3 DAYS

Day 1: Data Structures + Algorithms + C Programming (code output practice)
Day 2: DBMS + Operating Systems
Day 3: Computer Networks + Computer Architecture + Quick revision of all tables

Since there is NO negative marking — attempt every question. Even guess on uncertain ones.
The exam is 2 hours for 100 questions — that is 72 seconds per question. Do not overthink.

Good luck! You've got this!
