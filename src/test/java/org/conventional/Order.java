package org.conventional;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	List<LineItem> items = new ArrayList<LineItem>();

	public void addLineItem(LineItem item) {
		this.items.add(item);
	}

}
