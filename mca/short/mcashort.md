# VITMEE MCA — 2 HOUR EMERGENCY CRAM SHEET

### Read in this exact order. Nothing extra. Just this.

---

# STEP 1 — READ THIS FIRST (30 min)

## 40 Direct Exam Questions — Memorize These

1. Stack = LIFO | Queue = FIFO ✅
2. Recursion internally uses → Stack
3. "Which DS used for factorial/fibonacci?" → Stack

4. Inorder traversal of BST gives → Sorted output
5. BFS uses → Queue | DFS uses → Stack

6. Time complexity of Binary Search → O(log n) ✅
7. Time complexity of Linear Search → O(n)
8. Merge Sort time complexity → Always O(n log n) — best, avg, worst
9. Quick Sort worst case → O(n²) — when input is already sorted
10. Quick Sort average case → O(n log n)
11. Which sorting is always O(n log n)? → Merge Sort
12. Which sort is stable? → Merge Sort, Bubble Sort, Insertion Sort
13. Which sort is NOT stable? → Quick Sort, Selection Sort, Heap Sort
14. Big O order (slow to fast): O(n!) > O(2ⁿ) > O(n²) > O(n log n) > O(n) > O(log n) > O(1)

15. Greedy algorithms: Kruskal, Prim, Dijkstra, Fractional Knapsack
16. Dynamic Programming: 0/1 Knapsack, LCS, Fibonacci (DP version)
17. Divide and Conquer: Merge Sort, Quick Sort, Binary Search
18. MST algorithms → Kruskal's and Prim's (both Greedy)
19. All-pairs shortest path → Floyd-Warshall (DP)
20. Single-source shortest path (negative edges) → Bellman-Ford
21. Single-source shortest path (no negative edges) → Dijkstra

22. TCP = Transport layer (connection-oriented, reliable)
23. UDP = Transport layer (connectionless, faster, no guarantee)
24. HTTP, FTP, SMTP, DNS, DHCP = Application layer (Layer 7)
25. IP = Network layer (Layer 3)
26. MAC address = Data Link layer (Layer 2) = 48 bits
27. IP address = 32 bits (IPv4)
28. Class F IP address → DOES NOT EXIST (only A, B, C, D, E)
29. CRC detects → multiple/burst bit errors
30. Parity check detects → only single bit errors
31. Primary Key → Unique + NOT NULL
32. Foreign Key → references primary key of another table
33. 3NF removes → transitive dependency
34. BCNF is → stricter than 3NF
35. Process waiting for I/O → Blocked/Waiting state
36. Starvation caused by → Priority Scheduling. Solution → Aging
37. Deadlock: ALL 4 Coffman conditions must hold simultaneously
38. Semaphore: wait()/P() = decrement | signal()/V() = increment
39. Von Neumann: program + data stored in → same memory
40. JK flip-flop when J=K=1 → output TOGGLES

---

# STEP 2 — OSI MODEL (20 min)

## Memorize: 7 Layers + Protocol

| Layer # | Name         | Key Protocol/Example  |
| ------- | ------------ | --------------------- |
| 7       | Application  | HTTP, FTP, SMTP, DNS  |
| 6       | Presentation | SSL/TLS, JPEG         |
| 5       | Session      | NetBIOS               |
| 4       | Transport    | TCP, UDP              |
| 3       | Network      | IP, ICMP              |
| 2       | Data Link    | Ethernet, MAC address |
| 1       | Physical     | Cables, hubs          |

Memory trick (top to bottom): "All People Seem To Need Data Processing"
Memory trick (bottom to top): "Please Do Not Throw Sausage Pizza Away"

### Most Asked OSI Questions:

- "Which layer does TCP belong to?" → Transport (Layer 4)
- "Which layer does IP belong to?" → Network (Layer 3)
- "Which layer does MAC address belong to?" → Data Link (Layer 2)
- "HTTP is which layer?" → Application (Layer 7)
- "Which is NOT an application layer protocol?" → TCP (it's transport!)

---

# STEP 3 — SORTING TABLE (20 min)

## Just Memorize This Table

| Algorithm      | Best      | Worst     | Stable |
| -------------- | --------- | --------- | ------ |
| Bubble Sort    | O(n)      | O(n²)     | YES    |
| Selection Sort | O(n²)     | O(n²)     | NO     |
| Insertion Sort | O(n)      | O(n²)     | YES    |
| Merge Sort     | O(n logn) | O(n logn) | YES    |
| Quick Sort     | O(n logn) | O(n²)     | NO     |
| Heap Sort      | O(n logn) | O(n logn) | NO     |

### Key facts to remember:

- Merge Sort ALWAYS O(n log n) — no worst case trap
- Quick Sort WORST = O(n²) — sorted/reverse sorted input
- Insertion Sort BEST = O(n) — nearly sorted input
- Heap Sort = always O(n log n) + in-place (O(1) space)

---

# STEP 4 — C PROGRAMMING TRAPS (20 min)

## These Are Directly Asked as Code Output Questions

### TRAP 1 — Switch without break (CLASSIC VITMEE QUESTION):

```
int x = 2;
switch(x) {
  case 1: printf("One");
  case 2: printf("Two");    ← execution starts here
  case 3: printf("Three");  ← falls through!
  default: printf("Def");   ← falls through!
}
Output: TwoThreeDef
```

Rule: Without break, ALL cases after match execute.

### TRAP 2 — Static variable:

```
void counter() {
    static int count = 0;  ← only initialized once
    count++;
    printf("%d ", count);
}
Call 3 times → Output: 1 2 3   (NOT 1 1 1)
```

Rule: static retains value between function calls.

### TRAP 3 — do-while runs at least once:

```
int i = 10;
do {
    printf("%d", i);
} while(i < 5);
Output: 10   (runs once even though condition is false)
```

### TRAP 4 — Integer division:

```
int a = 7/2;
printf("%d", a);
Output: 3   (NOT 3.5)
```

### TRAP 5 — Bitwise shift:

- x << 1 = x × 2
- x >> 1 = x ÷ 2
- 5 & 3 = 1 (0101 & 0011 = 0001)
- 5 | 3 = 7 (0101 | 0011 = 0111)
- 5 ^ 3 = 6 (0101 ^ 0011 = 0110)

### Storage Classes (1-liner each):

- auto → default local variable, dies after function ends
- static → local but value persists across calls
- register → hint to store in CPU register, cannot use &
- extern → global variable, accessible across files

---

# STEP 5 — DBMS KEYS + NORMALIZATION (10 min)

### Keys:

- Super Key → any set of attributes that uniquely identifies a row
- Candidate Key → minimal super key (no extra attributes)
- Primary Key → chosen candidate key. UNIQUE + NOT NULL
- Foreign Key → points to primary key in another table
- Alternate Key → candidate keys not chosen as primary key

### Normalization (just the rule for each):

- 1NF → all values must be atomic (no lists in a cell)
- 2NF → 1NF + no partial dependency on composite primary key
- 3NF → 2NF + no transitive dependency (A→B→C not allowed if B is non-key)
- BCNF → every determinant must be a super key (stricter than 3NF)

---

# STEP 6 — OS QUICK FACTS (10 min)

### Process States (in order):

New → Ready → Running → Waiting/Blocked → Terminated

### CPU Scheduling — one line each:

- FCFS: first come first served. Simple. High waiting time. Non-preemptive.
- SJF: shortest job runs first. Best average wait time. Non-preemptive.
- Round Robin: time quantum. Fair. Preemptive. Best for time-sharing.
- Priority: lower number = higher priority. Starvation possible.

### Deadlock — 4 Coffman Conditions (ALL must hold):

1. Mutual Exclusion
2. Hold and Wait
3. No Preemption
4. Circular Wait

### Memory:

- Paging → NO external fragmentation, has internal fragmentation
- Segmentation → NO internal fragmentation, has external fragmentation

---

# STEP 7 — ENGLISH (30 min)

## This is 20 FREE MARKS. Do not skip.

### Memo format:

```
MEMORANDUM
To: [Name/Designation]
From: [Your Name]
Date: [Date]
Subject: [Topic]

Body of memo here. Formal, concise, clear.
```

### Minutes format:

- Written in past tense
- Signed at the bottom by secretary/chairman
- Includes: date, attendees, agenda, decisions taken

### Quick grammar rules:

- Subject-verb agreement: "He goes" not "He go"
- Active: "The manager approved the report"
- Passive: "The report was approved by the manager"
- Use simple present for facts, simple past for completed actions

---

# EXAM DAY RULES — READ BEFORE ENTERING HALL

1. NO NEGATIVE MARKING → attempt EVERY single question. Never leave blank.
2. Do English 20 questions FIRST → fastest marks, builds confidence
3. 72 seconds per question → if stuck after 30 sec, best guess and move
4. Code output Q → trace each line with finger on paper, don't guess
5. OSI layer Q → always think "which layer does this protocol/address belong to"
6. If two options look similar → eliminate wrong ones first

---

# FINAL SCORE ESTIMATE IF YOU READ THIS FULLY

- English: 15–18 marks (easy)
- OSI + Networks: 5–6 marks
- Sorting/Complexity: 4–5 marks
- C code output: 4–6 marks
- DBMS keys + normalization: 3–4 marks
- OS concepts: 3–4 marks
- Remaining CS (guess): 5–8 marks

TOTAL ESTIMATE: 39–51 marks minimum
With luck on guesses: 50–60+ marks

That is a valid rank. Go do it. You've got this.
