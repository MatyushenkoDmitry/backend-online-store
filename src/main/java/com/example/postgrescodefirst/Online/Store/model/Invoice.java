package com.example.postgrescodefirst.Online.Store.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="invoices")
public class Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;


    private BigDecimal total;
    private Date issue_date;
    private Date due_date;
    private boolean is_paid;

    public Invoice() {
    }

    public Invoice(Long id, User user, BigDecimal total, Date issue_date, Date due_date, boolean is_paid) {
        this.id = id;
        this.user = user;
        this.total = total;
        this.issue_date = issue_date;
        this.due_date = due_date;
        this.is_paid = is_paid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public boolean isIs_paid() {
        return is_paid;
    }

    public void setIs_paid(boolean is_paid) {
        this.is_paid = is_paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return is_paid == invoice.is_paid && Objects.equals(id, invoice.id) && Objects.equals(user, invoice.user) && Objects.equals(total, invoice.total) && Objects.equals(issue_date, invoice.issue_date) && Objects.equals(due_date, invoice.due_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, total, issue_date, due_date, is_paid);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", user=" + user +
                ", total=" + total +
                ", issue_date=" + issue_date +
                ", due_date=" + due_date +
                ", is_paid=" + is_paid +
                '}';
    }
}
