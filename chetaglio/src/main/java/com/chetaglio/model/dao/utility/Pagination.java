package com.chetaglio.model.dao.utility;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.Order;

public class Pagination {
	
	private int maxresult;
	private int firstResult;
	private List<String> orderParams;
	private List<ORDINAMENTO> versoOrdine;
	
	public Pagination(int maxresult, int firstResult, List<String> orderParams, List<ORDINAMENTO> versoOrdine){
		this.maxresult = maxresult;
		this.firstResult = firstResult;
		this.orderParams = orderParams;
		this.versoOrdine = versoOrdine;
	}
	
	public int getMaxresult() {
		return maxresult;
	}

	public void setMaxresult(int maxresult) {
		this.maxresult = maxresult;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public List<String> getOrderParams() {
		return orderParams;
	}

	public void setOrderParams(List<String> orderParams) {
		this.orderParams = orderParams;
	}

	public List<ORDINAMENTO> getVersoOrdine() {
		return versoOrdine;
	}

	public void setVersoOrdine(List<ORDINAMENTO> versoOrdine) {
		this.versoOrdine = versoOrdine;
	}
	
	public List<Order> getOrders(){
		List<Order> list = new ArrayList<Order>();
		
		if(!CollectionUtils.isEmpty(this.getOrderParams()) && !CollectionUtils.isEmpty(this.getVersoOrdine()) && this.getOrderParams().size() == this.getVersoOrdine().size()){
			for(int i = 0; i < this.getOrderParams().size(); i++){
				Order order;
				if(this.getVersoOrdine().get(i).getValue().equals("asc")){
					order = Order.asc(this.getOrderParams().get(i));
				}else{
					order = Order.desc(this.getOrderParams().get(i));
				}
				list.add(order);
			}
		}
			
		return list;
	}

}