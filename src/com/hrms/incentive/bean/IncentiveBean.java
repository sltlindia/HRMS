package com.hrms.incentive.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.YearBean;

@Entity
@Table(name = "incentive_tbl")
public class IncentiveBean {

	private int incentive_id;
	private String po_date;
	private String sjo_date;
	private String inv_date;
	private String customer;
	private String scope;
	private String remarks;
	private double basic_price;
	private double discount;
	private double quotation_price;
	private String project_code;
	private String new_repeat;
	private double deduction;
	private double net_basic;
	private double additional_accesories;
	private double slab;
	private double amount;
	private double invoice_amount;
	private String invoice_no;
	private String incentive_status;
	private String customer_code;
	private double eligible_incentive_percentage;
	private String eligible_insentive_save;

	private MonthBean monthBean;
	private YearBean yearBean;
	private SalespersonBean salespersonBean;
	private ZoneBean zoneBean;
	private ProductMasterBean productMasterBean;
	private ClassificationBean classificationBean;
	private LaserMasterBean laserMasterBean;

	public IncentiveBean() {
		super();
	}

	public IncentiveBean(int incentive_id, String po_date, String sjo_date, String inv_date, String customer,
			String scope, String remarks, double basic_price, double discount, double quotation_price,
			String project_code, MonthBean monthBean, YearBean yearBean, SalespersonBean salespersonBean,
			ZoneBean zoneBean, ProductMasterBean productMasterBean, ClassificationBean classificationBean,
			LaserMasterBean laserMasterBean) {
		super();
		this.incentive_id = incentive_id;
		this.po_date = po_date;
		this.sjo_date = sjo_date;
		this.inv_date = inv_date;
		this.customer = customer;
		this.scope = scope;
		this.remarks = remarks;
		this.basic_price = basic_price;
		this.discount = discount;
		this.quotation_price = quotation_price;
		this.project_code = project_code;
		this.monthBean = monthBean;
		this.yearBean = yearBean;
		this.salespersonBean = salespersonBean;
		this.zoneBean = zoneBean;
		this.productMasterBean = productMasterBean;
		this.classificationBean = classificationBean;
		this.laserMasterBean = laserMasterBean;
	}

	public IncentiveBean(String po_date, String sjo_date, String inv_date, String customer, String scope,
			String remarks, double basic_price, double discount, double quotation_price, String project_code,
			MonthBean monthBean, YearBean yearBean, SalespersonBean salespersonBean, ZoneBean zoneBean,
			ProductMasterBean productMasterBean, ClassificationBean classificationBean, LaserMasterBean laserMasterBean,
			String new_repeat, double deduction, double net_basic, double additional_accesories, double slab,
			double amount, String invoice_no, String incentive_status,String customer_code,double eligible_incentive_percentage,
			String eligible_insentive_save,double invoice_amount) {
		super();
		this.po_date = po_date;
		this.sjo_date = sjo_date;
		this.inv_date = inv_date;
		this.customer = customer;
		this.scope = scope;
		this.remarks = remarks;
		this.basic_price = basic_price;
		this.discount = discount;
		this.quotation_price = quotation_price;
		this.project_code = project_code;
		this.monthBean = monthBean;
		this.yearBean = yearBean;
		this.salespersonBean = salespersonBean;
		this.zoneBean = zoneBean;
		this.productMasterBean = productMasterBean;
		this.classificationBean = classificationBean;
		this.laserMasterBean = laserMasterBean;
		this.new_repeat = new_repeat;
		this.deduction = deduction;
		this.net_basic = net_basic;
		this.additional_accesories = additional_accesories;
		this.slab = slab;
		this.amount = amount;
		this.invoice_no = invoice_no;
		this.incentive_status = incentive_status;
		this.customer_code = customer_code;
		this.eligible_incentive_percentage = eligible_incentive_percentage;
		this.eligible_insentive_save = eligible_insentive_save;
		this.invoice_amount = invoice_amount;
	}
	
	
	
	

	/**
	 * @param incentive_id
	 * @param po_date
	 * @param sjo_date
	 * @param inv_date
	 * @param customer
	 * @param scope
	 * @param remarks
	 * @param basic_price
	 * @param discount
	 * @param quotation_price
	 * @param project_code
	 * @param new_repeat
	 * @param deduction
	 * @param net_basic
	 * @param additional_accesories
	 * @param slab
	 * @param amount
	 * @param invoice_no
	 * @param incentive_status
	 * @param monthBean
	 * @param yearBean
	 * @param salespersonBean
	 * @param zoneBean
	 * @param productMasterBean
	 * @param classificationBean
	 * @param laserMasterBean
	 */
	public IncentiveBean(int incentive_id, String po_date, String sjo_date, String inv_date, String customer,
			String scope, String remarks, double basic_price, double discount, double quotation_price,
			String project_code, String new_repeat, double deduction, double net_basic, double additional_accesories,
			double slab, double amount, String invoice_no, String incentive_status, MonthBean monthBean,
			YearBean yearBean, SalespersonBean salespersonBean, ZoneBean zoneBean, ProductMasterBean productMasterBean,
			ClassificationBean classificationBean, LaserMasterBean laserMasterBean,String customer_code,double eligible_incentive_percentage,
			String eligible_insentive_save,double invoice_amount) {
		super();
		this.incentive_id = incentive_id;
		this.po_date = po_date;
		this.sjo_date = sjo_date;
		this.inv_date = inv_date;
		this.customer = customer;
		this.scope = scope;
		this.remarks = remarks;
		this.basic_price = basic_price;
		this.discount = discount;
		this.quotation_price = quotation_price;
		this.project_code = project_code;
		this.new_repeat = new_repeat;
		this.deduction = deduction;
		this.net_basic = net_basic;
		this.additional_accesories = additional_accesories;
		this.slab = slab;
		this.amount = amount;
		this.invoice_no = invoice_no;
		this.incentive_status = incentive_status;
		this.monthBean = monthBean;
		this.yearBean = yearBean;
		this.salespersonBean = salespersonBean;
		this.zoneBean = zoneBean;
		this.productMasterBean = productMasterBean;
		this.classificationBean = classificationBean;
		this.laserMasterBean = laserMasterBean;
		this.customer_code = customer_code;
		this.eligible_incentive_percentage = eligible_incentive_percentage;
		this.eligible_insentive_save = eligible_insentive_save;
		this.invoice_amount = invoice_amount;
	}

	@Id
	@Column(name = "incentive_id")
	@GeneratedValue
	public int getIncentive_id() {
		return incentive_id;
	}

	public void setIncentive_id(int incentive_id) {
		this.incentive_id = incentive_id;
	}

	@Column(name = "po_date")
	public String getPo_date() {
		return po_date;
	}

	public void setPo_date(String po_date) {
		this.po_date = po_date;
	}

	@Column(name = "sjo_date")
	public String getSjo_date() {
		return sjo_date;
	}

	public void setSjo_date(String sjo_date) {
		this.sjo_date = sjo_date;
	}

	@Column(name = "inv_date")
	public String getInv_date() {
		return inv_date;
	}

	public void setInv_date(String inv_date) {
		this.inv_date = inv_date;
	}

	@Column(name = "customer")
	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	@Column(name = "scope")
	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	@Column(name = "remarks")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "basic_price")
	public double getBasic_price() {
		return basic_price;
	}

	public void setBasic_price(double basic_price) {
		this.basic_price = basic_price;
	}

	@Column(name = "discount")
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Column(name = "quotation_price")
	public double getQuotation_price() {
		return quotation_price;
	}

	public void setQuotation_price(double quotation_price) {
		this.quotation_price = quotation_price;
	}

	@ManyToOne
	@JoinColumn(name = "month_id")
	public MonthBean getMonthBean() {
		return monthBean;
	}

	public void setMonthBean(MonthBean monthBean) {
		this.monthBean = monthBean;
	}

	@ManyToOne
	@JoinColumn(name = "year_id")
	public YearBean getYearBean() {
		return yearBean;
	}

	public void setYearBean(YearBean yearBean) {
		this.yearBean = yearBean;
	}

	@ManyToOne
	@JoinColumn(name = "sales_person_id")
	public SalespersonBean getSalespersonBean() {
		return salespersonBean;
	}

	public void setSalespersonBean(SalespersonBean salespersonBean) {
		this.salespersonBean = salespersonBean;
	}

	@ManyToOne
	@JoinColumn(name = "zone_id")
	public ZoneBean getZoneBean() {
		return zoneBean;
	}

	public void setZoneBean(ZoneBean zoneBean) {
		this.zoneBean = zoneBean;
	}

	@ManyToOne
	@JoinColumn(name = "product_master_id")
	public ProductMasterBean getProductMasterBean() {
		return productMasterBean;
	}

	public void setProductMasterBean(ProductMasterBean productMasterBean) {
		this.productMasterBean = productMasterBean;
	}

	@ManyToOne
	@JoinColumn(name = "classification_id")
	public ClassificationBean getClassificationBean() {
		return classificationBean;
	}

	public void setClassificationBean(ClassificationBean classificationBean) {
		this.classificationBean = classificationBean;
	}

	@ManyToOne
	@JoinColumn(name = "laser_master_id")
	public LaserMasterBean getLaserMasterBean() {
		return laserMasterBean;
	}

	public void setLaserMasterBean(LaserMasterBean laserMasterBean) {
		this.laserMasterBean = laserMasterBean;
	}

	@Column(name = "project_code")
	public String getProject_code() {
		return project_code;
	}

	public void setProject_code(String project_code) {
		this.project_code = project_code;
	}

	@Column(name = "new_repeat")
	public String getNew_repeat() {
		return new_repeat;
	}

	public void setNew_repeat(String new_repeat) {
		this.new_repeat = new_repeat;
	}

	@Column(name = "deduction")
	public double getDeduction() {
		return deduction;
	}

	public void setDeduction(double deduction) {
		this.deduction = deduction;
	}

	@Column(name = "net_basic")
	public double getNet_basic() {
		return net_basic;
	}

	public void setNet_basic(double net_basic) {
		this.net_basic = net_basic;
	}

	@Column(name = "additional_accesories")
	public double getAdditional_accesories() {
		return additional_accesories;
	}

	public void setAdditional_accesories(double additional_accesories) {
		this.additional_accesories = additional_accesories;
	}

	public double getSlab() {
		return slab;
	}

	public void setSlab(double slab) {
		this.slab = slab;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getInvoice_no() {
		return invoice_no;
	}

	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}

	/**
	 * @return the incentive_status
	 */
	public String getIncentive_status() {
		return incentive_status;
	}

	/**
	 * @param incentive_status the incentive_status to set
	 */
	public void setIncentive_status(String incentive_status) {
		this.incentive_status = incentive_status;
	}

	/**
	 * @return the customer_code
	 */
	public String getCustomer_code() {
		return customer_code;
	}

	/**
	 * @param customer_code the customer_code to set
	 */
	public void setCustomer_code(String customer_code) {
		this.customer_code = customer_code;
	}

	public double getEligible_incentive_percentage() {
		return eligible_incentive_percentage;
	}

	public void setEligible_incentive_percentage(double eligible_incentive_percentage) {
		this.eligible_incentive_percentage = eligible_incentive_percentage;
	}

	public String getEligible_insentive_save() {
		return eligible_insentive_save;
	}

	public void setEligible_insentive_save(String eligible_insentive_save) {
		this.eligible_insentive_save = eligible_insentive_save;
	}

	public double getInvoice_amount() {
		return invoice_amount;
	}

	public void setInvoice_amount(double invoice_amount) {
		this.invoice_amount = invoice_amount;
	}
	
	
	

}
