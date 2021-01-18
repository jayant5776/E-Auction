package com.cdac.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dto.Buyer;
import com.cdac.repo.BuyerRepository;

@Service
public class BuyerServiceImple implements BuyerService{

	@Autowired
	private BuyerRepository buyerRepository;
	
	@Override
	public void addBuyer(Buyer buyer) {
		buyerRepository.save(buyer);
	}

	@Override
	public void removeBuyer(int buyerId) {
		buyerRepository.deleteById(buyerId);
	}

	@Override
	public Optional<Buyer> getBuyer(int buyerId) {
		return buyerRepository.findById(buyerId);
	}

	@Override
	public void modifyBuyer(Buyer buyer) {
		buyerRepository.save(buyer);
	}

	@Override
	public List<Buyer> getAll() {
		Iterable<Buyer> itr = buyerRepository.findAll();
		Iterator<Buyer> it = itr.iterator();
		List<Buyer> li = new ArrayList<Buyer>();
		while (it.hasNext()) {
			li.add(it.next());
		}
		return li;
	}

}
