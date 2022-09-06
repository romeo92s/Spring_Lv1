package hello.spring_lv1.repository;

import hello.spring_lv1.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long> ,MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
