package me.itzg.tryspqr.api;

import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import java.security.Principal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import me.itzg.tryspqr.model.Entry;
import org.springframework.stereotype.Service;

/**
 * @author Geoff Bourne
 * @since Dec 2018
 */
@Service
@GraphQLApi
public class RootQuery {

  @GraphQLQuery
  public Entry entry(Principal principal, @GraphQLNonNull String id) {
    return new Entry()
        .setOwner(principal.getName())
        .setWhen(new Date())
        .setId(id);
  }

  @GraphQLQuery
  public List<String> tags(@GraphQLContext Entry entry) {
    return Arrays.asList("red", "green", "blue");
  }
}
