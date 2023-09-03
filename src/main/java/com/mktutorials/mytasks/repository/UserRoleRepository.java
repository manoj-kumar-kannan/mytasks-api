package com.mktutorials.mytasks.repository;

import com.mktutorials.mytasks.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    @Modifying
    @Transactional
    @Query(value = "update tbl_user_role set is_active = :isActive where id = :id", nativeQuery = true)
    public void deActivateUserRole(@Param(value = "id") Integer id, @Param(value = "isActive") Integer isActive);
}
