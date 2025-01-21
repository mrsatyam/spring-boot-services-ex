package com.axisbank.limit.Utility;

import java.util.Collection;

import com.axisbank.limit.dto.CustomPaginator;
import com.axisbank.limit.dto.Paginator;
import com.axisbank.limit.exception.AxisException;

public class CustomPaginationUtility {

	public static CustomPaginator pagination(CustomPaginator customPaginator ,Collection<?> content, Paginator paginator, Integer totalElement)
			throws AxisException {
		if(content !=null && totalElement !=null && totalElement > 0 ) {
			if (paginator.getStartIndex() == 0)
				customPaginator.setFirst(true);
			else
				customPaginator.setFirst(false);

			if (paginator.getEndIndex() >= totalElement)
				customPaginator.setLast(true);
			else
				customPaginator.setLast(false);

			customPaginator.setPage(paginator.getPage());
			customPaginator.setNumberOfElements(content.size());
			customPaginator.setPageSize(paginator.getPageSize());
			customPaginator.setContent(content);
			customPaginator.setTotalElements(totalElement);
			float totalPages = (float) totalElement / paginator.getPageSize();
			int nextPageCheck = Math.round(totalPages);
			if (totalPages > nextPageCheck)
				nextPageCheck++;

			customPaginator.setTotalPages(nextPageCheck);
		}
		
		return customPaginator;
	}
}
