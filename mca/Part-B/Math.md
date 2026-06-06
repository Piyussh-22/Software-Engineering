# Mathematics — Notes

## BIT Mesra MCA 2026 | Part B, Section 1

> ⭐ = directly in BIT Mesra syllabus | rest = general knowledge, lower priority

---

## Syllabus Coverage

- Sets, relations, functions ⭐
- Combinatorics: counting ⭐
- Probability and Statistics: uniform, normal, exponential, Poisson, binomial distributions ⭐
- Mean, median, mode, standard deviation ⭐
- Conditional probability and Bayes theorem ⭐

---

## 1. Sets ⭐

- **Set** — well-defined collection of distinct objects
- Denoted by capital letters: A, B, C
- Elements denoted by small letters: a, b, c

### Types of Sets

- **Empty set (∅)** — no elements
- **Singleton set** — exactly one element
- **Finite set** — countable number of elements
- **Infinite set** — uncountable elements (e.g. natural numbers)
- **Universal set (U)** — contains all elements under consideration
- **Subset (A ⊆ B)** — every element of A is in B
- **Power set P(A)** — set of all subsets of A; if |A| = n then |P(A)| = 2^n

### Set Operations

| Operation            | Symbol | Meaning                              |
| -------------------- | ------ | ------------------------------------ |
| Union                | A ∪ B  | Elements in A or B or both           |
| Intersection         | A ∩ B  | Elements in both A and B             |
| Difference           | A - B  | Elements in A but not in B           |
| Complement           | A'     | Elements not in A (in Universal set) |
| Symmetric Difference | A △ B  | Elements in A or B but not both      |

### Key Formulas

- **|A ∪ B| = |A| + |B| - |A ∩ B|** ← most used formula
- **|A ∪ B ∪ C| = |A| + |B| + |C| - |A∩B| - |B∩C| - |A∩C| + |A∩B∩C|**
- If A and B are disjoint (no common elements): |A ∪ B| = |A| + |B|
- |Power set of A| = 2^n where n = |A|

### De Morgan's Laws for Sets

- **(A ∪ B)' = A' ∩ B'**
- **(A ∩ B)' = A' ∪ B'**

> 🧠 Trick: Same as De Morgan's in Boolean algebra — complement of union = intersection of complements

---

## 2. Relations ⭐

- **Relation** from A to B — subset of A × B (Cartesian product)
- **Cartesian product A × B** — all ordered pairs (a, b) where a ∈ A, b ∈ B
- If |A| = m, |B| = n → |A × B| = m × n

### Types of Relations

- **Reflexive** — (a, a) ∈ R for every a ∈ A (every element relates to itself)
- **Symmetric** — if (a, b) ∈ R then (b, a) ∈ R
- **Antisymmetric** — if (a,b) ∈ R and (b,a) ∈ R then a = b
- **Transitive** — if (a,b) ∈ R and (b,c) ∈ R then (a,c) ∈ R
- **Equivalence Relation** — Reflexive + Symmetric + Transitive

> 🧠 Trick: Equivalence = R + S + T (Reflexive, Symmetric, Transitive). Remember "REST"

### Equivalence Classes

- All elements related to each other under equivalence relation form an equivalence class
- Equivalence classes partition the set (no overlap, union = whole set)

---

## 3. Functions ⭐

- **Function f: A → B** — every element of A maps to exactly one element of B
- A = domain, B = codomain
- **Range** = actual set of output values (subset of codomain)

### Types of Functions

- **One-to-One (Injective)** — different inputs give different outputs; no two elements of A map to same element of B
- **Onto (Surjective)** — every element of B is mapped by some element of A (range = codomain)
- **Bijective (One-to-One + Onto)** — perfect pairing; invertible
- **Many-to-One** — multiple inputs can give same output (not injective)

> 🧠 Trick: Injective = no two arrows go to same target. Surjective = every target is hit. Bijective = both.

### Special Functions

- **Identity function** — f(x) = x
- **Constant function** — f(x) = c (same output for all inputs)
- **Inverse function f⁻¹** — exists only if f is bijective

---

## 4. Combinatorics — Counting ⭐

### Basic Counting Principles

- **Addition Rule** — if event A can happen in m ways AND event B in n ways (mutually exclusive): total = m + n
- **Multiplication Rule** — if event A can happen in m ways AND then event B in n ways: total = m × n

> 🧠 Trick: OR → Add. AND → Multiply.

### Permutations (Order matters)

- Arranging r items from n distinct items
- **nPr = n! / (n-r)!**
- Arranging all n items = n!

```
Examples:
5P3 = 5!/(5-3)! = 5!/2! = 60
Arranging 4 people in a line = 4! = 24
```

### Combinations (Order does NOT matter)

- Selecting r items from n distinct items
- **nCr = n! / (r! × (n-r)!)**
- Also written as C(n,r) or (n choose r)

```
Examples:
5C3 = 5!/(3! × 2!) = 10
Choosing 3 students from 5 = 5C3 = 10
```

### Key Combination Identities

- nC0 = 1
- nCn = 1
- nC1 = n
- nCr = nC(n-r) ← very useful
- nCr + nC(r-1) = (n+1)Cr (Pascal's rule)

> 🧠 Trick: Permutation = Arrangement (order matters, like password). Combination = Selection (order doesn't matter, like committee).

### Factorial

- 0! = 1 (by definition)
- 1! = 1
- n! = n × (n-1) × (n-2) × ... × 1

---

## 5. Probability ⭐

### Basic Terms

- **Experiment** — process with uncertain outcome
- **Sample space (S)** — set of all possible outcomes
- **Event** — subset of sample space
- **Probability P(A)** = (Favourable outcomes) / (Total outcomes)

### Basic Rules

- 0 ≤ P(A) ≤ 1
- P(S) = 1 (probability of sample space = 1)
- P(∅) = 0
- P(A') = 1 - P(A) ← complement rule

### Addition Rule

- **P(A ∪ B) = P(A) + P(B) - P(A ∩ B)**
- If A and B are **mutually exclusive**: P(A ∪ B) = P(A) + P(B)

### Multiplication Rule

- If A and B are **independent**: **P(A ∩ B) = P(A) × P(B)**
- If dependent: P(A ∩ B) = P(A) × P(B|A)

### Mutually Exclusive vs Independent

| Property | Mutually Exclusive        | Independent              |
| -------- | ------------------------- | ------------------------ |
| Meaning  | Cannot happen together    | One doesn't affect other |
| P(A ∩ B) | 0                         | P(A) × P(B)              |
| Example  | Head and Tail in one flip | Two separate coin flips  |

> 🧠 Trick: Mutually exclusive = can't both happen. Independent = one doesn't influence other.

---

## 6. Conditional Probability ⭐

- **P(A|B)** = probability of A given B has already occurred
- **P(A|B) = P(A ∩ B) / P(B)** (provided P(B) ≠ 0)

### Total Probability Theorem

- If B1, B2, ..., Bn are mutually exclusive and exhaustive events:
- **P(A) = Σ P(A|Bi) × P(Bi)**
- Used to find overall probability when multiple scenarios exist

```
Example: Two boxes. Box1 has 3 red, 2 blue. Box2 has 1 red, 4 blue.
Pick a box randomly then pick a ball.
P(Red) = P(Red|Box1)×P(Box1) + P(Red|Box2)×P(Box2)
       = (3/5)(1/2) + (1/5)(1/2) = 3/10 + 1/10 = 4/10 = 2/5
```

---

## 7. Bayes Theorem ⭐ (Very Important — directly in syllabus)

### Formula

**P(Bi|A) = P(A|Bi) × P(Bi) / Σ P(A|Bj) × P(Bj)**

In simple form for two events:
**P(B|A) = P(A|B) × P(B) / P(A)**

### Terms

- **P(B)** = Prior probability (before evidence)
- **P(B|A)** = Posterior probability (after seeing evidence A)
- **P(A|B)** = Likelihood

### When to use Bayes Theorem

- When you know conditional probabilities in one direction but want the other direction
- "Given that this result happened, what was the cause?"

### Solved Example

```
A factory has 3 machines: M1 (50% of output), M2 (30%), M3 (20%)
Defect rates: M1=2%, M2=3%, M3=5%
A defective item is found. What is P(it came from M1)?

P(M1) = 0.5, P(M2) = 0.3, P(M3) = 0.2
P(D|M1) = 0.02, P(D|M2) = 0.03, P(D|M3) = 0.05

P(D) = (0.02)(0.5) + (0.03)(0.3) + (0.05)(0.2)
     = 0.01 + 0.009 + 0.01 = 0.029

P(M1|D) = P(D|M1)×P(M1) / P(D) = (0.02×0.5) / 0.029 = 0.01/0.029 ≈ 0.345
```

> 🧠 Trick: Bayes = "reverse conditional probability". You know P(effect|cause), want P(cause|effect).

---

## 8. Probability Distributions ⭐

### Discrete vs Continuous

- **Discrete** — countable outcomes (Binomial, Poisson)
- **Continuous** — any value in a range (Normal, Exponential, Uniform)

---

### Binomial Distribution ⭐

- **n** independent trials, each with probability **p** of success
- X = number of successes
- **P(X = k) = nCk × p^k × (1-p)^(n-k)**
- **Mean (μ) = np**
- **Variance (σ²) = np(1-p) = npq** where q = 1-p
- **SD = √(npq)**

**When to use:** Fixed number of trials, each trial has two outcomes (success/failure), constant p, trials independent

```
Example: Toss a coin 10 times. P(exactly 6 heads)?
n=10, k=6, p=0.5
P(X=6) = 10C6 × (0.5)^6 × (0.5)^4 = 210 × (0.5)^10
```

> 🧠 Trick: Binomial = "Binary outcomes, n trials". Mean = np. Remember npq for variance.

---

### Poisson Distribution ⭐

- Events occurring randomly in a **fixed interval** of time/space
- **P(X = k) = (e^(-λ) × λ^k) / k!**
- **Mean = λ** (lambda = average rate of occurrence)
- **Variance = λ**
- Mean = Variance = λ ← very important MCQ fact

**When to use:** Count of rare events in fixed interval (e.g. calls per hour, accidents per day)

> 🧠 Trick: Poisson = rare events over time/space. Mean = Variance = λ (both equal lambda).

---

### Normal Distribution ⭐

- Bell-shaped, symmetric curve
- Defined by **mean (μ)** and **standard deviation (σ)**
- **Notation: X ~ N(μ, σ²)**
- **Empirical Rule (68-95-99.7 rule):**
  - 68% of data within μ ± σ
  - 95% of data within μ ± 2σ
  - 99.7% of data within μ ± 3σ
- **Standard Normal:** Z = (X - μ) / σ → mean=0, SD=1
- Symmetric: P(X > μ) = P(X < μ) = 0.5

**When to use:** Natural phenomena, heights, weights, errors in measurement

> 🧠 Trick: Normal = bell curve, symmetric. 68-95-99.7 rule. Always standardize using Z = (X-μ)/σ

---

### Uniform Distribution ⭐

- All outcomes equally likely in range [a, b]
- **f(x) = 1/(b-a)** for a ≤ x ≤ b
- **Mean = (a + b) / 2**
- **Variance = (b-a)² / 12**

> 🧠 Trick: Uniform = flat distribution. Mean = midpoint of range.

---

### Exponential Distribution ⭐

- Time between events in a Poisson process
- **f(x) = λe^(-λx)** for x ≥ 0
- **Mean = 1/λ**
- **Variance = 1/λ²**
- **Memoryless property** — P(X > s+t | X > s) = P(X > t)

**When to use:** Time until next event (e.g. time until next phone call, component lifetime)

> 🧠 Trick: Exponential = waiting time between Poisson events. Mean = 1/λ (inverse of rate). Memoryless!

---

### Distribution Summary Table ⭐

| Distribution | Type       | Mean    | Variance  | Use                  |
| ------------ | ---------- | ------- | --------- | -------------------- |
| Binomial     | Discrete   | np      | npq       | n trials, 2 outcomes |
| Poisson      | Discrete   | λ       | λ         | Rare events/interval |
| Normal       | Continuous | μ       | σ²        | Natural phenomena    |
| Uniform      | Continuous | (a+b)/2 | (b-a)²/12 | Equal probability    |
| Exponential  | Continuous | 1/λ     | 1/λ²      | Waiting time         |

> 🧠 Trick: Poisson → Mean = Variance (only distribution where this is true for discrete)

---

## 9. Measures of Central Tendency ⭐

### Mean (Arithmetic Mean)

- **Mean = Sum of all values / Number of values**
- **x̄ = Σx / n**
- Affected by extreme values (outliers)

### Median

- Middle value when data sorted in order
- If n is odd: median = ((n+1)/2)th value
- If n is even: median = average of (n/2)th and (n/2 + 1)th values
- Not affected by outliers

### Mode

- Most frequently occurring value
- A dataset can have no mode, one mode, or multiple modes
- **Unimodal** = one mode | **Bimodal** = two modes | **Multimodal** = many modes

### Relationship (for moderately skewed data)

- **Mode = 3 × Median - 2 × Mean** (empirical formula)

> 🧠 Trick: Mean = sensitive to outliers. Median = middle value, robust. Mode = most frequent.

---

## 10. Measures of Dispersion ⭐

### Range

- **Range = Maximum - Minimum**
- Simple but heavily affected by outliers

### Variance

- Average of squared deviations from mean
- **σ² = Σ(xi - x̄)² / n** (population)
- **s² = Σ(xi - x̄)² / (n-1)** (sample)

### Standard Deviation (SD)

- Square root of variance
- **σ = √(Σ(xi - x̄)² / n)**
- Same unit as original data
- Measures spread around mean

### Coefficient of Variation (CV)

- **CV = (σ / x̄) × 100%**
- Used to compare spread of datasets with different units

> 🧠 Trick: Large SD = data widely spread. Small SD = data clustered around mean.

---

## 11. Key Facts for MCQs ⭐

- |P(A)| = 2^n where n = number of elements
- nCr = nC(n-r) ← very commonly tested
- 0! = 1 (by definition)
- P(A') = 1 - P(A)
- P(A ∪ B) = P(A) + P(B) - P(A ∩ B)
- Independent events: P(A ∩ B) = P(A) × P(B)
- Mutually exclusive: P(A ∩ B) = 0
- **Poisson: Mean = Variance = λ** ← most asked
- **Binomial: Mean = np, Variance = npq**
- **Normal: symmetric, Mean = Median = Mode**
- **Exponential: Mean = 1/λ, memoryless**
- **Uniform: Mean = (a+b)/2**
- In normal distribution: 68% within 1σ, 95% within 2σ, 99.7% within 3σ
- Z-score = (X - μ) / σ
- Bayes theorem = reverse conditional probability
- Equivalence relation = Reflexive + Symmetric + Transitive
- Bijective function = one-to-one + onto (invertible)
- nPr = n!/(n-r)! | nCr = n!/(r!(n-r)!)
- OR → Add probabilities | AND → Multiply probabilities

---

## 12. Practice MCQs

1. |P(A)| for A = {1,2,3} is? → **8 (2^3)**
2. nCr = nC? → **n-r**
3. 0! = ? → **1**
4. P(A') = ? → **1 - P(A)**
5. For independent events P(A ∩ B) = ? → **P(A) × P(B)**
6. For mutually exclusive events P(A ∩ B) = ? → **0**
7. Mean of Poisson distribution? → **λ**
8. Variance of Poisson distribution? → **λ** (same as mean)
9. Mean of Binomial distribution? → **np**
10. Variance of Binomial distribution? → **npq**
11. Mean of Exponential distribution? → **1/λ**
12. Mean of Uniform distribution [a,b]? → **(a+b)/2**
13. In Normal distribution, Mean = Median = ? → **Mode**
14. 68% data lies within? → **μ ± σ (1 standard deviation)**
15. Z-score formula? → **Z = (X - μ) / σ**
16. Bayes theorem is used for? → **Reverse conditional probability**
17. Equivalence relation requires? → **Reflexive + Symmetric + Transitive**
18. 5P2 = ? → **20 (5×4)**
19. 5C2 = ? → **10 (5!/(2!×3!))**
20. Which distribution has mean = variance? → **Poisson**
21. Median is preferred over mean when? → **Data has outliers**
22. nCr + nC(r-1) = ? → **(n+1)Cr** (Pascal's rule)
23. Bijective function is also called? → **One-to-one correspondence**
24. De Morgan's law: (A ∪ B)' = ? → **A' ∩ B'**
25. Exponential distribution has which property? → **Memoryless**

---

_End of Mathematics Notes | Next: Logical Reasoning_
