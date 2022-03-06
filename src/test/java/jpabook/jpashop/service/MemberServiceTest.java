package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) //junit을 실행할때 spring을 엮어서 실행할때 넣어줘야함.
@SpringBootTest //Spring boot를 띄운상태로 테스트할 때 넣어줘야함.
@Transactional //Test에서 이 어노테이션은 Rollback을 기본으로 해줌.
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;


    @Test
    @Rollback(false) //@Transactional 어노테이션이 기본적으로 Rollback을해서 영속성 컨텍스트에서 flush를 안하기때문에 값 넣어진 걸 볼려면 Rollback을 false로 해야함.
    public void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("박주영");

        //when
        Long savedId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("박");

        Member member2 = new Member();
        member2.setName("박");

        //when
        memberService.join(member1);
        memberService.join(member2); //예외가 발생해야 한다!!


        //then
        fail("예외가 발생해야 합니다.");
    }
}