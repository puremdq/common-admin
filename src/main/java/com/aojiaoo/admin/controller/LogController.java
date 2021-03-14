package com.aojiaoo.admin.controller;

import com.aojiaoo.admin.entity.Log;
import com.aojiaoo.admin.service.ILogService;
import com.aojiaoo.common.response.ServerResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private ILogService logService;

    @RequestMapping("")
    public ServerResponse
            <Page<Log>> list(Page<Log> page, Log log) {
        logService.findPage(page, log);
        return ServerResponse.createSuccessWithDta(page);
    }

    @RequestMapping("form")
    public ServerResponse<Log> edit(Log log) {
        if (log.getId() != null) {
            log = logService.get(log.getId());
        }

        return ServerResponse.createSuccessWithDta(log);
    }

    @RequestMapping("delete")
    public ServerResponse delete(Long id) {
        this.logService.delete(id);
        return ServerResponse.createSuccess();
    }

    @RequestMapping("save")
    public ServerResponse save(Log log) {
        logService.save(log);
        return ServerResponse.createSuccess();
    }

}
