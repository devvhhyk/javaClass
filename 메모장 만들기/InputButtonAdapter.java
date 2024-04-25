package ex9_memo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InputButtonAdapter implements ActionListener{
	
	JTextField tf;
	JTextArea ta;
	
	public InputButtonAdapter(JTextField tf, JTextArea ta) {
		this.tf = tf;
		this.ta = ta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TextField의 내용을 getText()해서
		String word = tf.getText();
		// TextArea로 setText()를 해준다
//		ta.setText(word);
		ta.append(word+"\n");
		// TextField의 내용은 비운다
		tf.setText("");
	}

}
