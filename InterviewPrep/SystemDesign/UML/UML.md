# UML Diagrams

## What is UML and Why

- UML = Unified Modeling Language — a standardized way to visually represent software design
- When you have an app idea, explaining it in a paragraph is confusing — a diagram is faster and clearer
- Used to communicate design to teammates, document systems, and discuss LLD in interviews
- UML is language and technology agnostic — works for any codebase

> **One liner:** UML = visual blueprint of your software that everyone can understand

---

## Types of UML

- 14 total: 7 Structural + 7 Behavioural
- Structural → static structure of the system (classes, components)
- Behavioural → dynamic behavior, how objects interact over time
- 95% of the time only 2 matter:
  - **Class Diagram** — structural
  - **Sequence Diagram** — behavioural

---

## Class Diagram — How to Draw a Class

- A rectangle divided into 3 sections:
  - **Top** — class name (bold, centered)
  - **Middle** — attributes/variables with datatype e.g. `name : String`
  - **Bottom** — methods with return type e.g. `getSpeed() : int`
- Access modifiers prefix: `+` public &nbsp; `-` private &nbsp; `#` protected
- Abstract class → write `«abstract»` on top of the box
- Interface → write `«interface»` on top, only methods (no attributes)
- Concrete class → nothing extra, just the 3 sections

---

## Class Diagram — Relationships

| Type               | Relation       | Notation                 | Example                                          |
| ------------------ | -------------- | ------------------------ | ------------------------------------------------ |
| Inheritance        | is-a           | solid line, hollow arrow | Dog is-a Animal                                  |
| Simple Association | has-a (loose)  | plain arrow              | Arjun has a House                                |
| Aggregation        | has-a (weak)   | hollow diamond           | Room has Chair/Bed (can exist without Room)      |
| Composition        | has-a (strong) | filled diamond           | Chair has Arms/Legs (cannot exist without Chair) |

> **Composition > Aggregation > Association** — strongest to weakest ownership

---

## Class Diagram — Cardinality

- Shows how many instances of one class relate to another
- `1` → exactly one &nbsp; `*` → many &nbsp; `1..*` → one or more
- Example: one Course has many Users (1 to \*) as participants
- Same two classes can have different cardinalities for different relationships
- Always read left to right then right to left to find both sides

---

## Sequence Diagram — What it Shows

- Shows how objects interact with each other **over time** in sequential order
- Class diagram shows structure — sequence diagram shows behavior/flow
- Used to model a specific use case e.g. ATM withdrawal, user login, payment flow

> **One liner:** Sequence diagram = who calls who, in what order, and what comes back

---

## Sequence Diagram — Elements

| Element         | Description                                                                |
| --------------- | -------------------------------------------------------------------------- |
| Actor           | External user/system, shown as stick figure, outside system boundary       |
| Lifeline        | Dashed vertical line below each object, represents its existence over time |
| Activation bar  | Solid rectangle on lifeline, shows when object is actively processing      |
| Sync message    | Solid line, closed arrowhead → sender waits for response                   |
| Async message   | Solid line, open arrowhead → sender fires and moves on, does not wait      |
| Return message  | Dashed line, open arrowhead → response going back to sender                |
| Create message  | Object is created, lifeline starts here                                    |
| Destroy message | Object destroyed, lifeline ends with X (e.g. session logout)               |
| Lost message    | Arrow ends at filled circle → response never received                      |
| Found message   | Arrow starts from filled circle → origin unknown                           |

---

## Sequence Diagram — Combined Fragments

- Used to model control flow inside a sequence diagram
- **alt** — alternative flows, like if/else — only one block executes
- **opt** — optional block, like if with no else — may or may not execute
- **loop** — repeated interaction, like a for/while loop
- Shown as a labeled rectangle drawn over the relevant part of the diagram

---

## ATM Withdrawal — Sequence Diagram Example

- Actor: User → Objects: ATM, BankServer, Account
- User inserts card → ATM sends sync message to BankServer to authenticate
- BankServer checks Account → returns auth result (return message)
- User enters amount → ATM sends sync message to BankServer to check balance
- BankServer checks Account → returns balance
- ATM dispenses cash → sends destroy message (session ends, lifeline closes with X)

---

## UML in Interviews

- In LLD interviews you are expected to draw a class diagram for the system you design
- Show key classes, their attributes/methods, and relationships between them
- Sequence diagram for one core use case shows you understand runtime behavior
- Clarity matters more than covering every detail — focus on the core flow
- On a phone screen with no whiteboard — describe it verbally using the same structure
