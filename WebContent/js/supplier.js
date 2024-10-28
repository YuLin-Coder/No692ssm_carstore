$(function() {

$("#supname").blur(
		function() {
			$("#supname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#supname").after("<span id='supname_msg' style='color: red'>供应商名称不能为空</span>");
			}
	});

$("#contents").blur(
		function() {
			$("#contents_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#contents").after("<span id='contents_msg' style='color: red'>详情不能为空</span>");
			}
	});







$('#sub').click(function(){
var supname = $("#supname").val();
var contents = $("#contents").val();
$("#supname_msg").empty();
$("#contents_msg").empty();
if (supname == "" || supname == null) {
	$("#supname").after("<span id='supname_msg' style='color: red'>供应商名称不能为空</span>");
	return false;
}
if (contents == "" || contents == null) {
	$("#contents").after("<span id='contents_msg' style='color: red'>详情不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#supname_msg").empty();
$("#contents_msg").empty();
});

});
