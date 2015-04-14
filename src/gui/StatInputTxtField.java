package gui;
import javax.swing.JTextField;

public final class StatInputTxtField {
	/**
	 * @wbp.factory
	 */
	public static JTextField createInputTextField() {
		JTextField textField = new JTextField();
		textField.setColumns(1);
		return textField;
	}
}