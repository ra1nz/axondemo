package com.jd.axondemo.activity.service;

import com.jd.axondemo.activity.command.AddActivityApplyCommand;
import com.jd.axondemo.activity.command.CreateActivityCommand;
import com.jd.axondemo.activity.command.StartRegisterCommand;
import com.jd.axondemo.activity.dto.ActivityApplyDTO;
import com.jd.axondemo.activity.dto.ActivityDTO;
import com.jd.axondemo.activity.dto.CreateActivityDTO;
import com.jd.axondemo.activity.query.IdQuery;
import org.apache.log4j.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

@Service
public class ActivityService {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    private CommandGateway commandGateway;

    @Autowired(required = false)
    private QueryGateway queryGateway;

    /**
     * 创建活动
     *
     * @param dto
     */
    public void createActivity(CreateActivityDTO dto) {
        try {
            commandGateway.send(new CreateActivityCommand(dto));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    public ActivityDTO getActivity(Long id) {
        try {
            return queryGateway.send(new IdQuery(id), ActivityDTO.class).get();
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        } catch (ExecutionException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 增加活动apply
     * @param id
     * @param activityApplyDTOS
     * @return
     */
    public boolean addActivityApply(Long id, Collection<ActivityApplyDTO> activityApplyDTOS) {
        try {
            return commandGateway.sendAndWait(new AddActivityApplyCommand(id, activityApplyDTOS));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 启动活动报名
     *
     * @param id
     * @return
     */
    public boolean startActivityRegister(Long id) {
        try {
            return commandGateway.sendAndWait(new StartRegisterCommand(id));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }
}
