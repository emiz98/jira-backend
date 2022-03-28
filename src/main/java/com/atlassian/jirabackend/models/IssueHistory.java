package com.atlassian.jirabackend.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "issue_histories")
public class IssueHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "issue_id")
    private Issue issue;

    private String changedTo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date timestamp;

    public IssueHistory() {
    }

    @PrePersist
    private void onCreate(){
        timestamp=new Date();
    }

    public IssueHistory(Issue issue, String changedTo) {
        this.issue = issue;
        this.changedTo = changedTo;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public String getChangedTo() {
        return changedTo;
    }

    public void setChangedTo(String changedTo) {
        this.changedTo = changedTo;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
