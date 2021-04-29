package com.itesting.SBDemo.respositories;

import com.itesting.SBDemo.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
