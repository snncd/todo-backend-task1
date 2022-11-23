package com.snn.todobackendtask1.decorater;

public class WordPresentation {
    public static void main(String[] args) {

        Document doc = new PdfDocument();

        PdfDocument pdfDoc = new PdfDocument();

        Document decorePdfDocumnet = new RedColor(pdfDoc);

    }

}


interface Document{
    void print();
}
class PdfDocument implements Document{

    @Override
    public void print() {
        System.out.println("Pdf Doc");
    }

    public void draw(){
        System.out.println("draw");
    }
}

abstract class DocumentDecoreter implements Document{
    protected Document document;

    public DocumentDecoreter(Document document) {
        this.document = document;
    }

    @Override
    public void print(){
        document.print();
    }
}
class RedColor extends DocumentDecoreter{

    public RedColor(Document document) {
        super(document);
    }
    @Override
    public void print(){
        document.print();
        redColor();
    }

    public void redColor(){
        System.out.println("Red document");
    }

}