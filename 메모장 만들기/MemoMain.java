package ex9_memo;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemoMain {
	public static void main(String[] args) {
		
		// 컴포넌트를 붙힐 패널
		JPanel jp = new JPanel();
		jp.setBackground(Color.darkGray);
		jp.setLayout(null);
		
		Font font = new Font("", Font.PLAIN, 20);
		
		// 한줄을 입력할 수 있는 텍스트필드
		JTextField tf = new JTextField();
		tf.setBounds(10,15,180,30);
		tf.setFont(font);
		
		// TextFeild에 적힌 내용을 TextArea로 보내주는 버튼
		JButton btn_input = new JButton("확인");
		btn_input.setBounds(190,15,60,30);
		
		// TextFeild에 아무것도 안적혀있으면 비활성화
		btn_input.setEnabled(false);
		
		// 텍스트파일 형식으로 저장할 내용이 있는 TextArea
		JTextArea ta = new JTextArea();
		ta.setBounds(10,70,230,280);
		ta.setEditable(false);
		
		// 텍스트 파일로 수정하기 위한 버튼
		JButton btnRe = new JButton("수정");
		btnRe.setBounds(10,360,70,30);
		
		// 텍스트 파일로 저장하기 위한 버튼
		JButton btnSave = new JButton("저장");
		btnSave.setBounds(90,360,70,30);
		
		// 프로그램 종료버튼
		JButton btnClose = new JButton("종료");
		btnClose.setBounds(170,360,70,30);
		
		// 패널에 컴포넌트 붙히기
		jp.add(tf);
		jp.add(btn_input);
		jp.add(ta);
		jp.add(btnRe);
		jp.add(btnSave);
		jp.add(btnClose);
		
		// 기능
		// TextField에 값이 있는지 확인하여 '확인'버튼을 활성화 또는 비활성화
		tf.getDocument().addDocumentListener(new TextAdapter(tf,btn_input));
		
		// 엔터키 입력 감지를 위한 KeyListener 추가
        tf.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                // 엔터 키가 입력되면
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // TextArea에 텍스트 추가
                    ta.append(tf.getText() + "\n");
                    // TextField 내용 지우기
                    tf.setText("");
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
		
		// 확인버튼 클릭시 TextField의 값을 TextArea로 전달
		btn_input.addActionListener(new InputButtonAdapter(tf,ta));
		
		JFrame f = new JFrame();
		
		// 수정버튼 눌렀을 때 TextArea 활성화
		btnRe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TextArea의 현재 편집 가능 여부를 확인
		        boolean isEditable = ta.isEditable();
		        
		        // 편집 가능 여부를 토글 (반대로 변경)
		        ta.setEditable(!isEditable);
				
			}
		});
		
		// 저장버튼 눌렀을 때 TextArea의 내용을 텍스트파일로 저장
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileWriter fw = null;
				
				// 경로를 설정하는 FileDialog
				FileDialog fd = new FileDialog(f,"제목",FileDialog.SAVE);
				fd.setVisible(true);
				
				// TextArea에 쓰여진 내용을 읽어온다
				String message = ta.getText();
				
				String path = fd.getDirectory() + fd.getFile();
				System.out.println(path);
				
				try {
					fw = new FileWriter(path);
					fw.write(message);
				} catch (Exception e2) {
					// TODO: handle exception
				} finally {
					try {
						if(fw != null) {
							fw.close();
						}
					} catch (Exception e3) {
						// TODO: handle exception
					}
				}
			}
		});
		
		// 종료버튼 눌렀을 때 프로그램 종료
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose(); // 현재 프레임 종료
				
			}
		});
		
		f.add(jp);
		
		f.setBounds(700,200,270,440);
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
