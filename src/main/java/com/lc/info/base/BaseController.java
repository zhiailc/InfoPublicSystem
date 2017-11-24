package com.lc.info.base;

import com.lc.info.constant.Constant;
import com.lc.info.exception.ParamException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;


public class BaseController {
	@ModelAttribute
	public void init(HttpServletRequest request,Model model){
		String ctx = request.getContextPath();
		model.addAttribute("ctx", ctx);
	}
	
	protected ResultInfo failure (Integer errorCode,String errorMsg) {
		ResultInfo result = new ResultInfo(errorCode, errorMsg, errorMsg);
		return result;
	}
	
	protected ResultInfo failure (String errorMsg) {
		ResultInfo result = failure(Constant.OPS_ERROR_CODE,errorMsg);
		return result;
	}
	
	protected ResultInfo failure (ParamException e) {
		ResultInfo result = failure(e.getMessage());
		return result;
	}
	
	protected ResultInfo success (Object result) {
		ResultInfo resultInfo = new ResultInfo(Constant.OPS_SUCCESS_CODE, Constant.OPS_SUCCESS_MSG, result);
		return resultInfo;
	}
}
