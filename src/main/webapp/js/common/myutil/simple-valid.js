/**
 * 自己写的验证
 * 
 * @author Dbyz
 */

/**
 * 简单验证方法
 * 
 * @param element
 *            element 是 jQuery 对象（包含在 <div/> 中，并且含有 class="am-form-field"）
 * @returns {Boolean}
 */
function SimpleValid(element) {
	var valid = true;
	// 验证required
	var required = element.attr("required");
	if (undefined != required) {
		valid = element.val().trim().length > 0;
		showOrHiddenError(valid, element);
		if (!valid) {
			return valid;
		}
	}
	// 验证minlength
	var minlength = element.attr("minlength");
	if (undefined != minlength) {
		valid = element.val().trim().length >= minlength;
		showOrHiddenError(valid, element);
		if (!valid) {
			return valid;
		}
	}
	// 验证maxlength
	var maxlength = element.attr("maxlength");
	if (undefined != maxlength) {
		valid = element.val().trim().length <= maxlength;
		showOrHiddenError(valid, element);
		if (!valid) {
			return valid;
		}
	}

	return valid;
}

/**
 * 显示或者隐藏错误信息
 * 
 * @param valid
 * @param element
 * @returns
 */
function showOrHiddenError(valid, element) {
	if (!valid) {
		element.parent().addClass("am-form-error");
	} else {
		element.parent().removeClass("am-form-error");
	}
}