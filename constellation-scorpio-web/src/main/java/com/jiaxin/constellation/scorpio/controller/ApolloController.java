package com.jiaxin.constellation.scorpio.controller;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiaxin.constellation.scorpio.api.ApolloService;
import com.jiaxin.constellation.scorpio.constant.ScorpioResponseCodeEnum;
import com.jiaxin.constellation.scorpio.dao.entity.NameSpace;
import com.jiaxin.constellation.scorpio.exception.ScorpioException;
import com.jiaxin.constellation.scorpio.response.Response;
import com.jiaxin.constellation.scorpio.response.ResponseHelper;
import com.jiaxin.constellation.scorpio.service.INameSpaceService;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 命名空间 前端控制器
 * </p>
 *
 * @author jiaxin.gong
 * @since 2020-06-20
 */
@RestController
@RequestMapping("/apollo")
@Slf4j
@Api(tags = "Apollo控制类")
public class ApolloController {
    @Resource
    private ApolloService apolloService;
    @Resource
    private INameSpaceService nameSpaceService;

    @GetMapping("/maxId/{msg}")
    @ApiOperation(value = "获取最大的命名空间",notes = "获取最大的命名空间Notes")
    public Response getNameSpace(@PathVariable("msg") String msg) {
        log.info("param={}", msg);
        int maxIdOfNameSpace = apolloService.getMaxIdOfNameSpace();
        return ResponseHelper.success(maxIdOfNameSpace);
    }

    @GetMapping("/testPage")
    public Response testPage() {
        IPage<NameSpace> page = new Page<>(2, 3);
        QueryWrapper<NameSpace> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().ne(NameSpace::getAppId, "");
        IPage<NameSpace> selectPage = nameSpaceService.getBaseMapper().selectPage(page, queryWrapper);
        return ResponseHelper.success(selectPage);
    }

    @GetMapping("/test/exception")
    public Response testException() {
        int i = 10 / 0;
        int maxIdOfNameSpace = apolloService.getMaxIdOfNameSpace();
        return ResponseHelper.success(maxIdOfNameSpace);
    }

    @GetMapping("/test/bizException")
    public Response testBizException() {
        throw new ScorpioException(ScorpioResponseCodeEnum.INVALID_PARAM);
    }
}
