package javaSe_Comprehensive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
（1）	在工程下创建goods.txt文件，内容如下
笔记本	4000	电子设备
三星手机	2700	电子设备
钢琴	14000	音乐器材
古筝	3000	音乐器材
古筝	3000	音乐器材
 （2）	分行读取good.txt文件内容，将每行数据存入集合
 （3）	遍历集合，在控制台输出
 （4）	统计里面音乐器材和电子设备的数量输出
 （5）	将 读取的每项数据分离，将分离的数据分别封装到对应的商品对象中。
 （6）	将封装的商品对象去重，添加到一个集合中，并遍历数据商品名称和价格。
 */
public class Reader_Goods_Split_String {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new FileReader("Goods.txt"));
		ArrayList<String> aRead = new ArrayList<>();
		int count =0;
		ArrayList<Goods> aGoods= new ArrayList<>();
		String line= null;
		while( (line=br.readLine()) != null) {
			aRead.add(line);
			count++;
		}
		for(String stringLine:aRead) {
			System.out.println(stringLine);
		}
		System.out.println("count= "+ count);
		br.close();
		String regex="	";
		for(int x=0;x<aRead.size();x++) {
			int y=0;
			String[] split= aRead.get(x).split(regex);
			
				Goods goods= new Goods();
				goods.setDiyName(split[y]);
				goods.setName(split[y+2]);
				goods.setPrice(Integer.valueOf(split[y+1]));
				aGoods.add(goods);
		}
		for(int x=0;x<aGoods.size()-1;x++) {
			for(int y=x+1;y<aGoods.size();y++) {
				if(aGoods.get(x).equals(aGoods.get(y))) {
					aGoods.remove(y);
					y--;
				}
			}
		}
	}
}

class Goods{
	String name;
	int price;
	String diyName;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diyName == null) ? 0 : diyName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goods other = (Goods) obj;
		if (diyName == null) {
			if (other.diyName != null)
				return false;
		} else if (!diyName.equals(other.diyName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Goods [name=" + name + ", price=" + price + ", diyName=" + diyName + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDiyName() {
		return diyName;
	}
	public void setDiyName(String diyName) {
		this.diyName = diyName;
	}
	
}
