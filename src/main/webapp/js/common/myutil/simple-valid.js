/**
 * 自己写的验证
 * 
 * @author Dbyz
 */
function SimpleValid(element) {
	var valid = true;
	// 验证required
	var required = element.attr("required");
	if (undefined != required) {
		valid = element.val().trim().length > 0;
		if (!valid) {
			element.parent().addClass("am-form-error");
			return valid;
		}
		element.parent().removeClass("am-form-error");
	}
	// 验证minlength
	var minlength = element.attr("minlength");
	if (undefined != minlength) {
		valid = element.val().trim().length >= minlength;
		if (!valid) {
			element.parent().addClass("am-form-error");
			return valid;
		}
		element.parent().removeClass("am-form-error");
	}
	// 验证maxlength
	var maxlength = element.attr("maxlength");
	if (undefined != maxlength) {
		valid = element.val().trim().length <= maxlength;
		if (!valid) {
			element.parent().addClass("am-form-error");
			return valid;
		}
		element.parent().removeClass("am-form-error");
	}

	return valid;
}