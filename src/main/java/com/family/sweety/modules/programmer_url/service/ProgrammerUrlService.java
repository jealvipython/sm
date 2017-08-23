package com.family.sweety.modules.programmer_url.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.family.sweety.modules.programmer_url.entity.ProgrammerUrlCategoryEntity;
import com.family.sweety.modules.programmer_url.entity.SummerizeCategoryEntity;

@Service
@Transactional(readOnly=true)
public interface ProgrammerUrlService {
	public List<SummerizeCategoryEntity>findProgrammerUrlList();
	
	public List<ProgrammerUrlCategoryEntity>findCategoryBySummrizeId(Integer summrizeId);
}
