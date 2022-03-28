package com.atlassian.jirabackend.services;

import com.atlassian.jirabackend.models.Issue;
import com.atlassian.jirabackend.repos.IssueRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService{
    private IssueRepo issueRepo;

    public IssueService(IssueRepo issueRepo) {
        this.issueRepo = issueRepo;
    }

    public List<Issue> getAllIssues(){
        return issueRepo.findAll();
    }
    public Issue getIssueById(Long id) {
        return issueRepo.findById(id).get();
    }
    public Issue storeIssue(Issue issue){
        return issueRepo.save(issue);
    }
    public Issue updateIssue(Issue issue){
        return issueRepo.save(issue);
    }

}
