package com.cdac.service;

import java.util.List;
import java.util.Optional;

import com.cdac.dto.Buyer;

public interface BuyerService {
	public void addBuyer(Buyer buyer);
	public void removeBuyer(int buyerId);
	public Optional<Buyer> getBuyer(int buyerId);
	public void modifyBuyer(Buyer buyer);
	public List<Buyer> getAll();
}
