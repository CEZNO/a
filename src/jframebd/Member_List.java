package jframebd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Member_List extends JFrame implements MouseListener, ActionListener {

	Vector v;
	Vector cols;
	DefaultTableModel model;
	JTable jTable;
	JScrollPane pane;
	JPanel pbtn;
	JButton  btnSearch;
	JComboBox combo;

	MemberDAO dao = new MemberDAO();
	JTextField jtf;
	

	public Member_List() {
		super("회원관리 프로그램  v0.1.1");
		MemberDAO dao = new MemberDAO();
		v = dao.getMemberList();
		System.out.println("v=" + v);
		cols = getColumn();
		System.out.println(cols);

		model = new DefaultTableModel(v, cols);

		jTable = new JTable(model);
		pane = new JScrollPane(jTable);
		add(pane);

		pbtn = new JPanel();
		pbtn.setBackground(Color.orange);
		add(pbtn, BorderLayout.NORTH);

		JPanel p = new JPanel();
		String[] comboName = { "NAME+ID", " NAME  ", " ID ", };
		combo = new JComboBox(comboName);

		btnSearch = new JButton("검색");
		jtf = new JTextField(20);
		p.add(combo);
		p.add(jtf);
		p.setBackground(Color.orange);
		p.add(btnSearch);
		add(p, BorderLayout.SOUTH);

		jTable.addMouseListener(this); // 리스너 등록
		btnSearch.addActionListener(this); // 검색 버튼 리스너 등록

		setSize(600, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 dao.userSelectAll(model);
		 jTableRefresh2();
          if (model.getRowCount() > 0)
              jTable.setRowSelectionInterval(0, 0);
				
	}// end 생성자

	// JTable의 컬럼
	public Vector getColumn() {
		Vector col = new Vector();
		col.add("번호");
		col.add("이름");
		col.add("아이디");
		col.add("비밀번호");

		return col;
	}// getColumn

	public static void main(String[] args) {
		
				new Member_List();
		
	}// main

	@Override
	public void mouseClicked(MouseEvent e) {
		// mouseClicked 만 사용
		int r = jTable.getSelectedRow();
		int num = (int) jTable.getValueAt(r, 0);
		MemberProc mem = new MemberProc(num, this); // 아이디를 인자로 수정창 생성

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	// Jtable 내용 갱신 메서드2
	public void jTableRefresh2() {

		MemberDAO dao = new MemberDAO();
		DefaultTableModel model = new DefaultTableModel(dao.getMemberList(), getColumn());

	}

	@Override
	public void actionPerformed(ActionEvent d) {
		// 버튼을 클릭하면
		 if (d.getSource() == btnSearch) { // 검색 버튼 클릭
			String fieldName = combo.getSelectedItem().toString();
			System.out.println("필드명 " + fieldName);
			
			if (fieldName.trim().equals("NAME+ID")) {// 전체검색
				if (jtf.getText().trim().equals("")) {
					MemberProc.messageBox(this, "검색단어를 입력해주세요!");
					jTableRefresh2();
					dao.userSelectAll(model);
					jtf.requestFocus();
				} else { // 검색어를 입력했을경우
					dao.getUserSearch2(model, jtf.getText());
					if (model.getRowCount() > 0)
						jTable.setRowSelectionInterval(0, 0);
				}
				
//				 dao.userSelectAll(model);
//				 jTableRefresh2();
	              if (model.getRowCount() > 0)
	                  jTable.setRowSelectionInterval(0, 0);

			} else {
				if (jtf.getText().trim().equals("")) {
					MemberProc.messageBox(this, "검색단어를 입력해주세요!");
					jTableRefresh2();
					dao.userSelectAll(model);
					jtf.requestFocus();
				} else {// 검색어를 입력했을경우
					dao.getUserSearch(model, fieldName, jtf.getText());
					if (model.getRowCount() > 0)
						jTable.setRowSelectionInterval(0, 0);

				}
			}
		}
	}
}