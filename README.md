# Online Store 

There is a lot of names for this type of architecture. Each of us has different style for the same thing. You'll find here  combination of various good practices. Some of which are hype terms like DDD, TDD, FP practices along with hexagonal architecture. We'll try to keep high cohesion and low coupling. You'll see what that means. 

## Tech stack: 
- Kotlin, Spring, Arrow

## Branches:

<br>

#### 📦 `step-1-starter` - basic structure of the project. 

📜 Shows separation of domain and infrastructure. 

**Domain** - contains only pure `Kotlin` code (business code) and does not contain `Spring` (infrastructure) dependencies. In our application representation of domain is `services:offer` and `services:offer-api`. Later we will discuss what those modules contain.

**Infrastructure** - contains `Spring` dependecies. Rest, Soap, GraphQL and all other things like logging, search engines, queues in other words everything that is connected with the outside world (cloud, database). Representation of this is `services:app`.

<br>

#### 📦 `step-2-offer-api` - offer api design

📜 Basically we'll create a facade (it is a design pattern) that is going to be the only thing that other modules (in other words **bounded context**) will interact with. So later we are gonna have modules like `cart`, `order`, `payment` and these things will use `offer-api` to interact with `offer` domain.
