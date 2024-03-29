package com.nva.server.repositories;

import com.nva.server.pojos.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    List<User> findByCreatedAtBetween(Date startDate, Date endDate);
    @Query("SELECT u FROM User u WHERE LOWER(u.email) NOT LIKE LOWER(concat('%', :email, '%'))")
    List<User> findAllByEmailNotLike(String email, Sort sort);
    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User u " +
            "SET u.enabled = TRUE WHERE u.email = ?1")
    int enableUser(String email);
}
