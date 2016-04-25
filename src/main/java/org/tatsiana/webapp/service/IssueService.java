package org.tatsiana.webapp.service;

import org.tatsiana.webapp.entity.Issue;

import java.util.List;

public interface IssueService {

    List<Issue> getAllIssues();

    Issue getById(long id);

    void saveIssue(Issue issue);

    void deleteIssue(long id);

}
