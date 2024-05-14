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


import com.dao.LingyongbaobiaoDao;
import com.entity.LingyongbaobiaoEntity;
import com.service.LingyongbaobiaoService;
import com.entity.vo.LingyongbaobiaoVO;
import com.entity.view.LingyongbaobiaoView;

@Service("lingyongbaobiaoService")
public class LingyongbaobiaoServiceImpl extends ServiceImpl<LingyongbaobiaoDao, LingyongbaobiaoEntity> implements LingyongbaobiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LingyongbaobiaoEntity> page = this.selectPage(
                new Query<LingyongbaobiaoEntity>(params).getPage(),
                new EntityWrapper<LingyongbaobiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LingyongbaobiaoEntity> wrapper) {
		  Page<LingyongbaobiaoView> page =new Query<LingyongbaobiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LingyongbaobiaoVO> selectListVO(Wrapper<LingyongbaobiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LingyongbaobiaoVO selectVO(Wrapper<LingyongbaobiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LingyongbaobiaoView> selectListView(Wrapper<LingyongbaobiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LingyongbaobiaoView selectView(Wrapper<LingyongbaobiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
