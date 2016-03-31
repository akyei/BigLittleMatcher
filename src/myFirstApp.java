



import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;

import org.eclipse.swt.widgets.Button;

public class myFirstApp {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			myFirstApp window = new myFirstApp();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(585, 386);
		shell.setText("SWT Application");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(39, 51, 469, 19);
		
		Label lblGoogleSheetsUrl = new Label(shell, SWT.NONE);
		lblGoogleSheetsUrl.setBounds(39, 31, 113, 14);
		lblGoogleSheetsUrl.setText("Google Sheets URL");
		
		Button button = new Button(shell, SWT.RADIO);
		button.setBounds(10, 51, 22, 18);
		
		
		
		
		
		Button btnGo = new Button(shell, SWT.NONE);
		btnGo.setBounds(251, 336, 94, 28);
		btnGo.setText("Go");
		shell.pack();
		
		
		shell.open();
		
		

	}
}
