package org.deveshgupta.orm.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "MESSAGE")
@Table
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "TEXT")
	private String text;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "NEXT_MESSAGE_ID")
	private Message nextMessage;

	public Message() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Message getNextMessage() {
		return nextMessage;
	}

	public void setNextMessage(Message nextMessage) {
		this.nextMessage = nextMessage;
	}

}