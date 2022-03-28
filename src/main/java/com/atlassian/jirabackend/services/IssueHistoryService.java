package com.atlassian.jirabackend.services;

import com.atlassian.jirabackend.models.IssueHistory;
import com.atlassian.jirabackend.repos.IssueHistoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueHistoryService {
    private IssueHistoryRepo issueHistoryRepo;

    public IssueHistoryService(IssueHistoryRepo issueHistoryRepo) {
        this.issueHistoryRepo = issueHistoryRepo;
    }

    public List<IssueHistory> getAllByIssueId(Long id) {
        return issueHistoryRepo.findByIssueId(id);
    }

    public IssueHistory store(IssueHistory issueHistory){
        return issueHistoryRepo.save(issueHistory);
    }

    public List<IssueHistory> getSummaryByIssueId(Long id, String changedTo){
        return issueHistoryRepo.findByIssueIdAndChangedTo(id,changedTo);
    }
}
