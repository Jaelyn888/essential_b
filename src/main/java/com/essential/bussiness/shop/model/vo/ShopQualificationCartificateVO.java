package com.essential.bussiness.shop.model.vo;

import java.util.List;

import com.essential.bussiness.shop.model.auto.ShopBankCardAuto;

public class ShopQualificationCartificateVO {
	/*** 店铺Id */
	private Long shopId;
	/*** 登录用户 */
	private Long loginUser;
	/*** 公司名称 */
	private String companyName;
	/*** 税务登记号码 */
	private String taxRegistrationNumber;
	/*** 省Id */
	private Long provinceId;
	/*** 市Id */
	private Long cityId;
	/*** 区（县）Id */
	private Long districtId;
	/*** 详细地址 */
	private String detailAddress;
	/*** 电话 */
	private String fixedTelephone;
	/*** 公司法人身份证正面 */
	private String legalidScan;
	/*** 公司法人身份证反面 */
	private String legalidBackScan;
	/*** 营业执照 */
	private String bussinessLicenceScan;
	/*** 税务登记证扫描件 */
	private String taxRegistrationCertificateScan;
	/*** 组织机构代码证 */
	private String organizationCodeScan;
	/*** 开户许可证 */
	private String accountOpeningLicenseScan;
	/*** 开户银行 */
	private List<ShopBankCardAuto> openingBankInfomation;
	/*** 开票账户和结算账户是否相同 */
	private Long isSame;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTaxRegistrationNumber() {
		return taxRegistrationNumber;
	}

	public void setTaxRegistrationNumber(String taxRegistrationNumber) {
		this.taxRegistrationNumber = taxRegistrationNumber;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getFixedTelephone() {
		return fixedTelephone;
	}

	public void setFixedTelephone(String fixedTelephone) {
		this.fixedTelephone = fixedTelephone;
	}

	public String getLegalidScan() {
		return legalidScan;
	}

	public void setLegalidScan(String legalidScan) {
		this.legalidScan = legalidScan;
	}

	public String getLegalidBackScan() {
		return legalidBackScan;
	}

	public void setLegalidBackScan(String legalidBackScan) {
		this.legalidBackScan = legalidBackScan;
	}

	public String getBussinessLicenceScan() {
		return bussinessLicenceScan;
	}

	public void setBussinessLicenceScan(String bussinessLicenceScan) {
		this.bussinessLicenceScan = bussinessLicenceScan;
	}

	public String getTaxRegistrationCertificateScan() {
		return taxRegistrationCertificateScan;
	}

	public void setTaxRegistrationCertificateScan(String taxRegistrationCertificateScan) {
		this.taxRegistrationCertificateScan = taxRegistrationCertificateScan;
	}

	public String getOrganizationCodeScan() {
		return organizationCodeScan;
	}

	public void setOrganizationCodeScan(String organizationCodeScan) {
		this.organizationCodeScan = organizationCodeScan;
	}

	public String getAccountOpeningLicenseScan() {
		return accountOpeningLicenseScan;
	}

	public void setAccountOpeningLicenseScan(String accountOpeningLicenseScan) {
		this.accountOpeningLicenseScan = accountOpeningLicenseScan;
	}

	public List<ShopBankCardAuto> getOpeningBankInfomation() {
		return openingBankInfomation;
	}

	public void setOpeningBankInfomation(List<ShopBankCardAuto> openingBankInfomation) {
		this.openingBankInfomation = openingBankInfomation;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Long loginUser) {
		this.loginUser = loginUser;
	}

	public Long getIsSame() {
		return isSame;
	}

	public void setIsSame(Long isSame) {
		this.isSame = isSame;
	}
}
