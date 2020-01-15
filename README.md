# Online Store 

There is a lot of names for this type of architecture. Each of us has different style for the same thing. You'll find here  combination of various good practices. Some of which are hype terms like FP, DDD, TDD practices along with hexagonal architecture. We'll try to keep high cohesion and low coupling. You'll see what that means.

## Tech stack: 
- Kotlin
- Spring

## Branches:

<br>

### 📦 `step-1-starter` - basic structure of the project. 

📜 Shows separation of domain and infrastructure. 

**Domain (product, product-api)** - contains only pure `Kotlin` code (business code) and does not contain `Spring` (infrastructure) dependencies. In our application representation of domain is `product` and `product-api`.

**Infrastructure (app)** - contains `Spring` dependencies. Rest, Soap, GraphQL and all other things like logging, search engines, queues in other words everything that is connected with the outside world (cloud, database and other).

<br>

### 📦 `step-2-product-api` - product api design, error handler, support-domain

📜 We can easily say that `product` and `product-api` is a microservice. It's separated from other modules and it can be easily moved to another (separate) repository if needed. High cohesion means keeping parts of a code base that are related to each other in a single place. Low coupling, at the same time, is about separating unrelated parts of the code base as much as possible. That's exactly what we want to achieve.

**product-api** - other modules can interact with `product` via `product-api`. In that case `ProductAPI.kt` is a facade for the module. All the models that reside in `product-api` are for public use. Thanks to that we have clear separations of concerns.

**product** - implementation of `product-api`. Business logic. All nitty-gritty details of our app.

**support-domain** - it is concept from DDD world. Contains all the things that will be shared between modules (`product`, `cart`, `order`, `payment`). Also some generic solutions to common problems related with our domain. 

<br>

We also introduced **functional error handling** - `Either<ProductError, ProductResponse>`. 

`Either.right` is the correct value `ProductResponse`. 

`Either.left` is some known error `ProductError`.

Error is represented by sealed class. What we have here is a restricted set of classes that our domain can generate. There is only room for errors that we expect. Thanks to that we generate error to the frontend developer that is clear and simple: 

```json
{
    "productId": "111",
    "status": "NOT_FOUND",
    "title": "Product with id=111 not found"
}
```

<br>

### **Error handling details:**

##### `AppThrowableError` from `support-domain`

We override and ignore things we don't want in response. Frontend developer doesn't need our stacktrace he just needs relevant information for him. Which means response similar to above JSON. 

##### `AppError` from `support-domain`.

Generic error class that is inherited by `productError` and will be inherited later by other modules.

##### `ProductError` from `product-api`

It is a sealed class with restricted errors known by our domain (in that case product). In other words, errors that we know might happen during runtime of our application.   

##### `AppExceptionHandler` from `app`.

This is our infrastructure. We map models from domain to infrastructure. We create JSON response with `ResponseEntity`. For example we map domain HttpStatus (from **zalando-problem**) to infrastructure HttpStatus (from **spring-web**).

<br>

### 🧱Addons
- **[facade](https://github.com/iluwatar/java-design-patterns/tree/master/facade) (design pattern)** - provides a simplified interface to a complex subsystem. In our case `ProductAPI.kt` is a facade.


