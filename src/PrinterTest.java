import com.github.anastaciocintra.escpos.EscPos;
import com.github.anastaciocintra.escpos.EscPos.CharacterCodeTable;
import com.github.anastaciocintra.escpos.EscPosConst;
import com.github.anastaciocintra.escpos.Style;
import com.github.anastaciocintra.output.PrinterOutputStream;
import com.github.anastaciocintra.escpos.image.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;

class CodeTableSample {

    public void Sample(String printerName){

        // get the printer service by name passed on command line...
        //this call is slow, try to use it only once and reuse the PrintService variable.
        PrintService printService = PrinterOutputStream.getPrintServiceByName(printerName);
        EscPos escpos;
        try {
            escpos = new EscPos(new PrinterOutputStream(printService));

            Style title = new Style()
                    .setFontSize(Style.FontSize._2, Style.FontSize._2)
                    .setJustification(EscPosConst.Justification.Center);

            escpos.write("鸡");
            escpos.feed(2);

            printCodeTable(escpos, 25, 128, 130);



            escpos.close();

        } catch (IOException ex) {
            Logger.getLogger(CodeTableSample.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    void printCodeTable(EscPos escpos, int codeTable, int codMin, int codMax) throws IOException {
        escpos.setCharacterCodeTable(EscPos.CharacterCodeTable.CP437_USA_Standard_Europe);
        escpos.writeLF(String.format("character code table for code [%d], " +
                "\nbetween %d and %d", codeTable,codMin, codMax));
        escpos.setCharacterCodeTable(EscPos.CharacterCodeTable.Katakana);
        for(int code = codMin; code <= codMax; code++){
            escpos.write(code);
            escpos.write("  ");

        }
        escpos.writeLF("");
        escpos.feed(5).cut(EscPos.CutMode.FULL);

    }
    public static void main(String[] args) {
        if(args.length!=1){
            System.out.println("Usage: java -jar xyz.jar (\"printer name\")");
            System.out.println("Printer list to use:");
            String[] printServicesNames = PrinterOutputStream.getListPrintServicesNames();
            for(String printServiceName: printServicesNames){
                System.out.println(printServiceName);
            }

//            System.exit(0);
        }
        CodeTableSample obj = new CodeTableSample();
        obj.Sample("GP-U80300 Series");

    }

}


public class PrinterTest {

}
//https://github.com/anastaciocintra/escpos-coffee