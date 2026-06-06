# Computer Networks — Notes

## BIT Mesra MCA 2026 | Part A, Section 7

> ⭐ = directly in BIT Mesra syllabus | rest = general knowledge, lower priority

---

## Syllabus Coverage

- OSI and TCP/IP protocol stacks ⭐
- Circuit and packet switching ⭐
- Framing ⭐
- IP addressing, IPv4 ⭐
- Flow control, error control ⭐

---

## 1. Introduction

- **Network** — two or more devices connected to share resources
- **Protocol** — set of rules for communication between devices
- **Bandwidth** — amount of data transmitted per unit time (bps)
- **Latency** — delay from source to destination

### Types of Networks

| Type | Range           | Example          |
| ---- | --------------- | ---------------- |
| PAN  | Personal area   | Bluetooth        |
| LAN  | Building/campus | Ethernet, Wi-Fi  |
| MAN  | City            | Cable TV network |
| WAN  | Country/global  | Internet         |

---

## 2. OSI Model ⭐

- **7-layer model** for network communication
- Each layer has specific function and communicates with adjacent layers

### OSI Layers (top to bottom)

| Layer | Number       | Name         | Function                                         | Data Unit | Devices        |
| ----- | ------------ | ------------ | ------------------------------------------------ | --------- | -------------- |
| 7     | Application  | Application  | User interface, services (HTTP, FTP, SMTP)       | Data      | —              |
| 6     | Presentation | Presentation | Encryption, compression, translation             | Data      | —              |
| 5     | Session      | Session      | Establish, manage, terminate sessions            | Data      | —              |
| 4     | Transport    | Transport    | End-to-end delivery, flow control, error control | Segment   | —              |
| 3     | Network      | Network      | Routing, logical addressing (IP)                 | Packet    | Router         |
| 2     | Data Link    | Data Link    | Framing, error detection, MAC addressing         | Frame     | Switch, Bridge |
| 1     | Physical     | Physical     | Bits over physical medium, signals               | Bits      | Hub, Repeater  |

> 🧠 Trick (top to bottom): **A**ll **P**eople **S**eem **T**o **N**eed **D**ata **P**rocessing
> Application, Presentation, Session, Transport, Network, Data Link, Physical

> 🧠 Trick (bottom to top): **P**lease **D**o **N**ot **T**hrow **S**ausage **P**izza **A**way

### Key Layer Functions (MCQ favourites)

- **Physical** — bits, cables, signals, transmission rate
- **Data Link** — framing, error detection (CRC), flow control, MAC address
- **Network** — routing, IP addressing, packet forwarding
- **Transport** — TCP/UDP, port numbers, end-to-end reliability, flow control
- **Session** — synchronization, dialog control
- **Presentation** — encryption/decryption, compression, encoding (ASCII, JPEG)
- **Application** — HTTP, FTP, SMTP, DNS, Telnet

### Devices and their OSI Layers

| Device          | OSI Layer              |
| --------------- | ---------------------- |
| Hub / Repeater  | Physical (Layer 1)     |
| Switch / Bridge | Data Link (Layer 2)    |
| Router          | Network (Layer 3)      |
| Gateway         | All layers (Layer 4–7) |

> 🧠 Trick: Hub=L1, Switch=L2, Router=L3. "**H**appy **S**tudents **R**ead" → Hub, Switch, Router

---

## 3. TCP/IP Model ⭐

- **4-layer model** (practical model used in internet)
- Simpler than OSI

| TCP/IP Layer   | OSI Equivalent                       | Protocols                    |
| -------------- | ------------------------------------ | ---------------------------- |
| Application    | Application + Presentation + Session | HTTP, FTP, SMTP, DNS, Telnet |
| Transport      | Transport                            | TCP, UDP                     |
| Internet       | Network                              | IP, ICMP, ARP                |
| Network Access | Data Link + Physical                 | Ethernet, Wi-Fi              |

### OSI vs TCP/IP

| Feature            | OSI                   | TCP/IP                       |
| ------------------ | --------------------- | ---------------------------- |
| Layers             | 7                     | 4                            |
| Developed by       | ISO                   | DARPA                        |
| Model type         | Reference/theoretical | Practical/implemented        |
| Session layer      | Yes                   | No (merged into Application) |
| Presentation layer | Yes                   | No (merged into Application) |

> 🧠 Trick: TCP/IP has NO separate Session or Presentation layers — both merged into Application layer.

---

## 4. Switching ⭐

### Circuit Switching

- **Dedicated path** established before communication
- Path reserved for entire duration of connection
- Example: traditional telephone network
- **Pros:** guaranteed bandwidth, no delay once connected
- **Cons:** wasteful (path reserved even when idle), setup time needed

### Packet Switching

- Data divided into **packets**, each routed independently
- No dedicated path — packets may take different routes
- Example: Internet
- **Pros:** efficient use of bandwidth, no setup needed
- **Cons:** variable delay, packets may arrive out of order

### Types of Packet Switching

- **Datagram** — each packet routed independently (connectionless) → used in Internet (IP)
- **Virtual Circuit** — path established before data transfer but not dedicated (connection-oriented) → used in ATM

> 🧠 Trick: Circuit = dedicated line like a private road. Packet = shared highway, each car finds its own route.

### Message Switching (general)

- Entire message stored at intermediate node then forwarded
- Store-and-forward
- Not used for real-time communication

---

## 5. Framing ⭐

- **Framing** — dividing bitstream into frames at Data Link layer
- Receiver needs to know where each frame starts and ends

### Framing Methods

**Character Count**

- First field in frame contains number of characters in frame
- Problem: if count corrupted, sync is lost

**Flag Bytes with Byte Stuffing**

- Special flag byte marks start/end of frame
- If flag byte appears in data → insert escape byte before it (byte stuffing)

**Bit Stuffing**

- Flag pattern: **01111110** (six 1s between two 0s)
- If five consecutive 1s appear in data → insert a 0 after them
- Receiver removes inserted 0s

**Physical Layer Coding Violations**

- Use signal patterns not used in normal encoding to mark frame boundaries

> 🧠 Trick: Bit stuffing rule — after 5 consecutive 1s, stuff a 0. Remove at receiver.

---

## 6. IP Addressing — IPv4 ⭐

- **IPv4** — 32-bit address (4 bytes)
- Written as 4 decimal numbers separated by dots: **192.168.1.1**
- Total addresses: 2^32 = ~4.3 billion

### IPv4 Address Classes

| Class | First Octet Range | Default Subnet Mask | Networks     | Hosts per Network |
| ----- | ----------------- | ------------------- | ------------ | ----------------- |
| A     | 1 – 126           | 255.0.0.0 (/8)      | 126          | ~16 million       |
| B     | 128 – 191         | 255.255.0.0 (/16)   | 16,384       | ~65,000           |
| C     | 192 – 223         | 255.255.255.0 (/24) | ~2 million   | 254               |
| D     | 224 – 239         | —                   | Multicast    | —                 |
| E     | 240 – 255         | —                   | Experimental | —                 |

> 🧠 Trick: **A**lways **B**ig **C**ompanies **D**o **E**xperiments → A, B, C, D, E classes
> 127.x.x.x = loopback address (localhost) — not in class A range for public use

### Private IP Ranges (not routable on internet)

- Class A: 10.0.0.0 – 10.255.255.255
- Class B: 172.16.0.0 – 172.31.255.255
- Class C: 192.168.0.0 – 192.168.255.255

### Subnetting

- Dividing a network into smaller subnetworks
- **Subnet mask** — determines which part is network, which is host
- **CIDR notation** — /24 means 24 bits for network (e.g. 192.168.1.0/24)
- Hosts per subnet = 2^(host bits) - 2 (subtract network and broadcast address)

### Special Addresses

- **127.0.0.1** — loopback (localhost)
- **255.255.255.255** — broadcast to all on local network
- **0.0.0.0** — unspecified/default route

### IPv4 vs IPv6

| Feature         | IPv4            | IPv6                |
| --------------- | --------------- | ------------------- |
| Address size    | 32 bits         | 128 bits            |
| Notation        | Decimal, dotted | Hexadecimal, colons |
| Total addresses | ~4.3 billion    | 3.4 × 10^38         |
| Header size     | 20 bytes        | 40 bytes            |
| Checksum        | Yes             | No                  |

> 🧠 Trick: IPv4 = 32 bits. IPv6 = 128 bits. IPv6 = 4× more bits.

---

## 7. Key Protocols ⭐

### Transport Layer Protocols

| Feature       | TCP                        | UDP                          |
| ------------- | -------------------------- | ---------------------------- |
| Connection    | Connection-oriented        | Connectionless               |
| Reliability   | Reliable (ACK, retransmit) | Unreliable                   |
| Order         | In-order delivery          | No ordering                  |
| Speed         | Slower                     | Faster                       |
| Flow control  | Yes                        | No                           |
| Error control | Yes                        | Minimal                      |
| Use           | Web, email, file transfer  | Video streaming, DNS, gaming |

> 🧠 Trick: TCP = reliable but slow (like registered mail). UDP = fast but unreliable (like postcards).

### Common Port Numbers (MCQ favourites)

| Protocol | Port                     |
| -------- | ------------------------ |
| HTTP     | 80                       |
| HTTPS    | 443                      |
| FTP      | 20 (data), 21 (control)  |
| SMTP     | 25                       |
| POP3     | 110                      |
| IMAP     | 143                      |
| DNS      | 53                       |
| Telnet   | 23                       |
| SSH      | 22                       |
| DHCP     | 67 (server), 68 (client) |

### Network Layer Protocols

- **IP** — logical addressing and routing (connectionless)
- **ICMP** — error reporting and diagnostics (used by `ping`)
- **ARP** — maps IP address → MAC address
- **RARP** — maps MAC address → IP address
- **DHCP** — automatically assigns IP addresses

### Application Layer Protocols

- **HTTP** — web browsing (port 80)
- **HTTPS** — secure web (port 443)
- **FTP** — file transfer (port 20/21)
- **SMTP** — sending email (port 25)
- **POP3/IMAP** — receiving email
- **DNS** — resolves domain names to IP addresses (port 53)
- **Telnet** — remote login (port 23), insecure
- **SSH** — secure remote login (port 22)

---

## 8. Flow Control ⭐

- Prevents sender from overwhelming a slow receiver
- Managed at **Data Link layer** and **Transport layer**

### Stop-and-Wait

- Sender sends one frame, waits for ACK before sending next
- Simple but very inefficient
- **Efficiency = 1 / (1 + 2a)** where a = propagation delay / transmission time

### Sliding Window Protocol

- Sender can send multiple frames without waiting for ACK
- **Window size** = number of unacknowledged frames allowed
- Much more efficient than stop-and-wait

**Go-Back-N (GBN)**

- Receiver accepts only **in-order** frames
- If error in frame n → retransmit frame n and all after it
- Sender window size ≤ 2^n - 1 (n = sequence number bits)
- Receiver window size = 1

**Selective Repeat (SR)**

- Receiver accepts **out-of-order** frames (buffers them)
- Only retransmit the specific errored frame
- More efficient than GBN but needs more buffer at receiver
- Sender window size = Receiver window size = 2^(n-1)

> 🧠 Trick: GBN = go back and redo everything from error. SR = only fix the one mistake.

### TCP Flow Control

- Uses **sliding window**
- Receiver advertises **receive window (rwnd)** — how much buffer space available
- Sender cannot send more than rwnd bytes unacknowledged

---

## 9. Error Control ⭐

- Detecting and correcting errors in transmitted data

### Types of Errors

- **Single-bit error** — only one bit flipped
- **Burst error** — multiple consecutive bits corrupted

### Error Detection Methods

**Parity Check**

- Add one extra bit so total 1s are even (even parity) or odd (odd parity)
- Detects **single-bit errors** only
- Cannot detect even number of errors

**Checksum**

- Sum all data segments; send complement of sum
- Receiver adds all segments including checksum; should be all 1s
- Used in TCP/UDP/IP

**CRC (Cyclic Redundancy Check)**

- Most powerful error detection method
- Treat data as polynomial, divide by generator polynomial
- Remainder = CRC bits appended to data
- Detects all single and burst errors up to generator length
- Used in Data Link layer (Ethernet)

> 🧠 Trick: Parity = weakest. Checksum = medium. CRC = strongest error detection.

### Error Correction Methods

**Hamming Code**

- Adds redundant bits at positions that are powers of 2 (1, 2, 4, 8...)
- Can **detect and correct single-bit errors**
- Can **detect double-bit errors**

**Forward Error Correction (FEC)**

- Receiver corrects errors without retransmission
- Used when retransmission is too costly (e.g. satellite)

**ARQ (Automatic Repeat reQuest)**

- Error detection + retransmission
- Three types: Stop-and-Wait ARQ, Go-Back-N ARQ, Selective Repeat ARQ

---

## 10. MAC Layer and Medium Access (general)

- **MAC (Medium Access Control)** — sublayer of Data Link layer
- Controls how devices share the communication medium

### Multiple Access Protocols

- **TDMA** — Time Division Multiple Access; each device gets a time slot
- **FDMA** — Frequency Division; each device gets a frequency band
- **CSMA/CD** — Carrier Sense Multiple Access / Collision Detection → used in **Ethernet**
- **CSMA/CA** — Collision Avoidance → used in **Wi-Fi (802.11)**

> 🧠 Trick: Ethernet = CSMA/CD. Wi-Fi = CSMA/CA. CD = detect. CA = avoid.

### MAC Address

- 48-bit hardware address burned into NIC
- Written as 6 pairs of hex: **00:1A:2B:3C:4D:5E**
- Unique per device (in theory)
- Used within a LAN (not routed across internet)

---

## 11. Routing (general)

- **Routing** — choosing path for packets from source to destination
- Done by **routers** at Network layer

### Routing Algorithms

- **Distance Vector** — each router shares distance table with neighbours (RIP uses this)
- **Link State** — each router shares full topology with all routers (OSPF uses this)
- **Dijkstra's Algorithm** — used in link-state routing for shortest path

### Common Routing Protocols

| Protocol | Type            | Use                              |
| -------- | --------------- | -------------------------------- |
| RIP      | Distance Vector | Small networks, max 15 hops      |
| OSPF     | Link State      | Large networks                   |
| BGP      | Path Vector     | Between ISPs (internet backbone) |

---

## 12. Key Facts for MCQs ⭐

- OSI has **7 layers** | TCP/IP has **4 layers**
- TCP/IP has NO separate Session and Presentation layers
- **Hub = L1** | **Switch = L2** | **Router = L3** | **Gateway = all layers**
- Data unit: Bits (L1) → Frames (L2) → Packets (L3) → Segments (L4)
- **ARP** = IP → MAC | **RARP** = MAC → IP
- IPv4 = **32 bits** | IPv6 = **128 bits**
- **127.0.0.1** = loopback address
- **TCP = reliable, connection-oriented** | **UDP = fast, connectionless**
- DNS uses port **53** | HTTP = **80** | HTTPS = **443** | FTP = **21** | SSH = **22**
- **CRC** = strongest error detection (used in Ethernet)
- **Parity** = weakest, only detects single-bit errors
- **Hamming code** = detects and corrects single-bit errors
- **CSMA/CD** = Ethernet | **CSMA/CA** = Wi-Fi
- **Go-Back-N** = retransmit from error onward | **Selective Repeat** = retransmit only error
- Circuit switching = dedicated path | Packet switching = shared, no dedicated path
- **Bit stuffing** = after 5 consecutive 1s, insert a 0
- Class A: 1-126 | Class B: 128-191 | Class C: 192-223
- **192.168.x.x** = private Class C address
- ICMP used by **ping** command
- **DHCP** automatically assigns IP addresses

---

## 13. Practice MCQs

1. OSI model has how many layers? → **7**
2. TCP/IP model has how many layers? → **4**
3. Which layer does a Router work at? → **Network Layer (Layer 3)**
4. Which layer does a Switch work at? → **Data Link Layer (Layer 2)**
5. Which layer does a Hub work at? → **Physical Layer (Layer 1)**
6. IPv4 address is how many bits? → **32 bits**
7. IPv6 address is how many bits? → **128 bits**
8. ARP maps what to what? → **IP address → MAC address**
9. TCP is connection-oriented — True or False? → **True**
10. UDP provides reliable delivery — True or False? → **False**
11. Port number of HTTP? → **80**
12. Port number of HTTPS? → **443**
13. Port number of FTP (control)? → **21**
14. Port number of SSH? → **22**
15. Port number of DNS? → **53**
16. Which error detection is strongest? → **CRC**
17. Hamming code corrects how many bit errors? → **Single-bit errors**
18. CSMA/CD is used in? → **Ethernet**
19. CSMA/CA is used in? → **Wi-Fi**
20. Loopback address is? → **127.0.0.1**
21. Which protocol assigns IP addresses automatically? → **DHCP**
22. ICMP is used by which command? → **ping**
23. Go-Back-N ARQ — on error, what is retransmitted? → **Errored frame and all frames after it**
24. Selective Repeat ARQ — on error, what is retransmitted? → **Only the errored frame**
25. Circuit switching wastes bandwidth when? → **No data being sent (path still reserved)**

---

_End of Networks Notes | Next: Software Engineering_
