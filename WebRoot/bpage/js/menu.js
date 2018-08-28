// JavaScript Document
/*
 * 文件名：menu.js
 * 功能：创建菜单
 * 作者：YuanJingshan
 * 时间：2014-05-06
 */

var show = true;
var hide = false;
var currentId = "";
	
//修改菜单的上下箭头符号
function my_on(head,body)
{
	var tag_a;
	for(var i=0;i<head.childNodes.length;i++)
	{
		if (head.childNodes[i].nodeName=="A")
		{
			tag_a=head.childNodes[i];
			break;
		}
	}
	tag_a.className="on";
}

function my_off(head,body)
{
	var tag_a;
	for(var i=0;i<head.childNodes.length;i++)
	{
		if (head.childNodes[i].nodeName=="A")
		{
			tag_a=head.childNodes[i];
			break;
		}
	}
	
//	if (tag_a.id != currentId) {
//		tag_a.className="off";
//	} else {
//		tag_a.className="on";
//	}
	
}

//添加菜单	
window.onload=function()
{
	currentId = $("#menu-id").val();
	m1 =new Menu("menu1",'menu1_child','dtu','100',hide,my_on,my_off);
	m1.init();
	m2 =new Menu("menu2",'menu2_child','dtu','100',hide,my_on,my_off);
	m2.init();
	m3 =new Menu("menu3",'menu3_child','dtu','100',hide,my_on,my_off);
	m3.init();
	m4 =new Menu("menu4",'menu4_child','dtu','100',hide,my_on,my_off);
	m4.init();
	m5 =new Menu("menu5",'menu5_child','dtu','100',hide,my_on,my_off);
	m5.init();
	m6 =new Menu("menu6",'menu6_child','dtu','100',hide,my_on,my_off);
	m6.init();
	m7 =new Menu("menu7",'menu7_child','dtu','100',hide,my_on,my_off);
	m7.init();
	m8 =new Menu("menu8",'menu8_child','dtu','100',hide,my_on,my_off);
	m8.init();
	m9 =new Menu("menu9",'menu9_child','dtu','100',hide,my_on,my_off);
	m9.init();
}