package com.family.sweety.common.utils.Log;

import com.family.sweety.common.utils.MyBatisDao;

import java.util.List;

/**
 * Created by joseph on 2017/8/23.
 */

@MyBatisDao
public interface LogDao {

    void deleteLogByUserIds(String[] userId);

    List<LogEntity> getLogByIps(String[] userIp);

    Integer getCountByIps(String[] userIp);

    void saveLogInfo(LogEntity entity);
}
