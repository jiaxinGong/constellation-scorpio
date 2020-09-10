package com.jiaxin.constellation.scorpio.service.facade;

import com.jiaxin.constellation.scorpio.api.ApolloService;
import com.jiaxin.constellation.scorpio.service.INameSpaceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jiaxin.gong
 * @date 2020/6/20 17:16
 */
@Service
public class ApolloServiceImpl implements ApolloService {
    @Resource
    private INameSpaceService nameSpaceService;

    @Override
    public int getMaxIdOfNameSpace() {
        return nameSpaceService.getMaxId();
    }
}
