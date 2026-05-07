import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

// ELEMENT

interface DocumentElement{
  String render();
}

class TextElement implements DocumentElement{
  private String text;
  public TextElement(String text){
    this.text = text;
  }
  public String render(){
    return text;
  }
}

class ImageElement implements DocumentElement{
  private String imagePath;
  public ImageElement(String imagePath){
    this.imagePath = imagePath;
  } 
  public String render(){
    return "[Image: " + imagePath + "]";
  }
}

class NewLineElement implements DocumentElement{
  public String render(){
    return "\n";
  }
}

class TabSpaceElement implements DocumentElement {
    @Override
    public String render() {
        return "\t";
    }
}

// MODEL

class Document{
  private List<DocumentElement> elements = new ArrayList<>();

  public void addElement(DocumentElement element){
    elements.add(element);
  }

  public List<DocumentElement> getElements(){
    return elements;
  }
}

// RENDERER

class DocumentRenderer{
  public String render(Document document){
    StringBuilder result = new StringBuilder();
    for(DocumentElement element : document.getElements()){
      result.append(element.render());
    }
    return result.toString();
  }
}

// PERSISTENCE

interface Persistence{
  void save(String data);
}

class FileStorage implements Persistence{
  public void save(String data){
    try{
      FileWriter writer = new FileWriter("document.txt");
      writer.write(data);
      writer.close();
      System.out.println("Document saved to document.txt");
    }catch(IOException e){
      System.out.println("Error saving file"+e);
    }
  }
}

class MySQLStorage implements Persistence{
  public void save(String data){
    System.out.println("Saving document to database...");
  }
}

// Document Editor
class DocumentEditor{
  private Document document;
  private Persistence storage;
  private DocumentRenderer renderer;
  public DocumentEditor(Document document, Persistence storage,DocumentRenderer renderer){
              this.document = document;
              this.storage = storage;
              this.renderer = renderer;
            }

  public void addText(String text){
    document.addElement(new TextElement(text));
  }
  public void addImage(String imagePath){
    document.addElement(new ImageElement(imagePath));
  }
  public void addNewLine() {
    document.addElement(new NewLineElement());
  }
  public void addTabSpace() {
    document.addElement(new TabSpaceElement());
  }

  public String renderDocument(){
    return renderer.render(document);
  }
  public void saveDocument(){
    String renderedData = renderDocument();
    storage.save(renderedData);
  }
}

public class AppDocsEditor{
  public static void main(String[] args) {
    Document document = new Document();
    Persistence storage = new FileStorage();
    DocumentRenderer renderer = new DocumentRenderer();

    DocumentEditor editor = new DocumentEditor(document, storage, renderer);

    editor.addText("Hello World");
    editor.addNewLine();
    editor.addText("This is document editor example.");
    editor.addNewLine();
    editor.addTabSpace();
    editor.addText("Indented line.");
    editor.addNewLine();
    editor.addImage("cat.png");
    String output = editor.renderDocument();
    System.out.println(output);

    editor.saveDocument();
  }
}
