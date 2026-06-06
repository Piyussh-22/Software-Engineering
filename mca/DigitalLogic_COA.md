# Digital Logic & Computer Organization and Architecture — Notes

## BIT Mesra MCA 2026 | Part A, Section 1 & 2

> ⭐ = directly in BIT Mesra syllabus | rest = general knowledge, lower priority

---

## Syllabus Coverage

**Section 1 - Digital Logic**

- Boolean algebra ⭐
- Combinational and sequential circuits ⭐
- Number representations and computer arithmetic (fixed and floating point) ⭐

**Section 2 - COA**

- Machine instructions and addressing modes ⭐
- ALU, control unit ⭐
- Instruction pipelining, pipeline hazards ⭐
- Memory hierarchy: cache, main memory, secondary storage ⭐

---

# PART 1 — DIGITAL LOGIC

## 1. Number Systems ⭐

### Types

| System      | Base | Digits Used |
| ----------- | ---- | ----------- |
| Binary      | 2    | 0, 1        |
| Octal       | 8    | 0–7         |
| Decimal     | 10   | 0–9         |
| Hexadecimal | 16   | 0–9, A–F    |

### Conversion Tips

- **Binary → Decimal:** multiply each bit by 2^position (right to left from 0)
- **Decimal → Binary:** divide by 2, collect remainders bottom to top
- **Binary → Octal:** group bits in 3s from right
- **Binary → Hex:** group bits in 4s from right
- **Hex digits:** A=10, B=11, C=12, D=13, E=14, F=15

> 🧠 Trick: Binary to Octal = groups of 3. Binary to Hex = groups of 4.

### Examples

```
(13)₁₀ = (1101)₂ = (15)₈ = (D)₁₆
(255)₁₀ = (11111111)₂ = (FF)₁₆
```

---

## 2. Binary Arithmetic ⭐

### Addition

```
0+0=0 | 0+1=1 | 1+0=1 | 1+1=10 (0 carry 1)
```

### Subtraction using Complements

- **1's Complement** — flip all bits (0→1, 1→0)
- **2's Complement** — 1's complement + 1
- Computers use **2's complement** for subtraction

> 🧠 Trick: 2's complement of a number = flip bits then add 1

```
Example: 2's complement of 0110 (6)
Step 1: flip → 1001
Step 2: +1  → 1010  (which is -6 in 2's complement)
```

### Subtraction using 2's complement

- A - B = A + (2's complement of B)
- If carry out → positive result (discard carry)
- If no carry → negative result (take 2's complement of result)

---

## 3. Fixed and Floating Point Representation ⭐

### Fixed Point

- Decimal point is at a **fixed position**
- Simple but limited range

### Floating Point (IEEE 754)

- Represents very large and very small numbers
- Format: **Sign | Exponent | Mantissa**

| Format           | Sign  | Exponent | Mantissa | Total   |
| ---------------- | ----- | -------- | -------- | ------- |
| Single precision | 1 bit | 8 bits   | 23 bits  | 32 bits |
| Double precision | 1 bit | 11 bits  | 52 bits  | 64 bits |

- **Sign bit:** 0 = positive, 1 = negative
- **Exponent:** stored with bias (bias = 127 for single precision)
- **Mantissa:** fractional part (normalized: 1.mantissa × 2^exp)

> 🧠 Trick: Single = 1-8-23. Double = 1-11-52. "Single has 8 exponent bits"

---

## 4. Boolean Algebra ⭐

### Basic Laws

| Law             | AND form  | OR form  |
| --------------- | --------- | -------- |
| Identity        | A·1 = A   | A+0 = A  |
| Null            | A·0 = 0   | A+1 = 1  |
| Idempotent      | A·A = A   | A+A = A  |
| Complement      | A·A' = 0  | A+A' = 1 |
| Double Negation | (A')' = A | —        |

### Key Theorems

- **Commutative:** A·B = B·A | A+B = B+A
- **Associative:** (A·B)·C = A·(B·C)
- **Distributive:** A·(B+C) = A·B + A·C
- **Absorption:** A + A·B = A | A·(A+B) = A

### De Morgan's Theorem ⭐ (most asked)

- **(A·B)' = A' + B'** — NAND = NOT AND = OR of complements
- **(A+B)' = A'·B'** — NOR = NOT OR = AND of complements

> 🧠 Trick: De Morgan = "break the bar, change the operator"
> Bar over AB → break bar → A' + B' (AND becomes OR)
> Bar over A+B → break bar → A'·B' (OR becomes AND)

---

## 5. Logic Gates ⭐

### Basic Gates

| Gate | Symbol | Operation      | Output 1 when     |
| ---- | ------ | -------------- | ----------------- |
| AND  | A·B    | Multiplication | ALL inputs = 1    |
| OR   | A+B    | Addition       | ANY input = 1     |
| NOT  | A'     | Inversion      | Input = 0         |
| NAND | (A·B)' | NOT AND        | NOT all 1s        |
| NOR  | (A+B)' | NOT OR         | ALL inputs = 0    |
| XOR  | A⊕B    | Exclusive OR   | ODD number of 1s  |
| XNOR | (A⊕B)' | Exclusive NOR  | EVEN number of 1s |

### Universal Gates ⭐

- **NAND** and **NOR** are universal gates
- Any logic function can be built using only NAND or only NOR gates

> 🧠 Trick: NAND and NOR = universal. Any circuit = built with just one of these.

### XOR Key Properties

- A⊕0 = A
- A⊕1 = A' (complement)
- A⊕A = 0
- A⊕A' = 1
- Used in **parity checking** and **adders**

---

## 6. Combinational Circuits ⭐

- Output depends **only on current inputs** (no memory)

### Half Adder

- Adds 2 single bits
- **Sum = A⊕B** | **Carry = A·B**

### Full Adder

- Adds 3 bits (A, B, Carry-in)
- **Sum = A⊕B⊕Cin** | **Carry-out = A·B + Cin·(A⊕B)**

### Multiplexer (MUX)

- **Many inputs → 1 output**
- Select lines choose which input goes to output
- 2^n inputs need n select lines
- Acts as a **universal combinational circuit**

### Demultiplexer (DEMUX)

- **1 input → many outputs**
- Opposite of MUX

### Encoder

- **Many inputs → fewer outputs** (binary code)
- 2^n inputs → n output lines
- Example: 8-to-3 encoder

### Decoder

- **Few inputs → many outputs**
- n input lines → 2^n outputs
- Example: 3-to-8 decoder

### Comparator

- Compares two binary numbers
- Outputs: A>B, A=B, A<B

> 🧠 Trick: MUX = many to one (multiplying channels into one). DEMUX = one to many.

---

## 7. Karnaugh Map (K-Map) ⭐

- Graphical method to simplify Boolean expressions
- Groups of 1s in powers of 2 (1, 2, 4, 8...)
- Larger groups = simpler expression
- **Groups must be rectangular, wrap around edges**
- **SOP (Sum of Products)** — group 1s → simplified AND-OR expression
- **POS (Product of Sums)** — group 0s → simplified OR-AND expression

> 🧠 Trick: K-Map groups must be size 1, 2, 4, 8 only. Never 3, 5, 6, 7.

---

## 8. Sequential Circuits ⭐

- Output depends on **current inputs AND previous state** (has memory)
- Uses **flip-flops** as memory elements

### Flip-Flops ⭐

**SR Flip-Flop (Set-Reset)**
| S | R | Q (next) | Note |
|---|---|---------|------|
| 0 | 0 | Q (no change) | Hold |
| 0 | 1 | 0 | Reset |
| 1 | 0 | 1 | Set |
| 1 | 1 | ? | **Invalid/Forbidden** |

**D Flip-Flop (Data)**

- Q(next) = D
- Whatever D is, output follows
- Eliminates invalid state of SR

**JK Flip-Flop**
| J | K | Q (next) |
|---|---|---------|
| 0 | 0 | Q (no change) |
| 0 | 1 | 0 (reset) |
| 1 | 0 | 1 (set) |
| 1 | 1 | Q' (toggle) |

- Eliminates invalid state by toggling when J=K=1
- Most versatile flip-flop

**T Flip-Flop (Toggle)**

- T=0 → no change | T=1 → toggle (complement Q)
- Special case of JK with J=K=T

> 🧠 Trick: SR has forbidden state. JK fixes it with toggle. D just follows input. T just toggles.

### Registers

- Group of flip-flops storing multiple bits
- **Shift Register** — bits shift left or right each clock cycle
- Used in serial-to-parallel and parallel-to-serial conversion

### Counters

- Sequential circuit that counts clock pulses
- **Synchronous** — all flip-flops triggered simultaneously (faster)
- **Asynchronous (Ripple)** — each FF triggered by previous FF (slower, ripple delay)
- **Up counter** — counts 0,1,2,3...
- **Down counter** — counts in reverse
- **Mod-N counter** — counts from 0 to N-1 then resets

> 🧠 Trick: n flip-flops → 2^n states → Mod-2^n counter by default

---

# PART 2 — COMPUTER ORGANIZATION & ARCHITECTURE

## 9. Basic Computer Structure

### Von Neumann Architecture

- Single memory for both program and data
- Components: **CPU, Memory, I/O devices, Buses**
- **Bottleneck** — CPU and memory share same bus (Von Neumann bottleneck)

### CPU Components

- **ALU** — Arithmetic Logic Unit (does calculations)
- **Control Unit** — directs operations of CPU
- **Registers** — small, fast storage inside CPU
- **Buses** — Data bus, Address bus, Control bus

### Important Registers

| Register | Full Name               | Purpose                           |
| -------- | ----------------------- | --------------------------------- |
| PC       | Program Counter         | Holds address of next instruction |
| IR       | Instruction Register    | Holds current instruction         |
| MAR      | Memory Address Register | Holds address for memory access   |
| MDR      | Memory Data Register    | Holds data to/from memory         |
| ACC      | Accumulator             | Holds result of ALU operations    |
| SP       | Stack Pointer           | Points to top of stack            |

> 🧠 Trick: PC = "what's next". IR = "what's happening now". MAR/MDR = memory interface.

---

## 10. Machine Instructions ⭐

### Instruction Format

```
| Opcode | Operand 1 | Operand 2 |
```

- **Opcode** — operation to perform (ADD, SUB, MOV etc.)
- **Operand** — data or address to operate on

### Instruction Types by Number of Addresses

- **0-address** — operands on stack (stack machine)
- **1-address** — one operand in instruction, other in accumulator
- **2-address** — two operands (most common)
- **3-address** — three operands (result + two sources)

---

## 11. Addressing Modes ⭐

| Mode                     | How address is found                 | Example                                 |
| ------------------------ | ------------------------------------ | --------------------------------------- |
| **Immediate**            | Operand is in the instruction itself | ADD #5 (add 5 directly)                 |
| **Direct**               | Instruction contains memory address  | ADD 2000 (go to address 2000)           |
| **Indirect**             | Instruction has address of address   | ADD @2000 (2000 holds the real address) |
| **Register**             | Operand is in a register             | ADD R1                                  |
| **Register Indirect**    | Register holds the memory address    | ADD (R1)                                |
| **Displacement (Based)** | Address = Base register + offset     | ADD 100(R1)                             |
| **Indexed**              | Address = Index register + constant  | ADD 100(X)                              |
| **Relative**             | Address = PC + offset                | used in branch instructions             |

> 🧠 Trick: Immediate = fastest (no memory access). Indirect = slowest (two memory accesses).

---

## 12. ALU and Control Unit ⭐

### ALU (Arithmetic Logic Unit)

- Performs arithmetic: ADD, SUB, MUL, DIV
- Performs logical: AND, OR, NOT, XOR
- Performs shifts: left shift, right shift
- Has **flags/status bits**: Zero, Carry, Overflow, Sign

### Control Unit (CU)

- Directs and coordinates all CPU operations
- Fetches instruction → decodes → executes (Fetch-Decode-Execute cycle)
- Two types:
  - **Hardwired CU** — uses logic circuits; fast but not flexible
  - **Microprogrammed CU** — uses microprogram (ROM); flexible but slower

### Fetch-Decode-Execute Cycle

```
1. Fetch: PC → MAR → Memory → MDR → IR  (PC++)
2. Decode: IR decoded by Control Unit
3. Execute: ALU performs operation, result stored
```

---

## 13. Instruction Pipelining ⭐

### What is Pipelining?

- Overlapping execution of multiple instructions
- Like an assembly line — different stages of different instructions at same time
- Improves **throughput** (instructions per second), not individual instruction speed

### Pipeline Stages (typical 5-stage)

```
IF → ID → EX → MEM → WB
Instruction Fetch → Instruction Decode → Execute → Memory Access → Write Back
```

### Speedup Formula

```
Speedup = Time without pipeline / Time with pipeline
         = n × k / (k + n - 1)
where n = number of instructions, k = number of stages
```

- For large n: Speedup ≈ k (number of stages)

### Pipeline Hazards ⭐ (very common MCQ)

Situations that prevent next instruction from executing in next clock cycle:

**1. Structural Hazard**

- Two instructions need same hardware resource at same time
- Solution: duplicate hardware or stall

**2. Data Hazard**

- Instruction needs result of previous instruction not yet complete
- Types:
  - **RAW (Read After Write)** — true dependency, most common
  - **WAR (Write After Read)** — anti-dependency
  - **WAW (Write After Write)** — output dependency
- Solutions: **forwarding/bypassing** (pass result directly), **stalling** (insert NOPs)

**3. Control Hazard (Branch Hazard)**

- Branch instruction changes PC; pipeline already fetched wrong instructions
- Solutions: **branch prediction**, **delayed branching**, **flushing pipeline**

> 🧠 Trick: **S**ome **D**ata **C**auses Hazards → Structural, Data, Control

---

## 14. Memory Hierarchy ⭐

### Hierarchy (fastest/smallest to slowest/largest)

```
Registers → Cache → Main Memory (RAM) → Secondary Storage (Disk) → Tertiary (Tape)
```

| Level     | Speed     | Cost     | Size  |
| --------- | --------- | -------- | ----- |
| Registers | Fastest   | Highest  | Bytes |
| Cache     | Very fast | High     | KB–MB |
| RAM       | Moderate  | Moderate | GB    |
| SSD/HDD   | Slow      | Low      | TB    |

> 🧠 Trick: As you go down the hierarchy — slower, cheaper, bigger.

### Cache Memory ⭐

- Small, fast memory between CPU and RAM
- Stores **frequently used data** (principle of locality)
- **Temporal locality** — recently used data will be used again soon
- **Spatial locality** — data near recently used data will be used soon

### Cache Mapping Techniques ⭐

**Direct Mapping**

- Each RAM block maps to exactly one cache line
- Simple, fast, but **conflict misses** (two blocks compete for same cache line)
- Cache line = Memory block address mod Number of cache lines

**Associative Mapping (Fully Associative)**

- Any RAM block can go into any cache line
- Most flexible, fewest misses
- Expensive — must search all cache lines

**Set-Associative Mapping**

- Cache divided into sets; each set has k lines (k-way set associative)
- Block maps to a specific set, but can go in any line within that set
- **Best balance** between direct and fully associative

> 🧠 Trick: Direct = one slot. Fully Associative = any slot. Set Associative = any slot in one set.

### Cache Performance

- **Hit** — data found in cache
- **Miss** — data not in cache; must go to RAM
- **Hit ratio** = Hits / Total accesses
- **Average access time** = Hit ratio × Cache time + (1 - Hit ratio) × RAM time

### Cache Replacement Policies

- **LRU** (Least Recently Used) — replace least recently accessed line
- **FIFO** — replace oldest line
- **Random** — replace random line

### Main Memory (RAM)

- **SRAM** — Static RAM; uses flip-flops; fast; expensive; used in cache
- **DRAM** — Dynamic RAM; uses capacitors; needs refresh; slower; cheap; used in main memory

> 🧠 Trick: SRAM = fast = cache. DRAM = slow = main memory. D for Dull (slower).

### Secondary Storage

- HDD, SSD, CD/DVD
- Non-volatile (data survives power off)
- Much slower than RAM
- Access time = seek time + rotational latency + transfer time (for HDD)

---

## 15. Key Facts for MCQs ⭐

- NAND and NOR are **universal gates**
- XOR = 1 when odd number of inputs are 1
- SR flip-flop invalid state: S=1, R=1
- JK flip-flop eliminates invalid state with **toggle**
- D flip-flop: Q(next) = D (simplest, no invalid state)
- **2's complement** used in computers for subtraction
- De Morgan: (AB)' = A'+B' | (A+B)' = A'·B'
- IEEE 754 single precision: 1 sign + 8 exponent + 23 mantissa = 32 bits
- **Immediate addressing** = fastest (operand in instruction)
- **Indirect addressing** = slowest (two memory accesses)
- Pipeline improves **throughput**, not latency of single instruction
- **RAW** hazard = most common data hazard
- **Control hazard** caused by branch instructions
- Speedup of k-stage pipeline ≈ k (for large number of instructions)
- SRAM = cache | DRAM = main memory
- Cache hit ratio formula: Hit ratio = Hits / Total accesses
- **Direct mapping** = simplest cache | **Set-associative** = best balance
- **Temporal locality** = reuse recent data | **Spatial locality** = use nearby data
- PC register holds **address of next instruction**
- IR register holds **current instruction**
- Hardwired CU = fast. Microprogrammed CU = flexible.
- n flip-flops can store 2^n states
- K-Map groups must be in powers of 2 only (1, 2, 4, 8...)
- MUX = many to one | DEMUX = one to many
- Synchronous counter = all FFs triggered simultaneously (faster)

---

## 16. Practice MCQs

1. Which gates are called universal gates? → **NAND and NOR**
2. De Morgan's law: (A+B)' = ? → **A'·B'**
3. SR flip-flop forbidden state? → **S=1, R=1**
4. Which flip-flop toggles when both inputs are 1? → **JK**
5. D flip-flop output Q(next) = ? → **D**
6. Binary to Hex: group bits in? → **4s**
7. Binary to Octal: group bits in? → **3s**
8. 2's complement of 0101 (5)? → **1011**
9. IEEE 754 single precision total bits? → **32 (1+8+23)**
10. Which addressing mode has operand in the instruction itself? → **Immediate**
11. Which addressing mode requires two memory accesses? → **Indirect**
12. Register that holds address of next instruction? → **Program Counter (PC)**
13. Register that holds current instruction? → **Instruction Register (IR)**
14. Pipelining improves? → **Throughput** (not individual instruction speed)
15. Most common type of data hazard? → **RAW (Read After Write)**
16. Control hazard is caused by? → **Branch instructions**
17. Which cache mapping is most flexible? → **Fully Associative**
18. Which cache mapping has conflict misses? → **Direct Mapping**
19. SRAM vs DRAM — which is used in cache? → **SRAM**
20. Which is faster: SRAM or DRAM? → **SRAM**
21. Speedup of 5-stage pipeline for large n? → **≈ 5**
22. MUX does what? → **Many inputs to one output**
23. XOR output is 1 when? → **Odd number of inputs are 1**
24. K-Map group size must be? → **Power of 2 (1, 2, 4, 8)**
25. Von Neumann bottleneck is due to? → **Shared bus between CPU and memory**

---

_End of Digital Logic & COA Notes | Next: Computer Networks_
