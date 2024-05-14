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


import com.dao.GerenbaobiaoDao;
import com.entity.GerenbaobiaoEntity;
import com.service.GerenbaobiaoService;
import com.entity.vo.GerenbaobiaoVO;
import com.entity.view.GerenbaobiaoView;

@Service("gerenbaobiaoService")
public class GerenbaobiaoServiceImpl extends ServiceImpl<GerenbaobiaoDao, GerenbaobiaoEntity> implements GerenbaobiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GerenbaobiaoEntity> page = this.selectPage(
                new Query<GerenbaobiaoEntity>(params).getPage(),
                new EntityWrapper<GerenbaobiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GerenbaobiaoEntity> wrapper) {
		  Page<GerenbaobiaoView> page =new Query<GerenbaobiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GerenbaobiaoVO> selectListVO(Wrapper<GerenbaobiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GerenbaobiaoVO selectVO(Wrapper<GerenbaobiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GerenbaobiaoView> selectListView(Wrapper<GerenbaobiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GerenbaobiaoView selectView(Wrapper<GerenbaobiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
