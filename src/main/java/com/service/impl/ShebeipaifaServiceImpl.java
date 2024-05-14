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


import com.dao.ShebeipaifaDao;
import com.entity.ShebeipaifaEntity;
import com.service.ShebeipaifaService;
import com.entity.vo.ShebeipaifaVO;
import com.entity.view.ShebeipaifaView;

@Service("shebeipaifaService")
public class ShebeipaifaServiceImpl extends ServiceImpl<ShebeipaifaDao, ShebeipaifaEntity> implements ShebeipaifaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShebeipaifaEntity> page = this.selectPage(
                new Query<ShebeipaifaEntity>(params).getPage(),
                new EntityWrapper<ShebeipaifaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShebeipaifaEntity> wrapper) {
		  Page<ShebeipaifaView> page =new Query<ShebeipaifaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShebeipaifaVO> selectListVO(Wrapper<ShebeipaifaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShebeipaifaVO selectVO(Wrapper<ShebeipaifaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShebeipaifaView> selectListView(Wrapper<ShebeipaifaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShebeipaifaView selectView(Wrapper<ShebeipaifaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
