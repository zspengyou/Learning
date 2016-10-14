package utils;

import java.util.ArrayList;

public class ListCompress {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < 4; i++){
			for (int j = 0; j < i; j++){
				list.add("" + i);
			}
		}
		ArrayList<String> result = new ArrayList<String>();
		System.out.println(list);
		int count = 0;
		String pre = list.get(0);
		for(String tag: list){
			if(pre.equals(tag)){
				count ++;
			}else{
				result.add(pre + count);
				count = 1;
				pre = tag;
			}
		}
		result.add(pre+count);
		System.out.println(result);

	}

}
