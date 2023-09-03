package com.mktutorials.mytasks.repository;

import com.mktutorials.mytasks.entity.User;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByIsActive(Integer isActive);

    @Modifying
    @Transactional
    @Query(value = "update tbl_user set is_active = :isActive where id = :id", nativeQuery = true)
    void updateIsActive(@Param(value = "id") long id, @Param(value = "isActive") Integer isActive);
}
