package org.study.mgr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Review_SEQ")
	@SequenceGenerator(sequenceName = "review_seq", allocationSize = 1, name = "Review_SEQ")
	@Column(name = "id")
	private int id;

	@Column(name = "comm")
	private String comment;

	public Review() {
	}

	public Review(String comment) {
		super();
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + "]";
	}

}
