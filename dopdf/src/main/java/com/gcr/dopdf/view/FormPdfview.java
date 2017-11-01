package com.gcr.dopdf.view;

import com.gcr.dopdf.utils.FreemarkerUtils;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.StringReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by gongchunru
 * Date：2017/9/27.
 * Time：17:08
 */
public class FormPdfview extends  AbstractITextPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        URL fileResource = FormPdfview.class.getResource("/templates");
        String html = FreemarkerUtils.loadFtlHtml(new File(fileResource.getFile()), "simpleForm.ftl", model);

//        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new StringReader(html));
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(html.getBytes()), Charset.forName("UTF-8"), new AsianFontProvider() );
    }

    /*private static final Font getChineseFont(float size) {
        Font FontChinese = null;
        try {
            BaseFont bfChinese = BaseFont.createFont("STSong-Light",
                    "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            FontChinese = new Font(bfChinese, size, Font.NORMAL);
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        return FontChinese;
    }*/
}
