package com.family.sweety.common.utils.Log;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by joseph on 2017/8/23.
 */
@Service
@Transactional(readOnly = true)
public interface LogService {
    void deleteLogByUserIds(String[] userId);

    List<LogEntity> getLogByIps(String[] userIp);

    Integer getCountByIps(String[] userIp);

    void saveLogInfo(LogEntity entity);
}
