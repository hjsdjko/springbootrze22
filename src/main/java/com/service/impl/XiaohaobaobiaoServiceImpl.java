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


import com.dao.XiaohaobaobiaoDao;
import com.entity.XiaohaobaobiaoEntity;
import com.service.XiaohaobaobiaoService;
import com.entity.vo.XiaohaobaobiaoVO;
import com.entity.view.XiaohaobaobiaoView;

@Service("xiaohaobaobiaoService")
public class XiaohaobaobiaoServiceImpl extends ServiceImpl<XiaohaobaobiaoDao, XiaohaobaobiaoEntity> implements XiaohaobaobiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaohaobaobiaoEntity> page = this.selectPage(
                new Query<XiaohaobaobiaoEntity>(params).getPage(),
                new EntityWrapper<XiaohaobaobiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaohaobaobiaoEntity> wrapper) {
		  Page<XiaohaobaobiaoView> page =new Query<XiaohaobaobiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiaohaobaobiaoVO> selectListVO(Wrapper<XiaohaobaobiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiaohaobaobiaoVO selectVO(Wrapper<XiaohaobaobiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiaohaobaobiaoView> selectListView(Wrapper<XiaohaobaobiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaohaobaobiaoView selectView(Wrapper<XiaohaobaobiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
