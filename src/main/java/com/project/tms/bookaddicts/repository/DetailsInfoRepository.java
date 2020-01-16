package com.project.tms.bookaddicts.repository;


import com.project.tms.bookaddicts.pojo.DetailsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DetailsInfoRepository extends JpaRepository<DetailsInfo,Long> {
    @Query(nativeQuery = true,value = "SELECT id FROM user_book WHERE id_user = :id AND id_book = :id2")
    Long findByBookIdAndUserId(@Param("id") long id,@Param("id2") long id2);
}
