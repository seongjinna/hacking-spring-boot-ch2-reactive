package com.seongjin.springboot.reactive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RepositoryDatabaseLoader {

  /*
   * CommandLineRunner는 애플리케이션이 시작된 후에 자동으로 실행되는 특수한 스프링 부트 컴포넌트로서, run() 메소드 하나만 갖고 있는 함수형 인터페이스다.
   * 애플리케이션에서 사용되는 모든 컴포넌트가 등록되고 활성화된 이후에 run() 메소드가 자동으로 실행되는 것이 보장된다.
   *
   * CommandLineRunner 객체는 특정 순서로 동작하는것이 보장되지 않는다.
   *
   * 블로킹으로 동작하므로 애플리케이션 시작 시 네티와 충돌할 위험은 없다.
   */

  @Bean
  CommandLineRunner initialize(BlockingItemRepository repository) {
    return args -> {
      repository.save(new Item("Alf alarm clock", 19.99));
      repository.save(new Item("Smurf TV tray", 24.99));
    };
  }
}
