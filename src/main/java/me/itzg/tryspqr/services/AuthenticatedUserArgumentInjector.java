package me.itzg.tryspqr.services;

import io.leangen.graphql.generator.mapping.ArgumentInjector;
import io.leangen.graphql.generator.mapping.ArgumentInjectorParams;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Parameter;
import java.security.Principal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Geoff Bourne
 * @since Dec 2018
 */
@Component
public class AuthenticatedUserArgumentInjector implements ArgumentInjector {

  @Override
  public Object getArgumentValue(ArgumentInjectorParams params) {
    return SecurityContextHolder.getContext().getAuthentication();
  }

  @Override
  public boolean supports(AnnotatedType type, Parameter parameter) {
    return type.getType().equals(Principal.class);
  }
}
