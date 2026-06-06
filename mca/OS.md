# Operating System — Notes

## BIT Mesra MCA 2026 | Part A, Section 5

> Topics marked with ⭐ are directly in BIT Mesra MCA syllabus
> Topics without ⭐ are general OS knowledge (good to know, lower priority)

---

## 1. Introduction to OS ⭐ (background)

- OS is software that manages hardware and provides services to programs
- Acts as interface between user and hardware
- Types: Batch, Time-sharing, Real-time, Distributed, Embedded

**Functions of OS:**

- Process management
- Memory management
- File management
- I/O management
- Security and protection

---

## 2. Processes ⭐

- **Program** = passive (stored on disk)
- **Process** = active (program in execution)
- Each process has its own memory, registers, and state

### Process States

```
New → Ready → Running → Waiting → Terminated
```

- **New** — being created
- **Ready** — waiting for CPU
- **Running** — using CPU right now
- **Waiting** — waiting for I/O or event
- **Terminated** — finished

> 🧠 Trick: **N**aughty **R**abbits **R**un **W**ild **T**oday

### PCB (Process Control Block)

- OS data structure that stores everything about a process
- Contains: PID, state, program counter, registers, memory limits, open files, priority
- Created when process is created, deleted when it terminates

> 🧠 Trick: PCB = process's "ID card" kept by OS

### Context Switch

- Saving state of current process and loading state of next process
- Pure overhead — no useful work done during switch
- More context switches = more overhead

### Types of Processes

- **CPU-bound** — more computation, less I/O (e.g. video encoding)
- **I/O-bound** — more I/O, less computation (e.g. file copy)

---

## 3. Inter-Process Communication (IPC) ⭐

Two main models:

- **Shared Memory** — processes share a memory region. Faster. Less OS involvement.
- **Message Passing** — processes send/receive messages via OS. Safer. Slower.

### IPC Mechanisms

- **Pipes** — one-way, between related (parent-child) processes
- **Named Pipes (FIFO)** — like pipes but between unrelated processes
- **Message Queues** — OS-maintained queue of messages
- **Semaphores** — for synchronization, not data transfer
- **Shared Memory** — fastest IPC mechanism
- **Sockets** — IPC over network

> 🧠 Trick: Shared memory = fastest IPC (no OS in the middle for data transfer)

---

## 4. Concurrency and Synchronization ⭐

### Why Synchronization?

- Multiple processes access shared data simultaneously
- Without control → **race condition** (output depends on execution order)

### Critical Section

- Code segment that accesses shared resources
- Only one process should execute it at a time

**Three requirements for Critical Section solution:**

1. **Mutual Exclusion** — only one process in CS at a time
2. **Progress** — if CS is free and processes want in, one must be allowed
3. **Bounded Waiting** — no process waits forever

> 🧠 Trick: **M**y **P**rogram **B**locks → Mutual Exclusion, Progress, Bounded Waiting

### Semaphores ⭐

- Integer variable for synchronization
- **wait(S) / P(S)** — decrement S; if S < 0, block the process
- **signal(S) / V(S)** — increment S; wake up a blocked process
- **Binary semaphore** (0 or 1) = mutex (used for mutual exclusion)
- **Counting semaphore** — value 0 to N (used for resource counting)

### Mutex vs Semaphore

| Feature   | Mutex                     | Semaphore            |
| --------- | ------------------------- | -------------------- |
| Values    | 0 or 1                    | 0 to N               |
| Ownership | Yes (only owner releases) | No                   |
| Use       | Locking a resource        | Signaling / counting |

### Classic Problems (MCQ favourites)

- **Producer-Consumer** — producer fills buffer, consumer empties it. Semaphores prevent overflow/underflow.
- **Reader-Writer** — multiple readers OK simultaneously, writer needs exclusive access
- **Dining Philosophers** — 5 philosophers, 5 forks. Illustrates deadlock risk.

### Monitors (general OS)

- High-level synchronization construct
- Only one process active inside a monitor at a time
- Used in Java (synchronized keyword)

---

## 5. Deadlock ⭐

### What is Deadlock?

- A set of processes permanently blocked, each waiting for a resource held by another in the set

### Four Necessary Conditions (ALL must hold for deadlock)

1. **Mutual Exclusion** — resource held by only one process
2. **Hold and Wait** — process holds resource and waits for more
3. **No Preemption** — resource cannot be forcibly taken away
4. **Circular Wait** — P1 waits for P2, P2 waits for P3, ..., Pn waits for P1

> 🧠 Trick: **M**y **H**ouse **N**ever **C**hanges → Mutual exclusion, Hold & wait, No preemption, Circular wait

### Deadlock Handling

| Strategy       | Idea                                    | Key Point                          |
| -------------- | --------------------------------------- | ---------------------------------- |
| **Prevention** | Remove one of the 4 conditions          | Wasteful                           |
| **Avoidance**  | Banker's Algorithm — stay in safe state | Need advance info                  |
| **Detection**  | Let it happen, detect using RAG         | Overhead                           |
| **Recovery**   | Kill process or preempt resource        | May lose work                      |
| **Ignorance**  | Do nothing (Ostrich Algorithm)          | Used in most OS like Windows/Linux |

### Banker's Algorithm (Avoidance) ⭐

- OS checks if granting a request keeps system in **safe state**
- **Safe state** = there exists a sequence where all processes can finish
- If safe → grant. If unsafe → make process wait.

> 🧠 Trick: Banker = "Only give loan if I can still pay everyone back"

### Resource Allocation Graph (RAG)

- **Request edge** P → R (process wants resource)
- **Assignment edge** R → P (resource given to process)
- Single instance resources: **cycle = deadlock**
- Multiple instance resources: **cycle = maybe deadlock** (not guaranteed)

---

## 6. CPU Scheduling ⭐

### Key Terms

| Term                  | Formula                    |
| --------------------- | -------------------------- |
| Turnaround Time (TAT) | CT − AT                    |
| Waiting Time (WT)     | TAT − BT                   |
| Response Time         | First CPU time − AT        |
| Throughput            | Processes completed / time |

- AT = Arrival Time, BT = Burst Time, CT = Completion Time

### Scheduling Algorithms

**FCFS (First Come First Served)**

- Non-preemptive
- Execute in order of arrival
- Simple but poor average WT
- **Convoy effect** — short processes stuck behind long ones

**SJF (Shortest Job First)**

- Non-preemptive
- Pick process with shortest BT
- **Optimal — gives minimum average waiting time** ← most asked MCQ fact
- Problem: needs BT in advance, causes **starvation** for long processes

**SRTF (Shortest Remaining Time First)**

- Preemptive version of SJF
- Preempts current process if new arrival has shorter remaining time

**Round Robin (RR)**

- Preemptive, uses **time quantum (TQ)**
- Each process gets TQ time, then sent to end of queue
- Best for **time-sharing systems**
- Best **response time** among all algorithms
- Large TQ → behaves like FCFS
- Small TQ → too many context switches, high overhead

**Priority Scheduling**

- Highest priority process runs first
- Preemptive or non-preemptive
- Causes **starvation** for low priority processes
- Fix: **Aging** — gradually increase priority of waiting processes

**Multilevel Queue (general OS)**

- Ready queue split into multiple queues (foreground, background)
- Each queue has its own scheduling algorithm

**Multilevel Feedback Queue (general OS)**

- Processes can move between queues based on behaviour
- Most flexible, used in modern OS

### Comparison Table

| Algorithm   | Preemptive | Starvation | Best For     |
| ----------- | ---------- | ---------- | ------------ |
| FCFS        | No         | No         | Batch        |
| SJF         | No         | Yes        | Min avg WT   |
| SRTF        | Yes        | Yes        | Min avg WT   |
| Round Robin | Yes        | No         | Time-sharing |
| Priority    | Both       | Yes        | Real-time    |

> 🧠 Trick: SJF = minimum average waiting time. RR = best response time.

---

## 7. I/O Scheduling ⭐

### Disk Scheduling Algorithms

- Goal: minimise disk seek time (moving read/write head)

**FCFS**

- Service requests in order of arrival
- Simple but high seek time

**SSTF (Shortest Seek Time First)**

- Service request closest to current head position
- Better throughput but causes **starvation**

**SCAN (Elevator Algorithm)**

- Head moves in one direction, services all requests, then reverses
- Like an elevator going up then down

**C-SCAN (Circular SCAN)**

- Head moves in one direction only, jumps back to start when it reaches the end
- More uniform wait time than SCAN

**LOOK / C-LOOK**

- Like SCAN/C-SCAN but head only goes as far as last request (doesn't go to end of disk)

> 🧠 Trick: SSTF = greedy (nearest first). SCAN = elevator. C-SCAN = one-direction elevator.

---

## 8. Memory Management ⭐

### Why?

- Multiple processes in memory; OS must allocate, protect, and manage

### Contiguous Allocation

- Fixed Partitioning — fixed blocks; causes **internal fragmentation**
- Dynamic Partitioning — variable blocks; causes **external fragmentation**

### Fragmentation

- **Internal** — allocated memory > required (wasted space inside block)
- **External** — free memory exists but scattered, not contiguous

> 🧠 Trick: Internal = waste inside. External = waste outside (scattered gaps).

### Paging ⭐

- Physical memory → fixed-size **frames**
- Logical memory → same-size **pages**
- OS maintains **page table** to map page → frame
- No external fragmentation
- Internal fragmentation possible (last page may not be full)
- Physical Address = Frame number × Frame size + Offset

### Segmentation ⭐

- Memory divided into **variable-size segments** (code, stack, heap, data)
- Each segment: base address + limit
- Causes **external fragmentation**
- More logical — matches programmer's view of memory

### Paging vs Segmentation

| Feature       | Paging   | Segmentation |
| ------------- | -------- | ------------ |
| Size          | Fixed    | Variable     |
| Fragmentation | Internal | External     |
| User view     | No       | Yes          |

### Memory Allocation Strategies (general OS)

- **First Fit** — allocate first hole that is big enough (fast)
- **Best Fit** — allocate smallest hole that fits (least internal waste, most external fragmentation)
- **Worst Fit** — allocate largest hole (leaves large leftover chunks)

---

## 9. Virtual Memory ⭐

### What is Virtual Memory?

- Allows process to run even if not fully in RAM
- Uses disk as extension of RAM
- Process sees a large virtual address space

### Demand Paging ⭐

- Pages loaded **only when needed**
- **Page fault** — page not in memory → OS loads it from disk
- More page faults = slower performance

### Page Replacement Algorithms ⭐

| Algorithm   | Rule                                    | Note                               |
| ----------- | --------------------------------------- | ---------------------------------- |
| **FIFO**    | Replace oldest page                     | Belady's anomaly occurs            |
| **LRU**     | Replace least recently used             | No Belady's, costly                |
| **Optimal** | Replace page not used longest in future | Best performance, theoretical only |

> 🧠 Trick: FLO = FIFO → LRU → Optimal (increasing efficiency)

### Belady's Anomaly ⭐

- With **FIFO**, adding more frames can **increase** page faults (counterintuitive)
- Does NOT happen with LRU or Optimal

### Thrashing ⭐

- Process spends more time swapping pages than executing
- Happens when too many processes compete for limited frames
- Fix: reduce degree of multiprogramming

---

## 10. File System (general OS)

- File = named collection of related data stored on disk
- **File attributes** — name, type, size, location, permissions, timestamps
- **File operations** — create, read, write, seek, delete, truncate
- **Directory structure** — single-level, two-level, tree, acyclic graph, general graph

### File Allocation Methods

- **Contiguous** — fast access, external fragmentation
- **Linked** — no fragmentation, slow random access
- **Indexed** — index block stores pointers, good random access

### Access Methods

- **Sequential** — read in order
- **Direct (Random)** — read any record directly

---

## 11. Protection and Security (general OS)

- **Protection** — mechanism to control access to resources
- **Security** — defend system from external threats
- **Access Matrix** — rows = domains (users/processes), columns = objects (files/devices)
- **Authentication** — verify who you are (password, biometric)
- **Authorization** — what you are allowed to do

---

## 12. Key Facts for MCQs ⭐

- SJF gives **minimum average waiting time** — most asked
- Round Robin gives **best response time** — most asked
- **Belady's anomaly** = FIFO only
- Cycle in RAG with **single instance** resources = deadlock confirmed
- Cycle in RAG with **multiple instances** = deadlock possible, not confirmed
- **Banker's Algorithm** needs resources and process count known in advance
- **Aging** solves starvation
- **Shared Memory** is fastest IPC
- **Thrashing** → reduce multiprogramming
- Increasing frames in FIFO can **increase** page faults (Belady's)
- Paging → internal fragmentation. Segmentation → external fragmentation
- Context switch has **overhead** (pure waste, no useful work)
- **Spooling** = simultaneous peripheral operations online (e.g. print queue)
- Multiprogramming ≠ Multitasking ≠ Multiprocessing
  - Multiprogramming = multiple programs in memory (CPU utilisation)
  - Multitasking = rapid CPU switching between tasks (responsiveness)
  - Multiprocessing = multiple CPUs

---

## 13. Practice MCQs

1. Which scheduling algorithm gives minimum average waiting time? → **SJF**
2. Which scheduling is best for time-sharing systems? → **Round Robin**
3. Belady's anomaly is associated with? → **FIFO page replacement**
4. All four conditions for deadlock must hold — True or False? → **True**
5. Binary semaphore is also known as? → **Mutex**
6. Fastest IPC mechanism? → **Shared Memory**
7. RR with very large time quantum behaves like? → **FCFS**
8. Paging causes which type of fragmentation? → **Internal**
9. Segmentation causes which type of fragmentation? → **External**
10. Thrashing can be reduced by? → **Reducing degree of multiprogramming**
11. What does PCB store? → PID, state, program counter, registers, memory info
12. Banker's Algorithm is used for? → **Deadlock Avoidance**
13. In RAG, cycle with single instance = ? → **Deadlock**
14. Aging is solution to? → **Starvation**
15. Demand paging loads a page when? → **First referenced (page fault occurs)**
16. Which disk scheduling is called elevator algorithm? → **SCAN**
17. SSTF disk scheduling problem? → **Starvation**
18. Optimal page replacement is theoretical because? → **Future page references unknown**
19. C-SCAN vs SCAN difference? → C-SCAN goes one direction only, more uniform wait
20. Monitor allows how many processes inside at once? → **One**

---

_End of OS Notes | Next: Data Structures & Algorithms_
