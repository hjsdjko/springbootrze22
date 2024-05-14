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


import com.dao.BanzubaobiaoDao;
import com.entity.BanzubaobiaoEntity;
import com.service.BanzubaobiaoService;
import com.entity.vo.BanzubaobiaoVO;
import com.entity.view.BanzubaobiaoView;

@Service("banzubaobiaoService")
public class BanzubaobiaoServiceImpl extends ServiceImpl<BanzubaobiaoDao, BanzubaobiaoEntity> implements BanzubaobiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BanzubaobiaoEntity> page = this.selectPage(
                new Query<BanzubaobiaoEntity>(params).getPage(),
                new EntityWrapper<BanzubaobiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BanzubaobiaoEntity> wrapper) {
		  Page<BanzubaobiaoView> page =new Query<BanzubaobiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BanzubaobiaoVO> selectListVO(Wrapper<BanzubaobiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BanzubaobiaoVO selectVO(Wrapper<BanzubaobiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BanzubaobiaoView> selectListView(Wrapper<BanzubaobiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BanzubaobiaoView selectView(Wrapper<BanzubaobiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
