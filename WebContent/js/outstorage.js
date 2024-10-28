$(function() {

$("#ordersid").blur(
		function() {
			$("#ordersid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#ordersid").after("<span id='ordersid_msg' style='color: red'>订单不能为空</span>");
			}
	});

$("#goodsid").blur(
		function() {
			$("#goodsid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#goodsid").after("<span id='goodsid_msg' style='color: red'>商品不能为空</span>");
			}
	});

$("#num").blur(
		function() {
			$("#num_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#num").after("<span id='num_msg' style='color: red'>数量不能为空</span>");
			}
	});

$("#adminid").blur(
		function() {
			$("#adminid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#adminid").after("<span id='adminid_msg' style='color: red'>管理员不能为空</span>");
			}
	});







$('#sub').click(function(){
var ordersid = $("#ordersid").val();
var goodsid = $("#goodsid").val();
var num = $("#num").val();
var adminid = $("#adminid").val();
$("#ordersid_msg").empty();
$("#goodsid_msg").empty();
$("#num_msg").empty();
$("#adminid_msg").empty();
if (ordersid == "" || ordersid == null) {
	$("#ordersid").after("<span id='ordersid_msg' style='color: red'>订单不能为空</span>");
	return false;
}
if (goodsid == "" || goodsid == null) {
	$("#goodsid").after("<span id='goodsid_msg' style='color: red'>商品不能为空</span>");
	return false;
}
if (num == "" || num == null) {
	$("#num").after("<span id='num_msg' style='color: red'>数量不能为空</span>");
	return false;
}
if (adminid == "" || adminid == null) {
	$("#adminid").after("<span id='adminid_msg' style='color: red'>管理员不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#ordersid_msg").empty();
$("#goodsid_msg").empty();
$("#num_msg").empty();
$("#adminid_msg").empty();
});

});
