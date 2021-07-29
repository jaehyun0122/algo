package News;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class NewsUi extends JFrame {

		JButton button = null;
		JTable table = null;
		
		DefaultTableModel model = null;
	
	public static void main(String[] args) {

		  NewsUi ui = new NewsUi();
	        ui.launchUi();
	    }

	    private void launchUi() {
	        button = new JButton("읽기");

	        // 테이블 구성
	        table = new JTable();
	        String[] header = {"제목", "설명", "기사", "guid","코멘트", "발행일", "최종수정일"};
	        model = (DefaultTableModel) table.getModel();
	        model.setColumnIdentifiers(header);

	        // 이벤트 listener 등록 처리
	        addEventListener();

	        // 요소 배치lastBuildDate
	        this.add(new JScrollPane(table), BorderLayout.CENTER);
	        this.add(button, BorderLayout.SOUTH);

	        this.setTitle("뉴스 정보");
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setSize(500, 300);
	        this.setVisible(true);
	    }

	    private void addEventListener() {
	        button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // 기존 자료 삭제
	                model.setRowCount(0);
	                // 새로운 자료 조회
	                NewsDomParser parser = new NewsDomParser();
	                List<News> list = parser.getNews();
	                for (News info : list) {
	                    model.addRow(new Object[] {info.getTitle(), info.getDescription(), 
	                    		info.getAuthor(),info.getGuid(),info.getComment(), info.getPubDate(), info.getLastBD()});
	                }
	                // model의 데이터가 변경되었음을 알림
	                model.fireTableDataChanged();
	            }
	        });

	        // TODO:테이블에서 발생하는 click event 처리를 위한 listener 등록
	        table.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                int row = table.getSelectedRow();
	                String nm = model.getValueAt(row, 1).toString();
	                JOptionPane.showMessageDialog(NewsUi.this, "선택된 요소: " +
	                                                                nm);
	            }
	        });
	        // END:
	}

}
