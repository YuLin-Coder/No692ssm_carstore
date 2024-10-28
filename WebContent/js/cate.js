$(function() {

$("#catename").blur(
		function() {
			$("#catename_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#catename").after("<span id='catename_msg' style='color: red'>类型名称不能为空</span>");
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
var catename = $("#catename").val();
var contents = $("#contents").val();
$("#catename_msg").empty();
$("#contents_msg").empty();
if (catename == "" || catename == null) {
	$("#catename").after("<span id='catename_msg' style='color: red'>类型名称不能为空</span>");
	return false;
}
if (contents == "" || contents == null) {
	$("#contents").after("<span id='contents_msg' style='color: red'>详情不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#catename_msg").empty();
$("#contents_msg").empty();
});

});
