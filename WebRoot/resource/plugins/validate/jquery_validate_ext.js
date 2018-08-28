/**
 * jquery validate校验扩展JS
 *
 * @auth Yuan Jingshan
 * @date 2017/3/26
 */
$(function(){
    /*
    //折扣
    jQuery.validator.addMethod("discount", function(value, element) {
        return this.optional(element) || /^[1](\.[0]{1,2})?|[0]\.\d{1,2}$/.test(value);
    }, "折扣输入不合法");
    */

    // select not select
    jQuery.validator.addMethod("checkSelect", function(value, element) {
        if (value != "-1") {
            return true;
        }
        return false;
    }, "请选择");
    
    // select not select
    jQuery.validator.addMethod("dobleTwo", function(value, element) {
    	return this.optional(element) || /^(([1-9]{1}[0-9]{1})|([0-9]{1}))(\.[0-9]{0,3})?$/.test(value);
    }, "请输入两位小数的浮点数");

});