package org.tatsiana.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tatsiana.webapp.entity.Issue;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
}
