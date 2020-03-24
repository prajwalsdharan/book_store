package com.fincity.bookStore.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fincity.bookStore.dao.AuthRepository;
import com.fincity.bookStore.entity.Auth;
import com.fincity.bookStore.service.CRUDService;

@Service
public class AuthServiceImpl implements CRUDService<Auth> {

	@Autowired
	AuthRepository authRepository;
	
	@Override
	@Transactional
	public Auth save(Auth auth) {
		return authRepository.save(auth);
	}

	@Override
	public Auth get(int id) {
		return authRepository.getOne(id);
	}

	@Override
	@Transactional
	public Boolean delete(int id) {
		try {
			authRepository.deleteById(id);
			return true;
		} catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Auth> get() {
		return authRepository.findAll();
	}

	public Boolean isVerified(String username,String password) {
		Auth auth = authRepository.findByUsernameAndPassword(username,password);
		if(auth==null)
			return false;
		else
			return true;
	}
}
