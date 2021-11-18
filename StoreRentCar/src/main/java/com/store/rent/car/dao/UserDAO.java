package com.store.rent.car.dao;

import com.store.rent.car.enity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDAO extends JpaRepository<Account, Long> {

    @Query(value = "SELECT * FROM tai_khoan as t WHERE t.ten_dang_nhap = :username and t.mat_khau = :password", nativeQuery = true)
    Account findByUsernameAndPassword(String username, String password);
}
