package cn.wtyoha.company_background_system.service.impl;

import cn.wtyoha.company_background_system.dao.SysLogDao;
import cn.wtyoha.company_background_system.domain.SysLog;
import cn.wtyoha.company_background_system.service.SysLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    SysLogDao sysLogDao;

    @Override
    public List<SysLog> findAll(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return sysLogDao.findAll();
    }

    @Override
    public void save(SysLog sysLog) {
        sysLog.setId(UUID.randomUUID().toString().replace("-", ""));
        sysLogDao.save(sysLog);
    }
}
