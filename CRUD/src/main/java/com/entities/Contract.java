package com.entities;
// Generated 8 avr. 2018 00:43:56 by Hibernate Tools 5.2.8.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Contract generated by hbm2java
 */
@Entity
@Table(name = "contract", catalog = "nursery_webapp")
public class Contract implements java.io.Serializable {

	private Integer id;
	private String contractType;
	private Date startingDate;
	private Date endingDate;
	private int childcarePrice;
	private String legalTutor;
	private String legalTutorPhone;
	private int childId;

	public Contract() {
	}

	public Contract(String contractType, Date startingDate, Date endingDate, int childcarePrice, String legalTutor,
			String legalTutorPhone, int childId) {
		this.contractType = contractType;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
		this.childcarePrice = childcarePrice;
		this.legalTutor = legalTutor;
		this.legalTutorPhone = legalTutorPhone;
		this.childId = childId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "contract_type", nullable = false, length = 45)
	public String getContractType() {
		return this.contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "starting_date", nullable = false, length = 19)
	public Date getStartingDate() {
		return this.startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ending_date", nullable = false, length = 19)
	public Date getEndingDate() {
		return this.endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	@Column(name = "childcare_price", nullable = false)
	public int getChildcarePrice() {
		return this.childcarePrice;
	}

	public void setChildcarePrice(int childcarePrice) {
		this.childcarePrice = childcarePrice;
	}

	@Column(name = "legal_tutor", nullable = false, length = 45)
	public String getLegalTutor() {
		return this.legalTutor;
	}

	public void setLegalTutor(String legalTutor) {
		this.legalTutor = legalTutor;
	}

	@Column(name = "legal_tutor_phone", nullable = false, length = 45)
	public String getLegalTutorPhone() {
		return this.legalTutorPhone;
	}

	public void setLegalTutorPhone(String legalTutorPhone) {
		this.legalTutorPhone = legalTutorPhone;
	}

	@Column(name = "child_id", nullable = false)
	public int getChildId() {
		return this.childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
	}

}
