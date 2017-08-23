package com.family.sweety.modules.programmer_url.dao;

import java.util.List;

import com.family.sweety.common.utils.MyBatisDao;
import com.family.sweety.modules.programmer_url.entity.ProgrammerUrlCategoryEntity;
import com.family.sweety.modules.programmer_url.entity.SummerizeCategoryEntity;

@MyBatisDao
public interface ProgrammerUrlDao {

	
	public List<SummerizeCategoryEntity>findProgrammerUrlList();
	public List<ProgrammerUrlCategoryEntity>findCategoryBySummrizeId(Integer summrizeId);
}
