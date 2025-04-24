# dtproject-api-optimization

# Container Yard Slot Picker API

This Spring Boot API receives container data and recommends the **best available yard slot** based on various scoring rules like distance, size fit, cold storage, and occupancy.

---

## Problem Statement

Imagine a busy shipping yard. A robot crane must place containers **quickly and optimally** on available slots. Each slot has constraints such as:

- Size capacity (small/big)
- Cold storage availability
- Occupancy status

Your job is to **compute a score for each slot** and return the **best one** for the container.

---

## 🚀 How to Run

```bash
# Clone the project
git clone https://github.com/ramswarooppatidar/dtproject-api-optimization.git

# Navigate to project directory
cd dtproject-api-optimization

# Run the project using Maven
mvn spring-boot:run
