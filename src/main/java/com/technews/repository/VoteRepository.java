package com.technews.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import com.technews.model.Vote;

public interface VoteRepository extends JpaRepository<Vote,Integer>{
   @Query("Select count(*) from Vote v where v.posted=:id")
    int countVotesByPostId(@Param("id") Integer id);
}
