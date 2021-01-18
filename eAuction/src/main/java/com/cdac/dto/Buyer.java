package com.cdac.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "buyer")
public class Buyer {
	
	@Id
	@GeneratedValue
	private int buyerId;
	private int userId;
	private int bidAmount;
	
	public Buyer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}

	@Override
	public String toString() {
		return "Buyer [buyerId=" + buyerId + ", userId=" + userId + ", bidAmount=" + bidAmount + "]";
	}
}
