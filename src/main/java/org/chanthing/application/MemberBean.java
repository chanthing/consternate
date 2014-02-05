package org.chanthing.application;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="MEMBER")
public class MemberBean implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String handle;
    private String email;

    public MemberBean() {
    }

    public MemberBean(String firstName, String lastName, String handle, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.handle = handle;
		this.email = email;
    }

    @Id
    @GeneratedValue
    @Column(name="ID")
    public Long getId() {
    	return id;
    }

    public void setId(Long id) {
    	this.id = id;
    }


    @Column(name="FIRST_NAME")
    public String getFirstName() {
    	return firstName;
    }

    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }


    @Column(name="LAST_NAME")
    public String getLastName() {
    	return lastName;
    }

    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }


    @Column(name="HANDLE")
    public String getHandle() {
    	return handle;
    }

    public void setHandle(String handle) {
    	this.handle = handle;
    }


    public String getEmail() {
    	return email;
    }

    @Column(name="EMAIL")
    public void setEmail(String email) {
    	this.email = email;
    }

}
