/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2020 iText Group NV
    Authors: iText Software.

    For more information, please contact iText Software at this address:
    sales@itextpdf.com
 */
/**
 * Example written by Bruno Lowagie and Nishanthi Grashia in answer to the following question:
 * http://stackoverflow.com/questions/33440294/create-table-in-itext-pdf-in-java
 */
package com.itextpdf.samples.sandbox.tables;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;

import java.io.File;

public class RightCornerTable {
    public static final String DEST = "./target/sandbox/tables/right_corner_table.pdf";

    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new RightCornerTable().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc, new PageSize(300, 300));
        doc.setMargins(0, 0, 0, 0);

        Table table = new Table(UnitValue.createPercentArray(1)).useAllAvailableWidth();
        table.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        table.setWidth(90);

        Cell cell = new Cell().add(new Paragraph(" Date").setFontColor(ColorConstants.WHITE));
        cell.setBackgroundColor(ColorConstants.BLACK);
        cell.setBorder(new SolidBorder(ColorConstants.GRAY, 2));
        table.addCell(cell);

        Cell cellTwo = new Cell().add(new Paragraph("10/01/2015"));
        cellTwo.setBorder(new SolidBorder(2));
        table.addCell(cellTwo);

        doc.add(table);

        doc.close();
    }
}