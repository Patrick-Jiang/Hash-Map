package hashMap;

import java.io.*;
import java.util.*;

public class Adventure {
	private HashMap<StringKey, Item> map = new HashMap<>();

	public Adventure(String fileName) {

		if (fileName == null) {
			throw new IllegalArgumentException("Invalid fileName.");
		}

		File file = new File(fileName);

		if (!file.exists()) {
			throw new IllegalArgumentException("Invalid fileName.");
		}

		String line;
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				String[] lineValues = line.split(",");

				String name = lineValues[0].trim();
				int value = Integer.parseInt(lineValues[1].trim());
				double weight = Double.parseDouble(lineValues[2].trim());

				Item item = new Item(name, value, weight);
				StringKey key = new StringKey(item.getName());

				map.put(key, item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap getMap() {
		return map;
	}

	public String printLootMap() {
		Iterator items = map.values();
		String lootMap = "";
		ArrayList<Item> itemList = new ArrayList<>();

		while (items.hasNext()) {
			itemList.add((Item) items.next());
		}

		Collections.sort(itemList);

		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getGoldPieces() > 0) {
				Item currentItem = itemList.get(i);
				String line = currentItem.toString() + "\n";
				System.out.print(line);
				lootMap += line;
			}
		}

		return lootMap;
	}

}