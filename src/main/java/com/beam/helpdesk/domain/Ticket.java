package com.beam.helpdesk.domain;

//JPA Imports
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Standard Java Imports
import java.io.Serializable;

//Model Imports
import com.beam.helpdesk.domain.Staff;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {

 private static final long serialVersionUID = 1L;

 // *************************************************************************
 // Ticket Data Model
 // *************************************************************************

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "ticket_id", unique = true, insertable = false, updatable = false, nullable = false, length = 3)
 private Long ticketId;

 @Column(name = "customer_id", length = 3)
 private String customerId;

 @Column(name = "problem_desc", nullable = false, length = 500)
 private String problemDesc;

 @Column(name = "resolution", length = 500)
 private String resolution;

 @Column(name = "created_date")
 @Temporal(TemporalType.TIMESTAMP)
 private java.util.Date createdDate;

 @Column(name = "resolved_date")
 @Temporal(TemporalType.TIMESTAMP)
 private java.util.Date resolvedDate;

 @Column(name = "status")
 private String status;

 // bi-directional many-to-one association to Region
 @ManyToOne
 @JoinColumn(name = "staff_id")
 private Staff staff;

 // *************************************************************************
 // Constructor
 // *************************************************************************

 public Ticket() {

 }

 // *************************************************************************
 // Getters and Setters
 // *************************************************************************

 public Long getTicketId() {
     return ticketId;
 }

 public void setTicketId(Long ticketId) {
     this.ticketId = ticketId;
 }

 public String getCustomerId() {
     return customerId;
 }

 public void setCustomerId(String customerId) {
     this.customerId = customerId;
 }

 public Staff getStaff() {
     return staff;
 }

 public void setStaff(Staff staff) {
     this.staff = staff;
 }

 public String getProblemDesc() {
     return problemDesc;
 }

 public void setProblemDesc(String problemDesc) {
     this.problemDesc = problemDesc;
 }

 public String getResolution() {
     return resolution;
 }

 public void setResolution(String resolution) {
     this.resolution = resolution;
 }

 public java.util.Date getCreatedDate() {
     return createdDate;
 }

 public void setCreatedDate(java.util.Date createdDate) {
     this.createdDate = createdDate;
 }

 public java.util.Date getResolvedDate() {
     return resolvedDate;
 }

 public void setResolvedDate(java.util.Date resolvedDate) {
     this.resolvedDate = resolvedDate;
 }

 public String getStatus() {
     return status;
 }

 public void setStatus(String status) {
     this.status = status;
 }

 // *************************************************************************
 // ToString Override
 // *************************************************************************

 @Override
 public String toString() {

     return String.format(
             "TicketId: %s, " + "Created: %s, " + "Owner: %s %s, " + "Status: %s, " + "Description: %s ", ticketId,
             createdDate, staff.getFirstName(), staff.getLastName(), status, problemDesc);
 }

}
