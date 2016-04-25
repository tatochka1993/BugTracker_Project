package org.tatsiana.webapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "issue")
public class Issue extends BaseEntity {

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "type", length = 20)
    private String type;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "priority", length = 10)
    private String priority;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return Objects.equals(title, issue.title) &&
                Objects.equals(description, issue.description) &&
                Objects.equals(type, issue.type) &&
                Objects.equals(status, issue.status) &&
                Objects.equals(priority, issue.priority);
    }

    @Override
    public String toString() {
        return "Issue{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                "} " + super.toString();
    }

}
