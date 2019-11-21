package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Required;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "account")
@EqualsAndHashCode(callSuper = false)
public class Account extends AuditModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "account_number")
	private int accountNumber;
	
	
	//Check this out!! Takes the Enum values as a string itself, not as the key integer values
	@Column(name = "account_type")
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	
	@Column(name = "active_status")
	private boolean active;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cust_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Customer customer;
}
