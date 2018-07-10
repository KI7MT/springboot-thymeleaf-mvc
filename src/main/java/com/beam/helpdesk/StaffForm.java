package com.beam.helpdesk;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * Entity Class for Add Staff HTML Form. Used by
 * {@link com.beam.helpdesk.StaffController} and
 * {@link resources/staff/addform.html}
 * 
 * @author Greg Beam (ki7mt)
 * @since 7/1/2018
 * @version 0.1.0
 *
 */
public class StaffForm
{

    @NotNull
    @Size(min = 1, max = 25)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 25)
    private String lastName;

    @NotNull
    private String badgeCode;

    @NotNull
    private String skillLevel;

    @NotNull
    private String status;

    private String email;

    private String phone;

    
    // -------------------------------------------------------------------------
    // Getters and Setters
    // -------------------------------------------------------------------------

    /**
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @return the badgeCode
     */
    public String getBadgeCode()
    {
        return badgeCode;
    }

    /**
     * @param badgeCode
     *            the badgeCode to set
     */
    public void setBadgeCode(String badgeCode)
    {
        this.badgeCode = badgeCode;
    }

    /**
     * @return the skillLevel
     */
    public String getSkillLevel()
    {
        return skillLevel;
    }

    /**
     * @param skillLevel
     *            the skillLevel to set
     */
    public void setSkillLevel(String skillLevel)
    {
        this.skillLevel = skillLevel;
    }

    /**
     * @return the status
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * @param phone
     *            the phone to set
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "StaffForm [firstName=" + firstName + ", lastName=" + lastName + ", badgeCode=" + badgeCode
                + ", skillLevel=" + skillLevel + ", status=" + status + ", email=" + email + ", phone=" + phone + "]";
    }

    
}
