package com.cdac.cntr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.Buyer;
import com.cdac.exception.ResourceNotFoundException;
import com.cdac.repo.BuyerRepository;
import com.cdac.service.BuyerService;

@CrossOrigin(origins = "*")
@RestController
public class BuyerController {
	
	@Autowired
	private BuyerService buyerService;
	
	@Autowired
	private BuyerRepository buyerRepository;
	
	@PostMapping(value = "buyers")
	public String userAdd(@RequestBody Buyer buyer) {
		buyerService.addBuyer(buyer);
		return "success";
	}
	
	@GetMapping(value = "buyers")
	public List<Buyer> buyerList(){
		return buyerService.getAll();
	}
	
	@GetMapping(value = "/buyers/{buyerId}")
	public ResponseEntity<Buyer> getBuyerById(@PathVariable int buyerId){
		Buyer buyer = buyerRepository.findById(buyerId)
				.orElseThrow(()-> new ResourceNotFoundException("Buyer not exist with buyerId : " + buyerId));
		return ResponseEntity.ok(buyer);
	}
	
	@PutMapping("/buyers/{buyerId}")
	public ResponseEntity<Buyer> updateBuyer(@PathVariable int buyerId, @RequestBody Buyer buyerDetails){
		Buyer buyer = buyerRepository.findById(buyerId)
				.orElseThrow(() -> new ResourceNotFoundException("Buyer not exist with BuyerId : " + buyerId));
		
		buyer.setUserId(buyerDetails.getUserId());
		buyer.setBidAmount(buyerDetails.getBidAmount());
		
	
		Buyer updatedBuyer = buyerRepository.save(buyer);
		
		return ResponseEntity.ok(updatedBuyer);
	} 
	
	@DeleteMapping("/buyers/{buyerId}")
	public ResponseEntity<Map<String, Boolean>> deleteBuyer(@PathVariable int buyerId){
		Buyer buyer = buyerRepository.findById(buyerId)
				.orElseThrow(() -> new ResourceNotFoundException("Buyer not exist with buyerId : " + buyerId));
		
		buyerRepository.delete(buyer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
//	@DeleteMapping("/buyers/{buyerId}")
//    public List<Buyer> deleteBuyer(@PathVariable int buyerId) {
//        buyerRepository.deleteById(buyerId);
//        return buyerRepository.findAll();
//    }
}
