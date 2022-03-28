package com.atlassian.jirabackend.repos;

import com.atlassian.jirabackend.models.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepo extends JpaRepository<Issue,Long> {
}
