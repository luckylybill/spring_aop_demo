package com.jerry.service.impl;

import com.jerry.dao.IBalanceDao;
import com.jerry.service.IBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * created by jerry on 2021-12-16
 */
@Service
public class BalanceServiceImpl implements IBalanceService {
    @Autowired
    IBalanceDao balanceDao;
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void transfer(Integer fromId, Integer toId, Integer balance) {
        sub(fromId,balance);
        //int i=1/0;
        save(toId,balance);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void sub(Integer id,Integer balance)
    {
        balanceDao.change(id,-balance);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Integer id,Integer balance)
    {
        balanceDao.change(id,balance);
    }
}
