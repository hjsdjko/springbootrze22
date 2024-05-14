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


import com.dao.DingqixiufuDao;
import com.entity.DingqixiufuEntity;
import com.service.DingqixiufuService;
import com.entity.vo.DingqixiufuVO;
import com.entity.view.DingqixiufuView;

@Service("dingqixiufuService")
public class DingqixiufuServiceImpl extends ServiceImpl<DingqixiufuDao, DingqixiufuEntity> implements DingqixiufuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DingqixiufuEntity> page = this.selectPage(
                new Query<DingqixiufuEntity>(params).getPage(),
                new EntityWrapper<DingqixiufuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DingqixiufuEntity> wrapper) {
		  Page<DingqixiufuView> page =new Query<DingqixiufuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DingqixiufuVO> selectListVO(Wrapper<DingqixiufuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DingqixiufuVO selectVO(Wrapper<DingqixiufuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DingqixiufuView> selectListView(Wrapper<DingqixiufuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DingqixiufuView selectView(Wrapper<DingqixiufuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
