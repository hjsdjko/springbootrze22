package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.XiaohaoshebeiDao;
import com.entity.XiaohaoshebeiEntity;
import com.service.XiaohaoshebeiService;
import com.entity.vo.XiaohaoshebeiVO;
import com.entity.view.XiaohaoshebeiView;

@Service("xiaohaoshebeiService")
public class XiaohaoshebeiServiceImpl extends ServiceImpl<XiaohaoshebeiDao, XiaohaoshebeiEntity> implements XiaohaoshebeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaohaoshebeiEntity> page = this.selectPage(
                new Query<XiaohaoshebeiEntity>(params).getPage(),
                new EntityWrapper<XiaohaoshebeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaohaoshebeiEntity> wrapper) {
		  Page<XiaohaoshebeiView> page =new Query<XiaohaoshebeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiaohaoshebeiVO> selectListVO(Wrapper<XiaohaoshebeiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiaohaoshebeiVO selectVO(Wrapper<XiaohaoshebeiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiaohaoshebeiView> selectListView(Wrapper<XiaohaoshebeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaohaoshebeiView selectView(Wrapper<XiaohaoshebeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
