/**
 * 首页JS的
 * 
 * @author Dbyz
 */
$(function() {
	$("#J_submit").click(function() {
		var valid = false;
		valid = (SimpleValid($("#name")) & SimpleValid($("#password")));
		if (valid) {
			$.ajax({
				type : "post",
				url : systemConfigs.webRoot+"/sys/login",
				data:{"name":$("#name").val(),"password":$("#password").val()},
				dataType : "json",
				success : function(req) {
					if (req.success == true) {
						$("#loginForm").submit();
					}else{
						$("#password").parent().addClass("am-form-error");
					}
				},
				error : function(req) {
				}
			});
		}
	});
});