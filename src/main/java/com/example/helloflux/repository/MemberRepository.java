package com.example.helloflux.repository;

import com.example.helloflux.domain.Member;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MemberRepository extends ReactiveCrudRepository<Member, Long> {
}
