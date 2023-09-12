package com.reshma;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class LoanDAO implements LoanDAOContractor {

	@PersistenceContext
	private EntityManager emt;

	@Override
	public List<User> getAllCredentials() {
		return emt.createQuery("select user from User user").getResultList();
	}

}
