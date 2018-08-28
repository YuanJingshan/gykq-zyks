package cn.poomoo.exam.params.service;

import java.util.Map;

import cn.poomoo.exam.params.model.Params;

public interface ParamsService {
	
	Params queryParams();
	
	int updateParams(Map<String, String> map);

	int sysInit();
}
