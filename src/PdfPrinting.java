
import com.github.anastaciocintra.escpos.EscPos;
import com.github.anastaciocintra.escpos.image.BitonalOrderedDither;
import com.github.anastaciocintra.escpos.image.CoffeeImageImpl;
import com.github.anastaciocintra.escpos.image.RasterBitImageWrapper;
import com.github.anastaciocintra.output.PrinterOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.TextMarginFinder;
import lib.ImageHelper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.print.PrintService;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * make pdf rendering and send to escpos_coffee
 */
public class PdfPrinting {

    public void printPdf(PrinterOutputStream outputStream) throws IOException {
        try (EscPos escpos = new EscPos(outputStream)){


            PDDocument document = PDDocument.load(getURL("test-trimmed-stamper.pdf"));
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            int numberOfPages = document.getNumberOfPages();
            System.out.println("Total files to be converting -> "+ numberOfPages);
            //
            // each page of pdf is rendered in one image
            for (int i = 0; i < numberOfPages; ++i) {
                BufferedImage image = pdfRenderer.renderImage(i);
//        /* DEBUG
//        File output = new File("C:\\Users\\macin\\desenv\\pdf_pag_x.png");
//        ImageIO.write(image, "png", output);

//         */

                // print the rendered image...
                new ImageHelper().write(escpos, new CoffeeImageImpl(image),new RasterBitImageWrapper(),new BitonalOrderedDither());
//                escpos.feed(2);
//                escpos.feed(3).cut(EscPos.CutMode.PART);
            }
            // put the feed here, outside the for loop, since it's after the pages are printed
            escpos.feed(2);
            escpos.feed(3).cut(EscPos.CutMode.PART);
//            escpos.feed(3).cut(EscPos.CutMode.FULL);
            document.close();
        }

    }

    // get file from resource file
    private  InputStream getURL(String fileName) {

        String strPath = fileName;
        return getClass()
                .getClassLoader()
                .getResourceAsStream(strPath);
    }


    public static void main(String[] args) throws IOException {
        if(args.length!=1){
            System.out.println("Usage: java -jar xyz.jar (\"printer name\")");
            System.out.println("Printer list to use:");
            String[] printServicesNames = PrinterOutputStream.getListPrintServicesNames();
            for(String printServiceName: printServicesNames){
                System.out.println(printServiceName);
            }

//            System.exit(0);
        }
        PrintService printService = PrinterOutputStream.getPrintServiceByName("GP-U80300 Series");
        PdfPrinting printing = new PdfPrinting();
        printing.printPdf(new PrinterOutputStream(printService));


    }

}
//        PdfReader reader = new PdfReader("test2.pdf");
//        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("test-trimmed-stamper.pdf"));
//
//// Go through all pages
//        int n = reader.getNumberOfPages();
//        for (int i = 1; i <= n; i++)
//        {
//            Rectangle pageSize = reader.getPageSize(i);
//            Rectangle rect = getOutputPageSize(pageSize, reader, i);
//
//            PdfDictionary page = reader.getPageN(i);
//            page.put(PdfName.CROPBOX, new PdfArray(new float[]{rect.getLeft(), rect.getBottom(), rect.getRight(), rect.getTop()}));
//            stamper.markUsed(page);
//        }
//        stamper.close();
//
////        PDPageContentStream contentStream = new PDPageContentStream(document,page, true, false, false);
////        contentStream.close();
//    }
//    private static Rectangle getOutputPageSize(Rectangle pageSize, PdfReader reader, int page) throws IOException
//    {
//        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
//        TextMarginFinder finder = parser.processContent(page, new TextMarginFinder());
//        Rectangle result = new Rectangle(finder.getLlx(), finder.getLly(), finder.getUrx(), finder.getUry());
//        System.out.printf("Text/bitmap boundary: %f,%f to %f, %f\n", finder.getLlx(), finder.getLly(), finder.getUrx(), finder.getUry());
//        return result;
//    }


