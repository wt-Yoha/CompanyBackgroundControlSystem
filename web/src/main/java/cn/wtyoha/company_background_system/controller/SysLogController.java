package cn.wtyoha.company_background_system.controller;

import cn.wtyoha.company_background_system.dao.SysLogDao;
import cn.wtyoha.company_background_system.domain.SysLog;
import cn.wtyoha.company_background_system.domain.User;
import cn.wtyoha.company_background_system.service.SysLogService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    @Qualifier("sysLogServiceImpl")
    SysLogService sysLogService;

    @RequestMapping("/sysLogList")
    public String showSysLogList(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                 HttpServletRequest request){
        List<SysLog> sysLogList = sysLogService.findAll(currentPage, pageSize);
        PageInfo<SysLog> pageInfo = new PageInfo<>(sysLogList);
        int startPageNo = currentPage - 5 > 0 ? currentPage - 5 : 1;
        int endPageNo = Math.min(10 - startPageNo, pageInfo.getPages());
        request.setAttribute("startPageNo", startPageNo);
        request.setAttribute("endPageNo", endPageNo);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("logs", pageInfo.getList());
        return "SysLogList";
    }

}
