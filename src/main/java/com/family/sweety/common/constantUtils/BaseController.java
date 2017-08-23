package com.family.sweety.common.constantUtils;

import com.family.sweety.common.utils.Log.LogEntity;
import com.family.sweety.common.utils.Log.LogService;
import com.family.sweety.common.utils.Log.LogServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by joseph on 2017/8/23.
 */
@Controller
public class BaseController {

    Logger logger = LoggerFactory.getLogger(getClass());

    protected  static  final  String opType_2="2";
    protected  static  final  String opType_3="3";
    protected  static  final  String opType_4="4";
    protected  static  final  String opType_5="5";
@Autowired
private LogService logService;





    protected  void saveLogInfo(LogEntity entity){

        logService.saveLogInfo(entity);

    }
    protected Integer  getCountByIps(String ... userIp){

        return    logService.getCountByIps(userIp);

    }


    protected List<LogEntity> getLogByIps(String ...userIp){


      return  logService.getLogByIps(userIp);
    }


    protected  void  deleteLogByUserIds(String ... userId){


     logService.deleteLogByUserIds(userId);
    }



}
