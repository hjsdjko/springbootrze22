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


import com.dao.ZhuangtaihuibaoDao;
import com.entity.ZhuangtaihuibaoEntity;
import com.service.ZhuangtaihuibaoService;
import com.entity.vo.ZhuangtaihuibaoVO;
import com.entity.view.ZhuangtaihuibaoView;

@Service("zhuangtaihuibaoService")
public class ZhuangtaihuibaoServiceImpl extends ServiceImpl<ZhuangtaihuibaoDao, ZhuangtaihuibaoEntity> implements ZhuangtaihuibaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhuangtaihuibaoEntity> page = this.selectPage(
                new Query<ZhuangtaihuibaoEntity>(params).getPage(),
                new EntityWrapper<ZhuangtaihuibaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhuangtaihuibaoEntity> wrapper) {
		  Page<ZhuangtaihuibaoView> page =new Query<ZhuangtaihuibaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhuangtaihuibaoVO> selectListVO(Wrapper<ZhuangtaihuibaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhuangtaihuibaoVO selectVO(Wrapper<ZhuangtaihuibaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhuangtaihuibaoView> selectListView(Wrapper<ZhuangtaihuibaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhuangtaihuibaoView selectView(Wrapper<ZhuangtaihuibaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
