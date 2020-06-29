package helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFHelper {
	private static Document doc;
	private static Document docWeb;
	private static String testName;
	private static String genPath;
	private static String genWeb;
	private static String dateCal;
	private static String onlyPath;
	private static String testNamePath;
	private static Boolean textNewPage;
	private static Boolean newPageToText;
	private static List<String> msgTotal = new ArrayList<String>();


	public static String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
	
	public static void initialize(String path, String tName, SimpleDateFormat date) throws FileNotFoundException, DocumentException {
		doc = new Document();
		docWeb = new Document(PageSize.A4.rotate());
		
		dateCal = date.format(new Date());

		textNewPage = true;
		onlyPath = "";
		
		if (OS.contains("win")) {
			String[] pathSplit = path.split("\\\\");
			
			for(int i=0;i<pathSplit.length-1;i++) {
				onlyPath = onlyPath.concat(pathSplit[i].concat("\\\\"));
			}

			testNamePath = pathSplit[pathSplit.length-1];
			
			PdfWriter.getInstance(docWeb, new FileOutputStream(path + "_old.pdf"));
			genWeb = path + "_old.pdf";
			docWeb.open();
		}else {
			String[] pathSplit = path.split("/");

			for(int i=0;i<pathSplit.length-1;i++) {
				onlyPath = onlyPath.concat(pathSplit[i].concat("/"));
			}
			
			testNamePath = pathSplit[pathSplit.length-1];

			PdfWriter.getInstance(docWeb, new FileOutputStream(path + "_old.pdf"));
			genWeb = path + "_old.pdf";
			docWeb.open();
		}
	}
	
	public static void addText(String msg) throws DocumentException {
		if (doc == null || docWeb == null)
			return;
		if (textNewPage) {
			docWeb.newPage();
			Paragraph p = new Paragraph(80, msg);
			p.setAlignment(Element.ALIGN_CENTER);
			docWeb.add(p);
			msgTotal.add("XxTestxX");
			textNewPage = false;
		} else {
			Paragraph p = new Paragraph(80, msg);
			p.setAlignment(Element.ALIGN_CENTER);
			docWeb.add(p);
			msgTotal.add("XxTestxX");
		}

	}

	/*public static void addScreenshot() {
		byte[] img = ScreenshotUtils.takeScreenshotLogger_("");
		Image docImg;

		docImg = Image.getInstance(img);
		docImg.scaleAbsolute(800, 400);

		float xImg = (PageSize.A4.rotate().getWidth() - docImg.getScaledWidth()) / 2;

		docImg.setAbsolutePosition(xImg, 40f);

		doc.newPage();
		docWeb.add(docImg);
		textNewPage = true;

	}*/

}
