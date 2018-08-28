/**
 * @fileName ExportExcel.java
 * @author YuanJingshan
 * @date 2015-6-27
 */
package cn.poomoo.common;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * 操作Excel表格的功能类-利用开源组件POI3.0.2动态导出EXCEL文档
 * 
 * @author leno
 * @version v1.0
 * @param <T>
 */
public class ExportExcel<T> {

    public int exportExcel(Collection<T> dataset, OutputStream out) {
        return exportExcel("考试成绩", null, dataset, out, "yyyy-MM-dd HH:mm:ss");
    }

    public int exportExcel(String[] headers, Collection<T> dataset,
            OutputStream out) {
        return exportExcel("考试成绩", headers, dataset, out, "yyyy-MM-dd HH:mm:ss");
    }

    public int exportExcel(String[] headers, Collection<T> dataset,
            OutputStream out, String pattern) {
        return exportExcel("考试成绩", headers, dataset, out, pattern);
    }

    /**
     * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
     * 
     * @param title
     *            表格标题名
     * @param headers
     *            表格属性列名数组
     * @param dataset
     *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
     *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
     * @param out
     *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
     * @param pattern
     *            如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    public int exportExcel(String title, String[] headers,
            Collection<T> dataset, OutputStream out, String pattern) {
    	int result = 0;
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(title);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 15);
        
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // modified by yjs at 2015-07-03 begin 原因：修改样式颜色
        // 设置这些样式
        //style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        style.setFillForegroundColor(HSSFColor.WHITE.index);
        // modified by yjs at 2015-07-03 end 
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        // modified by yjs at 2015-07-03 begin 原因：修改颜色为白色
        //font.setColor(HSSFColor.VIOLET.index); 
        font.setColor(HSSFColor.BLACK.index);
        // modified by yjs at 2015-07-03 end
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
        
        // 生成并设置另一个样式
        HSSFCellStyle style2 = workbook.createCellStyle();
        // modified by yjs at 2015-07-03 begin 原因：颜色改为白色
        //style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        style2.setFillForegroundColor(HSSFColor.WHITE.index);
        // modified by yjs at 2015-07-03 end
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        
        // 生成另一个字体
        HSSFFont font2 = workbook.createFont();
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style2.setFont(font2);
        // 声明一个画图的顶级管理器
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置,详见文档
        HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
                0, 0, 0, (short) 4, 2, (short) 6, 5));
        // 设置注释内容
        comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
        comment.setAuthor("leno");

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);
            T t = (T) it.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            for (short i = 0; i < fields.length; i++) {
                HSSFCell cell = row.createCell(i);
                cell.setCellStyle(style2);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    // if (value instanceof Integer) {
                    // int intValue = (Integer) value;
                    // cell.setCellValue(intValue);
                    // } else if (value instanceof Float) {
                    // float fValue = (Float) value;
                    // textValue = new HSSFRichTextString(
                    // String.valueOf(fValue));
                    // cell.setCellValue(textValue);
                    // } else if (value instanceof Double) {
                    // double dValue = (Double) value;
                    // textValue = new HSSFRichTextString(
                    // String.valueOf(dValue));
                    // cell.setCellValue(textValue);
                    // } else if (value instanceof Long) {
                    // long longValue = (Long) value;
                    // cell.setCellValue(longValue);
                    // }
                    if (value instanceof Boolean) {
                        boolean bValue = (Boolean) value;
                        textValue = "男";
                        if (!bValue) {
                            textValue = "女";
                        }
                    } else if (value instanceof Date) {
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        textValue = sdf.format(date);
                    } else if (value instanceof byte[]) {
                        // 有图片时，设置行高为60px;
                        row.setHeightInPoints(60);
                        // 设置图片所在列宽度为80px,注意这里单位的一个换算
                        sheet.setColumnWidth(i, (short) (35.7 * 80));
                        // sheet.autoSizeColumn(i);
                        byte[] bsValue = (byte[]) value;
                        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,
                                1023, 255, (short) 6, index, (short) 6, index);
                        anchor.setAnchorType(2);
                        patriarch.createPicture(anchor, workbook.addPicture(
                                bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
                    } else {
                    	if (value != null) {
	                        // 其它数据类型都当作字符串简单处理
	                        textValue = value.toString();
                    	} else {
							textValue = "";
						}
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(
                                    textValue);
                            HSSFFont font3 = workbook.createFont();
                            // modified by yjs at 2015-07-03 begin 原因：颜色改为黑色
                            //font3.setColor(HSSFColor.BLUE.index); 
                            font3.setColor(HSSFColor.BLACK.index);
                            // modified by yjs at 2015-07-03 end
                            
                            richString.applyFont(font3);
                            cell.setCellValue(richString);
                        }
                    }
                } catch (SecurityException e) {
                	result = -1;
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                	result = -1;
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                	result = -1;
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                	result = -1;
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                	result = -1;
                    e.printStackTrace();
                } finally {
                    // 清理资源
                }
            }
        }
        try {
            workbook.write(out);
        } catch (IOException e) {
        	result = -1;
            e.printStackTrace();
        }
        return result;
    }

    /*
    public static void main(String[] args) {
    	//
    	DoctorService doctorService = new DoctorServiceImpl();
        // 测试学生
        ExportExcel<Doctor> ex = new ExportExcel<Doctor>();
        String[] headers = { "编号", "姓名", "性别", "名族", "出生日期", "身份证", "准考证号", "考试类别", "添加时间" };
        List<Doctor> dataset = new ArrayList<Doctor>();
        dataset = doctorService.queryDateByCondition("id in (1,2,3)");
//        dataset.add(new Student(10000001, "张三", 20, true, new Date()));
//        dataset.add(new Student(20000002, "李四", 24, false, new Date()));
//        dataset.add(new Student(30000003, "王五", 22, true, new Date()));
//        // 测试图书
//        ExportExcel<Book> ex2 = new ExportExcel<Book>();
//        String[] headers2 = { "图书编号", "图书名称", "图书作者", "图书价格", "图书ISBN",
//                "图书出版社", "封面图片" };
//        List<Book> dataset2 = new ArrayList<Book>();
        try {
//            BufferedInputStream bis = new BufferedInputStream(
//                    new FileInputStream("book.jpg"));
//            byte[] buf = new byte[bis.available()];
//            while ((bis.read(buf)) != -1) {
//                //
//            }
//            dataset2.add(new Book(1, "jsp", "leno", 300.33f, "1234567",
//                    "清华出版社", buf));
//            dataset2.add(new Book(2, "java编程思想", "brucl", 300.33f, "1234567",
//                    "阳光出版社", buf));
//            dataset2.add(new Book(3, "DOM艺术", "lenotang", 300.33f, "1234567",
//                    "清华出版社", buf));
//            dataset2.add(new Book(4, "c++经典", "leno", 400.33f, "1234567",
//                    "清华出版社", buf));
//            dataset2.add(new Book(5, "c#入门", "leno", 300.33f, "1234567",
//                    "汤春秀出版社", buf));
//
            OutputStream out = new FileOutputStream("E://a.xls");
            ex.exportExcel(headers, dataset, out);
            out.close();
            JOptionPane.showMessageDialog(null, "导出成功!");
            System.out.println("excel导出成功！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}