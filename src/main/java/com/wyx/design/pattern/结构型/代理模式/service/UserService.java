package com.wyx.design.pattern.结构型.代理模式.service;

import com.wyx.design.pattern.结构型.代理模式.entity.User;

/**
 * @author : Just wyx
 * @Description : TODO 2020/8/18
 * @Date : 2020/8/18
 */
public interface UserService {

	User get(Integer id);

	int add(User user);
}
