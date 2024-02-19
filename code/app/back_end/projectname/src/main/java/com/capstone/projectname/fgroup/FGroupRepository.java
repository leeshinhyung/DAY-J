package com.capstone.projectname.fgroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FGroupRepository extends JpaRepository<FGroup, Integer> {
}
