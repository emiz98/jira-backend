package com.atlassian.jirabackend.controllers;

import com.atlassian.jirabackend.models.HistorySummary;
import com.atlassian.jirabackend.models.IssueHistory;
import com.atlassian.jirabackend.services.IssueHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class IssueHistoryController {
    private IssueHistoryService issueHistoryService;

    public IssueHistoryController(IssueHistoryService issueHistoryService) {
        this.issueHistoryService = issueHistoryService;
    }

    @GetMapping("/issuehistory/{id}")
    public List<IssueHistory> getAllbyIssueId(@PathVariable Long id){
        return issueHistoryService.getAllByIssueId(id);
    }

    @GetMapping("/issuehistory/summary/{id}")
    public HistorySummary getSummaryById(@PathVariable Long id){
        int openCount = issueHistoryService.getSummaryByIssueId(id,"open").size();
        int waitingCount = issueHistoryService.getSummaryByIssueId(id,"waiting").size();
        int progressCount = issueHistoryService.getSummaryByIssueId(id,"inprogress").size();
        int resolvedCount = issueHistoryService.getSummaryByIssueId(id,"resolved").size();

        HistorySummary historySummary = new HistorySummary();
        historySummary.setOpenCount(openCount);
        historySummary.setWaitingCount(waitingCount);
        historySummary.setProgressCount(progressCount);
        historySummary.setResolvedCount(resolvedCount);

        return historySummary;
    }
}
