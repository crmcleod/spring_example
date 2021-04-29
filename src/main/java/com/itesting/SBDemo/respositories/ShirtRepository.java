package com.itesting.SBDemo.respositories;

import com.itesting.SBDemo.models.Shirt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShirtRepository extends JpaRepository<Shirt, Long> {
}
