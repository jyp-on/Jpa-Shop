package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //조회만 하는 트랜잭션이라고 설정해주면 성능 최적화가 됌
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository; //@RequiredArgsConstructor 로 인해서 final 이 있는 필드만 생성자 생성

    //회원가입
    @Transactional //readOnly false로 설정(기본값이 false)
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //회원 1명 조회
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
