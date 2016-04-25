package org.tatsiana.webapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tatsiana.webapp.entity.Issue;
import org.tatsiana.webapp.repository.IssueRepository;
import org.tatsiana.webapp.service.IssueService;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;


    @Override
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    @Override
    public Issue getById(long id) {
        return issueRepository.findOne(id);
    }

    @Override
    public void saveIssue(Issue issue) {
        issueRepository.save(issue);
    }

    @Override
    public void deleteIssue(long id) {
        issueRepository.delete(id);
    }

}
