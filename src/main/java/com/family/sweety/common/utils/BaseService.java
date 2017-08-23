package com.family.sweety.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author 梅浩
 * @2016年12月10日下午2:24:22
 * @author_phone : 18610507472
 * @ClassInfo:service基类
 */
@Transactional(readOnly = true)
@Service
public class BaseService {
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

}

