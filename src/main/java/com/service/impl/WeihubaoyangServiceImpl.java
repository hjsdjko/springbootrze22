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


import com.dao.WeihubaoyangDao;
import com.entity.WeihubaoyangEntity;
import com.service.WeihubaoyangService;
import com.entity.vo.WeihubaoyangVO;
import com.entity.view.WeihubaoyangView;

@Service("weihubaoyangService")
public class WeihubaoyangServiceImpl extends ServiceImpl<WeihubaoyangDao, WeihubaoyangEntity> implements WeihubaoyangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeihubaoyangEntity> page = this.selectPage(
                new Query<WeihubaoyangEntity>(params).getPage(),
                new EntityWrapper<WeihubaoyangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeihubaoyangEntity> wrapper) {
		  Page<WeihubaoyangView> page =new Query<WeihubaoyangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WeihubaoyangVO> selectListVO(Wrapper<WeihubaoyangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WeihubaoyangVO selectVO(Wrapper<WeihubaoyangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WeihubaoyangView> selectListView(Wrapper<WeihubaoyangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeihubaoyangView selectView(Wrapper<WeihubaoyangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
