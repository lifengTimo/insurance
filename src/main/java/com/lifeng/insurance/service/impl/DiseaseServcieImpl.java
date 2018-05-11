package com.lifeng.insurance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifeng.insurance.dao.DiseaseRepository;
import com.lifeng.insurance.model.Disease;
import com.lifeng.insurance.service.DiseaseServcie;
/**
 * 
* @ClassName: DiseaseServcieImpl 
* @Description: TODO(疾病ServiceImpl) 
* @author lifeng
* @date 2018年5月11日 下午10:22:11 
*
 */
@Service
public class DiseaseServcieImpl implements DiseaseServcie {

	/**
	 * 疾病dao
	 */
	@Autowired
	private DiseaseRepository diseaseDao;
	@Override
	public List<Disease> getAll(String q) {
		List<Disease> list = diseaseDao.getAll(q);
		return list;
	}

}
