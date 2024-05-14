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


import com.dao.ShebeijianceDao;
import com.entity.ShebeijianceEntity;
import com.service.ShebeijianceService;
import com.entity.vo.ShebeijianceVO;
import com.entity.view.ShebeijianceView;

@Service("shebeijianceService")
public class ShebeijianceServiceImpl extends ServiceImpl<ShebeijianceDao, ShebeijianceEntity> implements ShebeijianceService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShebeijianceEntity> page = this.selectPage(
                new Query<ShebeijianceEntity>(params).getPage(),
                new EntityWrapper<ShebeijianceEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShebeijianceEntity> wrapper) {
		  Page<ShebeijianceView> page =new Query<ShebeijianceView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShebeijianceVO> selectListVO(Wrapper<ShebeijianceEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShebeijianceVO selectVO(Wrapper<ShebeijianceEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShebeijianceView> selectListView(Wrapper<ShebeijianceEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShebeijianceView selectView(Wrapper<ShebeijianceEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
