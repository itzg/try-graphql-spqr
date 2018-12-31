This application uses [graphql-spqr](https://github.com/leangen/graphql-spqr) with its
[Spring Boot support](https://github.com/leangen/graphql-spqr-spring-boot-starter) and 
integrates Spring Security to authenticate callers.

# Example Queries

With the default login of user/testing, the following curl operation can be used to query
the 

```
curl --request POST \
  --url http://localhost:8080/graphql \
  --header 'authorization: Basic dXNlcjp0ZXN0aW5n' \
  --header 'content-type: application/json' \
  --data '{"query":"{\n  entry(id:\"1\") {\n    id\n    owner\n    when\n    tags\n  }\n}"}'
```

or GraphQL form is:

```graphql
{
  entry(id:"1") {
    id
    owner
    when
    tags
  }
}
```

which will give a JSON response like:

```json
{
  "data": {
    "entry": {
      "id": "1",
      "owner": "user",
      "when": "2018-12-27T16:12:05.440Z",
      "tags": [
        "red",
        "green",
        "blue"
      ]
    }
  }
}
```

The response is contrived, but derived from the query to verify the operation:
- `id` is always the one given in the query parameter
- `owner` is the Spring Security authenticated username
- `when` is always the current date/time
- `tags` always contains the values red, green, blue