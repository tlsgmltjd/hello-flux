package com.example.helloflux.handler;

import com.example.helloflux.domain.Member;
import com.example.helloflux.handler.dto.request.MemberReqDto;
import com.example.helloflux.handler.dto.response.MemberResDto;
import com.example.helloflux.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class MemberHandler {

    private final MemberRepository memberRepository;

    public Mono<ServerResponse> getAllUsers(ServerRequest request) {
        return memberRepository.findAll()
                .map(member -> new MemberResDto(member.getId(), member.getName()))
                .collectList()
                .flatMap(memberList -> ServerResponse.ok().body(BodyInserters.fromValue(memberList)));
    }

    public Mono<ServerResponse> createUser(ServerRequest request) {
        return request.bodyToMono(MemberReqDto.class)
                .flatMap(reqDto -> memberRepository.save(new Member(reqDto.getName())))
                .then(ServerResponse.ok().build());
    }
}
