package com.gov.Repository;

import com.gov.Model.Agriculture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAgricultureRepository extends JpaRepository<Agriculture, Long> {
}
