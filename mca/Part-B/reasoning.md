# Logical Reasoning — Notes
## BIT Mesra MCA 2026 | Part B, Section 2

> This section is purely practice-based. Notes cover concepts + tricks + solved examples.
> No theory to memorise — understand the pattern, then practice daily.

---

## Syllabus Coverage
- Logical situations and questions based on given facts
- Topics commonly tested: Series, Blood Relations, Direction Sense, Coding-Decoding,
  Syllogisms, Seating Arrangement, Statement-Conclusion, Analogies, Rankings

---

## 1. Number Series

- Find the pattern in a sequence and identify the missing/next term
- Common patterns:
  - **Arithmetic:** add/subtract fixed number → 2, 5, 8, 11, ? (add 3) → **14**
  - **Geometric:** multiply/divide by fixed number → 2, 6, 18, 54, ? (×3) → **162**
  - **Squares:** 1, 4, 9, 16, 25, ? → **36** (n²)
  - **Cubes:** 1, 8, 27, 64, ? → **125** (n³)
  - **Fibonacci-type:** each term = sum of previous two → 1, 1, 2, 3, 5, 8, ? → **13**
  - **Alternating:** two interlaced series → 2, 3, 4, 6, 6, 12, 8, ? → **24**
  - **Difference series:** differences form their own pattern → 2, 3, 5, 8, 12, ? (diff = 1,2,3,4,5) → **17**

> 🧠 Trick: Always find difference between consecutive terms first. If differences have a pattern → use it.

### Solved Example
```
Series: 1, 4, 9, 16, 25, 36, ?
Pattern: 1², 2², 3², 4², 5², 6², 7²
Answer: 49
```

---

## 2. Alphabet Series

- Find missing letter(s) in an alphabetical pattern
- **Alphabet positions:** A=1, B=2, C=3, ... Z=26
- Useful: remember middle = M(13), N(14). Also EJOTY (5,10,15,20,25).

> 🧠 Trick: **EJOTY** → E=5, J=10, O=15, T=20, Y=25. Use as reference points.

### Common Patterns
- Skip fixed letters: A, C, E, G, ? (skip 1) → **I**
- Reverse: Z, X, V, T, ? (skip 1 backward) → **R**
- +3 pattern: A, D, G, J, ? → **M**

### Solved Example
```
Series: A, E, I, M, ?
Positions: 1, 5, 9, 13, ? (add 4 each time)
Answer: Q (position 17)
```

---

## 3. Coding-Decoding

- A word is coded using a rule; find the code or decode it

### Types of Coding

**Letter shifting**
- Each letter shifted by fixed positions
- CAT coded as DBU → each letter +1 → C→D, A→B, T→U

**Reverse alphabet coding**
- A↔Z, B↔Y, C↔X ... (complement: position + reverse position = 27)
- CAT → XZG (C=3→X=24, A=1→Z=26, T=20→G=7)

**Number coding**
- Each letter assigned a number: A=1, B=2 or A=26, B=25 (reverse)
- BALL = 2+1+12+12 = 27

**Symbol/letter substitution**
- Fixed substitution given in question; just apply it

> 🧠 Trick: First identify the pattern using the given example, then apply same rule to find answer.

### Solved Example
```
If MANGO is coded as NBOHP, find code for APPLE
Rule: each letter +1 (M→N, A→B, N→O, G→H, O→P)
APPLE → BQQMF
```

---

## 4. Blood Relations

- Find relationship between people based on given clues

### Key Relations to Remember
| Relation | Meaning |
|---------|---------|
| Father's/Mother's father | Grandfather |
| Father's/Mother's mother | Grandmother |
| Father's brother | Uncle (Paternal) |
| Mother's brother | Maternal Uncle (Mama) |
| Father's/Mother's sister | Aunt |
| Uncle's/Aunt's child | Cousin |
| Husband's/Wife's father | Father-in-law |
| Sibling's child | Nephew (male) / Niece (female) |

### Approach
1. Start from the person you know (usually "I" or a named person)
2. Draw a family tree diagram
3. Trace the relationship step by step

> 🧠 Trick: Always draw a small family tree. Never try to solve blood relation in your head.

### Solved Example
```
"Pointing to a photo, Ravi says, 'She is the daughter of my grandfather's only son'"
- Grandfather's only son = Ravi's father
- Father's daughter = Ravi's sister
Answer: The woman is Ravi's sister
```

### Common Puzzle Type
```
A is B's brother. C is A's mother. D is C's father. E is D's wife.
Q: How is E related to B?
Step 1: A is B's brother → A and B are siblings
Step 2: C is A's mother → C is also B's mother
Step 3: D is C's father → D is B's maternal grandfather
Step 4: E is D's wife → E is B's maternal grandmother
Answer: E is B's grandmother
```

---

## 5. Direction Sense

- Track movement and find final position or distance

### Compass Directions
```
         North
           ↑
West ← — — — — → East
           ↓
         South
```
- Clockwise turns: N → E → S → W → N
- Anti-clockwise: N → W → S → E → N

### Turn Rules
- **Left turn** = anti-clockwise 90°
- **Right turn** = clockwise 90°
- Facing North + Left turn → facing West
- Facing North + Right turn → facing East
- **U-turn** = 180° reversal

> 🧠 Trick: Draw the path on paper step by step. Never solve in head.

### Distance Formula
- For straight-line displacement: use **Pythagoras** (a² + b² = c²)

### Solved Example
```
Start facing North.
Walk 3km North → turn right → walk 4km East → turn right → walk 3km South
Final position?
- Moved 3N, then 4E, then 3S → net N-S = 0, net E-W = 4E
- Distance from start = 4km East
Answer: 4km East of starting point
```

---

## 6. Syllogisms

- Draw logical conclusions from two or more statements

### Types of Statements
- **All A are B** — every element of A is in B
- **Some A are B** — at least one element of A is in B
- **No A are B** — no element of A is in B
- **Some A are not B** — at least one element of A is not in B

### Rules (Venn Diagram approach)
- Draw Venn diagrams for each statement
- Check which conclusions are DEFINITELY true (not possibly true)

### Standard Valid Conclusions
| Premise 1 | Premise 2 | Valid Conclusion |
|-----------|-----------|----------------|
| All A are B | All B are C | All A are C |
| All A are B | Some B are C | Some A may be C (not definite) |
| No A are B | All C are A | No C are B |
| Some A are B | All B are C | Some A are C |

> 🧠 Trick: "Some" is always a weak conclusion. If both premises are positive, conclusion can be positive. If any premise is negative, conclusion must be negative.

### Solved Example
```
Statements:
1. All dogs are animals
2. All animals are living beings

Conclusions:
I. All dogs are living beings → Valid (All A→B, All B→C, so All A→C)
II. Some living beings are dogs → Valid (follows from I, reversing "All dogs")
```

---

## 7. Statement — Conclusion / Assumption / Course of Action

### Statement-Conclusion
- Conclusion must **follow directly** from the statement
- Must not assume extra information
- Must be **definitely true**, not possibly true

> 🧠 Trick: Ask "Does this follow ONLY from what is stated?" If yes → follows. If it needs extra assumption → does not follow.

### Statement-Assumption
- Assumption must be **implicit** (taken for granted in the statement)
- Must be necessary for the statement to make sense

### Statement-Course of Action
- Course of action should be **practical and directly addresses** the problem
- Must be logically connected to the statement

### Solved Example
```
Statement: "The government should open more public schools."
Assumption I: There is shortage of public schools → IMPLICIT (implicit in the suggestion)
Assumption II: Private schools are bad → NOT IMPLICIT (not stated or necessary)
```

---

## 8. Seating Arrangement

- Place people/objects in a row, circle, or table based on clues

### Types
- **Linear** — people in a row (facing same direction or opposite)
- **Circular** — people around a table (facing centre or outward)
- **Double row** — two rows facing each other

### Approach
1. Note total number of people/seats
2. Start with the most definite clue (exact position given)
3. Place known positions first
4. Use process of elimination for rest

> 🧠 Trick: In circular arrangement — "left" and "right" depend on which way they face. If facing centre → left is anti-clockwise, right is clockwise.

### Solved Example
```
5 people A, B, C, D, E in a row.
- B is 3rd from left
- A is immediately to B's right
- D is at one end

Clue 1: _ _ B _ _  → B at position 3
Clue 2: B is at 3, A immediately right → A at 4
Clue 3: D at one end → D at 1 or 5
Remaining: C, D, E for positions 1, 2, 5
If D=1: C and E at 2 and 5 (both valid)
```

---

## 9. Ranking and Order

- Find position of a person in a row/queue

### Key Formula
- **Total = Position from left + Position from right - 1**
- **Position from right = Total - Position from left + 1**

### Solved Example
```
Ravi is 7th from left and 15th from right in a row.
Total = 7 + 15 - 1 = 21
Answer: 21 people in the row
```

---

## 10. Analogies

- Find the relationship between first pair, apply same to second pair
- Format: A : B :: C : ?

### Types
- **Synonym:** Hot : Warm :: Cold : ?  → **Cool**
- **Antonym:** Day : Night :: Black : ? → **White**
- **Part : Whole:** Wheel : Car :: Page : ? → **Book**
- **Worker : Tool:** Doctor : Stethoscope :: Carpenter : ? → **Saw**
- **Animal : Young:** Dog : Puppy :: Cat : ? → **Kitten**
- **Cause : Effect:** Fire : Smoke :: Rain : ? → **Flood**

> 🧠 Trick: Clearly define the relationship in words first, then find the matching option.

---

## 11. Odd One Out / Classification

- Find the item that does NOT belong to the group

### Approach
- Look for the common property shared by most items
- The one that doesn't share that property = odd one out
- Properties can be: category, pattern, number type, letter position, etc.

### Solved Example
```
Options: Apple, Mango, Banana, Carrot
Apple, Mango, Banana = fruits | Carrot = vegetable
Answer: Carrot (odd one out)
```

---

## 12. Clocks and Calendars (general)

### Clocks
- Clock = 360°, 12 hours → each hour = 30°
- Minute hand moves 6° per minute
- Hour hand moves 0.5° per minute
- **Angle between hands = |30H - 5.5M|** (H=hours, M=minutes)
- Hands coincide every 65.5 minutes (approx)
- Hands are opposite (180°) every 32.7 minutes after coinciding

### Calendars
- Odd days concept: each year has 1 odd day (365 = 52 weeks + 1 day), leap year = 2 odd days
- Leap year: divisible by 4; century year divisible by 400
- 100 years = 5 odd days | 200 years = 3 odd days | 300 years = 1 odd day | 400 years = 0 odd days

---

## 13. Key Tips for Reasoning Section

- **Never solve in your head** — always draw diagrams (family tree, direction map, seating chart)
- **Start with most definite clue** in arrangement problems
- For series — find difference between terms first
- For coding — identify the rule from given example before solving
- For syllogisms — draw Venn diagrams; never assume beyond what is stated
- For direction — use compass, note final displacement not total distance
- **Time management** — reasoning questions can be time traps; skip and come back
- No negative marking — attempt all, guess if stuck
- For blood relations — "grandfather's only son" = father; "mother's only daughter" = sister (if female speaker)

---

## 14. Practice Questions (with answers)

1. Series: 2, 6, 12, 20, 30, ? → **42** (differences: 4,6,8,10,12)
2. Series: 1, 1, 2, 3, 5, 8, ? → **13** (Fibonacci)
3. Alphabet: A, C, F, J, O, ? → **U** (gaps: +2,+3,+4,+5,+6)
4. Coding: If CAT=3120, then DOG=? → **4157** (C=3,A=1,T=20 | D=4,O=15,G=7)
5. Blood relation: "A is B's brother. C is A's mother. How is C related to B?" → **Mother**
6. Direction: Walk 5km North, turn left, walk 5km West. Distance from start? → **5√2 km** (Pythagoras: √(5²+5²))
7. Syllogism: All men are mortal. Socrates is a man. Conclusion? → **Socrates is mortal**
8. Ranking: Priya is 8th from left, 12th from right. Total students? → **19** (8+12-1)
9. Analogy: Book : Library :: Money : ? → **Bank**
10. Odd one out: 2, 3, 5, 7, 9, 11 → **9** (not a prime number)
11. Clock angle at 3:00? → **90°**
12. Direction: Facing South, turn right. Now facing? → **West**
13. Series: 100, 96, 89, 79, 66, ? → **50** (differences: 4,7,10,13,16)
14. Coding: If MANGO = NBOHP (each +1), code for GRAPE? → **HSBQF**
15. Blood relation: "She is the daughter of my father's only son." Who is she? → **My daughter** (father's only son = me, my daughter)

---

*End of Logical Reasoning Notes | Next: General English*