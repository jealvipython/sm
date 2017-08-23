package com.family.sweety.modules.programmer_url.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.family.sweety.modules.programmer_url.dao.ProgrammerUrlDao;
import com.family.sweety.modules.programmer_url.entity.ProgrammerUrlCategoryEntity;
import com.family.sweety.modules.programmer_url.entity.SummerizeCategoryEntity;
import com.family.sweety.modules.programmer_url.service.ProgrammerUrlService;

@Service
@Transactional(readOnly = true)
public class ProgrammerUrlServiceImpl implements ProgrammerUrlService{

	@Autowired
	private ProgrammerUrlDao programmerUrlDao;
	
	public List<SummerizeCategoryEntity>findProgrammerUrlList(){
		
		return programmerUrlDao.findProgrammerUrlList();
	}
	@Override
	public List<ProgrammerUrlCategoryEntity> findCategoryBySummrizeId(Integer summrizeId) {
		
		
		return  programmerUrlDao.findCategoryBySummrizeId(summrizeId);
	}
	
}
