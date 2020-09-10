package com.jiaxin.constellation.scorpio.service;

import com.jiaxin.constellation.scorpio.dao.entity.NameSpace;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 命名空间 服务类
 * </p>
 *
 * @author jiaxin.gong
 * @since 2020-06-20
 */
public interface INameSpaceService extends IService<NameSpace> {
    /**
     * 获取命名空间的最大id值
     *
     * @return
     */
    Integer getMaxId();
}
