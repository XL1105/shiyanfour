

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class main {
	static Scanner in = new Scanner(System.in);
	static Map<String, Integer> wordsCount = new TreeMap<String, Integer>();
	public static void main(String[] args) throws IOException {
		// ��ȡ�ļ�
		String filename = "src/harrypotter.txt";
		FileReader fk = new FileReader(filename);
		BufferedReader br = new BufferedReader(fk);
		// ���б�洢���˺󵥴�
		List<String> ls = new ArrayList<String>();
		String readLine = null;
		while ((readLine = br.readLine()) != null) {
			// ���˳�ֻ������ĸ��
			String[] correctword = readLine.split("[^a-zA-Z]");
			for (String word : correctword) {
				// ȥ������Ϊ0����
				if (word.length() != 0) {
					ls.add(word);
				}
			}
		}
		br.close();
		// �洢���ʼ�����Ϣ��keyֵΪ���ʣ�valueΪ���������Ե��ʵĴ�Ƶͳ��
		for (String li : ls) {
			if (wordsCount.get(li) != null) {
				wordsCount.put(li, wordsCount.get(li) + 1);
			} else {
				wordsCount.put(li, 1);
			}
		}
		// Map��������(sort by key)
		Map<String, Integer> resMap = sortMapByKey(wordsCount);
		for (Map.Entry<String, Integer> entry : resMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		// 
		// for (Map.Entry<String, String> entry : resultMap.entrySet()) {
		// System.out.println(entry.getKey() + " " + entry.getValue()); }
		//
		//(Map<key,value>)
		File file = new File("result.txt");
		try {
			if (file.exists()) {
				file.createNewFile();
			}
			// ��������������·����
			// FileWriter ff = new FileWriter(file.getAbsoluteFile());
			// ����������src��
			FileWriter ff = new FileWriter(file.getCanonicalFile());
			for (Entry<String, Integer> entry : resMap.entrySet()) {
				ff.write(entry.getKey() + "/" + entry.getValue() + "    " + "\n");
			}
			ff.close();
			System.out.println("ͳ�����");
			// System.out.println(file.getAbsoluteFile());
			// System.out.println(file.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("�ܵ�����Ϊ��" + file.length());
		System.out.println("�Ѿ�������е��ʼ���Ƶ��result.txt");
		System.out.println("ѡ�����������˽��");
		System.out.println("1:��������Ҫ��ѯ�ĵ��ʴ�Ƶ:");
		System.out.println("2:�����Ƶ��ߵ�ǰN������:");
		System.out.println("3:ͳ��ÿ�е�ÿ�����ʵ�����:");
		System.out.println("4:ͳ�Ƹ��ı��ĵ�������:");
		int num = in.nextInt();
		while (num != 0) {
			switch (num) {
			case 1:
				long startTime1=System.currentTimeMillis();
				Find ww = new Find();
		    	String [] ss = ww.find(wordsCount);
		    	Find f = new Find(ss,wordsCount);
		    	f.setVisible(true);
				long endTime1=System.currentTimeMillis();
				//double time1=(endTime1-startTime1)/1000;
				long time1=endTime1-startTime1;
				System.out.println("����1ʵ�ֵ����е�ʱ��Ϊ��"+time1+"����");
				break;
			case 2: 
				long startTime2=System.currentTimeMillis();
				Valuesort vs = new Valuesort();
				vs.valuesort(wordsCount);
				long endTime2=System.currentTimeMillis();
				long time2=endTime2-startTime2;
				System.out.println("����2ʵ�ֵ����е�ʱ��Ϊ��"+time2+"����");
				break;
			case 3: 
				//ʵ��ͳ��ÿһ�еĵ�������
				long startTime3=System.currentTimeMillis();
				SortWords sortword=new SortWords();
				sortword.SortWords();
				long endTime3=System.currentTimeMillis();
				long time3=endTime3-startTime3;
				System.out.println("����3ʵ�ֵ����е�ʱ��Ϊ��"+time3+"����");
				break;
			case 4: 
				//ʵ��ͳ���ı��ĵ�������
				long startTime4=System.currentTimeMillis();
				//EnterCount ec=new EnterCount();
				//ec.
				EnterCount entercount=new EnterCount();
				entercount.enterCount();
				long endTime4=System.currentTimeMillis();
				long time4=endTime4-startTime4;
				System.out.println("����4ʵ�ֵ����е�ʱ��Ϊ��"+time4+"����");
				break;
			}
			System.out.println("�ٴ�ѡ����Ҫ�˽�ģ�");
			num = in.nextInt();
			if (num > 4) {
				System.out.println("��������ȷ�������");
			}
		}

	}

	// �� Map��key��������
	public static Map<String, Integer> sortMapByKey(Map<String, Integer> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}
		Map<String, Integer> sortMap = new TreeMap<String, Integer>(new MapKeyComparator());
		sortMap.putAll(map);
		return sortMap;

	}
	private void sort(Map<String, Integer> map, int i) {
	}

}
//ʵ��һ���Ƚ�����

class MapKeyComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		return s1.compareTo(s2); // ��С��������
		//������õĵ��ʼ���Ӧ�Ĵ�Ƶ�ŵ��ļ���    
}		
}