package com.gcr.dopdf.services;

import com.gcr.dopdf.utils.PDFUtil;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by gongchunru
 * Date：2017/9/28.
 * Time：11:04
 */
public class BusinessPdfView extends AbstractPdfView {

    // 标题
    public static final String title_content = "测试数据";
    // 敬语
    public static final String honorific_content ="亲爱的程序员：";

    // 这是主体内容
    public static  String context = "我的名字叫:{name} 编号:{no}{#}"
            +"这是另一行内容：{xxx}";

    // 表格标题
    public static String[] cellTitles = {"标题1","标题2","标题3"};

    // 银行信息
    public static String bank_content = "请贵司将货款汇入我公司如下银行帐户：{account}";

    public static void test(Map<String,Object> map){

    }

    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            document.open();
            Paragraph title = PDFUtil.getParagraph(new Chunk(title_content,new Font(PDFUtil.bfChinese,16,Font.BOLD)));
            title.setAlignment(Paragraph.ALIGN_CENTER);
            //中文  黑体
            document.add(title);

            Paragraph head = PDFUtil.getParagraph(honorific_content);
            head.setSpacingBefore(20);
            head.setSpacingAfter(10);
            document.add(head);

            //正文
            List<Paragraph> paragraphs = PDFUtil.createParagraphs(context,map);
            for (Paragraph paragraph : paragraphs) {
                document.add(paragraph);
            }

            //表格标题
            PdfPTable table = new PdfPTable(cellTitles.length);
            table.setSpacingBefore(20);
            table.setSpacingAfter(30);
            for (String str : cellTitles) {
                table.addCell(PDFUtil.getParagraph(str));
            }

            // 表格数据
            List<String> cells = (List<String>) map.get("poTableList");
            if(cells != null){
                for(String cell : cells){
                    table.addCell(cell);
                }
            }
            document.add(table);
            // 关闭
            document.close();




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
