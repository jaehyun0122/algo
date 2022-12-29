package practice;
import java.util.*;

import jxl.*;

import java.io.*;
public class ExcelRead {

	public static void main(String[] args) {
        list = new ArrayList<DongInfo>();
        File f = new File("C:/Users/jaehyun/Downloads/dong.xls");
        Workbook wb = null;
        
		try {
			wb = Workbook.getWorkbook(f);
			Sheet s4 = wb.getSheet(0);
			for(int idx=0; idx<5048; idx++) {
				if(idx == 0) continue;
				// 필요없는 컬럼 패스
				String sido=""; String gugun=""; String dong=""; String code="";
				for(int j=0; j<6; j++) {
					Cell cell = s4.getCell(j,idx);
					if(j == 0 || j== 2) continue;
					if(j==1) sido = cell.getContents();
					if(j==3) gugun = cell.getContents();
					if(j==4) code = cell.getContents();
					if(j==5) dong = cell.getContents();
				}
				list.add(new DongInfo(code, sido, gugun, dong));
			}
			write();
			
		}catch (Exception e) {
//			System.out.println("엑셀 파일 읽기 실패 ERR : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	static ArrayList<DongInfo> list;
	static String[] cityArr = {
			"서울특별시",
			"부산광역시",
			"대구광역시",
			"인천광역시",
			"광주광역시",
			"대전광역시",
			"울산광역시",
			"세종특별자치시",
			"제주특별자치도",
	};
	static Set s = new HashSet<>(Arrays.asList(cityArr));
	
	static boolean check(String city) {
		
		if(s.contains(city)) return false;
		return true;
	}
	
	static void write() throws IOException {
		String end = ");";
		File file = new File("C:/Users/jaehyun/Downloads/sido.txt");
		
		FileWriter fw = new FileWriter(file);
		BufferedWriter writer = new BufferedWriter(fw);
		
		for(DongInfo data : list) {
			String query = "insert into city_info(sido_code, sido_name, gugun_name, dong_name) values(";
			query += data.code+", "+"\""+data.sido+"\""+", "+"\""+data.gugun+"\""+", "+"\""+data.dong+"\""+end;
			writer.write(query);
			writer.write("\n");
		}
		writer.close();
	}
	
	static class DongInfo {

		private String code;
		private String sido;
		private String gugun;
		private String dong;
		
		public DongInfo(String code, String sido, String gugun, String dong) {
			this.code = code;
			this.sido = sido;
			this.gugun = gugun;
			this.dong = dong;
		}
	}
}