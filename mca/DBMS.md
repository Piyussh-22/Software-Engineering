# Database Management System (DBMS) — Notes

## BIT Mesra MCA 2026 | Part A, Section 6

> ⭐ = directly in BIT Mesra syllabus | rest = general knowledge, lower priority

---

## Syllabus Coverage

- ER model ⭐
- Relational model, SQL ⭐
- Integrity constraints, normal forms ⭐
- Transactions and concurrency control ⭐

---

## 1. Introduction to DBMS

- **DBMS** — software to store, retrieve, and manage data in a database
- Advantages over file system:
  - Reduces data redundancy
  - Data consistency and integrity
  - Data sharing and security
  - Concurrent access support
  - Crash recovery

### Three Level Architecture (ANSI/SPARC)

- **External level** — user view (what user sees)
- **Conceptual level** — logical structure of entire database
- **Internal level** — physical storage details

### Data Independence

- **Logical Data Independence** — change conceptual schema without affecting external view
- **Physical Data Independence** — change internal schema without affecting conceptual schema

### Database Languages

- **DDL** (Data Definition Language) — CREATE, ALTER, DROP, TRUNCATE
- **DML** (Data Manipulation Language) — SELECT, INSERT, UPDATE, DELETE
- **DCL** (Data Control Language) — GRANT, REVOKE
- **TCL** (Transaction Control Language) — COMMIT, ROLLBACK, SAVEPOINT

> 🧠 Trick: DDL = structure. DML = data. DCL = access. TCL = transactions.

---

## 2. ER Model ⭐

- **Entity-Relationship Model** — conceptual design of a database
- Used before creating actual tables

### Key Terms

- **Entity** — real-world object (e.g. Student, Employee)
- **Entity Set** — collection of similar entities
- **Attribute** — property of an entity (e.g. name, age)
- **Relationship** — association between entities

### Types of Attributes

- **Simple** — atomic, cannot be divided (e.g. age)
- **Composite** — can be divided into smaller parts (e.g. name → first, last)
- **Single-valued** — one value per entity (e.g. age)
- **Multi-valued** — multiple values (e.g. phone numbers) — shown with double ellipse
- **Derived** — calculated from other attributes (e.g. age from DOB) — shown with dashed ellipse
- **Key attribute** — uniquely identifies entity — shown with underline

### ER Diagram Notation

| Symbol           | Represents             |
| ---------------- | ---------------------- |
| Rectangle        | Entity                 |
| Ellipse          | Attribute              |
| Diamond          | Relationship           |
| Double ellipse   | Multi-valued attribute |
| Dashed ellipse   | Derived attribute      |
| Double rectangle | Weak entity            |

### Types of Relationships (Cardinality)

- **One-to-One (1:1)** — one entity in A related to one in B (e.g. Person — Passport)
- **One-to-Many (1:N)** — one entity in A related to many in B (e.g. Department — Employees)
- **Many-to-One (N:1)** — many in A related to one in B
- **Many-to-Many (M:N)** — many in A related to many in B (e.g. Students — Courses)

### Weak Entity

- Cannot be uniquely identified by its own attributes alone
- Depends on a **strong entity** (owner entity)
- Has a **partial key** (discriminator)
- Shown with **double rectangle**
- Relationship with owner shown with **double diamond**

> 🧠 Trick: Weak entity = no complete key of its own; needs its parent's key to be identified

### Generalization vs Specialization

- **Generalization** — bottom-up: combine entities into one general entity (e.g. Car, Truck → Vehicle)
- **Specialization** — top-down: divide entity into sub-entities (e.g. Employee → Manager, Clerk)

---

## 3. Relational Model ⭐

- Data stored in **tables (relations)**
- Each table has rows (**tuples**) and columns (**attributes**)
- Each row is unique

### Key Terminology

| Term        | Meaning                                      |
| ----------- | -------------------------------------------- |
| Relation    | Table                                        |
| Tuple       | Row / Record                                 |
| Attribute   | Column                                       |
| Domain      | Set of allowed values for an attribute       |
| Degree      | Number of attributes (columns) in a relation |
| Cardinality | Number of tuples (rows) in a relation        |

> 🧠 Trick: Degree = columns. Cardinality = rows. Easy to mix up in MCQ.

### Types of Keys ⭐

- **Super Key** — any set of attributes that uniquely identifies a tuple
- **Candidate Key** — minimal super key (no redundant attributes)
- **Primary Key** — chosen candidate key; cannot be NULL
- **Alternate Key** — candidate keys not chosen as primary key
- **Foreign Key** — attribute in one table that references primary key of another table
- **Composite Key** — key made of more than one attribute

> 🧠 Trick: Super Key ⊇ Candidate Key ⊇ Primary Key (each is a subset of the previous)

### Relational Algebra (general but appears in MCQ)

| Operation         | Symbol    | Meaning                              |
| ----------------- | --------- | ------------------------------------ |
| Select            | σ (sigma) | Filter rows based on condition       |
| Project           | π (pi)    | Select specific columns              |
| Union             | ∪         | Combine rows from two relations      |
| Intersection      | ∩         | Common rows in two relations         |
| Difference        | −         | Rows in first not in second          |
| Cartesian Product | ×         | All combinations of rows             |
| Join              | ⋈         | Combine related rows from two tables |

---

## 4. SQL ⭐

### DDL Commands

```sql
CREATE TABLE Student (id INT PRIMARY KEY, name VARCHAR(50), age INT);
ALTER TABLE Student ADD email VARCHAR(100);
DROP TABLE Student;
TRUNCATE TABLE Student;  -- deletes all rows, keeps structure
```

### DML Commands

```sql
INSERT INTO Student VALUES (1, 'Raj', 21);
SELECT * FROM Student WHERE age > 20;
UPDATE Student SET age = 22 WHERE id = 1;
DELETE FROM Student WHERE id = 1;
```

### SELECT Clauses (order matters)

```sql
SELECT columns
FROM table
WHERE condition
GROUP BY column
HAVING condition      -- filter on groups (like WHERE but for GROUP BY)
ORDER BY column ASC/DESC
```

> 🧠 Trick for clause order: **S**ome **F**riends **W**ork **G**reat **H**aving **O**rder → SELECT, FROM, WHERE, GROUP BY, HAVING, ORDER BY

### Aggregate Functions

- `COUNT()` — number of rows
- `SUM()` — total
- `AVG()` — average
- `MAX()` — maximum value
- `MIN()` — minimum value

> 🧠 Trick: Aggregate functions work on **groups** (used with GROUP BY). WHERE filters before grouping, HAVING filters after grouping.

### Types of JOINs ⭐

| JOIN Type       | Returns                                                     |
| --------------- | ----------------------------------------------------------- |
| INNER JOIN      | Only matching rows from both tables                         |
| LEFT JOIN       | All rows from left + matching from right (NULL if no match) |
| RIGHT JOIN      | All rows from right + matching from left (NULL if no match) |
| FULL OUTER JOIN | All rows from both tables (NULL where no match)             |
| CROSS JOIN      | Cartesian product — all combinations                        |
| SELF JOIN       | Table joined with itself                                    |
| NATURAL JOIN    | Joins on all common column names automatically              |

> 🧠 Trick: INNER = only matches. LEFT = left table boss. RIGHT = right table boss. FULL = everyone included.

### Subqueries

- Query inside another query
- Inner query runs first, result used by outer query

```sql
SELECT name FROM Student WHERE id IN (SELECT student_id FROM Enrolled WHERE course = 'CS101');
```

### Views

- Virtual table based on a SELECT query
- Does not store data physically
- `CREATE VIEW v AS SELECT ...`

### Indexes (general)

- Speed up data retrieval
- `CREATE INDEX idx ON Student(name);`
- Slows down INSERT/UPDATE/DELETE (index must also be updated)

---

## 5. Integrity Constraints ⭐

- Rules to maintain accuracy and consistency of data

| Constraint      | Meaning                                    |
| --------------- | ------------------------------------------ |
| **NOT NULL**    | Attribute cannot have NULL value           |
| **UNIQUE**      | All values in column must be different     |
| **PRIMARY KEY** | NOT NULL + UNIQUE; uniquely identifies row |
| **FOREIGN KEY** | Value must exist in referenced table       |
| **CHECK**       | Value must satisfy a condition             |
| **DEFAULT**     | Assigns default value if none given        |

### Referential Integrity

- Foreign key value must match a primary key in the referenced table OR be NULL
- Ensures no orphan records

### Entity Integrity

- Primary key cannot be NULL
- Every table must have a primary key

---

## 6. Normalization ⭐

- Process of organizing database to reduce **redundancy** and prevent **anomalies**
- Anomalies: insertion anomaly, deletion anomaly, update anomaly

### Normal Forms

**1NF (First Normal Form)**

- Each cell must have **atomic (single) value**
- No repeating groups or arrays
- All entries in a column must be of same type

**2NF (Second Normal Form)**

- Must be in 1NF
- No **partial dependency** — every non-key attribute must depend on the **whole** primary key
- Only relevant when primary key is composite

> 🧠 Trick: 2NF removes partial dependency. Partial = part of key → non-key attribute.

**3NF (Third Normal Form)**

- Must be in 2NF
- No **transitive dependency** — non-key attribute should not depend on another non-key attribute
- Rule: A → B → C is transitive if A is key, B is non-key, C is non-key

> 🧠 Trick: 3NF removes transitive dependency. Non-key → non-key = bad.

**BCNF (Boyce-Codd Normal Form)**

- Stricter than 3NF
- For every functional dependency A → B, A must be a **super key**
- Every 3NF relation may not be in BCNF

**4NF (general)**

- Must be in BCNF
- No **multi-valued dependencies**

### Functional Dependency

- A → B means: if two tuples have same value of A, they must have same value of B
- A **determines** B
- Example: StudentID → StudentName

### Summary of Normal Forms

| Normal Form | Removes                                                |
| ----------- | ------------------------------------------------------ |
| 1NF         | Repeating groups, non-atomic values                    |
| 2NF         | Partial dependencies                                   |
| 3NF         | Transitive dependencies                                |
| BCNF        | All anomalies from FDs; every determinant is super key |
| 4NF         | Multi-valued dependencies                              |

> 🧠 Trick: "**1** atom, **2** partial, **3** transitive, **B**CNF super key" → what each removes

---

## 7. Transactions ⭐

- A **transaction** is a sequence of operations treated as a single unit
- Either all operations succeed or none do

### ACID Properties ⭐ (most asked in MCQ)

- **Atomicity** — all or nothing; if one step fails, entire transaction rolled back
- **Consistency** — database moves from one valid state to another valid state
- **Isolation** — transactions execute as if they are alone; intermediate states not visible to others
- **Durability** — once committed, changes are permanent even after crash

> 🧠 Trick: **A**ll **C**hanges **I**solated **D**urably → Atomicity, Consistency, Isolation, Durability

### Transaction States

```
Active → Partially Committed → Committed
                ↓
             Failed → Aborted (Rolled back)
```

### Operations

- **COMMIT** — save all changes permanently
- **ROLLBACK** — undo all changes since last commit
- **SAVEPOINT** — set a point to rollback to (partial rollback)

---

## 8. Concurrency Control ⭐

### Why Concurrency Control?

- Multiple transactions running simultaneously can cause problems

### Concurrency Problems

- **Lost Update** — two transactions update same data; one update is lost
- **Dirty Read** — transaction reads data written by an uncommitted transaction
- **Non-repeatable Read** — transaction reads same row twice and gets different values
- **Phantom Read** — transaction re-executes query and gets different set of rows (due to insert/delete by another transaction)

### Schedules

- **Serial Schedule** — transactions run one after another (no interleaving); always correct
- **Serializable Schedule** — concurrent schedule that gives same result as some serial schedule; correct
- **Non-serializable** — may cause inconsistency

### Lock-Based Protocols

- **Shared Lock (S)** — for reading; multiple transactions can hold shared lock simultaneously
- **Exclusive Lock (X)** — for writing; only one transaction can hold it; no other lock allowed

### Two-Phase Locking (2PL) ⭐

- **Growing phase** — transaction acquires locks, releases none
- **Shrinking phase** — transaction releases locks, acquires none
- Guarantees **serializability**
- Can cause **deadlock**

> 🧠 Trick: 2PL = first collect all locks, then release all locks. No mixing.

### Timestamp-Based Protocol

- Each transaction gets a timestamp when it starts
- Older timestamp = higher priority
- No locks needed; no deadlock possible
- May cause cascading rollbacks

### Deadlock in Transactions

- Same as OS deadlock — transactions wait for each other's locks
- Handled by: deadlock detection (wait-for graph) or deadlock prevention (timestamps)

---

## 9. Indexing (general but MCQ common)

- Speeds up search queries
- **Primary Index** — on ordered file, key field
- **Secondary Index** — on non-ordering field
- **Clustered Index** — data rows sorted same order as index
- **Non-clustered Index** — index order different from data order
- **B-Tree Index** — balanced tree; supports range queries
- **B+ Tree** — all data in leaf nodes; most commonly used in DBMS

> 🧠 Trick: B+ Tree = all actual data at leaf level. Internal nodes only have keys for navigation.

---

## 10. Key Facts for MCQs ⭐

- Primary key = NOT NULL + UNIQUE
- Foreign key can be NULL (unless constrained)
- Degree = number of columns | Cardinality = number of rows
- TRUNCATE is DDL (cannot rollback in most DBMS) | DELETE is DML (can rollback)
- WHERE filters rows before grouping | HAVING filters after grouping
- **ACID** — Atomicity, Consistency, Isolation, Durability
- 2NF removes **partial dependency** | 3NF removes **transitive dependency**
- BCNF — every determinant must be a super key
- **Dirty read** — reading uncommitted data
- **2PL guarantees serializability** but can cause deadlock
- NATURAL JOIN = join on all common columns automatically
- INNER JOIN = only matching rows
- Multi-valued attribute shown with **double ellipse** in ER diagram
- Weak entity shown with **double rectangle**
- Derived attribute shown with **dashed ellipse**
- Serial schedule is always correct (no concurrency issues)
- B+ Tree is most commonly used index structure in DBMS
- Super Key ⊇ Candidate Key ⊇ Primary Key

---

## 11. Practice MCQs

1. ACID stands for? → **Atomicity, Consistency, Isolation, Durability**
2. Which normal form removes partial dependency? → **2NF**
3. Which normal form removes transitive dependency? → **3NF**
4. Primary key can be NULL? → **No**
5. Foreign key can be NULL? → **Yes**
6. TRUNCATE is which type of SQL command? → **DDL**
7. DELETE is which type of SQL command? → **DML**
8. WHERE vs HAVING — which filters after GROUP BY? → **HAVING**
9. Which JOIN returns only matching rows? → **INNER JOIN**
10. Which JOIN returns all rows from left table? → **LEFT JOIN**
11. Dirty read means? → Reading data written by an **uncommitted** transaction
12. 2PL guarantees? → **Serializability**
13. 2PL can cause? → **Deadlock**
14. Degree of a relation means? → **Number of columns (attributes)**
15. Cardinality of a relation means? → **Number of rows (tuples)**
16. Weak entity is identified by? → Its own **partial key + owner entity's primary key**
17. Multi-valued attribute in ER diagram is shown by? → **Double ellipse**
18. Derived attribute in ER diagram is shown by? → **Dashed ellipse**
19. BCNF rule? → Every determinant must be a **super key**
20. Which index structure is most commonly used in DBMS? → **B+ Tree**
21. ROLLBACK undoes changes up to? → Last **COMMIT** (or SAVEPOINT if specified)
22. Serial schedule is always? → **Correct (consistent)**
23. Lost update problem occurs due to? → **Concurrent writes without proper locking**
24. Natural join joins on? → **All common column names**
25. Generalization is which approach? → **Bottom-up** (specific → general)

---

_End of DBMS Notes | Next: Digital Logic_
