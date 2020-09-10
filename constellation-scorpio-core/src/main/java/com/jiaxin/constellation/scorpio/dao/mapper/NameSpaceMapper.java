package com.jiaxin.constellation.scorpio.dao.mapper;

import com.jiaxin.constellation.scorpio.dao.entity.NameSpace;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 命名空间 Mapper 接口
 * </p>
 *
 * @author jiaxin.gong
 * @since 2020-06-20
 */
public interface NameSpaceMapper extends BaseMapper<NameSpace> {
    /**
     * 获取命名空间的最大id
     * @return
     */
    Integer getMaxId();
}
