package edu.hometask.androidclientsc;

import java.util.ArrayList;

public class Order
{
	private ArrayList<String> arrList;
	
	private String numberTitle;
	private int id;
	
	private String dateTitle;
	private String date;
	
	private String clientTitle;
	private String client;
	
	private String contactTitle;
	private String contact;
	
	private String phoneTitle;
	private String phone;
	
	private String deviceTitle;
	private String device;
	
	private String snTitle;
	private String sn;
	
	private String typeRepairTitle;
	private String typeRepair;
	
	private String defectTitle;
	private String defect;
	
	private String completenessTitle;
	private String completeness;
	
	private String engineerTitle;
	private String engineer;
	
	private String resultTitle;
	private String result;
	
	private String priceTitle;
	private String price;
	
	private String statusTitle;
	private String status;
	
	public Order() 
	{
		
	}

	public String getNumberTitle() 
	{
		return numberTitle;
	}

	public void setNumberTitle(String numberTitle) 
	{
		this.numberTitle = numberTitle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateTitle() {
		return dateTitle;
	}

	public void setDateTitle(String dateTitle) {
		this.dateTitle = dateTitle;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getClientTitle() {
		return clientTitle;
	}

	public void setClientTitle(String clientTitle) {
		this.clientTitle = clientTitle;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getContactTitle() {
		return contactTitle;
	}

	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhoneTitle() {
		return phoneTitle;
	}

	public void setPhoneTitle(String phoneTitle) {
		this.phoneTitle = phoneTitle;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDeviceTitle() {
		return deviceTitle;
	}

	public void setDeviceTitle(String deviceTitle) {
		this.deviceTitle = deviceTitle;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getSnTitle() {
		return snTitle;
	}

	public void setSnTitle(String snTitle) {
		this.snTitle = snTitle;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getTypeRepairTitle() {
		return typeRepairTitle;
	}

	public void setTypeRepairTitle(String typeRepairTitle) {
		this.typeRepairTitle = typeRepairTitle;
	}

	public String getTypeRepair() {
		return typeRepair;
	}

	public void setTypeRepair(String typeRepair) {
		this.typeRepair = typeRepair;
	}

	public String getDefectTitle() {
		return defectTitle;
	}

	public void setDefectTitle(String defectTitle) {
		this.defectTitle = defectTitle;
	}

	public String getDefect() {
		return defect;
	}

	public void setDefect(String defect) {
		this.defect = defect;
	}

	public String getCompletenessTitle() {
		return completenessTitle;
	}

	public void setCompletenessTitle(String completenessTitle) {
		this.completenessTitle = completenessTitle;
	}

	public String getCompleteness() {
		return completeness;
	}

	public void setCompleteness(String completeness) {
		this.completeness = completeness;
	}

	public String getEngineerTitle() {
		return engineerTitle;
	}

	public void setEngineerTitle(String engineerTitle) {
		this.engineerTitle = engineerTitle;
	}

	public String getEngineer() {
		return engineer;
	}

	public void setEngineer(String engineer) {
		this.engineer = engineer;
	}

	public String getResultTitle() {
		return resultTitle;
	}

	public void setResultTitle(String resultTitle) {
		this.resultTitle = resultTitle;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getPriceTitle() {
		return priceTitle;
	}

	public void setPriceTitle(String priceTitle) {
		this.priceTitle = priceTitle;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStatusTitle() {
		return statusTitle;
	}

	public void setStatusTitle(String statusTitle) {
		this.statusTitle = statusTitle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<String> createArrList()
	{
		arrList = new ArrayList<String>();
		
		String str = numberTitle +": " + Integer.toString(id);
		arrList.add(str);
		
		str = dateTitle +": " + date;
		arrList.add(str);
		
		str = clientTitle +": " + client;
		arrList.add(str);
		
		str = contactTitle +": " + contact;
		arrList.add(str);
		
		str = phoneTitle +": " + phone;
		arrList.add(str);
		
		str = deviceTitle +": " + device;
		arrList.add(str);
		
		str = snTitle +": " + sn;
		arrList.add(str);
		
		str = typeRepairTitle +": " + typeRepair;
		arrList.add(str);
		
		str = defectTitle +": " + defect;
		arrList.add(str);
		
		str = completenessTitle +": " + completeness;
		arrList.add(str);
		
		str = engineerTitle +": " + engineer;
		arrList.add(str);
		
		str = resultTitle +": " + result;
		arrList.add(str);
		
		str = priceTitle +": " + price;
		arrList.add(str);
		
		str = statusTitle +": " + status;
		arrList.add(str);
		
		return arrList;
	}
	
	
}
