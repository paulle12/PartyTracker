package com.partytracker.PartyTracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import com.partytracker.PartyTracker.model.PartyMember;

public interface PartyMemberRepository extends JpaRepository<PartyMember, Long> {

    // @Query(value = "SELECT party_id FROM party_member ORDER BY id DESC LIMIT 1",
    // nativeQuery = true)
    // String findLatestPartyId();
    // the above is previous codee we update it to accept the params name and realm

    @Query(value = """
              SELECT party_id
              FROM party_member
              WHERE name = :name AND realm = :realm
              ORDER BY id DESC
              LIMIT 1
            """, nativeQuery = true)
    String findLatestPartyIdForPlayer(@Param("name") String name, @Param("realm") String realm);

    List<PartyMember> findByPartyId(String partyId);
}