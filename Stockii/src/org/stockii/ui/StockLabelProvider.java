package org.stockii.ui;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.stockii.model.Stock;

public class StockLabelProvider implements ITableLabelProvider {

	@Override
	public Image getColumnImage(Object arg0, int arg1) {

		return null;
	}

	@Override
	public String getColumnText(Object item, int index) {

		Stock stock = (Stock)item;
		
		switch(index){
		case 0:
			return stock.getId();
		case 1:
			return stock.getName();
		case 2:
			return stock.getStartDate();
		case 3:
			return stock.getStartValue();
		case 4:
			return stock.getEndDate();
		case 5:
			return stock.getEndValue();
		case 6:
			return stock.getAvgValue();
		case 7:
			return stock.getSectionNum();
		}
		return null;
	}

	@Override
	public void addListener(ILabelProviderListener arg0) {

		
	}

	@Override
	public void dispose() {

		
	}

	@Override
	public boolean isLabelProperty(Object arg0, String arg1) {

		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener arg0) {

		
	}


}
