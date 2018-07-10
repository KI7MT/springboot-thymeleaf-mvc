package com.beam.helpdesk.domain;

// JPA Imports
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

// Standard Java Imports
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "staff")
@XmlRootElement
public class Staff implements Serializable
{

    private static final long serialVersionUID = 1L;

    // *************************************************************************
    // Staff Data Model
    // *************************************************************************

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Long staffId;

    @Column(name = "badge_code", unique = true, nullable = false, length = 10)
    private String badgeCode;

    @Column(name = "first_name", nullable = false, length = 25)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 25)
    private String lastName;

    @Column(name = "email", nullable = true, length = 25)
    private String email;

    @Column(name = "phone", nullable = true, length = 25)
    private String phone;

    @Column(name = "skill_level", nullable = false, length = 25)
    private String skillLevel;

    @Column(name = "STATUS", nullable = false, length = 25)
    private String status;

    // bi-directional many-to-one association to Country
    @OneToMany(mappedBy = "staff", fetch = FetchType.EAGER)
    private List<Ticket> tickets;
    
    public Staff() {
        tickets = new ArrayList<Ticket>();
    }
    
    // *************************************************************************
    // Getters and Setters
    // *************************************************************************

    public Long getStaffId()
    {
        return staffId;
    }

    public void setStaffId(Long staffId)
    {
        this.staffId = staffId;
    }

    public String getBadgeCode()
    {
        return badgeCode;
    }

    public void setBadgeCode(String badgeCode)
    {
        this.badgeCode = badgeCode;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getSkillLevel()
    {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel)
    {
        this.skillLevel = skillLevel;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public List<Ticket> getTickets()
    {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets)
    {
        this.tickets = tickets;
    }

    // *************************************************************************
    // ToString Override
    // *************************************************************************

    @Override
    public String toString()
    {
        return String.format("Id : %s, Name %s %s, Skill Level : %s, Status : %s  ", staffId, firstName, lastName, skillLevel, status);
    }
    
}
