# Software Engineering — Notes

## BIT Mesra MCA 2026 | Part A, Section 8

> ⭐ = directly in BIT Mesra syllabus | rest = general knowledge, lower priority
> Note: This is the easiest section — pure theory, high scoring, do not skip.

---

## Syllabus Coverage

- SDLC Models: Waterfall, Prototype, Spiral, Evolutionary, Agile ⭐
- Design Concepts ⭐

---

## 1. Introduction to Software Engineering

- **Software Engineering** — systematic approach to development, operation, and maintenance of software
- **Software Crisis** — inability to develop software on time, within budget, and meeting requirements
- **Software** — programs + documentation + data (not just code)

### Software Characteristics

- Software is **developed/engineered**, not manufactured
- Software does **not wear out** (unlike hardware)
- Software is **complex and flexible**
- Maintenance is a major part of software cost

### Software Types

- **System software** — OS, compilers, device drivers
- **Application software** — word processors, browsers
- **Embedded software** — runs on hardware devices (e.g. washing machine controller)
- **Real-time software** — must respond within strict time limits
- **Scientific software** — simulations, calculations

---

## 2. SDLC (Software Development Life Cycle) ⭐

- Structured process for developing software
- Defines phases, activities, and deliverables

### SDLC Phases

1. **Requirement Analysis** — gather and document what system must do (SRS document)
2. **System Design** — architecture, database design, module design
3. **Implementation (Coding)** — actual code writing
4. **Testing** — verify software works as expected
5. **Deployment** — release to users
6. **Maintenance** — fix bugs, add features, adapt to changes

> 🧠 Trick: **R**eal **S**oftware **I**s **T**ested **D**aily **M**eticulously → Requirements, System design, Implementation, Testing, Deployment, Maintenance

### SRS (Software Requirements Specification)

- Document that describes what the software should do
- Contains functional and non-functional requirements
- Does **NOT** contain design solutions
- Baseline for development and testing

### Types of Requirements

- **Functional** — what the system should do (e.g. user can login)
- **Non-functional** — how the system should perform (e.g. response time < 2s, security, reliability)

---

## 3. SDLC Models ⭐

### Waterfall Model ⭐

```
Requirements → Design → Implementation → Testing → Deployment → Maintenance
```

- **Sequential** — one phase must complete before next begins
- **No going back** — changes in later phases are costly
- Each phase has specific deliverables

**Advantages:**

- Simple and easy to understand
- Works well when requirements are **clear and fixed**
- Good documentation

**Disadvantages:**

- Not suitable when requirements **change**
- No working software until late in process
- Testing happens only at end
- **Not suitable for complex or large projects**

> 🧠 Trick: Waterfall = like a waterfall, only flows down. No going back up.

**Best for:** Small projects with well-defined, stable requirements

---

### Prototype Model ⭐

- Build a **working prototype** (preliminary version) first
- Show to client → get feedback → refine → repeat
- Actual system built after requirements are finalized through prototyping

**Types of Prototyping:**

- **Throwaway/Rapid** — prototype discarded after requirements gathered
- **Evolutionary** — prototype evolves into final system
- **Incremental** — build multiple prototypes for different parts

**Advantages:**

- Good when requirements are **unclear**
- Client involvement → fewer surprises
- Reduces risk of requirement mismatch

**Disadvantages:**

- Clients may mistake prototype for final product
- Can lead to **incomplete analysis** (rush to build)
- Costly if too many iterations

> 🧠 Trick: Prototype = build a demo first, get feedback, then build real thing.

**Best for:** Projects where requirements are unclear or user interface is important

---

### Spiral Model ⭐

- Combines **Waterfall + Prototype** with **risk analysis**
- Each loop = one phase of development
- **Risk assessment** done at every iteration (most important feature)
- Proposed by **Barry Boehm**

**Four Quadrants per loop:**

1. **Planning** — determine objectives, alternatives, constraints
2. **Risk Analysis** — identify and resolve risks
3. **Engineering** — develop and test
4. **Evaluation** — review by customer, plan next iteration

**Advantages:**

- Best model for **risk management**
- Suitable for **large, complex, high-risk** projects
- Customer feedback at each iteration
- Can handle changing requirements

**Disadvantages:**

- Complex and expensive
- Requires risk assessment expertise
- Not suitable for small projects

> 🧠 Trick: Spiral = circles + risk analysis every round. "Spiral around risks."

**Best for:** Large, high-risk, complex projects with changing requirements

---

### Evolutionary Model ⭐

- Software built and delivered in **increments/versions**
- Each version adds more functionality
- User uses early version while rest is being developed

**Two types:**

- **Incremental Model** — complete requirements known upfront; build in parts
- **Iterative Model** — requirements not fully known; refine through iterations

**Advantages:**

- Working software delivered early
- Easy to accommodate changes
- User gets usable product quickly

**Disadvantages:**

- Hard to divide system into meaningful increments
- Later increments may require rework of earlier ones

> 🧠 Trick: Evolutionary = keep evolving the product, version by version.

---

### Agile Model ⭐

- **Iterative and incremental** development with **continuous customer involvement**
- Work divided into short cycles called **sprints** (typically 2–4 weeks)
- Welcomes changing requirements even late in development
- Based on **Agile Manifesto (2001)**

**Agile Manifesto Values:**

- Individuals and interactions > processes and tools
- Working software > comprehensive documentation
- Customer collaboration > contract negotiation
- Responding to change > following a plan

**Scrum (most popular Agile framework):**

- **Sprint** — short development cycle (2–4 weeks)
- **Product Backlog** — list of all features to be built
- **Sprint Backlog** — features to be built in current sprint
- **Daily Standup** — short daily meeting (what done, what to do, blockers)
- **Sprint Review** — demo to stakeholders at end of sprint
- **Scrum Master** — facilitates process, removes obstacles
- **Product Owner** — represents customer, maintains backlog

**Advantages:**

- Fast delivery of working software
- Flexible — handles changing requirements well
- Continuous customer involvement
- Early detection of defects

**Disadvantages:**

- Hard to predict total cost and timeline upfront
- Requires highly collaborative team
- Not suitable for very large teams
- Less documentation

> 🧠 Trick: Agile = flexible, fast, customer always involved, short sprints.

**Best for:** Projects with changing requirements, small-to-medium teams, customer-focused products

---

### V-Model (general — not in syllabus but appears in MCQ)

- Extension of Waterfall
- Each development phase has a corresponding **testing phase**
- V shape: left side = development, right side = testing
- **Verification** on left | **Validation** on right
- Testing planned in parallel with development

---

### RAD Model — Rapid Application Development (general)

- Very fast development using **prototyping and reuse**
- Divided into parallel teams working on different components
- Very short development cycle (60–90 days)
- Requires experienced developers and close customer involvement

---

## 4. Model Comparison Table ⭐ (Most Important for MCQ)

| Model        | Requirements    | Risk Handling | Customer Involvement | Best For                       |
| ------------ | --------------- | ------------- | -------------------- | ------------------------------ |
| Waterfall    | Fixed, clear    | Poor          | Minimal              | Small, stable projects         |
| Prototype    | Unclear         | Moderate      | High                 | UI-heavy, unclear requirements |
| Spiral       | Changing        | Excellent     | Moderate             | Large, high-risk projects      |
| Evolutionary | Partially known | Moderate      | Moderate             | Large systems built in parts   |
| Agile        | Changing        | Good          | Very High            | Dynamic, fast-paced projects   |
| V-Model      | Fixed           | Poor          | Minimal              | Safety-critical systems        |

---

## 5. Design Concepts ⭐

### What is Software Design?

- Process of converting requirements into a blueprint for the software
- Bridge between requirements (what) and implementation (how)

### Levels of Design

- **Architectural Design** — overall structure, modules, interactions (high level)
- **Detailed Design** — internal logic of each module (low level)

### Key Design Principles

**Abstraction**

- Hide unnecessary details, show only what is needed
- Types: procedural abstraction (functions), data abstraction (classes)

**Modularity**

- Divide software into smaller, manageable **modules**
- Each module has a specific function
- Easier to develop, test, and maintain

**Cohesion** ⭐

- Measure of how **related** the functions within a single module are
- **High cohesion** = good (module does one thing well)
- Types (best to worst): Functional > Sequential > Communicational > Procedural > Temporal > Logical > Coincidental

> 🧠 Trick: High cohesion = module is focused on ONE job. Like a specialist doctor.

**Coupling** ⭐

- Measure of **interdependence** between modules
- **Low coupling** = good (modules are independent)
- Types (best to worst): Data < Stamp < Control < External < Common < Content

> 🧠 Trick: Low coupling = modules don't depend on each other. Easy to change one without breaking others.

> 🧠 Golden rule: **High cohesion + Low coupling = Good design**

**Information Hiding**

- Internal details of a module hidden from others
- Modules interact only through well-defined interfaces

**Separation of Concerns**

- Different aspects of the program handled by different parts
- E.g. UI code separate from business logic

### Design Patterns (general)

- Reusable solutions to common design problems
- Three categories:
  - **Creational** — how objects are created (e.g. Singleton, Factory)
  - **Structural** — how objects are composed (e.g. Adapter, Decorator)
  - **Behavioral** — how objects interact (e.g. Observer, Strategy)

---

## 6. Software Testing (general but MCQ common)

### Levels of Testing

- **Unit Testing** — test individual functions/modules
- **Integration Testing** — test combined modules
- **System Testing** — test complete system
- **Acceptance Testing** — client validates the system

### Testing Approaches

- **Black Box Testing** — test without knowing internal code; test based on inputs/outputs
  - Also called: Functional testing, Behavioral testing
- **White Box Testing** — test with knowledge of internal code; test logic paths
  - Also called: Structural testing, Glass box testing
- **Grey Box Testing** — partial knowledge of internal structure

### Types of Testing

- **Regression Testing** — retest after changes to ensure nothing broke
- **Load Testing** — test under expected load
- **Stress Testing** — test beyond normal load to find breaking point
- **Smoke Testing** — quick test to check basic functionality works

> 🧠 Trick: Black box = outside view only. White box = see everything inside.

---

## 7. Software Metrics (general)

- **LOC** (Lines of Code) — simplest size measure
- **Function Points** — measure functionality independent of language
- **KLOC** — thousands of lines of code
- **Defect density** — defects per KLOC
- **Cyclomatic complexity** — measures complexity of code (number of independent paths)

---

## 8. Software Maintenance (general)

- Largest phase in software lifecycle (up to 60–70% of total cost)
- Types:
  - **Corrective** — fix bugs
  - **Adaptive** — adapt to new environment (new OS, hardware)
  - **Perfective** — improve performance or add features
  - **Preventive** — restructure to prevent future problems

> 🧠 Trick: **C**orrect **A**dapt **P**erfect **P**revent → CAPP

---

## 9. Key Facts for MCQs ⭐

- **Waterfall** = sequential, no backtracking, fixed requirements
- **Prototype** = best for unclear requirements, show client early
- **Spiral** = best risk management, Barry Boehm, risk analysis every loop
- **Agile** = sprints, continuous customer involvement, Agile Manifesto 2001
- **Scrum sprint** = 2–4 weeks
- **Waterfall** = NOT suitable for changing requirements ← most asked
- **Spiral** = most suitable for large, high-risk projects
- **Prototype** = most suitable when requirements are unclear
- **Agile** = most customer involvement
- SRS does **NOT** contain design solutions
- **High cohesion + Low coupling** = good design
- **Cohesion** = within a module | **Coupling** = between modules
- **Black box** = no knowledge of code | **White box** = full knowledge of code
- Maintenance = largest cost in software lifecycle
- SDLC stands for **Software Development Life Cycle**
- V-Model emphasizes **verification and validation**
- **RAD** = Rapid Application Development (very fast, 60-90 days)
- Agile Manifesto values **working software** over comprehensive documentation
- **Scrum Master** removes obstacles for the team (does NOT manage the team)

---

## 10. Practice MCQs

1. Which model is best when requirements are unclear? → **Prototype Model**
2. Which model does NOT allow going back to previous phase? → **Waterfall Model**
3. Spiral model was proposed by? → **Barry Boehm**
4. Most important feature of Spiral model? → **Risk Analysis**
5. Agile development uses short cycles called? → **Sprints**
6. Sprint duration in Scrum is typically? → **2–4 weeks**
7. SRS document contains design solutions — True or False? → **False**
8. High cohesion means? → Module is **focused on one task**
9. Low coupling means? → Modules are **independent of each other**
10. Good design has? → **High cohesion + Low coupling**
11. Black box testing is also known as? → **Behavioral/Functional testing**
12. White box testing requires? → **Knowledge of internal code**
13. Regression testing is done after? → **Changes/modifications to code**
14. Which is the most expensive phase of software lifecycle? → **Maintenance**
15. Waterfall model is NOT suitable for? → **Changing requirements**
16. Which model is best for large, complex, high-risk projects? → **Spiral Model**
17. SDLC stands for? → **Software Development Life Cycle**
18. V-Model focuses on? → **Verification and Validation**
19. Agile Manifesto was created in which year? → **2001**
20. Scrum Master's role is to? → **Facilitate process and remove obstacles** (not manage team)

---

_End of Software Engineering Notes_

---

## All Notes Summary

| File                         | Section       | Status  |
| ---------------------------- | ------------- | ------- |
| OS_Notes.md                  | Section 5     | ✅ Done |
| DSA_Notes.md                 | Section 3 & 4 | ✅ Done |
| DBMS_Notes.md                | Section 6     | ✅ Done |
| DigitalLogic_COA_Notes.md    | Section 1 & 2 | ✅ Done |
| Networks_Notes.md            | Section 7     | ✅ Done |
| SoftwareEngineering_Notes.md | Section 8     | ✅ Done |
