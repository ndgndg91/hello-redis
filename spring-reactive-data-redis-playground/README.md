# Spring Webflux data redis playground
### spring-data-redis-reactive vs redisson-spring-boot-starter

- Spring Data Reactive Redis
  - Performance Issues
  - No Support for Reactive CRUD repository
  - Some annotations do not work with reactive type!

## User Case 1 : Caching
- Reduce Load on DB
  - Avoid Same query re-execution
- Avoid Tons of Network calls
  - Storing API responses
- Avoid Rework
  - Storing the complex computation results.
- Better Throughput
- Improved application response time
- Better user experience
### Cache Aside Pattern
- Primary Use Case
  - Caching Responses
  - To reduce load on the DB
  - To reduce external API calls
- Why app itself can not cache?
  - Waste of memory
  - Cache synchronization
1. Read from cache
2. If not, it from DB / Compute
3. Save it in cache for future use
4. Return the result