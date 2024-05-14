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


import com.dao.ShebeixiuliDao;
import com.entity.ShebeixiuliEntity;
import com.service.ShebeixiuliService;
import com.entity.vo.ShebeixiuliVO;
import com.entity.view.ShebeixiuliView;

@Service("shebeixiuliService")
public class ShebeixiuliServiceImpl extends ServiceImpl<ShebeixiuliDao, ShebeixiuliEntity> implements ShebeixiuliService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShebeixiuliEntity> page = this.selectPage(
                new Query<ShebeixiuliEntity>(params).getPage(),
                new EntityWrapper<ShebeixiuliEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShebeixiuliEntity> wrapper) {
		  Page<ShebeixiuliView> page =new Query<ShebeixiuliView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShebeixiuliVO> selectListVO(Wrapper<ShebeixiuliEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShebeixiuliVO selectVO(Wrapper<ShebeixiuliEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShebeixiuliView> selectListView(Wrapper<ShebeixiuliEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShebeixiuliView selectView(Wrapper<ShebeixiuliEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
