package hello.spring_lv1.repository;


import hello.spring_lv1.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);
    //Optional이란 >> findById,findByName이 반환됐을때 값이 없을경우 null로반환되는데  그냥반환되는것보다
    //optional로 감싸서 반환되는것을 선호함 java 8에들어감

    List<Member>findAll();

}
