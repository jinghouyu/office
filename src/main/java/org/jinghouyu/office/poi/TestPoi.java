package org.jinghouyu.office.poi;

import java.io.FileInputStream;
import java.io.StringWriter;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.HtmlDocumentFacade;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.model.PAPBinTable;
import org.apache.poi.hwpf.model.PAPX;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;

public class TestPoi {
	
	public static void main(String[] args) throws Exception {
		HWPFDocument d = new HWPFDocument(new FileInputStream("C:\\Users\\jingyu.ljy\\Desktop\\ttt.doc"));
		Range range = d.getRange();
		System.out.println("paragraphs num:" + range.numParagraphs());
		System.out.println("section num:" + range.numSections());
		for(int i = 0; i < range.numParagraphs(); i++) {
			Paragraph p = range.getParagraph(i);
			System.out.println("ph:" + p.text());
		}
		
		PAPBinTable table = d.getParagraphTable();
		
		List<PAPX> paps = table.getParagraphs();
		for(PAPX pap : paps) {
			System.out.println(pap.getStart());
		}
		org.w3c.dom.Document newDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		HtmlDocumentFacade htmlDoc = new HtmlDocumentFacade(newDocument);
		WordToHtmlConverter converter = new WordToHtmlConverter(htmlDoc);
		converter.processDocument(d);
		Transformer transformer = TransformerFactory.newInstance()
		        .newTransformer();
		StringWriter sw = new StringWriter();
		transformer.transform(new DOMSource(converter.getDocument()), new StreamResult(sw));
		System.out.println(sw.toString());
		
	}
}