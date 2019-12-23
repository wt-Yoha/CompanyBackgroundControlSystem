package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.domain.SysLog;

import java.util.List;

public interface SysLogService {
    List<SysLog> findAll(int currentPage, int pageSize);

    void save(SysLog sysLog);
}
