package com.neo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.entity.Periodical;
import com.neo.repository.PeriodicalRepository;
import com.neo.service.PeriodicalService;

@Service
public class PeriodicalServiceImpl implements PeriodicalService{

	@Autowired
	public PeriodicalRepository repository; 
	@Override
	public List<Periodical> getPeriodicalList() {
		return repository.findAll();
	}

	@Override
	public Periodical findPeriodicalById(long id) {
		return repository.findOne(id);
	}

	@Override
	public void save(Periodical periodical) {
		repository.save(periodical);
	}

	@Override
	public void edit(Periodical periodical) {
		repository.save(periodical);
	}

	@Override
	public void delete(long id) {
		repository.delete(id);
	}

  
}


