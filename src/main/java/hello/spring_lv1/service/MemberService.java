package hello.spring_lv1.service;


import hello.spring_lv1.domain.Member;
import hello.spring_lv1.repository.MemberRepository;
import hello.spring_lv1.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;


    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {


            //같은 이름이 있는 중복 회원X
            validateDuplicateMember(member); //중복 회원 검
            memberRepository.save(member);
            return member.getId(); //아이디만 반환해주겠다.





    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     *
     * 전체 회원 조회 //서비스 클래스는 비즈니스 관련된 언어를쓰는게 좋음.
     */
    public List<Member> findMembers(){

            return memberRepository.findAll();

    }
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
