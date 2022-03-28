package com.atlassian.jirabackend.controllers;

import com.atlassian.jirabackend.models.Issue;
import com.atlassian.jirabackend.models.IssueHistory;
import com.atlassian.jirabackend.services.IssueHistoryService;
import com.atlassian.jirabackend.services.IssueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class IssueController {

    private IssueService issueService;
    private IssueHistoryService issueHistoryService;

    public IssueController(IssueService issueService, IssueHistoryService issueHistoryService) {
        this.issueService = issueService;
        this.issueHistoryService = issueHistoryService;
    }

    @GetMapping("/issues")
    public List<Issue> getAllIssues(){
        return issueService.getAllIssues();
    }

    @PostMapping("/issue/create")
    public Issue createIssue(@RequestBody Issue issue){
        return issueService.storeIssue(issue);
    }

    @PostMapping("/issue/update")
    public Issue updateIssue(@RequestBody Issue issue){
        Issue existingIssue = issueService.getIssueById(issue.getId());
        existingIssue.setStatus(issue.getStatus());
        issueService.storeIssue(existingIssue);

        IssueHistory issueHistory = new IssueHistory();
        issueHistory.setIssue(issue);
        issueHistory.setChangedTo(issue.getStatus());
        issueHistoryService.store(issueHistory);

        return existingIssue;
    }
}
