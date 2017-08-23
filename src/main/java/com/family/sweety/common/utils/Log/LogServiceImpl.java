package com.family.sweety.common.utils.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by joseph on 2017/8/23.
 */

@Service
@Transactional(readOnly = true)
public class LogServiceImpl implements  LogService {


@Autowired
private LogDao logDao;



    @Transactional(readOnly = false)
    @Override
   public void deleteLogByUserIds(String[] userId){


        logDao.deleteLogByUserIds(userId);

   }
    @Override
    public List<LogEntity> getLogByIps(String[] userIp){
       return logDao.getLogByIps(userIp);

    }
    @Override
    public   Integer getCountByIps(String[] userIp){

        return logDao.getCountByIps(userIp);

    }
    @Transactional(readOnly = false)
    @Override
    public   void saveLogInfo(LogEntity entity){


        logDao.saveLogInfo(entity);
    }




}
