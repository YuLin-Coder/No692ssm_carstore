$(function() {

$("#racksno").blur(
		function() {
			$("#racksno_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#racksno").after("<span id='racksno_msg' style='color: red'>货架号不能为空</span>");
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
var racksno = $("#racksno").val();
var contents = $("#contents").val();
$("#racksno_msg").empty();
$("#contents_msg").empty();
if (racksno == "" || racksno == null) {
	$("#racksno").after("<span id='racksno_msg' style='color: red'>货架号不能为空</span>");
	return false;
}
if (contents == "" || contents == null) {
	$("#contents").after("<span id='contents_msg' style='color: red'>详情不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#racksno_msg").empty();
$("#contents_msg").empty();
});

});
