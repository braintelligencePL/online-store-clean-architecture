# Online Store 

There is a lot of names for this type of architecture. Each of us has different style for the same thing. You'll find here  combination of various good practices. Some of which are hype terms like DDD, TDD practices along with hexagonal architecture. We'll try to keep high cohesion and low coupling. You'll see what that means.

## Tech stack: 
- Kotlin
- Spring

## Branches:

<br>

### 📦 `step-1-starter` - basic structure of the project. 

📜 Shows separation of domain and infrastructure. 

**Domain (offer, offer-api)** - contains only pure `Kotlin` code (business code) and does not contain `Spring` (infrastructure) dependencies. In our application representation of domain is `offer` and `offer-api`.

**Infrastructure (app)** - contains `Spring` dependencies. Rest, Soap, GraphQL and all other things like logging, search engines, queues in other words everything that is connected with the outside world (cloud, database and other).

<br>

### 📦 `step-2-offer-api` - offer api design

📜 We can easily say that `offer` and `offer-api` is a microservice. It's separated from other modules and it can be easily moved to another (separate) repository if needed. High cohesion means keeping parts of a code base that are related to each other in a single place. Low coupling, at the same time, is about separating unrelated parts of the code base as much as possible. That's exactly what we want to achieve.

**offer-api** - other modules can interact with `offer` via `offer-api`. In that case `OfferAPI.kt` is a facade for the module. All the models that reside in `offer-api` are for public use. Thanks to that we have clear separations of concerns.

**offer** - implementation of `offer-api`. Business logic. All nitty-gritty details of our app.

**shared-kernel** - contains all the things that will be shared between modules (`offer`, `cart`, `order`, `payment`).

<br>

We also introduced functional **error handling**. Our domain has `Either<OfferError, OfferResponse>`. 

`Either.left` is some known error. 

`Either.right` is the correct value.

Left side of the `Either` is known error that is represented by `sealed class OfferError()`. In other words we only have restricted set of classes that our domain can generate. There is only room for the things we expect. That structure will generate simple and clear error to the frontend developer.

```json
{
    "offerId": "111",
    "status": "NOT_FOUND",
    "title": "Offer with id=111 not found"
}
```

<br>

**Error handling details:**

#### `AppThrowableError` from `shared-kernel`

We override and ignore things we don't want in response. Frontend developer doesn't need our stacktrace he just needs relevant information for him. Which means response similar to above JSON. 

#### `AppError` from `shared-kernel`.

Generic error class that is inherited by `OfferError` and will be inherited later by other modules.

#### `OfferError` from `offer-api`

It is a sealed class with restricted errors known by our domain (in that case offer). In other words, errors that we know might happen during runtime of our application.   

### `AppExceptionHandler` from `app`.

This is our infrastructure. We map models from domain to infrastructure. We create some `ResponseEntity` in case of an error.

<br>

#### 🧱Addons
- **[facade](https://github.com/iluwatar/java-design-patterns/tree/master/facade) (design pattern)** - provides a simplified interface to a complex subsystem. In our case `OfferAPI.kt` is a facade.


