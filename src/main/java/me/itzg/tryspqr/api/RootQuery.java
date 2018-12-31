package me.itzg.tryspqr.api;

import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import java.security.Principal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import me.itzg.tryspqr.model.Entry;
import org.springframework.stereotype.Service;

/**
 * For this example application, this serves as the "entry point" or root query.
 */
@Service
@GraphQLApi
public class RootQuery {

  /**
   * Tries out the following capabilities:
   * <ul>
   *   <li>Injecting the authenticated user from our
   *     {@link me.itzg.tryspqr.services.AuthenticatedUserArgumentInjector}</li>
   *   <li>Declaring id as a required argument.
   *     Schema-wise this will generate as <code>entry(id:String!) { }</code></li>
   *   <li>Showing that the response can be wrapped in a {@link CompletableFuture}, which is what
   *     some data stores, like jetcd, provide for async queries</li>
   * </ul>
   */
  @GraphQLQuery
  public CompletableFuture<Entry> entry(Principal principal, @GraphQLNonNull String id) {
    return
        CompletableFuture.completedFuture(
            new Entry()
                .setOwner(principal.getName())
                .setWhen(new Date())
                .setId(id)
        );
  }

  /**
   * Tries out the ability to augment a response object, {@link Entry} in this case, with an
   * additional field.
   */
  @GraphQLQuery
  public List<String> tags(@GraphQLContext Entry entry) {
    return Arrays.asList("red", "green", "blue");
  }
}
