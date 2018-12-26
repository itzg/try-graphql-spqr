package me.itzg.tryspqr.config;

import io.leangen.graphql.ExtensionProvider;
import io.leangen.graphql.GeneratorConfiguration;
import io.leangen.graphql.generator.mapping.ArgumentInjector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Geoff Bourne
 * @since Dec 2018
 */
@Configuration
public class GraphQLConfig {

  private final ArgumentInjector[] injectors;

  @Autowired
  public GraphQLConfig(ArgumentInjector... injectors) {
    this.injectors = injectors;
  }

  @Bean
  public ExtensionProvider<GeneratorConfiguration, ArgumentInjector> argumentInjectors() {
    return (config, defaults) ->
      defaults.prepend(injectors);
  }
}
