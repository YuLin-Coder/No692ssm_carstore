$(function() {

$("#cateid").blur(
		function() {
			$("#cateid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#cateid").after("<span id='cateid_msg' style='color: red'>汽车类型不能为空</span>");
			}
	});

$("#brand").blur(
		function() {
			$("#brand_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#brand").after("<span id='brand_msg' style='color: red'>品牌不能为空</span>");
			}
	});

$("#type").blur(
		function() {
			$("#type_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#type").after("<span id='type_msg' style='color: red'>型号不能为空</span>");
			}
	});

$("#size").blur(
		function() {
			$("#size_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#size").after("<span id='size_msg' style='color: red'>尺寸不能为空</span>");
			}
	});

$("#seating").blur(
		function() {
			$("#seating_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#seating").after("<span id='seating_msg' style='color: red'>座位数不能为空</span>");
			}
	});

$("#image").blur(
		function() {
			$("#image_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#image").after("<span id='image_msg' style='color: red'>图片不能为空</span>");
			}
	});

$("#color").blur(
		function() {
			$("#color_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#color").after("<span id='color_msg' style='color: red'>颜色不能为空</span>");
			}
	});

$("#supplierid").blur(
		function() {
			$("#supplierid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#supplierid").after("<span id='supplierid_msg' style='color: red'>供应商不能为空</span>");
			}
	});

$("#racksid").blur(
		function() {
			$("#racksid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#racksid").after("<span id='racksid_msg' style='color: red'>货架不能为空</span>");
			}
	});

$("#price").blur(
		function() {
			$("#price_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#price").after("<span id='price_msg' style='color: red'>价格不能为空</span>");
			}
	});

$("#storage").blur(
		function() {
			$("#storage_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#storage").after("<span id='storage_msg' style='color: red'>库存不能为空</span>");
			}
	});







$('#sub').click(function(){
var cateid = $("#cateid").val();
var brand = $("#brand").val();
var type = $("#type").val();
var size = $("#size").val();
var seating = $("#seating").val();
var image = $("#image").val();
var color = $("#color").val();
var supplierid = $("#supplierid").val();
var racksid = $("#racksid").val();
var price = $("#price").val();
var storage = $("#storage").val();
$("#cateid_msg").empty();
$("#brand_msg").empty();
$("#type_msg").empty();
$("#size_msg").empty();
$("#seating_msg").empty();
$("#image_msg").empty();
$("#color_msg").empty();
$("#supplierid_msg").empty();
$("#racksid_msg").empty();
$("#price_msg").empty();
$("#storage_msg").empty();
if (cateid == "" || cateid == null) {
	$("#cateid").after("<span id='cateid_msg' style='color: red'>汽车类型不能为空</span>");
	return false;
}
if (brand == "" || brand == null) {
	$("#brand").after("<span id='brand_msg' style='color: red'>品牌不能为空</span>");
	return false;
}
if (type == "" || type == null) {
	$("#type").after("<span id='type_msg' style='color: red'>型号不能为空</span>");
	return false;
}
if (size == "" || size == null) {
	$("#size").after("<span id='size_msg' style='color: red'>尺寸不能为空</span>");
	return false;
}
if (seating == "" || seating == null) {
	$("#seating").after("<span id='seating_msg' style='color: red'>座位数不能为空</span>");
	return false;
}
if (image == "" || image == null) {
	$("#image").after("<span id='image_msg' style='color: red'>图片不能为空</span>");
	return false;
}
if (color == "" || color == null) {
	$("#color").after("<span id='color_msg' style='color: red'>颜色不能为空</span>");
	return false;
}
if (supplierid == "" || supplierid == null) {
	$("#supplierid").after("<span id='supplierid_msg' style='color: red'>供应商不能为空</span>");
	return false;
}
if (racksid == "" || racksid == null) {
	$("#racksid").after("<span id='racksid_msg' style='color: red'>货架不能为空</span>");
	return false;
}
if (price == "" || price == null) {
	$("#price").after("<span id='price_msg' style='color: red'>价格不能为空</span>");
	return false;
}
if (storage == "" || storage == null) {
	$("#storage").after("<span id='storage_msg' style='color: red'>库存不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#cateid_msg").empty();
$("#brand_msg").empty();
$("#type_msg").empty();
$("#size_msg").empty();
$("#seating_msg").empty();
$("#image_msg").empty();
$("#color_msg").empty();
$("#supplierid_msg").empty();
$("#racksid_msg").empty();
$("#price_msg").empty();
$("#storage_msg").empty();
});

});
