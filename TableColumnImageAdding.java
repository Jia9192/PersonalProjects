import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class TableColumnImageAdding {

  public static void main(String[] args) {
    final Display display = new Display();
    
    Image checkedImage = new Image(display,"yourFile.gif");
    Image uncheckedImage = new Image(display,"yourFile.gif");
    
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());
    final Table table = new Table(shell, SWT.BORDER);
    TableColumn column1 = new TableColumn(table, SWT.NONE);
    TableColumn column2 = new TableColumn(table, SWT.NONE);
    TableColumn column3 = new TableColumn(table, SWT.NONE);
    
    TableItem item1 = new TableItem(table, SWT.NONE);
    item1.setText(new String[] { "first item", "Image 1", "Image 2" });
    item1.setImage(1, uncheckedImage);
    item1.setImage(2, uncheckedImage);

    column1.pack();
    column2.pack();
    column3.pack();

    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    checkedImage.dispose();
    uncheckedImage.dispose();
    display.dispose();
  }

}