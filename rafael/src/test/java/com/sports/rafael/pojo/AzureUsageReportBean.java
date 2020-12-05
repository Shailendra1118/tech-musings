package com.sports.rafael.pojo;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.joda.time.DateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AzureUsageReportBean implements Comparable<AzureUsageReportBean> {
    private String id;
    private String msftSubscriptionId;
    private String subscriptionDescription;
    private String resourceGroup;
    private String resourceURI;
    private String entitlementId;
    private String entitlementDescription;
    private BigDecimal rateOfPartnerEarnedCredit;
    private Boolean hasPartnerEarnedCredit;
    private String mpExternalVendorIdentifier;
    private String invoiceId;
    private String productId;
    private String productName;
    private String serviceName;
    private String serviceType;
    private Integer lineItemId;
    private DateTime usageDate;
    private String sku;
    private Currency currency;
    private BigDecimal quantity;
    private BigDecimal unitPrice;
    private BigDecimal effectiveUnitPrice;
    private String pricingUnit;
    @Builder.Default
    private boolean reported = false;
    @Builder.Default
    private String sourceType = "azure_csp_metered_usage";
    @Builder.Default
    private boolean isBillable = true;
    private BigDecimal pcToBCExchangeRate;
    private Map<String, Object> additionalInfo;

    //RI
    private String orderId;
    private DateTime orderDate;
    private String termAndBillingCycle;
    private String alternateId;
    private String priceAdjustmentDescription;
    private String billingFrequency;
    private String availabilityId;
    private String skuName;
    private String chargeType;
    private DateTime pcToBcExchangeRateDate;




    @Override
    public int compareTo(AzureUsageReportBean other) {
        return UUID.fromString(this.getId()).compareTo(UUID.fromString(other.getId()));
    }

    public boolean isNotReported() {
        return !reported;
    }
}
