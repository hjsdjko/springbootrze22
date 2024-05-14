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


import com.dao.XiulijihuaDao;
import com.entity.XiulijihuaEntity;
import com.service.XiulijihuaService;
import com.entity.vo.XiulijihuaVO;
import com.entity.view.XiulijihuaView;

@Service("xiulijihuaService")
public class XiulijihuaServiceImpl extends ServiceImpl<XiulijihuaDao, XiulijihuaEntity> implements XiulijihuaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiulijihuaEntity> page = this.selectPage(
                new Query<XiulijihuaEntity>(params).getPage(),
                new EntityWrapper<XiulijihuaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiulijihuaEntity> wrapper) {
		  Page<XiulijihuaView> page =new Query<XiulijihuaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiulijihuaVO> selectListVO(Wrapper<XiulijihuaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiulijihuaVO selectVO(Wrapper<XiulijihuaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiulijihuaView> selectListView(Wrapper<XiulijihuaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiulijihuaView selectView(Wrapper<XiulijihuaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
