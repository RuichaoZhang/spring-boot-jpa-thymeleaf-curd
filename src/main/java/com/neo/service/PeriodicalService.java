package com.neo.service;

import com.neo.entity.Periodical;

import java.util.List;

public interface PeriodicalService {

    public List<Periodical> getPeriodicalList();

    public Periodical findPeriodicalById(long id);
    
    public void save(Periodical periodical);

    public void edit(Periodical periodical);

    public void delete(long id);


}
