package com.jerry.service;

import com.jerry.entity.User;
import com.jerry.service.impl.BalanceServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * created by jerry on 2021-12-16
 */
public class BalanceServiceImplTest {
    ClassPathXmlApplicationContext ioc;
    @Before
    public void before(){
        ioc=new ClassPathXmlApplicationContext("spring.xml");
    }
    @Test
    public void test01()
    {
        IBalanceService balanceService = ioc.getBean(IBalanceService.class);
        IUserService userService = ioc.getBean(IUserService.class);
        User fromUser = userService.selectById(2);
        User toUser = userService.selectById(1);
        System.out.println("转账前"+fromUser.getRealName()+":"+fromUser.getBalance()+","+toUser.getRealName()+":"+toUser.getBalance());
        Integer balance =50;
        try {
            System.out.println(fromUser.getRealName() + "向" + toUser.getRealName() + "转账" + balance);
            balanceService.transfer(fromUser.getId(),toUser.getId(),balance);
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        fromUser = userService.selectById(2);
        toUser = userService.selectById(1);
        System.out.println("转账后"+fromUser.getRealName()+":"+fromUser.getBalance()+","+toUser.getRealName()+":"+toUser.getBalance());
    }
}
