package com.gbsmd.component.thymeleaf.utility;

import com.gbsmd.common.utils.EntityBeanUtil;
import com.gbsmd.common.utils.SpringContextUtil;
import com.gbsmd.modules.system.domain.ActionLog;
import com.gbsmd.modules.system.service.ActionLogService;

import javax.persistence.Table;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author 小懒虫
 * @date 2018/10/16
 */
public class LogUtil {

    /**
     * 获取实体对象的日志
     * @param entity 实体对象
     */
    public List<ActionLog> entityList(Object entity){
        ActionLogService actionLogService = SpringContextUtil.getBean(ActionLogService.class);
        Table table = entity.getClass().getAnnotation(Table.class);
        String tableName = table.name();
        try {
            Object object = EntityBeanUtil.getField(entity, "id");
            Long entityId = Long.valueOf(String.valueOf(object));
            return actionLogService.getDataLogList(tableName, entityId);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
