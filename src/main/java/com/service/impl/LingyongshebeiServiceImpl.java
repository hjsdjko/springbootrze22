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


import com.dao.LingyongshebeiDao;
import com.entity.LingyongshebeiEntity;
import com.service.LingyongshebeiService;
import com.entity.vo.LingyongshebeiVO;
import com.entity.view.LingyongshebeiView;

@Service("lingyongshebeiService")
public class LingyongshebeiServiceImpl extends ServiceImpl<LingyongshebeiDao, LingyongshebeiEntity> implements LingyongshebeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LingyongshebeiEntity> page = this.selectPage(
                new Query<LingyongshebeiEntity>(params).getPage(),
                new EntityWrapper<LingyongshebeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LingyongshebeiEntity> wrapper) {
		  Page<LingyongshebeiView> page =new Query<LingyongshebeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LingyongshebeiVO> selectListVO(Wrapper<LingyongshebeiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LingyongshebeiVO selectVO(Wrapper<LingyongshebeiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LingyongshebeiView> selectListView(Wrapper<LingyongshebeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LingyongshebeiView selectView(Wrapper<LingyongshebeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
