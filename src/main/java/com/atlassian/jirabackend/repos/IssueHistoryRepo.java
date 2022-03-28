package com.atlassian.jirabackend.repos;

import com.atlassian.jirabackend.models.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueHistoryRepo extends JpaRepository<IssueHistory,Long> {
    List<IssueHistory> findByIssueId(Long id);
    List<IssueHistory> findByIssueIdAndChangedTo(Long id,String changedTo);
}
