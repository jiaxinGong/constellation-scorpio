package com.jiaxin.constellation.scorpio.service.impl;

import com.jiaxin.constellation.scorpio.dao.entity.NameSpace;
import com.jiaxin.constellation.scorpio.dao.mapper.NameSpaceMapper;
import com.jiaxin.constellation.scorpio.service.INameSpaceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 命名空间 服务实现类
 * </p>
 *
 * @author jiaxin.gong
 * @since 2020-06-20
 */
@Service
public class NameSpaceServiceImpl extends ServiceImpl<NameSpaceMapper, NameSpace> implements INameSpaceService {

    @Override
    public Integer getMaxId() {
        return baseMapper.getMaxId();
    }
}
