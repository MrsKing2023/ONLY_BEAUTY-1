package org.backend.onlybeautydemo.repository;

import org.backend.onlybeautydemo.models.AdminProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminProfileRepository extends JpaRepository<AdminProfileEntity, Long> {
}
