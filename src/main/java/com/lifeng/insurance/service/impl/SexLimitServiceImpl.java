package com.lifeng.insurance.service.impl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lifeng.insurance.dao.SexLimitRepository;
import com.lifeng.insurance.model.PageReturn;
import com.lifeng.insurance.model.SexLimit;
import com.lifeng.insurance.service.SexLimitService;
/**
 * 
* @ClassName: SexLimitServiceImpl 
* @Description: TODO(ServiceImpl) 
* @author lifeng
* @date 2018年5月8日 下午11:20:37 
*
 */
@Service
public class SexLimitServiceImpl implements SexLimitService {

	/**
	 * 药品限制 性别限制 repository
	 */
	@Autowired
	private SexLimitRepository sexLimitRepository;
	
	@Override
	public PageReturn getAllSexLimit(Pageable pageable) {
		//根据分页条件获取相关信息
		Page<SexLimit> results = sexLimitRepository.findAll(pageable);
		List<SexLimit> content = results.getContent();
		Iterator<SexLimit> iterator = content.iterator();
		while(iterator.hasNext()) {
			SexLimit sexlimit=iterator.next();
			//性别限制判断
			if(sexlimit.getPromptMessage().equals("1")) {
				sexlimit.setPromptMessageName("限制男性");
			}else if(sexlimit.getPromptMessage().equals("2")){
				sexlimit.setPromptMessageName("限制女性");
			}else {
				sexlimit.setPromptMessageName("未知");
			}
		}
		//组装数据
		return PageReturn.instance((int)results.getTotalElements(), content);
	}

	@Override
	public int insert(SexLimit sex) {
		SexLimit save = sexLimitRepository.save(sex);
		if(save!=null) {
			return 1;
		}
		return 0;
	}

	@Override
	public SexLimit getOneById(int id) {
		Optional<SexLimit> sex = sexLimitRepository.findById(id);
		return sex.get();
	}

	@Override
	public int update(SexLimit sex) {
		SexLimit oldSex = sexLimitRepository.findById(sex.getId()).get();
		oldSex.setPromptMessage(sex.getPromptMessage());
		sexLimitRepository.save(oldSex);
		return 1;
	}

	@Override
	public int delete(String ids) {
		String[] split = ids.split(",");
		List<String> asList = Arrays.asList(split);
		return sexLimitRepository.deleteByIds(asList);
	}

}
