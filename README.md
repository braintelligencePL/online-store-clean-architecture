# Online Store 

There is a lot of names for this type of architecture. Each of us has different style for the same thing. This repository is a combination of various good practices. Some of which are hype terms like DDD, TDD practices along with hexagonal architecture.

## Tech stack: 
- Kotlin
- Spring

## Branches:

<br>

#### 📦 `step-1-starter` - basic structure of the project. 

📜 Show separation of domain and infrastructure. 

**Domain** - contains only pure `Kotlin` code (business code) and does not contain `Spring` (infrastructure) dependencies. In our application representation of domain is `offer` and `offer-api`.

**Infrastructure** - contains `Spring` dependecies. Rest, Soap, GraphQL and all other things like logging, search engines, queues... 


